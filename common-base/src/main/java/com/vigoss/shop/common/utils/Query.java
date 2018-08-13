package com.vigoss.shop.common.utils;

import com.vigoss.shop.common.xss.SQLFilter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:czq
 * @Description:
 * @Date: 20:51 2018/5/26
 * @Modified By:
 */
public class Query extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    //当前页码
    private int page;
    //每页条数
    private int limit = 10;

    public Query(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        if(!"".equals(params.get("page")) && params.get("page")!=null){
            this.page = Integer.parseInt(params.get("page").toString());
        }else{
            this.page=1;
        }
        if(!"".equals(params.get("limit")) && params.get("limit")!=null){
            this.limit = Integer.parseInt(params.get("limit").toString());
        }else{
            this.limit=10;
        }

        this.put("offset", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);

        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        if(!"".equals(params.get("sidx")) && params.get("sidx")!=null){
            this.put("sidx", SQLFilter.sqlInject(params.get("sidx").toString()));
        }
        if(!"".equals(params.get("order")) && params.get("order")!=null){
            this.put("order", SQLFilter.sqlInject(params.get("order").toString()));
        }
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
