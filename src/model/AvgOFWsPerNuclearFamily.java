package model;

public class AvgOFWsPerNuclearFamily {
	private String mun;
	private String zone;
	private String brgy;
	private String purok;
	private int sumNuclearFamilies;
	private int sumOFWs;
	private double avgOFWsPerNuclearFamily;
	
	public AvgOFWsPerNuclearFamily(String mun, String zone, String brgy,
			String purok, int sumNuclearFamilies, int sumOFWs,
			double avgOFWsPerNuclearFamily) {
		super();
		this.mun = mun;
		this.zone = zone;
		this.brgy = brgy;
		this.purok = purok;
		this.sumNuclearFamilies = sumNuclearFamilies;
		this.sumOFWs = sumOFWs;
		this.avgOFWsPerNuclearFamily = avgOFWsPerNuclearFamily;
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
	public String getPurok() {
		return purok;
	}
	public int getSumNuclearFamilies() {
		return sumNuclearFamilies;
	}
	public int getSumOFWs() {
		return sumOFWs;
	}
	public double getAvgOFWsPerNuclearFamily() {
		return avgOFWsPerNuclearFamily;
	}

	@Override
	public String toString() {
		return "AvgOFWsPerNuclearFamily [mun=" + mun + ", zone=" + zone
				+ ", brgy=" + brgy + ", purok=" + purok
				+ ", sumNuclearFamilies=" + sumNuclearFamilies + ", sumOFWs="
				+ sumOFWs + ", avgOFWsPerNuclearFamily="
				+ avgOFWsPerNuclearFamily + "]";
	}
}
