import java.util.Collection;

import dao.BaseQueries;
import model.AvgDeathAge;
import model.AvgOFWsPerNuclearFamily;
import model.CatchRatio;
import model.CommonBeneficiary;
import model.CropVolume;
import model.FishCount;
import model.HealthyKids;


public class test {
	public static void main(String[] args){
		Collection<AvgOFWsPerNuclearFamily> list = BaseQueries.getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(0);
		System.out.println(list.size());
		Collection<HealthyKids> list2 = BaseQueries.getPlacesWithHealthyKidsGreaterThan(0);
		System.out.println(list2.size());
		Collection<AvgDeathAge> list3 = BaseQueries.getAvgDeathAgeGraterThan(0);
		System.out.println(list3.size());
		Collection<FishCount> list4 = BaseQueries.getFishCountsGraterThan(0);
		System.out.println(list4.size());
		Collection<CatchRatio> list6 = BaseQueries.getCatchRatiosGraterThan(0);
		System.out.println(list6.size());
		Collection<CommonBeneficiary> list7 = BaseQueries.getCommonBeneficiariesGraterThan(0);
		System.out.println(list7.size());
	}
}
 