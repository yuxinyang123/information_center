package com.hnu.softwarecollege.infocenter.context;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.entity.po.CityPo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CityMapContext implements InitializingBean {
    /**
     * @Author liu
     * @Description // 将json 文件解析到map中,
     * @Date 2018/11/20 15:30
     * @Param []
     * @return java.util.Map<java.lang.String,com.hnu.softwarecollege.infocenter.entity.po.CityPo>
     **/

    private Map<String,CityPo> map;

    public Map<String, CityPo> getMap() {
        return map;
    }

    public void setMap(Map<String, CityPo> map) {
        this.map = map;
    }

    /*public Map<String, CityPo> savaInfo() throws IOException {
        Map<String, CityPo> cityMap = new HashMap<String, CityPo>();

        String jsonCity = FileUtils.readFileToString(ResourceUtils.getFile("classpath:city.json"), Charset.forName("UTF-8"));
        ObjectMapper mapper = new ObjectMapper();
        List<CityPo> listcity = mapper.readValue(jsonCity, new TypeReference<List<CityPo>>() {
        });
        for (int i = 0; i < listcity.size(); i++) {
            cityMap.put(listcity.get(i).getCity_code(), listcity.get(i));
            System.out.println(cityMap);
        }
        return cityMap;
    }*/

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CityPo> cityMap = new HashMap<String, CityPo>();

        String jsonCity = FileUtils.readFileToString(ResourceUtils.getFile("classpath:city.json"), Charset.forName("UTF-8"));
        ObjectMapper mapper = new ObjectMapper();
        List<CityPo> listcity = mapper.readValue(jsonCity, new TypeReference<List<CityPo>>() {
        });
        for (int i = 0; i < listcity.size(); i++) {
            cityMap.put(listcity.get(i).getCity_code(), listcity.get(i));
            //System.out.println(cityMap);
        }
        this.setMap(cityMap);
    }
}
