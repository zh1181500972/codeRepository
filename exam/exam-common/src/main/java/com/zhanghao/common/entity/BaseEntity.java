package com.zhanghao.common.entity;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.zhanghao.core.utils.ChineseUtils;
import com.zhanghao.core.utils.StringUtils;

import io.swagger.annotations.ApiParam;

public abstract class BaseEntity {
	/**
	 * 主键id
	 */
	private Integer id;
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
	 * 
	 * @param id
	 *            主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 主键id
	 * 
	 * @return id 主键id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 创建时间
	 * 
	 * @return createtime 创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createtime
	 *            创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 保留字段
	 * 
	 * @return version 保留字段
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 保留字段
	 * 
	 * @param version
	 *            保留字段
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 修改时间
	 * 
	 * @return updatetime 修改时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}

	/**
	 * 修改时间
	 * 
	 * @param updatetime
	 *            修改时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * 修改人
	 * 
	 * @return updateuser 修改人
	 */
	public Integer getUpdateuser() {
		return updateuser;
	}

	/**
	 * 修改人
	 * 
	 * @param updateuser
	 *            修改人
	 */
	public void setUpdateuser(Integer updateuser) {
		this.updateuser = updateuser;
	}

	private List<Object> visible = new ArrayList<Object>();

	private String toString(Object obj) {
		if (visible.contains(obj)) {
			return "...";
		}
		visible.add(obj);
		Class clazz = obj.getClass();
		if(clazz.equals(String.class)) {
		   return (String) obj;
		}
		StringBuffer buffer = new StringBuffer();
		if(clazz.isArray()) {
			buffer.append(clazz.getComponentType()).append("[]{");
			for(int i=0;i<Array.getLength(obj);i++) {
				Object arrValue = Array.get(obj, i);
				if(clazz.getComponentType().isPrimitive()) {
					buffer.append(arrValue);
				}else {
					buffer.append(toString());
				}
				buffer.append(",");
			}
			return buffer.append("}").toString();
		}
		buffer.append(clazz.getName());
		Field[] fields = clazz.getDeclaredFields();
		buffer.append("[");
		for (Field field : fields) {
			String name = field.getName();
			try {
				Method method = clazz.getMethod("get" + StringUtils.FirstUpper(name), null);
				Object value = method.invoke(obj, null);
				if(field.getType().isPrimitive()) {
					buffer.append(name).append("=").append(value).append(",");
				}else {
					buffer.append(toString(value)).append(",");
				}
			} catch (NoSuchMethodException e) {
				// TODO: handle exception
				System.out.println();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("没有"+name+"字段对应的get方法");
			}
		}
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append("]");
		return buffer.toString() + super.toString();
	}

	public String toString() {
		// TODO Auto-generated method stub
		return toString(this);
	}

}
