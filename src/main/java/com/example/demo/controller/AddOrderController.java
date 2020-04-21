package com.example.demo.controller;

import com.example.demo.util.ApiResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AddOrderController {
    @RequestMapping(value = "/addorder",method = RequestMethod.GET)
    public ApiResult addorder(@RequestParam("product_buy_username") String product_buy_username,@RequestParam("product_id") int product_id){
        HashMap res = new HashMap();

        return ApiResult.success(200,"success",res);

    }
}
