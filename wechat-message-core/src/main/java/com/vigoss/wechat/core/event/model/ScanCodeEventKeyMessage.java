package com.vigoss.wechat.core.event.model;

import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author chenzhiqiang
 * @date 2018/7/19
 */
public abstract class ScanCodeEventKeyMessage extends EventKeyMessage {
    public ScanCodeEventKeyMessage(String event) {
        super(event);
    }

    /**
     * 扫描信息
     */
    @XmlElement(name = "ScanCodeInfo")
    private ScanInfo scanInfo;

    public ScanInfo getScanInfo() {
        return scanInfo;
    }

    public static class ScanInfo implements Serializable {

        private static final long serialVersionUID = 2237570238164900421L;
        /**
         * 扫描类型，一般是qrcode
         */
        @XmlElement(name = "ScanType")
        private String scanType;
        /**
         * 扫描结果，即二维码对应的字符串信息
         */
        @XmlElement(name = "ScanResult")
        private String scanResult;

        public String getScanType() {
            return scanType;
        }

        public String getScanResult() {
            return scanResult;
        }

        @Override
        public int hashCode() {

            return Objects.hash(scanType, scanResult);
        }

        @Override
        public String toString() {
            return "ScanInfo{" +
                    "scanType='" + scanType + '\'' +
                    ", scanResult='" + scanResult + '\'' +
                    '}';
        }
    }

    @Override
    public int hashCode() {
        return MessageConstant.odd_prime * super.hashCode() + (scanInfo == null ? 0 : scanInfo.hashCode());
    }

    @Override
    public String toString() {
        return "scanInfo=" + scanInfo + ", " + super.toString();
    }
}
