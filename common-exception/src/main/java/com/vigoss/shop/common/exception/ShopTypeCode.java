package com.vigoss.shop.common.exception;

/**
 * ShopTypeCode
 *    错误码第一个提示语
 *    S代码选座，B代表行李，U登机口升舱，W代表wifi，E电子发票，F航延证明，A代表行动障碍、老人服务，
 *
 * @author Jamefeng
 * @date 2017-04-10
 */
public enum ShopTypeCode {

    MONITOR("M"), //监控
    UPCAIN("U"), //登机口升舱
    FLIGHT_DELAY("F"), //航延证明
    EMD("E"), //电子发票
    WIFI("W"), //wifi
    ;
    private String type;
    ShopTypeCode(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
