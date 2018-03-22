package com.xieyupeng.springboot.model;

import java.util.Date;

public class UserBase {
    private Integer id;

    private Integer bbsid;

    private Integer puid;

    private Short relevancename;

    private String username;

    private String password;

    private String email;

    private Byte registertype;

    private String phoneno;

    private String weibono;

    private String baiduno;

    private String qqno;

    private String weixinno;

    private String meizuno;

    private String xiaomino;

    private String devicetoken;

    private Byte openappid;

    private Byte type;

    private Byte status;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBbsid() {
        return bbsid;
    }

    public void setBbsid(Integer bbsid) {
        this.bbsid = bbsid;
    }

    public Integer getPuid() {
        return puid;
    }

    public void setPuid(Integer puid) {
        this.puid = puid;
    }

    public Short getRelevancename() {
        return relevancename;
    }

    public void setRelevancename(Short relevancename) {
        this.relevancename = relevancename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Byte getRegistertype() {
        return registertype;
    }

    public void setRegistertype(Byte registertype) {
        this.registertype = registertype;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno == null ? null : phoneno.trim();
    }

    public String getWeibono() {
        return weibono;
    }

    public void setWeibono(String weibono) {
        this.weibono = weibono == null ? null : weibono.trim();
    }

    public String getBaiduno() {
        return baiduno;
    }

    public void setBaiduno(String baiduno) {
        this.baiduno = baiduno == null ? null : baiduno.trim();
    }

    public String getQqno() {
        return qqno;
    }

    public void setQqno(String qqno) {
        this.qqno = qqno == null ? null : qqno.trim();
    }

    public String getWeixinno() {
        return weixinno;
    }

    public void setWeixinno(String weixinno) {
        this.weixinno = weixinno == null ? null : weixinno.trim();
    }

    public String getMeizuno() {
        return meizuno;
    }

    public void setMeizuno(String meizuno) {
        this.meizuno = meizuno == null ? null : meizuno.trim();
    }

    public String getXiaomino() {
        return xiaomino;
    }

    public void setXiaomino(String xiaomino) {
        this.xiaomino = xiaomino == null ? null : xiaomino.trim();
    }

    public String getDevicetoken() {
        return devicetoken;
    }

    public void setDevicetoken(String devicetoken) {
        this.devicetoken = devicetoken == null ? null : devicetoken.trim();
    }

    public Byte getOpenappid() {
        return openappid;
    }

    public void setOpenappid(Byte openappid) {
        this.openappid = openappid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
}