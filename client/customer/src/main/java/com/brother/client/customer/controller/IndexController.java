package com.brother.client.customer.controller;

import com.brother.client.customer.service.api.AccountService;
import com.brother.common.result.SingleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/index")
    public SingleResult index(){
        return accountService.index();
    }
}
