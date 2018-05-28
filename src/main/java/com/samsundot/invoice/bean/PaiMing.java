package com.samsundot.invoice.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaiMing {
	@Id
	 private Integer id;  
	    private String paiming;  
	    private String miaoshu;
		public PaiMing() {
			super();
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getPaiming() {
			return paiming;
		}
		public void setPaiming(String paiming) {
			this.paiming = paiming;
		}
		public String getMiaoshu() {
			return miaoshu;
		}
		public void setMiaoshu(String miaoshu) {
			this.miaoshu = miaoshu;
		}
		public PaiMing(Integer id, String paiming, String miaoshu) {
			super();
			this.id = id;
			this.paiming = paiming;
			this.miaoshu = miaoshu;
		}  
	    

}
