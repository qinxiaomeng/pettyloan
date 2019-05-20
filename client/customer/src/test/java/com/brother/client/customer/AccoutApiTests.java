package com.brother.client.customer;

import com.brother.client.customer.service.api.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = CustApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AccoutApiTests {
    @Autowired
    private AccountService accountService;
    @Test
    public void testIndes(){
        System.out.println(accountService.index().getData());
    }
}
