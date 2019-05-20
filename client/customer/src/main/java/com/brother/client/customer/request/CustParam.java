package com.brother.client.customer.request;

import com.brother.common.model.request.PageParam;
import lombok.Data;

@Data
public class CustParam extends PageParam {
    private String customerName;
    private String customerType;
    private String certificateNumber;
    private String phoneNumber;
    private String delFlag;
}
