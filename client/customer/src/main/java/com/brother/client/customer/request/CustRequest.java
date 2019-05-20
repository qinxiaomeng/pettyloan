package com.brother.client.customer.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CustRequest {
    @NotEmpty
    private String customerName;
    @NotEmpty
    private String customerType;
    @NotEmpty
    private String certificateType;
    @NotEmpty
    private String certificateNumber;
    @NotEmpty
    private String phoneNumber;

    private String email;
    private String remarks;
    private String recommender;
}
