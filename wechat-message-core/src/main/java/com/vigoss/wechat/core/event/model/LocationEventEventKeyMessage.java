package com.vigoss.wechat.core.event.model;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author chenzhiqiang
 * @date 2018/7/19
 */
public abstract class LocationEventEventKeyMessage extends EventKeyMessage {
    public LocationEventEventKeyMessage(String event) {
        super(event);
    }

    /**
     * 发送的图片信息
     */
    @XmlElement(name = "SendLocationInfo")
    private SendLocationInfo sendLocationInfo;

    public SendLocationInfo getSendLocationInfo() {
        return sendLocationInfo;
    }

    public static class SendLocationInfo implements Serializable {
        private static final long serialVersionUID = -8000083356291165055L;
        @XmlElement(name = "Location_X")
        private double x;
        @XmlElement(name = "Location_Y")
        private double y;
        @XmlElement(name = "Scale")
        private double scale;
        @XmlElement(name = "Label")
        private String label;
        @XmlElement(name = "Poiname")
        private String poiname;

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

        public String getPoiname() {
            return poiname;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y, scale, label, poiname);
        }

        @Override
        public String toString() {
            return "SendLocationInfo{" +
                    "x=" + x +
                    ", y=" + y +
                    ", scale=" + scale +
                    ", label='" + label + '\'' +
                    ", poiname='" + poiname + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "sendLocationInfo=" + sendLocationInfo + ", " + super.toString();
    }
}
