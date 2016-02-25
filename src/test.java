import java.util.Collection;

import dao.OptimizedQueries;
import model.AvgDeathAge;
import model.AvgOFWsPerNuclearFamily;
import model.CatchRatio;
import model.CommonBeneficiary;
import model.CropVolume;
import model.FishCount;
import model.HealthyKids;


public class test {
	public static void main(String[] args){
		System.out.println("TEST");
		Collection<AvgOFWsPerNuclearFamily> list = OptimizedQueries.getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(0);
		System.out.println(list.size());
		System.out.println("TEST");
		Collection<HealthyKids> list2 = OptimizedQueries.getPlacesWithHealthyKidsGreaterThan(0,2);
		System.out.println(list2.size());
		System.out.println("TEST");
		Collection<AvgDeathAge> list3 = OptimizedQueries.getAvgDeathAgeGraterThan(0);
		System.out.println(list3.size());
		System.out.println("TEST");
		Collection<FishCount> list4 = OptimizedQueries.getFishCountsGreaterThan(0,6);
		System.out.println(list4.size());
		System.out.println("TEST");
		Collection<CropVolume> list5 = OptimizedQueries.getCropVolumesGreaterThan(0);
		System.out.println(list5.size());
		System.out.println("TEST");
		Collection<CatchRatio> list6 = OptimizedQueries.getCatchRatiosGreaterThan(0,2,2);
		System.out.println(list6.size());
		System.out.println("TEST");
		Collection<CommonBeneficiary> list7 = OptimizedQueries.getCommonBeneficiariesGraterThan(0);
		System.out.println(list7.size());
	}
}
 