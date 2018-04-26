package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;
import com.app.validator.LocationValidator;

@Controller
public class LocationController {
	
	@Autowired
	private ILocationService service;

	@Autowired
	private ServletContext context;

	@Autowired
	private LocationUtil util;

	@Autowired
	private LocationValidator validator;

	@RequestMapping("/regLoc")
	public String regLocation() {
		return "LocationReg";
	}

	@RequestMapping(value = "/insertLoc", method = RequestMethod.POST)
	public String saveLocation(@ModelAttribute("location") Location location,
			ModelMap map) {
		String msg = validator.doValidateLocName(location.getLocName());
		if (msg != null) {
			// data has error
			map.addAttribute("msg", msg);
		} else {
			// save data-no error
			int id = service.saveLocation(location);
			map.addAttribute("modelData", "saving to database with " + id);
		}
		return "LocationReg";
	}

	@RequestMapping(value = "/searchAllLoc")
	public String showAllLocations(ModelMap map) {
		List<Location> loc = service.viewAllLocations();
		map.addAttribute("listLoc", loc);
		return "ShowAllLoc";
	}

	@RequestMapping(value = "/editLocById")
	public String editLocation(@RequestParam("locId") int id, ModelMap map) {
		Location loc = service.showLocById(id);
		map.addAttribute("locData", loc);
		return "LocUpdate";
	}

	@RequestMapping(value = "/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location loc) {
		service.updateLoc(loc);
		return "redirect:searchAllLoc";
	}

	@RequestMapping("/deleteLoc")
	public String deleteLocById(@RequestParam("locId") int id) {
		service.deleteLocById(id);
		return "redirect:searchAllLoc";
	}

	@RequestMapping("/locExcelExport")
	public String exportDataExcel(ModelMap map) {
		List<Location> locList = service.viewAllLocations();
		map.addAttribute("locListObj", locList);
		return "LocExcel";
	}

	@RequestMapping("/locPdfExport")
	public String exportDataPdf(ModelMap map) {
		List<Location> locList = service.viewAllLocations();
		map.addAttribute("locListObj", locList);
		return "LocPdf";
	}

	@RequestMapping("/generateReport")
	public String generateCharts() {
		List<Object[]> list = service.getLocationWiseCount();
		String path = context.getRealPath("/");

		util.generatePieChart(path, list);
		util.generateBarChart(path, list);
		return "LocReport";
	}
}
