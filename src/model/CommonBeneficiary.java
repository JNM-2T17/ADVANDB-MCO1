package model;

public class CommonBeneficiary {
	private String mun;
	private String zone;
	private String brgy;
	private int benefCount;
	
	public CommonBeneficiary(String mun, String zone, String brgy,
			int benefCount) {
		super();
		this.mun = mun;
		this.zone = zone;
		this.brgy = brgy;
		this.benefCount = benefCount;
	}

	public String getMun() {
		return mun;
	}

	public String getZone() {
		return zone;
	}

	public String getBrgy() {
		return brgy;
	}

	public int getBenefCount() {
		return benefCount;
	}

	@Override
	public String toString() {
		return "CommonBeneficiary [mun=" + mun + ", zone=" + zone + ", brgy="
				+ brgy + ", benefCount=" + benefCount + "]";
	}
	
	
}
