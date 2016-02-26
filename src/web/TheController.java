package web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AvgDeathAge;
import model.AvgOFWsPerNuclearFamily;
import model.CatchRatio;
import model.CommonBeneficiary;
import model.CropVolume;
import model.FishCount;
import model.HealthyKids;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.BaseQueries;
import dao.IndexedQueries;
import dao.OptimizedQueries;
import dao.SPQueries;
import dao.ViewQueries;

@Controller
public class TheController {
	@RequestMapping("/")
	public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery1")
	public void baseQuery1(@RequestParam(value="val") int val, @RequestParam(value="type") int type, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<AvgOFWsPerNuclearFamily> list = null;
		long time = System.currentTimeMillis();
		switch(type){
		case 1:
			list = BaseQueries.getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(val);
			time = System.currentTimeMillis()-time;
			break;
		case 2:
			list = OptimizedQueries.getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(val);
			time = System.currentTimeMillis()-time;
			break;
		case 3:
			IndexedQueries.createIndexesForQuery1();
			time = System.currentTimeMillis();
			list = IndexedQueries.getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(val);
			time = System.currentTimeMillis()-time;
			IndexedQueries.dropIndexesForQuery1();
			break;
		case 4:
			SPQueries.createIndexesForQuery1();
			time = System.currentTimeMillis();
			list = SPQueries.getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(val);
			time = System.currentTimeMillis()-time;
			SPQueries.dropIndexesForQuery1();
			break;
		case 5:
			ViewQueries.createIndexesForQuery1();
			time = System.currentTimeMillis();
			list = ViewQueries.getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(val);
			time = System.currentTimeMillis()-time;
			ViewQueries.dropIndexesForQuery1();
			break;
		}
		request.setAttribute("avgofws", list);
		request.setAttribute("time", (Math.round(time * 1000.0) / 1000.0 / 1000.0)+"s");
		request.getRequestDispatcher("WEB-INF/view/query1_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery2")
	public void baseQuery2(@RequestParam(value="val") int val, @RequestParam(value="type") int type, 
			@RequestParam(value="minNutIndex") int minNutIndex, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<HealthyKids> list = null;
		long time = System.currentTimeMillis();
		switch(type){
		case 1:
			list = BaseQueries.getPlacesWithHealthyKidsGreaterThan(val, minNutIndex);
			time = System.currentTimeMillis()-time;
			break;
		case 2:
			list = OptimizedQueries.getPlacesWithHealthyKidsGreaterThan(val, minNutIndex);
			time = System.currentTimeMillis()-time;
			break;
		case 3:
			IndexedQueries.createIndexesForQuery2();
			time = System.currentTimeMillis();
			list = IndexedQueries.getPlacesWithHealthyKidsGreaterThan(val, minNutIndex);
			time = System.currentTimeMillis()-time;
			IndexedQueries.dropIndexesForQuery2();
			break;
		case 4:
			SPQueries.createIndexesForQuery2();
			time = System.currentTimeMillis();
			list = SPQueries.getPlacesWithHealthyKidsGreaterThan(val, minNutIndex);
			time = System.currentTimeMillis()-time;
			SPQueries.dropIndexesForQuery2();
			break;
		case 5:
			ViewQueries.createIndexesForQuery2();
			time = System.currentTimeMillis();
			list = ViewQueries.getPlacesWithHealthyKidsGreaterThan(val, minNutIndex);
			time = System.currentTimeMillis()-time;
			ViewQueries.dropIndexesForQuery2();
			break;
		}
		request.setAttribute("healthykids", list);
		request.setAttribute("time", (Math.round(time * 1000.0) / 1000.0 / 1000.0)+"s");
		request.getRequestDispatcher("WEB-INF/view/query2_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery3")
	public void baseQuery3(@RequestParam(value="val") int val, @RequestParam(value="type") int type,
			@RequestParam(value="deady") int deady, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<AvgDeathAge> list = null;
		long time = System.currentTimeMillis();
		switch(type){
		case 1:
			list = BaseQueries.getAvgDeathAgeGreaterThan(val, type);
			time = System.currentTimeMillis()-time;
			break;
		case 2:
			list = OptimizedQueries.getAvgDeathAgeGreaterThan(val, type);
			time = System.currentTimeMillis()-time;
			break;
		case 3:
			IndexedQueries.createIndexesForQuery3();
			time = System.currentTimeMillis();
			list = IndexedQueries.getAvgDeathAgeGreaterThan(val, type);
			time = System.currentTimeMillis()-time;
			IndexedQueries.dropIndexesForQuery3();
			break;
		case 4:
			SPQueries.createIndexesForQuery3();
			time = System.currentTimeMillis();
			list = SPQueries.getAvgDeathAgeGreaterThan(val, deady);
			time = System.currentTimeMillis()-time;
			SPQueries.dropIndexesForQuery3();
			break;
		case 5:
			ViewQueries.createIndexesForQuery3();
			time = System.currentTimeMillis();
			list = ViewQueries.getAvgDeathAgeGreaterThan(val, deady);
			time = System.currentTimeMillis()-time;
			ViewQueries.dropIndexesForQuery3();
			break;
		}
		request.setAttribute("avgdeaths", list);
		request.setAttribute("time", (Math.round(time * 1000.0) / 1000.0 / 1000.0)+"s");
		request.getRequestDispatcher("WEB-INF/view/query3_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery4")
	public void baseQuery4(@RequestParam(value="val") int val, @RequestParam(value="type") int type, 
			@RequestParam(value="aquanitype") int aquanitype, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<FishCount> list = null;
		long time = System.currentTimeMillis();
		switch(type){
		case 1:
			list = BaseQueries.getFishCountsGreaterThan(val, aquanitype);
			time = System.currentTimeMillis()-time;
			break;
		case 2:
			list = OptimizedQueries.getFishCountsGreaterThan(val, aquanitype);
			time = System.currentTimeMillis()-time;
			break;
		case 3:
			IndexedQueries.createIndexesForQuery4();
			time = System.currentTimeMillis();
			list = IndexedQueries.getFishCountsGreaterThan(val, aquanitype);
			time = System.currentTimeMillis()-time;
			IndexedQueries.dropIndexesForQuery4();
			break;
		case 4:
			SPQueries.createIndexesForQuery4();
			time = System.currentTimeMillis();
			list = SPQueries.getFishCountsGreaterThan(val, aquanitype);
			time = System.currentTimeMillis()-time;
			SPQueries.dropIndexesForQuery4();
			break;
		case 5:
			ViewQueries.createIndexesForQuery4();
			time = System.currentTimeMillis();
			list = ViewQueries.getFishCountsGreaterThan(val, aquanitype);
			time = System.currentTimeMillis()-time;
			ViewQueries.dropIndexesForQuery4();
			break;
		}
		request.setAttribute("fishcount", list);
		request.setAttribute("time", (Math.round(time * 1000.0) / 1000.0 / 1000.0)+"s");
		request.getRequestDispatcher("WEB-INF/view/query4_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery5")
	public void baseQuery5(@RequestParam(value="val") double val, @RequestParam(value="type") int type, 
			@RequestParam(value="croptype") int croptype, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<CropVolume> list = null;
		long time = System.currentTimeMillis();
		switch(type){
		case 1:
			list = BaseQueries.getCropVolumesGreaterThan(val,croptype);
			break;
		case 2:
			list = OptimizedQueries.getCropVolumesGreaterThan(val,croptype);
			break;
		case 3:
			IndexedQueries.createIndexesForQuery5();
			time = System.currentTimeMillis();
			list = IndexedQueries.getCropVolumesGreaterThan(val,croptype);
			time = System.currentTimeMillis()-time;
			IndexedQueries.dropIndexesForQuery5();
			break;
		case 4:
			SPQueries.createIndexesForQuery5();
			time = System.currentTimeMillis();
			list = SPQueries.getCropVolumesGreaterThan(val, croptype);
			time = System.currentTimeMillis()-time;
			SPQueries.dropIndexesForQuery5();
			break;
		case 5:
			ViewQueries.createIndexesForQuery5();
			time = System.currentTimeMillis();
			list = ViewQueries.getCropVolumesGreaterThan(val, croptype);
			time = System.currentTimeMillis()-time;
			ViewQueries.dropIndexesForQuery5();
			break;
		}
		request.setAttribute("cropvolume", list);
		request.setAttribute("time", (Math.round(time * 1000.0) / 1000.0 / 1000.0)+"s");
		request.getRequestDispatcher("WEB-INF/view/query5_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery6")
	public void baseQuery6(@RequestParam(value="val") double val, @RequestParam(value="type") int type,  
			@RequestParam(value="aquaequiptype") int aquaequiptype, @RequestParam(value="aquanitype") int aquanitype, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<CatchRatio> list = null;
		long time = System.currentTimeMillis();
		switch(type){
		case 1:
			list = BaseQueries.getCatchRatiosGreaterThan(val, aquaequiptype, aquanitype);
			time = System.currentTimeMillis()-time;
			break;
		case 2:
			list = OptimizedQueries.getCatchRatiosGreaterThan(val, aquaequiptype, aquanitype);
			time = System.currentTimeMillis()-time;
			break;
		case 3:
			IndexedQueries.createIndexesForQuery6();
			time = System.currentTimeMillis();
			list = IndexedQueries.getCatchRatiosGreaterThan(val, aquaequiptype, aquanitype);
			time = System.currentTimeMillis()-time;
			IndexedQueries.dropIndexesForQuery6();
			break;
		case 4:
			SPQueries.createIndexesForQuery6();
			time = System.currentTimeMillis();
			list = SPQueries.getCatchRatiosGreaterThan(val, aquaequiptype, aquanitype);
			time = System.currentTimeMillis()-time;
			SPQueries.dropIndexesForQuery6();
			break;
		case 5:
			ViewQueries.createIndexesForQuery6();
			time = System.currentTimeMillis();
			list = ViewQueries.getCatchRatiosGreaterThan(val, aquaequiptype, aquanitype);
			time = System.currentTimeMillis()-time;
			ViewQueries.dropIndexesForQuery6();
			break;
		}
		request.setAttribute("catchratios", list);
		request.setAttribute("time", (Math.round(time * 1000.0) / 1000.0 / 1000.0)+"s");
		request.getRequestDispatcher("WEB-INF/view/query6_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery7")
	public void baseQuery7(@RequestParam(value="val") int val, @RequestParam(value="type") int type, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<CommonBeneficiary> list = null;
		long time = System.currentTimeMillis();
		switch(type){
		case 1:
			list = BaseQueries.getCommonBeneficiariesGreaterThan(val);
			time = System.currentTimeMillis()-time;
			break;
		case 2:
			list = OptimizedQueries.getCommonBeneficiariesGreaterThan(val);
			time = System.currentTimeMillis()-time;
			break;
		case 3:
			IndexedQueries.createIndexesForQuery7();
			time = System.currentTimeMillis();
			list = IndexedQueries.getCommonBeneficiariesGreaterThan(val);
			time = System.currentTimeMillis()-time;
			IndexedQueries.dropIndexesForQuery7();
			break;
		case 4:
			SPQueries.createIndexesForQuery7();
			time = System.currentTimeMillis();
			list = SPQueries.getCommonBeneficiariesGreaterThan(val);
			time = System.currentTimeMillis()-time;
			SPQueries.dropIndexesForQuery7();
			break;
		case 5:
			ViewQueries.createIndexesForQuery7();
			time = System.currentTimeMillis();
			list = ViewQueries.getCommonBeneficiariesGreaterThan(val);
			time = System.currentTimeMillis()-time;
			ViewQueries.dropIndexesForQuery7();
			break;
		}
		request.setAttribute("commonbeneficiaries", list);
		request.setAttribute("time", (Math.round(time * 1000.0) / 1000.0 / 1000.0)+"s");
		request.getRequestDispatcher("WEB-INF/view/query7_results.jsp").forward(request, response);
	}
}
