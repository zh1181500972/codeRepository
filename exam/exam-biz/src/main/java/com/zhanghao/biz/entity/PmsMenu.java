package com.zhanghao.biz.entity;

import java.util.Date;

public class PmsMenu {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 菜单编号
     */
    private String code;

    /**
     * 菜单父编号
     */
    private String pcode;

    /**
     * 当前菜单的所有父菜单编号
     */
    private String pcodes;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * url地址
     */
    private String url;

    /**
     * 菜单排序号
     */
    private Integer num;

    /**
     * 菜单层级
     */
    private Integer levels;

    /**
     * 是否是菜单（1：是  0：不是）
     */
    private Integer ismenu;

    /**
     * 备注
     */
    private String tips;

    /**
     * 菜单状态 :  1:启用   0:不启用
     */
    private Integer status;

    /**
     * 是否打开:    1:打开   0:不打开
     */
    private Integer isopen;

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
    private Integer version;

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
     * 菜单编号
     * @return code 菜单编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 菜单编号
     * @param code 菜单编号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 菜单父编号
     * @return pcode 菜单父编号
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * 菜单父编号
     * @param pcode 菜单父编号
     */
    public void setPcode(String pcode) {
        this.pcode = pcode == null ? null : pcode.trim();
    }

    /**
     * 当前菜单的所有父菜单编号
     * @return pcodes 当前菜单的所有父菜单编号
     */
    public String getPcodes() {
        return pcodes;
    }

    /**
     * 当前菜单的所有父菜单编号
     * @param pcodes 当前菜单的所有父菜单编号
     */
    public void setPcodes(String pcodes) {
        this.pcodes = pcodes == null ? null : pcodes.trim();
    }

    /**
     * 菜单名称
     * @return name 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单名称
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 菜单图标
     * @return icon 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单图标
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * url地址
     * @return url url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * url地址
     * @param url url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 菜单排序号
     * @return num 菜单排序号
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 菜单排序号
     * @param num 菜单排序号
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 菜单层级
     * @return levels 菜单层级
     */
    public Integer getLevels() {
        return levels;
    }

    /**
     * 菜单层级
     * @param levels 菜单层级
     */
    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    /**
     * 是否是菜单（1：是  0：不是）
     * @return ismenu 是否是菜单（1：是  0：不是）
     */
    public Integer getIsmenu() {
        return ismenu;
    }

    /**
     * 是否是菜单（1：是  0：不是）
     * @param ismenu 是否是菜单（1：是  0：不是）
     */
    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }

    /**
     * 备注
     * @return tips 备注
     */
    public String getTips() {
        return tips;
    }

    /**
     * 备注
     * @param tips 备注
     */
    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    /**
     * 菜单状态 :  1:启用   0:不启用
     * @return status 菜单状态 :  1:启用   0:不启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 菜单状态 :  1:启用   0:不启用
     * @param status 菜单状态 :  1:启用   0:不启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 是否打开:    1:打开   0:不打开
     * @return isopen 是否打开:    1:打开   0:不打开
     */
    public Integer getIsopen() {
        return isopen;
    }

    /**
     * 是否打开:    1:打开   0:不打开
     * @param isopen 是否打开:    1:打开   0:不打开
     */
    public void setIsopen(Integer isopen) {
        this.isopen = isopen;
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