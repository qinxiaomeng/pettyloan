package com.brother.client.customer.controller;

import com.brother.client.customer.model.Customer;
import com.brother.client.customer.request.CustParam;
import com.brother.client.customer.request.CustRequest;
import com.brother.client.customer.service.CustService;
import com.brother.common.controller.BaseController;
import com.brother.common.result.Code;
import com.brother.common.result.MultiResult;
import com.brother.common.result.SingleResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cust")
public class CustomerController extends BaseController {

    @Autowired
    CustService custService;

    @PostMapping("create")
    public SingleResult<String> createCust(@Valid @RequestBody CustRequest custRequest, BindingResult result){

        validate(result);
        return custService.createCustInfo(custRequest.getCustomerName(), custRequest.getCustomerType(),
                custRequest.getCertificateType(), custRequest.getCertificateNumber(),
                custRequest.getPhoneNumber(), custRequest.getEmail(),
                custRequest.getRemarks(), custRequest.getRecommender());
    }

    @GetMapping("findList")
    public MultiResult<Customer> findList(@RequestBody CustParam params){

        return custService.findList(params);
    }

    @GetMapping("get")
    public SingleResult<Customer> getById(String id){
        if(StringUtils.isEmpty(id)){
            return SingleResult.buildFailure(Code.ERROR, "参数错误");
        }
        return custService.get(id);
    }
}
