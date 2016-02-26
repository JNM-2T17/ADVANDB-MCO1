package model;

public class HealthyKids {
	private String country_resid;
	private String prov_resid_code;
	private String nutStatus;
	private int nutCount;
	
	public HealthyKids(String country_resid, String prov_resid_code,
			int mnutind, int nutCount) {
		super();
		this.country_resid = country_resid;
		this.prov_resid_code = prov_resid_code;
		switch(mnutind){
		case 1:
			nutStatus = "Above Normal";
			break;
		case 2:
			nutStatus = "Normal";
			break;
		case 3:
			nutStatus = "Below Normal (Moderate)";
			break;
		case 4:
			nutStatus = "Below Normal (Severe)";
			break;
		}
		this.nutCount = nutCount;
	}

	public String getCountry_resid() {
		return country_resid;
	}

	public String getProv_resid_code() {
		return prov_resid_code;
	}

	public String getNutStatus() {
		return nutStatus;
	}

	public int getNutCount() {
		return nutCount;
	}

	@Override
	public String toString() {
		return "HealthyKids [country_resid=" + country_resid
				+ ", prov_resid_code=" + prov_resid_code + ", nutStatus="
				+ nutStatus + ", nutCount=" + nutCount + "]";
	}
	
	
	
}
