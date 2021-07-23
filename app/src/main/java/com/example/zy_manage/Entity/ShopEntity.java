package com.example.zy_manage.Entity;

import java.io.Serializable;
import java.math.BigInteger;
/*
    店铺表
    * {
            "id": "01",
            "name": "李进明",
            "userId": "1414425953555308545",
            "styleId": "110",
            "introduction": "312321",
            "notice": "31231",
            "shopowner": "123",
            "phone": "1231",
            "address": "驻马店市西平县豫坡大道豫坡初中北侧约150米",
            "province": "123123",
            "city": "12312",
            "region": "312321",
            "code": "123131",
            "logo": "312312",
            "time": "32131",
            "statue": 1,
            "createTime": "2021-07-16",
            "updateTime": null,
            "style_id": null,
            "styleName": "线下店铺",
            "remarks": null
        }*/
//json串可以使用GsonFromatPlus一键生成属性和方法

public class ShopEntity implements Serializable {
    private String id;
    private String name;
    private String userId;
    private BigInteger styleId;
    private String introduction;
    private String notice;
    private String shopowner;
    private String phone;
    private String address;
    private String province;
    private String city;
    private String region;
    private String code;
    private String logo;
    private String time;
    private int statue;
    private String createTime;
    private String updateTime;
    private BigInteger style_id;
    private String styleName;
    private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getShopowner() {
        return shopowner;
    }

    public void setShopowner(String shopowner) {
        this.shopowner = shopowner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }



    public Object getStyle_id() {
        return style_id;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public BigInteger getStyleId() {
        return styleId;
    }

    public void setStyleId(BigInteger styleId) {
        this.styleId = styleId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setStyle_id(BigInteger style_id) {
        this.style_id = style_id;
    }

    public String getStyleName() {
        return styleName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
