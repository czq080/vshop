package com.vigoss.wechat.core.event.model;

import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author chenzhiqiang
 * @date 2018/7/19
 */
public abstract class PicEventKeyMessage extends EventKeyMessage {
    public PicEventKeyMessage(String event) {
        super(event);
    }

    /**
     * 发送的图片信息
     */
    @XmlElement(name = "SendPicsInfo")
    private SendPicsInfo sendPicsInfo;

    public SendPicsInfo getSendPicsInfo() {
        return sendPicsInfo;
    }

    @Override
    public int hashCode() {
        return MessageConstant.odd_prime * super.hashCode() + (sendPicsInfo == null ? 0 : sendPicsInfo.hashCode());
    }

    @Override
    public String toString() {
        return "sendPicsInfo=" + sendPicsInfo + ", " + super.toString();
    }

    public static class SendPicsInfo implements Serializable {

        private static final long serialVersionUID = 2237570238164900421L;
        /**
         * 发送的图片数量
         */
        @XmlElement(name = "Count")
        private Integer count;
        /**
         * 扫描结果，即二维码对应的字符串信息
         */
        @XmlElement(name = "PicList")
        private PicList picList;

        public Integer getCount() {
            return count;
        }

        public PicList getPicList() {
            return picList;
        }

        @Override
        public int hashCode() {
            return Objects.hash(count, picList);
        }

        @Override
        public String toString() {
            return "SendPicsInfo{" +
                    "count=" + count +
                    ", picList=" + picList +
                    '}';
        }
    }

    public static class PicList implements Serializable {
        @XmlElement(name = "item")
        private List<Item> item;

        public List<Item> getItem() {
            return item;
        }

        @Override
        public int hashCode() {
            return Objects.hash(item);
        }

        @Override
        public String toString() {
            return "PicList{" +
                    "item=" + item +
                    '}';
        }
    }

    public static class Item implements Serializable {
        @XmlElement(name = "PicMd5Sum")
        private String picMd5Sum;

        public String getPicMd5Sum() {
            return picMd5Sum;
        }


        @Override
        public String toString() {
            return "Item{" +
                    "picMd5Sum='" + picMd5Sum + '\'' +
                    '}';
        }
    }
}
