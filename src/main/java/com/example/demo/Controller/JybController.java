package com.example.demo.Controller;

import com.example.demo.Mapper.JybMapper;
import org.slf4j.Logger;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/JYB")
public class JybController {
    @Autowired
    JybMapper jybMapper;
    private static final Logger log = LoggerFactory.getLogger(JybController.class);
    @RequestMapping("/LS")
    public Object SelectLianSuo(@Param("id")  String id) {
        Map<String,Object> map = new HashMap<>();
        log.trace("aaaa");
        map.put(id,jybMapper.SelectLianSuo());
        log.trace("bbbb");
        return map;
    }
}
