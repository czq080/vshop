package com.vigoss.wechat.official.api.res.user;

import com.vigoss.wechat.base.http.weixin.ApiResult;

import java.util.List;

/**
 * @author chenzhiqiang
 * @date 2018/7/6
 */
public class UserApiResult extends ApiResult {

    /**
     * country : 中国
     * unionid : oeIRV0VGKfIhH2ybAj22gq3kisW8
     * qr_scene : 0
     * subscribe : 1
     * city : 广州
     * openid : o8gdns23z2GnNxiXphxF3UXsbEXQ
     * tagid_list : []
     * sex : 1
     * groupid : 0
     * language : zh_CN
     * remark : dsadada
     * subscribe_time : 1460610973
     * province : 广东
     * subscribe_scene : ADD_SCENE_OTHERS
     * nickname : vigos
     * headimgurl : http://thirdwx.qlogo.cn/mmopen/rFpwJwhsEicnsCvsdD1gTjIsKtzMtRicwtXnsYqYOMdUCfGbKNrbRwpqct8ic7DicYDkNjREiaibyxxyzfyxR17ngyjgxh1fq2gFibq/132
     * qr_scene_str :
     */

    private String country;
    private String unionid;
    private Integer qrScene;
    private int subscribe;
    private String city;
    private String openid;
    private Integer sex;
    private Integer groupid;
    private String language;
    private String remark;
    private Integer subscribeTime;
    private String province;
    private String subscribeScene;
    private String nickname;
    private String headimgurl;
    private String qrSceneStr;
    private List<Integer> tagidList;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Integer getQrScene() {
        return qrScene;
    }

    public void setQrScene(Integer qrScene) {
        this.qrScene = qrScene;
    }

    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Integer subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getQrSceneStr() {
        return qrSceneStr;
    }

    public void setQrSceneStr(String qrSceneStr) {
        this.qrSceneStr = qrSceneStr;
    }

    public List<Integer> getTagidList() {
        return tagidList;
    }

    public void setTagidList(List<Integer> tagidList) {
        this.tagidList = tagidList;
    }
}
