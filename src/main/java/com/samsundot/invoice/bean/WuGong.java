package com.samsundot.invoice.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WuGong {
	@Id
	 private Integer id;  
	    private String wugong;  
	    private String miaoshu;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getWugong() {
			return wugong;
		}
		public WuGong() {
			super();
		}
		public void setWugong(String wugong) {
			this.wugong = wugong;
		}
		public String getMiaoshu() {
			return miaoshu;
		}
		public void setMiaoshu(String miaoshu) {
			this.miaoshu = miaoshu;
		}
		public WuGong(Integer id, String wugong, String miaoshu) {
			super();
			this.id = id;
			this.wugong = wugong;
			this.miaoshu = miaoshu;
		}  
	    
}
