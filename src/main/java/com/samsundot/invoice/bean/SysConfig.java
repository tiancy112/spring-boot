package com.samsundot.invoice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

/**
 * 
 * @author tiancy 创建时间：2018年3月7日 下午2:04:09
 */
@Entity
@Table(name = "sys_config")
public class SysConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "config_name")
	private String configName;
	@Column(name = "config_key")
	private String configKey;
	@Column(name = "config_value")
	private String configValue;

	private Integer status;

	private String description;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "create_by")
	private String createBy;
	@Column(name = "update_time")
	private Date updateTime;
	@Column(name = "update_by")
	private String updateBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName == null ? null : configName.trim();
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey == null ? null : configKey.trim();
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue == null ? null : configValue.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {

		if (createTime == null) {
			return null;
		}
		return (Date) createTime.clone();
	}

	public void setCreateTime(Date createTime) {

		if (createTime == null) {
			this.createTime = null;
		} else {
			this.createTime = (Date) createTime.clone();
		}
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public Date getUpdateTime() {

		if (updateTime == null) {
			return updateTime = null;
		}
		return (Date) updateTime.clone();
	}

	public void setUpdateTime(Date updateTime) {
		if (updateTime == null) {
			this.updateTime = null;
		} else {
			this.updateTime = (Date) updateTime.clone();
		}
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}
}