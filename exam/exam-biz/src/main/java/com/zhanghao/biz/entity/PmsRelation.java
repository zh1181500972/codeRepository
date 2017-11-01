package com.zhanghao.biz.entity;

import java.util.Date;

public class PmsRelation {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 菜单id
     */
    private Integer menuid;

    /**
     * 角色id
     */
    private Integer roleid;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Date updatetime;

    /**
     * 
     */
    private Integer updateuser;

    /**
     * 
     */
    private Integer version;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 菜单id
     * @return menuid 菜单id
     */
    public Integer getMenuid() {
        return menuid;
    }

    /**
     * 菜单id
     * @param menuid 菜单id
     */
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    /**
     * 角色id
     * @return roleid 角色id
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * 角色id
     * @param roleid 角色id
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
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

    /**
     * 
     * @return version 
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}