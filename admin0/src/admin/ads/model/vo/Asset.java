package admin.ads.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Asset implements Serializable{

	private int cNo;
	private String cName;
	private int pNo;
	
	private int pCost;
	private int assetTotal;
	private int assetRevenue;
	private int assetAdsRevenue;
	private Date assetUpdateDate;
	
	public Asset() {
	}

	public Asset(int cNo, String cName, int pNo, int pCost, int assetTotal, int assetRevenue,
			int assetAdsRevenue, Date assetUpdateDate) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.pNo = pNo;
		this.pCost = pCost;
		this.assetTotal = assetTotal;
		this.assetRevenue = assetRevenue;
		this.assetAdsRevenue = assetAdsRevenue;
		this.assetUpdateDate = assetUpdateDate;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}



	public int getpCost() {
		return pCost;
	}

	public void setpCost(int pCost) {
		this.pCost = pCost;
	}

	public int getAssetTotal() {
		return assetTotal;
	}

	public void setAssetTotal(int assetTotal) {
		this.assetTotal = assetTotal;
	}

	public int getAssetRevenue() {
		return assetRevenue;
	}

	public void setAssetRevenue(int assetRevenue) {
		this.assetRevenue = assetRevenue;
	}

	public int getAssetAdsRevenue() {
		return assetAdsRevenue;
	}

	public void setAssetAdsRevenue(int assetAdsRevenue) {
		this.assetAdsRevenue = assetAdsRevenue;
	}

	public Date getAssetUpdateDate() {
		return assetUpdateDate;
	}

	public void setAssetUpdateDate(Date assetUpdateDate) {
		this.assetUpdateDate = assetUpdateDate;
	}

	@Override
	public String toString() {
		return "Asset [cNo=" + cNo + ", cName=" + cName + ", pNo=" + pNo + ", pCost=" + pCost
				+ ", assetTotal=" + assetTotal + ", assetRevenue=" + assetRevenue + ", assetAdsRevenue="
				+ assetAdsRevenue + ", assetUpdateDate=" + assetUpdateDate + "]";
	}
	
	
}
