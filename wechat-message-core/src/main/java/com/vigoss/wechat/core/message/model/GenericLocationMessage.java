package com.vigoss.wechat.core.message.model;

import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public abstract class GenericLocationMessage extends MsgIdMessage {

    /**
     * 地理位置维度
     */
    @XmlElement(name = "Location_X")
    private double x;
    /**
     * 地理位置经度
     */
    @XmlElement(name = "Location_Y")
    private double y;
    /**
     * 地图缩放大小
     */
    @XmlElement(name = "Scale")
    private double scale;
    /**
     * 地理位置信息
     */
    @XmlElement(name = "Label")
    private String label;

    public GenericLocationMessage(String msgType) {
        super(msgType);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getScale() {
        return scale;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int hashCode() {
        int result = MessageConstant.odd_prime * super.hashCode() + Double.hashCode(x);
        result = MessageConstant.odd_prime * result + Double.hashCode(y);
        result = MessageConstant.odd_prime * result + Double.hashCode(scale);
        result = MessageConstant.odd_prime * result + (label == null ? 0 : label.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", scale=" + scale
                + ", label=" + label + ", " + super.toString();
    }
}
