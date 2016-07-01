package com.retail.xx.entity;
import java.util.Date;
import com.retail.commons.base.BaseEntity;
public class ErpPrivilege extends BaseEntity {
	private static final long serialVersionUID = 1L;
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
	public String getIcon(){
     return icon;	}	public String getRemark(){
     return remark;	}	public Integer getStatus(){
     return status;	}	public Integer getErpDomainSysId(){
     return erpDomainSysId;	}	public Integer getPid(){
     return pid;	}	public Date getModified(){
     return modified;	}	public Integer getId(){
     return id;	}	public Integer getFlagLeaf(){
     return flagLeaf;	}	public String getPrivilegeCode(){
     return privilegeCode;	}	public Date getCreated(){
     return created;	}	public Integer getErpSysId(){
     return erpSysId;	}	public Integer getOrderNum(){
     return orderNum;	}	public String getPrivilegeName(){
     return privilegeName;	}	public String getPrivilegeUrl(){
     return privilegeUrl;	}	public Integer getPrivilegeType(){
     return privilegeType;	}	public void setPrivilegeUrl(String privilegeUrl ){
	 this. privilegeUrl = privilegeUrl;	}	public void setCreated(Date created ){
	 this. created = created;	}	public void setFlagLeaf(Integer flagLeaf ){
	 this. flagLeaf = flagLeaf;	}	public void setErpSysId(Integer erpSysId ){
	 this. erpSysId = erpSysId;	}	public void setRemark(String remark ){
	 this. remark = remark;	}	public void setOrderNum(Integer orderNum ){
	 this. orderNum = orderNum;	}	public void setModified(Date modified ){
	 this. modified = modified;	}	public void setPrivilegeCode(String privilegeCode ){
	 this. privilegeCode = privilegeCode;	}	public void setErpDomainSysId(Integer erpDomainSysId ){
	 this. erpDomainSysId = erpDomainSysId;	}	public void setPrivilegeType(Integer privilegeType ){
	 this. privilegeType = privilegeType;	}	public void setPrivilegeName(String privilegeName ){
	 this. privilegeName = privilegeName;	}	public void setStatus(Integer status ){
	 this. status = status;	}	public void setIcon(String icon ){
	 this. icon = icon;	}	public void setId(Integer id ){
	 this. id = id;	}	public void setPid(Integer pid ){
	 this. pid = pid;	}	}