package com.brother.common.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PageParam extends BaseRequest {
    private int beginLine;
    @Setter
    @Getter
    private int pageSize = 8;
    @Setter
    @Getter
    private int currentPage=1;

    public PageParam(int pageSize, int currentPage){
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public int getBeginLine() {
        return pageSize * (currentPage-1);//自动计算起始行
    }
}
