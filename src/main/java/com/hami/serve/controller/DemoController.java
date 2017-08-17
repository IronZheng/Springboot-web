package com.hami.serve.controller;

import com.hami.serve.common.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2017/7/19.
 */
@RestController
public class DemoController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/he")
    public String say(Map<String,Object> map){
        map.put("hello","sada");
        return "hello";
    }


    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Map<String, Object> test() {
        Map<String,Object> map = new HashMap<>();
        map.put("data","hello word");
        return map;
    }

    @RequestMapping(value = "setRedis",method = RequestMethod.GET)
    public String  test2(){
        redisUtils.set("123", "hello world");
        System.out.println("进入了方法");
        String string= redisUtils.get("123").toString();
        return string;
    }

}
