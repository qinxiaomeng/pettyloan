package com.brother.client.customer.service.apierror;

import com.brother.client.customer.service.api.AccountService;
import com.brother.common.result.Code;
import com.brother.common.result.SingleResult;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceError implements AccountService {
    @Override
    public SingleResult<String> index() {
        return SingleResult.buildFailure(Code.ERROR, "服务异常");
    }
}
