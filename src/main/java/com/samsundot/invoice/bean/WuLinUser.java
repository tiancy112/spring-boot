package com.samsundot.invoice.bean;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="wulinuser")
public class WuLinUser {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;  
    private String name;  
    @Column(name="wugong_id")
    private Integer wugongId;  
    @Column(name="paiming_id")
    private Integer paimingId; 
    @Column(name="birth_date")
    private Date birthDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getWugongId() {
		return wugongId;
	}
	public void setWugongId(Integer wugongId) {
		this.wugongId = wugongId;
	}
	public Integer getPaimingId() {
		return paimingId;
	}
	public void setPaimingId(Integer paimingId) {
		this.paimingId = paimingId;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public WuLinUser(Integer id, String name, Integer wugongId, Integer paimingId, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.wugongId = wugongId;
		this.paimingId = paimingId;
		this.birthDate = birthDate;
	}
	public WuLinUser() {
		// TODO Auto-generated constructor stub
	}  
   

}
