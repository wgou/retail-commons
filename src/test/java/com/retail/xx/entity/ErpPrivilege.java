package com.retail.xx.entity;
import java.util.Date;
import com.retail.commons.base.BaseEntity;
public class ErpPrivilege extends BaseEntity {

	/** 权限码 **/
	private String privilegeCode;
	/** 图标 **/
	private String icon;
	/** 备注描述 **/
	private String remark;
	/** -1：已删除，1：正常 **/
	private Integer status;
	/** 域名所属系统ID **/
	private Integer erpDomainSysId;
	/** 排序字段 **/
	private Integer orderNum;
	/** 上级id **/
	private Integer pid;
	/**  **/
	private Date modified;
	/**  **/
	private Integer id;
	/** 权限类型 0-菜单 1-url 2-页面元素 **/
	private Integer privilegeType;
	/** 菜单所属系统ID **/
	private Integer erpSysId;
	/**  **/
	private Date created;
	/** url地址 **/
	private String privilegeUrl;
	/** 权限名称 **/
	private String privilegeName;
	/** 是否叶子节点 0-否 1-是 **/
	private Integer flagLeaf;

     return icon;
     return remark;
     return status;
     return erpDomainSysId;
     return pid;
     return modified;
     return id;
     return flagLeaf;
     return privilegeCode;
     return created;
     return erpSysId;
     return orderNum;
     return privilegeName;
     return privilegeUrl;
     return privilegeType;
	 this. privilegeUrl = privilegeUrl;
	 this. created = created;
	 this. flagLeaf = flagLeaf;
	 this. erpSysId = erpSysId;
	 this. remark = remark;
	 this. orderNum = orderNum;
	 this. modified = modified;
	 this. privilegeCode = privilegeCode;
	 this. erpDomainSysId = erpDomainSysId;
	 this. privilegeType = privilegeType;
	 this. privilegeName = privilegeName;
	 this. status = status;
	 this. icon = icon;
	 this. id = id;
	 this. pid = pid;