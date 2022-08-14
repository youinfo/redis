package com.raker.controller;

import com.raker.util.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class TestRedisController {

    @Resource
    private RedisUtil redisUtil;


    @GetMapping("/get")
    public Map<String,Object> getName(@RequestParam Map<String,Object> prams){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name",redisUtil.get(prams.get("name").toString()));
        return map;
    }

    @GetMapping("/set")
    public Object setName(@RequestParam Map<String,Object> map){
        String key = map.get("nameKey").toString();
        String value = map.get("nameValue").toString();
        redisUtil.set(key,value);
        return "ok";
    }


}
