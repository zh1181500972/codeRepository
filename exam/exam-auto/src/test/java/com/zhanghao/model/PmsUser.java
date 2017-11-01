package com.zhanghao.model;

import java.util.Date;

public class PmsUser {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * md5密码盐
     */
    private String salt;

    /**
     * 名字
     */
    private String name;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别（1：男 2：女）
     */
    private Integer sex;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 角色id
     */
    private String roleid;

    /**
     * 部门id
     */
    private Integer deptid;

    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 保留字段
     */
    private Integer version;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * 修改人
     */
    private Integer updateuser;

    /**
     * 主键id
     * @return id 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 头像
     * @return avatar 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 头像
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 账号
     * @return account 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * md5密码盐
     * @return salt md5密码盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * md5密码盐
     * @param salt md5密码盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 名字
     * @return name 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 名字
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 生日
     * @return birthday 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 性别（1：男 2：女）
     * @return sex 性别（1：男 2：女）
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别（1：男 2：女）
     * @param sex 性别（1：男 2：女）
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 电子邮件
     * @return email 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 电子邮件
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 电话
     * @return phone 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 角色id
     * @return roleid 角色id
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * 角色id
     * @param roleid 角色id
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    /**
     * 部门id
     * @return deptid 部门id
     */
    public Integer getDeptid() {
        return deptid;
    }

    /**
     * 部门id
     * @param deptid 部门id
     */
    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    /**
     * 状态(1：启用  2：冻结  3：删除）
     * @return status 状态(1：启用  2：冻结  3：删除）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态(1：启用  2：冻结  3：删除）
     * @param status 状态(1：启用  2：冻结  3：删除）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建时间
     * @return createtime 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 保留字段
     * @return version 保留字段
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 保留字段
     * @param version 保留字段
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 修改时间
     * @return updatetime 修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 修改时间
     * @param updatetime 修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 修改人
     * @return updateuser 修改人
     */
    public Integer getUpdateuser() {
        return updateuser;
    }

    /**
     * 修改人
     * @param updateuser 修改人
     */
    public void setUpdateuser(Integer updateuser) {
        this.updateuser = updateuser;
    }
}