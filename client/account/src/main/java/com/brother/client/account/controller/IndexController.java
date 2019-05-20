package com.brother.client.account.controller;

import com.brother.common.result.SingleResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class IndexController {

    @GetMapping("index")
    public SingleResult<String> index(){
        return SingleResult.buildSuccess("Welcom to fegin world!");
    }
}
