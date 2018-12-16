package com.hnu.softwarecollege.infocenter.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.context.CityMapContext;
import com.hnu.softwarecollege.infocenter.context.ThreadContext;
import com.hnu.softwarecollege.infocenter.entity.po.CenterPo;
import com.hnu.softwarecollege.infocenter.entity.po.CityPo;
import com.hnu.softwarecollege.infocenter.entity.po.UserPo;
import com.hnu.softwarecollege.infocenter.entity.po.WeatherPo;
import com.hnu.softwarecollege.infocenter.mapper.CenterPoMapper;
import com.hnu.softwarecollege.infocenter.mapper.WeatherPoMapper;
import com.hnu.softwarecollege.infocenter.service.WeatherService;
import com.hnu.softwarecollege.infocenter.util.HttpRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {
    @Resource
    private CityMapContext cityMapContext;
    @Resource
    private WeatherPoMapper weatherPoMapper;
    @Resource
    CenterPoMapper centerPoMapper;
    /*
     * @Author 刘亚双
     * @Description //TODO 通过用户ID 逐步查询出 citycode
     * @Date 2018/12/1 12:32
     * @Param []
     * @return int
     **/
    @Override
    public int getcitycode() {
        int citycode = 0;
        UserPo userPo = ThreadContext.getUserContext();
        Long centerId = centerPoMapper.selectByUserKey(userPo.getUserId());
        CenterPo centerPo = centerPoMapper.selectByPrimaryKey(centerId);
        citycode = centerPo.getWeatherCode();
        return citycode;
    }

    /*
     * @Author 刘亚双
     * @Description //TODO 根据城市名字 查询对应的城市ID
     * @Date 2018/11/30 18:23
     * @Param [cityname]
     * @return java.lang.String
     **/
    @Override
    public String findcitycode(String cityname){

        Map<String, CityPo> map = this.cityMapContext.getMap();
        CityPo cp =map.get(cityname);
        return cp.getCity_code();
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 根据城市名称查询对应的城市ID,将用户对应的CenterPo 中的城市ID 改变，再进行天气查询
     * @Date 2018/12/1 13:12
     * @Param [code]
     * @return void
     **/
    @Override
    public int updateWeatherInfo(String code) {
        int citycode = Integer.parseInt(code);
        UserPo userPo = ThreadContext.getUserContext();
        Long userid = userPo.getUserId();
        Long centerId = centerPoMapper.selectByUserKey(userid);
        int num = centerPoMapper.updateWeatherCodeByPrimaryKey(citycode,centerId);
        return num;
    }

    /*
     * @Author 刘亚双
     * @Description //TODO 根据citycode 先进行数据库查询 存在直接返回 不存在则调用接口
     * @Date 2018/11/30 18:21
     * @Param [citycode]
     * @return com.hnu.softwarecollege.infocenter.entity.po.WeatherPo
     **/
    @Override
    public WeatherPo Weather(String citycode){
        int code = Integer.parseInt(citycode);
        WeatherPo wp = weatherPoMapper.selectByPrimaryKey(code);
        boolean b = false;
        if(wp==null){
            b=true;
        }
        if(b==true){
            String str = HttpRequestUtil.getJsonContent(citycode);
            //log.info(str);
            try {
                ObjectMapper mapper = new ObjectMapper();
                WeatherPo weatherPo = mapper.readValue(str,WeatherPo.class);
                insertWeather(weatherPo);
                wp = weatherPo;
            } catch (IOException e) {
                e.printStackTrace();
                log.error("json 转换为实体类错误");
            }
        }
        return wp;
    }
    @Override
    public void insertWeather(WeatherPo weatherPo) {
        weatherPoMapper.insert(weatherPo);
    }
    /*
     * @Author 刘亚双
     * @Description //TODO 修改数据库中已有城市的天气信息
     * @Date 2018/12/5 14:13
     * @Param []
     * @return void
     **/
    @Override
    public void updateAllWeatherInfo() {
        List<WeatherPo> list = weatherPoMapper.findAll();
        for(WeatherPo weatherPo:list){
            int code = weatherPo.getWeatherCode();
            String city_code=code+"";
            String weatherinfo = HttpRequestUtil.getJsonContent(city_code);
            ObjectMapper mapper = new ObjectMapper();
            try {
                WeatherPo weather = mapper.readValue(weatherinfo, WeatherPo.class);
                weatherPoMapper.updateByPrimaryKey(weather);
            }catch (IOException e){
                e.printStackTrace();
                log.error("实体类转换错误");
            }
        }
    }
}
