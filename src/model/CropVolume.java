package model;

public class CropVolume {
	private String mun;
	private String zone;
	private String brgy;
	private int totalcrop;
	private int totalArea;
	private double cropDensity;
	
	public CropVolume(String mun, String zone, String brgy, int totalcrop,
			int totalArea, double cropDensity) {
		super();
		this.mun = mun;
		this.zone = zone;
		this.brgy = brgy;
		this.totalcrop = totalcrop;
		this.totalArea = totalArea;
		this.cropDensity = cropDensity;
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

	public int getTotalcrop() {
		return totalcrop;
	}

	public int getTotalArea() {
		return totalArea;
	}

	public double getCropDensity() {
		return cropDensity;
	}

	@Override
	public String toString() {
		return "CropVolume [mun=" + mun + ", zone=" + zone + ", brgy=" + brgy
				+ ", totalcrop=" + totalcrop + ", totalArea=" + totalArea
				+ ", cropDensity=" + cropDensity + "]";
	}
	
	
	
}
