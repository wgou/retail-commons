package com.retail.xx.entity;
import com.retail.commons.base.BaseEntity;
import com.retail.commons.utils.JsonUtils;
public class Chginst extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String trgsvr;
	private String chgtyp;
	private String chgcod;
	private String syscod;
	private String srcusr;
	private String srcsts;
	private Integer srcdat;
	private Integer chgdat;
	private String chgusr;
	private Integer srctim;
	private String prtcod;
	private String oid;
	private Integer filcnt;
	private Integer chgcnt;
	private String chgsts;
	private Integer srccnt;
	public String getChgusr(){
     return chgusr;	}	public String getOid(){
     return oid;	}	public String getChgtyp(){
     return chgtyp;	}	public Integer getSrcdat(){
     return srcdat;	}	public String getPrtcod(){
     return prtcod;	}	public String getChgcod(){
     return chgcod;	}	public String getChgsts(){
     return chgsts;	}	public Integer getChgdat(){
     return chgdat;	}	public String getSrcusr(){
     return srcusr;	}	public Integer getFilcnt(){
     return filcnt;	}	public Integer getSrctim(){
     return srctim;	}	public String getTrgsvr(){
     return trgsvr;	}	public Integer getSrccnt(){
     return srccnt;	}	public Integer getChgcnt(){
     return chgcnt;	}	public String getSyscod(){
     return syscod;	}	public String getSrcsts(){
     return srcsts;	}	public void setChgsts(String chgsts ){
	 this. chgsts = chgsts;	}	public void setSrcsts(String srcsts ){
	 this. srcsts = srcsts;	}	public void setFilcnt(Integer filcnt ){
	 this. filcnt = filcnt;	}	public void setChgcod(String chgcod ){
	 this. chgcod = chgcod;	}	public void setTrgsvr(String trgsvr ){
	 this. trgsvr = trgsvr;	}	public void setSrccnt(Integer srccnt ){
	 this. srccnt = srccnt;	}	public void setPrtcod(String prtcod ){
	 this. prtcod = prtcod;	}	public void setChgdat(Integer chgdat ){
	 this. chgdat = chgdat;	}	public void setSyscod(String syscod ){
	 this. syscod = syscod;	}	public void setChgusr(String chgusr ){
	 this. chgusr = chgusr;	}	public void setSrcdat(Integer srcdat ){
	 this. srcdat = srcdat;	}	public void setChgcnt(Integer chgcnt ){
	 this. chgcnt = chgcnt;	}	public void setOid(String oid ){
	 this. oid = oid;	}	public void setChgtyp(String chgtyp ){
	 this. chgtyp = chgtyp;	}	public void setSrctim(Integer srctim ){
	 this. srctim = srctim;	}	public void setSrcusr(String srcusr ){
	 this. srcusr = srcusr;	}
	
	public static void main(String[] args) {
		System.out.println(JsonUtils.getJsonStringFromObject(new Chginst()));
	}	}