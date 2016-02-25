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
import dao.OptimizedQueries;

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
			break;
		case 2:
			list = OptimizedQueries.getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(val);
			break;
		}
		time = System.currentTimeMillis()-time;
		request.setAttribute("avgofws", list);
		System.out.println(time);
		request.setAttribute("time", time);
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
			break;
		case 2:
			list = OptimizedQueries.getPlacesWithHealthyKidsGreaterThan(val, minNutIndex);
			break;
		}
		time = System.currentTimeMillis()-time;
		request.setAttribute("healthykids", list);
		request.setAttribute("time", time);
		request.getRequestDispatcher("WEB-INF/view/query2_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery3")
	public void baseQuery3(@RequestParam(value="val") int val, @RequestParam(value="type") int type, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<AvgDeathAge> list = null;
		long time = System.currentTimeMillis();
		switch(type){
		case 1:
			list = BaseQueries.getAvgDeathAgeGreaterThan(val);
			break;
		case 2:
			list = OptimizedQueries.getAvgDeathAgeGreaterThan(val);
			break;
		}
		time = System.currentTimeMillis()-time;
		request.setAttribute("avgdeaths", list);
		request.setAttribute("time", time);
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
			break;
		case 2:
			list = OptimizedQueries.getFishCountsGreaterThan(val, aquanitype);
			break;
		}
		request.setAttribute("fishcount", list);
		request.setAttribute("time", time);
		request.getRequestDispatcher("WEB-INF/view/query4_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery5")
	public void baseQuery5(@RequestParam(value="val") double val, @RequestParam(value="type") int type, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<CropVolume> list = null;
		long time = System.currentTimeMillis();
		switch(type){
		case 1:
			list = BaseQueries.getCropVolumesGreaterThan(val);
			break;
		case 2:
			list = OptimizedQueries.getCropVolumesGreaterThan(val);
			break;
		}
		request.setAttribute("cropvolume", list);
		request.setAttribute("time", time);
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
			break;
		case 2:
			list = OptimizedQueries.getCatchRatiosGreaterThan(val, aquaequiptype, aquanitype);
			break;
		}
		request.setAttribute("catchratios", list);
		request.setAttribute("time", time);
		request.getRequestDispatcher("WEB-INF/view/query6_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery7")
	public void baseQuery7(@RequestParam(value="val") int val, @RequestParam(value="type") int type, 
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HELLO SHIT");
		Collection<CommonBeneficiary> list = null;
		long time = System.currentTimeMillis();
		switch(type){
		case 1:
			list = BaseQueries.getCommonBeneficiariesGreaterThan(val);
			break;
		case 2:
			list = OptimizedQueries.getCommonBeneficiariesGreaterThan(val);
			break;
		}
		request.setAttribute("commonbeneficiaries", list);
		request.setAttribute("time", time);
		request.getRequestDispatcher("WEB-INF/view/query7_results.jsp").forward(request, response);
	}
}
