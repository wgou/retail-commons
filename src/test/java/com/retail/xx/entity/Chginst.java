package com.retail.xx.entity;
import com.retail.commons.base.BaseEntity;
import com.retail.commons.utils.JsonUtils;
public class Chginst extends BaseEntity {

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

     return chgusr;
     return oid;
     return chgtyp;
     return srcdat;
     return prtcod;
     return chgcod;
     return chgsts;
     return chgdat;
     return srcusr;
     return filcnt;
     return srctim;
     return trgsvr;
     return srccnt;
     return chgcnt;
     return syscod;
     return srcsts;
	 this. chgsts = chgsts;
	 this. srcsts = srcsts;
	 this. filcnt = filcnt;
	 this. chgcod = chgcod;
	 this. trgsvr = trgsvr;
	 this. srccnt = srccnt;
	 this. prtcod = prtcod;
	 this. chgdat = chgdat;
	 this. syscod = syscod;
	 this. chgusr = chgusr;
	 this. srcdat = srcdat;
	 this. chgcnt = chgcnt;
	 this. oid = oid;
	 this. chgtyp = chgtyp;
	 this. srctim = srctim;
	 this. srcusr = srcusr;
	
	public static void main(String[] args) {
		System.out.println(JsonUtils.getJsonStringFromObject(new Chginst()));
	}