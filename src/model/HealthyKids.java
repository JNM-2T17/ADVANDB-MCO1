package model;

public class HealthyKids {
	private String country_resid;
	private String prov_resid_code;
	private int mnutind;
	private int nutCount;
	
	public HealthyKids(String country_resid, String prov_resid_code,
			int mnutind, int nutCount) {
		super();
		this.country_resid = country_resid;
		this.prov_resid_code = prov_resid_code;
		this.mnutind = mnutind;
		this.nutCount = nutCount;
	}

	public String getCountry_resid() {
		return country_resid;
	}

	public String getProv_resid_code() {
		return prov_resid_code;
	}

	public int getMnutind() {
		return mnutind;
	}

	public int getNutCount() {
		return nutCount;
	}

	@Override
	public String toString() {
		return "HealthyKids [country_resid=" + country_resid
				+ ", prov_resid_code=" + prov_resid_code + ", mnutind="
				+ mnutind + ", nutCount=" + nutCount + "]";
	}
	
	
	
}
