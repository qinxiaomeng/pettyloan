package com.brother.client.customer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustLoginRequest {
    @NotEmpty
    private String mobile;
    @NotEmpty
    private String password;
}
