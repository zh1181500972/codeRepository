package com.zhanghao.model;

import java.util.Date;

public class PmsRole {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 序号
     */
    private Integer num;

    /**
     * 父角色id
     */
    private Integer pid;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 部门名称
     */
    private Integer deptid;

    /**
     * 提示
     */
    private String tips;

    /**
     * 保留字段(暂时没用）
     */
    private Integer version;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Date updatetime;

    /**
     * 
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
     * 序号
     * @return num 序号
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 序号
     * @param num 序号
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 父角色id
     * @return pid 父角色id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 父角色id
     * @param pid 父角色id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 角色名称
     * @return name 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 部门名称
     * @return deptid 部门名称
     */
    public Integer getDeptid() {
        return deptid;
    }

    /**
     * 部门名称
     * @param deptid 部门名称
     */
    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    /**
     * 提示
     * @return tips 提示
     */
    public String getTips() {
        return tips;
    }

    /**
     * 提示
     * @param tips 提示
     */
    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    /**
     * 保留字段(暂时没用）
     * @return version 保留字段(暂时没用）
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 保留字段(暂时没用）
     * @param version 保留字段(暂时没用）
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 
     * @return createtime 
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 
     * @param createtime 
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 
     * @return status 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return updatetime 
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 
     * @param updatetime 
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 
     * @return updateuser 
     */
    public Integer getUpdateuser() {
        return updateuser;
    }

    /**
     * 
     * @param updateuser 
     */
    public void setUpdateuser(Integer updateuser) {
        this.updateuser = updateuser;
    }
}