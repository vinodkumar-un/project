package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Location;
import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.CommonUtil;
import com.app.util.LocationUtil;
import com.app.util.PerformanceUtil;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

@Controller
public class VendorController {
	@Autowired
	private IVendorService service;

	/**
	 * to integrate location with vendor using LocationUtil has a with vendor
	 * controller
	 */
	@Autowired
	private LocationUtil locUtil;

	@Autowired
	private CommonUtil commonUtil;

	// @Autowired
	// private PerformanceUtil performanceUtil;

	// show page
	@RequestMapping("/regVen")
	public String showVendorPage(ModelMap map) {
		List<Location> locList = locUtil.getAllLocations();
		map.addAttribute("locData", locList);
		return "VendorReg";
	}

	// save data

	@RequestMapping(value = "/insertVen", method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor,
			ModelMap map, @RequestParam("file") CommonsMultipartFile file) {

		Monitor monitor = MonitorFactory.start("java monitoring");
		int id = (Integer) service.saveVendor(vendor);
		// String report = MonitorFactory.getReport();

		String msg = "vendor saved with id: " + id;
		monitor.stop();

		/** adding lines to display locations after insert */

		List<Location> locList = locUtil.getAllLocations();
		map.addAttribute("locData", locList);
		/** end */

		/**
		 * sending email
		 */
		commonUtil.sendMail(vendor.getVenMail(), "Registered as vendor", msg,
				file);
		map.addAttribute("venData", msg);
		return "VendorReg";
	}

	@RequestMapping(value = "/allVen")
	public String getAllVendors(ModelMap map) {
		List<Vendor> listvdr = service.getAllVendors();

		map.addAttribute("allVenData", listvdr);
		return "VendorData";
	}

	@RequestMapping(value = "/deleteVen")
	public String deleteVendorById(@RequestParam("venId") int id) {
		service.deleteVendorById(id);
		return "redirect:allVen";
	}

	@RequestMapping(value = "/fetchById")
	public String fetchVendorById(@RequestParam("venId") int venId, ModelMap map) {
		Vendor vdr = service.getVendorById(venId);
		map.addAttribute("venData", vdr);
		return "VendorUpdate";
	}

	@RequestMapping(value = "/updateVen", method = RequestMethod.POST)
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor) {
		service.updateVendor(vendor);
		return "redirect:allVen";
	}

}
