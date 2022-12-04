package com.shopping.snack.DTO;

import lombok.Data;

@Data
public class PageDTO {
    private final static int pageCount = 5;
    private final static int pageItem = 3;
    int endPageNo;
    int startPageNo;
    Long totalCount ;
    int currPageNo;
    int totalPage;

    public PageDTO(Long totalCount, int currPageNo){
        this.currPageNo = currPageNo;
        this.totalCount = totalCount;

        totalPage =(int)Math.ceil(((double) totalCount)/3);
        startPageNo = currPageNo - (currPageNo % pageCount) +1;
        endPageNo = currPageNo - currPageNo/pageCount + pageCount;

        if(endPageNo > totalPage) {
            endPageNo = totalPage;
        }
    }
    @Override
    public String toString() {
        return "PageDTO{" +
                "endPageNo=" + endPageNo +
                ", startPageNo=" + startPageNo +
                ", totalCount=" + totalCount +
                ", currPageNo=" + currPageNo +
                ", totalPage=" + totalPage +
                '}';
    }
}
