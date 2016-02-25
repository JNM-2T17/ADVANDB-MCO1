package model;

public class CatchRatio {
	private String mun;
	private String zone;
	private String brgy;
	private long totalequip;
	private long totalvol;
	private double catchPerEquip;
	
	public CatchRatio(String mun, String zone, String brgy, long totalequip,
			long totalvol, double catchPerEquip) {
		super();
		this.mun = mun;
		this.zone = zone;
		this.brgy = brgy;
		this.totalequip = totalequip;
		this.totalvol = totalvol;
		this.catchPerEquip = catchPerEquip;
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

	public long getTotalequip() {
		return totalequip;
	}

	public long getTotalvol() {
		return totalvol;
	}

	public double getCatchPerEquip() {
		return catchPerEquip;
	}

	@Override
	public String toString() {
		return "CatchRatio [mun=" + mun + ", zone=" + zone + ", brgy=" + brgy
				+ ", totalequip=" + totalequip + ", totalvol=" + totalvol
				+ ", catchPerEquip=" + catchPerEquip + "]";
	}
	
	
}
