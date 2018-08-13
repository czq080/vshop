package com.vigoss.shop.management.api.dto;

import com.vigoss.shop.sys.entity.QuartzJob;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 22:20 2018/5/27
 * @Modified By:
 */
public class MQuartzJob extends QuartzJob{

    private List<Param> paramList;

    public List<Param> getParamList() {
        return paramList;
    }

    public void setParamList(List<Param> paramList) {
        this.paramList = paramList;
    }

    public class Param implements Serializable{
        private String name;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
