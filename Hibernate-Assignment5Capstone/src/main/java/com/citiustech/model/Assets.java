package com.citiustech.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Assets_Table")
public class Assets {

	@Id
	private int assetId;
	private int serialNo;
	private int prNo;
	private String assetType;
	private int assetPrice;
	private String assetLocation;
	
	public Assets() {
		super();
	}
	public Assets(int assetId, int serialNo, int prNo, String assetType, int assetPrice, String assetLocation) {
		super();
		this.assetId = assetId;
		this.serialNo = serialNo;
		this.prNo = prNo;
		this.assetType = assetType;
		this.assetPrice = assetPrice;
		this.assetLocation = assetLocation;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getPrNo() {
		return prNo;
	}
	public void setPrNo(int prNo) {
		this.prNo = prNo;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public int getAssetPrice() {
		return assetPrice;
	}
	public void setAssetPrice(int assetPrice) {
		this.assetPrice = assetPrice;
	}
	public String getAssetLocation() {
		return assetLocation;
	}
	public void setAssetLocation(String assetLocation) {
		this.assetLocation = assetLocation;
	}
	@Override
	public String toString() {
		return "Assets [assetId=" + assetId + ", serialNo=" + serialNo + ", prNo=" + prNo + ", assetType=" + assetType
				+ ", assetPrice=" + assetPrice + ", assetLocation=" + assetLocation + "]";
	}
	
	
}
