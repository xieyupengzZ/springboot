package com.xieyupeng.springboot.model;

import java.util.Date;

public class UsersToken {
    private Integer id;

    private String accesstoken;

    private String openid;

    private Integer userid;

    private Short type;

    private Byte issyncdata;

    private Byte iscallbind;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken == null ? null : accesstoken.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Byte getIssyncdata() {
        return issyncdata;
    }

    public void setIssyncdata(Byte issyncdata) {
        this.issyncdata = issyncdata;
    }

    public Byte getIscallbind() {
        return iscallbind;
    }

    public void setIscallbind(Byte iscallbind) {
        this.iscallbind = iscallbind;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "UsersToken{" +
                "id=" + id +
                ", accesstoken='" + accesstoken + '\'' +
                ", openid='" + openid + '\'' +
                ", userid=" + userid +
                ", type=" + type +
                ", issyncdata=" + issyncdata +
                ", iscallbind=" + iscallbind +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}