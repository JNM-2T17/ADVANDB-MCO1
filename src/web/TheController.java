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

@Controller
public class TheController {
	@RequestMapping("/")
	public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery1")
	public void baseQuery1(@RequestParam(value="val") int val, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<AvgOFWsPerNuclearFamily> list = BaseQueries.getAvgOFWsPerNuclearFamilyWithOFWCountGreaterThan(val);
		request.setAttribute("avgofws", list);
		request.getRequestDispatcher("WEB-INF/view/query1_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery2")
	public void baseQuery2(@RequestParam(value="val") int val, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<HealthyKids> list = BaseQueries.getPlacesWithHealthyKidsGreaterThan(val);
		request.setAttribute("healthykids", list);
		request.getRequestDispatcher("WEB-INF/view/query2_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery3")
	public void baseQuery3(@RequestParam(value="val") int val, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<AvgDeathAge> list = BaseQueries.getAvgDeathAgeGraterThan(val);
		request.setAttribute("avgdeaths", list);
		request.getRequestDispatcher("WEB-INF/view/query3_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery4")
	public void baseQuery4(@RequestParam(value="val") int val, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<FishCount> list = BaseQueries.getFishCountsGraterThan(val);
		request.setAttribute("fishcount", list);
		request.getRequestDispatcher("WEB-INF/view/query4_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery5")
	public void baseQuery5(@RequestParam(value="val") double val, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<CropVolume> list = BaseQueries.getCropVolumesGraterThan(val);
		request.setAttribute("cropvolume", list);
		request.getRequestDispatcher("WEB-INF/view/query5_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery6")
	public void baseQuery6(@RequestParam(value="val") double val, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<CatchRatio> list = BaseQueries.getCatchRatiosGraterThan(val);
		request.setAttribute("catchratios", list);
		request.getRequestDispatcher("WEB-INF/view/query6_results.jsp").forward(request, response);
	}
	
	@RequestMapping("/BaseQuery7")
	public void baseQuery7(@RequestParam(value="val") int val, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Collection<CommonBeneficiary> list = BaseQueries.getCommonBeneficiariesGraterThan(val);
		request.setAttribute("commonbeneficiaries", list);
		request.getRequestDispatcher("WEB-INF/view/query7_results.jsp").forward(request, response);
	}
}
