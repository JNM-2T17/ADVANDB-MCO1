package model;

public class FishCount {
	private String mun;
	private String zone;
	private String brgy;
	private int aquanitype;
	private int fishcount;
	
	public FishCount(String mun, String zone, String brgy, int aquanitype,
			int fishcount) {
		super();
		this.mun = mun;
		this.zone = zone;
		this.brgy = brgy;
		this.aquanitype = aquanitype;
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

	public int getAquanitype() {
		return aquanitype;
	}

	public int getFishcount() {
		return fishcount;
	}

	@Override
	public String toString() {
		return "FishCount [mun=" + mun + ", zone=" + zone + ", brgy=" + brgy
				+ ", aquanitype=" + aquanitype + ", fishcount=" + fishcount
				+ "]";
	}
	
	
	
}
