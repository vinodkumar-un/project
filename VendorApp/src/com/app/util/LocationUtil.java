package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.service.ILocationService;

@Component
public class LocationUtil {

	@Autowired
	private ILocationService service;

	public List<Location> getAllLocations() {
		return service.viewAllLocations();
	}

	/**
	 * Charts Generation process
	 * 
	 * PieChart method
	 */
	public void generatePieChart(String path, List<Object[]> list) {
		// 1.construct dataset
		DefaultPieDataset dataSet = new DefaultPieDataset();
		for (Object[] ob : list) {
			dataSet.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		// 2.convert to jFreeChart ob using ChartFactory
		JFreeChart chart = ChartFactory.createPieChart3D(
				"Location wise Report", dataSet, true, true, false);

		try {
			ChartUtilities.saveChartAsJPEG(new File(path + "/reportA.jpg"),
					chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void generateBarChart(String path, List<Object[]> list) {
		// 1.construct dataset
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

		for (Object[] ob : list) {
			dataSet.setValue(new Double(ob[1].toString()), ob[0].toString(), "");
		}
		// 2. convert to jfreechart ob using ChartFactory
		JFreeChart chart = ChartFactory.createBarChart3D(
				"Location wise Report", "Location Type", "Location value",
				dataSet);
		// 3. save as image as using chartUtils

		try {
			ChartUtilities.saveChartAsJPEG(new File(path + "/reportB.jpg"),
					chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
