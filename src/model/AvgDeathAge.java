package model;

public class AvgDeathAge {
	private String mun;
	private String zone;
	private String brgy;
	private int mdeadsx;
	private double avg_death_age;
	
	public AvgDeathAge(String mun, String zone, String brgy, int mdeadsx,
			double avg_death_age) {
		super();
		this.mun = mun;
		this.zone = zone;
		this.brgy = brgy;
		this.mdeadsx = mdeadsx;
		this.avg_death_age = avg_death_age;
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

	public int getMdeadsx() {
		return mdeadsx;
	}

	public double getAvg_death_age() {
		return avg_death_age;
	}

	@Override
	public String toString() {
		return "AvgDeathAge [mun=" + mun + ", zone=" + zone + ", brgy=" + brgy
				+ ", mdeadsx=" + mdeadsx + ", avg_death_age=" + avg_death_age
				+ "]";
	}
	
	
	
	
}
