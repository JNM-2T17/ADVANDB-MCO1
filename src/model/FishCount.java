package model;

public class FishCount {
	private String mun;
	private String zone;
	private String brgy;
	private int fishcount;
	
	public FishCount(String mun, String zone, String brgy,int fishcount) {
		super();
		this.mun = mun;
		this.zone = zone;
		this.brgy = brgy;
		this.fishcount = fishcount;
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

	public int getFishcount() {
		return fishcount;
	}

	@Override
	public String toString() {
		return "FishCount [mun=" + mun + ", zone=" + zone + ", brgy=" + brgy
				+ ", fishcount=" + fishcount
				+ "]";
	}
	
	
	
}
