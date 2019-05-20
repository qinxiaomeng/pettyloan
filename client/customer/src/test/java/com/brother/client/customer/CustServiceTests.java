package com.brother.client.customer;

import com.brother.client.customer.model.Customer;
import com.brother.client.customer.request.CustParam;
import com.brother.client.customer.service.CustService;
import com.brother.common.result.MultiResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = CustApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustServiceTests {
    @Autowired
    private CustService custService;


    @Test
    public void createCustTest(){
        custService.createCustInfo("Simon", "2", "1", "410523123123567",
                                    "18134516450", "qq@qq.com", "ok", "456");
    }

    @Test
    public void selectCustInfoByMobileTest(){
        String m = "18134516450";
        CustParam params = new CustParam();
        params.setPhoneNumber(m);
        MultiResult<Customer> result = custService.findList(params);

        Assert.assertEquals(2, result.getData().size());
        Assert.assertEquals("秦晓萌", result.getData().iterator().next().getCustomerName());
    }
}
