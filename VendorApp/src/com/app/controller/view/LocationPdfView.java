package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class LocationPdfView extends AbstractPdfView {

	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter arg2, HttpServletRequest arg3, HttpServletResponse arg4)
			throws Exception {

		List<Location> locList = (List<Location>) map.get("locListObj");

		PdfPTable table = new PdfPTable(3);
		table.addCell("LocationId");
		table.addCell("LocationName");
		table.addCell("LocationType");
		for (Location location : locList) {
			table.addCell(Integer.toString(location.getLocId()));
			table.addCell(location.getLocName());
			table.addCell(location.getLocType());

			Paragraph p = new Paragraph("Welcome to pdf file...,");
			document.add(p);
			document.add(table);
		}
	}
}
