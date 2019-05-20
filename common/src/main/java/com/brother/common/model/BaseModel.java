package com.brother.common.model;

import com.brother.common.utils.DLClock;
import com.sun.javafx.logging.PulseLogger;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

public abstract class BaseModel {
    protected String id;
    protected String createBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date createDate;
    protected String updateBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date updateDate;


    public String getId(){
        return id;
    }

    public void setId(){
        this.id = UUID.randomUUID().toString();
    }

    public String getCreateBy(){
        return createBy;
    }
    public Date getCreateDate(){
        return createDate;
    }

    public String getUpdateBy(){
        return updateBy;
    }

    public Date getUpdateDate(){
        return updateDate;
    }

    public void preCreate(String createBy){
        this.createBy = createBy;
        this.createDate = DLClock.nowDate().toDate();
    }

    public void preUpdate(String updateBy){
        this.updateBy = updateBy;
        this.updateDate = DLClock.nowDate().toDate();
    }

}
