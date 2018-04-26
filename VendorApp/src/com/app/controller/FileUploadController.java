package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.UploadFile;
import com.app.service.IFileUploadService;

@Controller
public class FileUploadController {

	@Autowired
	private IFileUploadService service;

	@RequestMapping("/uploadFile")
	public String showFileUpload(ModelMap map) {
		List<Object[]> obList = service.getFileIdAndNames();
		map.addAttribute("obList", obList);
		return "FileUpload";
	}

	@RequestMapping(value = "/uploadDoc", method = RequestMethod.POST)
	public String doUpload(@RequestParam("fileId") int fileId,
			@RequestParam("filessobj") CommonsMultipartFile fileObj) {

		if (fileObj != null) {
			String fileName = fileObj.getOriginalFilename();
			byte[] arr = fileObj.getBytes();
			UploadFile fileUploadObj = new UploadFile();
			fileUploadObj.setFileId(fileId);
			fileUploadObj.setFileName(fileName);
			fileUploadObj.setFileData(arr);

			service.saveUploadFile(fileUploadObj);
		}
		return "redirect:uploadFile";
	}

	@RequestMapping("/downloadFile")
	public void downloadFile(@RequestParam("fileId") int fileId,
			HttpServletResponse response) {

		UploadFile file = service.getFileObjById(fileId);
		response.setHeader("Content-Disposition",
				"attachment;filename=" + file.getFileName());

		try {
			FileCopyUtils.copy(file.getFileData(), response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
