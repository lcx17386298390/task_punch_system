package com.acm.common.util;

public class CommonUtil {
    public static int defaultPageNo(Integer pageNo){
        int pNo = pageNo;
        if(pageNo == null|| pageNo < 1){
            pNo=1;
        }
        return pNo;
    }

    public static int defaultPageSize(Integer pageSize){
        int pSize = pageSize;
        if(pageSize == null|| pageSize < 1){
            pSize=1;
        }
        return pSize;
    }

}
