package com.brother.client.customer.model;

import com.brother.common.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseModel {
    private String customerName;
    private String customerType;
    private String certificateType;
    private String customerManager;
    private String certificateNumber;
    private String phoneNumber;
    private String email;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String delFlag;
    private String picture;
    private String imagePath;
    private String accountId;
    private String realAuth;
    private String recommender;
}
