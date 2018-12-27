package com.hnu.softwarecollege.infocenter.context;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hnu.softwarecollege.infocenter.entity.po.CityPo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
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



    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CityPo> cityMap = new HashMap<String, CityPo>();
        //InputStream inputStream = getClass().getClassLoader().getResourceAsStream("city.json");
        ClassPathResource resource = new ClassPathResource("city.json");
        InputStream inputStream = resource.getInputStream();

        byte[] bytes = new byte[0];
        bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String jsonCity = new String(bytes);
        //String jsonCity = FileUtils.readFileToString(ResourceUtils.getFile(citypath), Charset.forName("UTF-8"));
        ObjectMapper mapper = new ObjectMapper();
        List<CityPo> listcity = mapper.readValue(jsonCity, new TypeReference<List<CityPo>>() {});
        for (int i = 0; i < listcity.size(); i++) {
            cityMap.put(listcity.get(i).getCity_name(), listcity.get(i));
            //System.out.println(cityMap);
        }
        this.setMap(cityMap);
    }

}
