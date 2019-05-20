package com.brother.client.customer.service;

import com.brother.client.customer.mapper.CustMapper;
import com.brother.client.customer.model.Customer;
import com.brother.client.customer.request.CustParam;
import com.brother.common.result.MultiResult;
import com.brother.common.result.SingleResult;
import com.brother.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CustService extends BaseService {
    @Autowired
    private CustMapper custMapper;

    public SingleResult<String> createCustInfo(String customerName, String custType,
                                               String certificateType, String certificateNumber,
                                               String phoneNumber, String email, String remarks, String recommender){
        Customer custModel = new Customer();
        custModel.setId();
        custModel.setCustomerName(customerName);
        custModel.setCustomerType(custType);
        custModel.setCertificateType(certificateType);
        custModel.setCertificateNumber(certificateNumber);
        custModel.setPhoneNumber(phoneNumber);
        custModel.setEmail(email);
        custModel.setRemarks(remarks);
        custModel.setRecommender(recommender);
        custModel.preCreate("123");

        custMapper.insert(custModel);
        return SingleResult.buildSuccessWithoutData();
    }

    public MultiResult<Customer> findList(CustParam param){

        List<Customer> results = custMapper.findList(param);
        int total = custMapper.getCount(param);
        return MultiResult.buildSuccess(results, total);
    }

    public SingleResult<Customer> get(String id){
        Customer customer = custMapper.get(id);
        return SingleResult.buildSuccess(customer);
    }


}
