package com.hlovex.edu.controller;

import com.hlovex.commonutils.R;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hlovex on 2021/2/13 22:12
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class LoginController {

    @PostMapping("/login")
    public R login(){
        Map<String,String> result = new HashMap<>();
        result.put("token","admin");
        return R.ok().data(result);
    }

    @GetMapping("/info")
    public R info(){
        Map<String,String> result = new HashMap<>();
        result.put("roles","[admin]");
        result.put("name","admin");
        result.put("avatar","https://cn.bing.com/sa/simg/hpc27.png");
        return R.ok().data(result);
    }
}
