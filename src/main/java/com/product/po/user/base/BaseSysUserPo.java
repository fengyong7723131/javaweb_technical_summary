package com.product.po.user.base;


import com.fengyong.base.beans.Po;

/**
 * BaseSysUserPo base model object
 *
 * @author wzy
 *         Created by wzy on 12/4/2015.
 * @version 1.0
 * @since 1.0
 */
public class BaseSysUserPo extends Po {

    /**
     * 自增主键
     */
    private Long userId;

    /**
     * 用户账号
     */
    private String accout;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 固定电话
     */
    private String telphone;

    /**
     * 邮件
     */
    private String email;

    /**
     * QQ,MSN
     */
    private String imType;

    /**
     * IM账号
     */
    private String imNo;

    /**
     * 企业ID: -1 - 平台管理员 其他-企业 
     */
    private Long entId;

    /**
     * 店铺ID
     */
    private Long storeId;

    /**
     * 是否逻辑删除：0-不删除 1：删除
     */
    private String isDelete;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 是否为主账号：0-非 1-是
     */
    private String isMain;



    /**
     * Sets new 自增主键.
     *
     * @param userId New value of 自增主键.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets 自增主键.
     *
     * @return Value of 自增主键.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets new 用户账号.
     *
     * @param accout New value of 用户账号.
     */
    public void setAccout(String accout) {
        this.accout = accout;
    }

    /**
     * Gets 用户账号.
     *
     * @return Value of 用户账号.
     */
    public String getAccout() {
        return accout;
    }

    /**
     * Sets new 用户名.
     *
     * @param userName New value of 用户名.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets 用户名.
     *
     * @return Value of 用户名.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets new 用户密码.
     *
     * @param password New value of 用户密码.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets 用户密码.
     *
     * @return Value of 用户密码.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets new 手机号.
     *
     * @param mobile New value of 手机号.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets 手机号.
     *
     * @return Value of 手机号.
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets new 固定电话.
     *
     * @param telphone New value of 固定电话.
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    /**
     * Gets 固定电话.
     *
     * @return Value of 固定电话.
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * Sets new 邮件.
     *
     * @param email New value of 邮件.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets 邮件.
     *
     * @return Value of 邮件.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets new QQ,MSN.
     *
     * @param imType New value of QQ,MSN.
     */
    public void setImType(String imType) {
        this.imType = imType;
    }

    /**
     * Gets QQ,MSN.
     *
     * @return Value of QQ,MSN.
     */
    public String getImType() {
        return imType;
    }

    /**
     * Sets new IM账号.
     *
     * @param imNo New value of IM账号.
     */
    public void setImNo(String imNo) {
        this.imNo = imNo;
    }

    /**
     * Gets IM账号.
     *
     * @return Value of IM账号.
     */
    public String getImNo() {
        return imNo;
    }

    /**
     * Sets new 企业ID: -1 - 平台管理员 其他-企业 .
     *
     * @param entId New value of 企业ID: -1 - 平台管理员 其他-企业 .
     */
    public void setEntId(Long entId) {
        this.entId = entId;
    }

    /**
     * Gets 企业ID: -1 - 平台管理员 其他-企业 .
     *
     * @return Value of 企业ID: -1 - 平台管理员 其他-企业 .
     */
    public Long getEntId() {
        return entId;
    }

    /**
     * Sets new 店铺ID.
     *
     * @param storeId New value of 店铺ID.
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * Gets 店铺ID.
     *
     * @return Value of 店铺ID.
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * Sets new 是否逻辑删除：0-不删除 1：删除.
     *
     * @param isDelete New value of 是否逻辑删除：0-不删除 1：删除.
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * Gets 是否逻辑删除：0-不删除 1：删除.
     *
     * @return Value of 是否逻辑删除：0-不删除 1：删除.
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * Sets new 角色ID.
     *
     * @param roleId New value of 角色ID.
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets 角色ID.
     *
     * @return Value of 角色ID.
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * Sets new 是否为主账号：0-非 1-是.
     *
     * @param isMain New value of 是否为主账号：0-非 1-是.
     */
    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }

    /**
     * Gets 是否为主账号：0-非 1-是.
     *
     * @return Value of 是否为主账号：0-非 1-是.
     */
    public String getIsMain() {
        return isMain;
    }

    @Override
    public String toString() {
        return "BaseSysUserPo{" +
                "userId=" + userId +
                ", accout='" + accout + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                ", imType='" + imType + '\'' +
                ", imNo='" + imNo + '\'' +
                ", entId=" + entId +
                ", storeId=" + storeId +
                ", isDelete='" + isDelete + '\'' +
                ", roleId=" + roleId +
                ", isMain='" + isMain + '\'' +
                '}';
    }
}