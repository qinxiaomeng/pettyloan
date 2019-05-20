package com.brother.client.customer.service.api;

import com.brother.client.customer.service.apierror.AccountServiceError;
import com.brother.common.result.SingleResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "account", fallback = AccountServiceError.class)
public interface AccountService {
    @GetMapping("/account/index")
    SingleResult<String> index();
}
