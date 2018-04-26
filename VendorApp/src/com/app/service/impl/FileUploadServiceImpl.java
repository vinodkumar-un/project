package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IFileUploadDao;
import com.app.model.UploadFile;
import com.app.service.IFileUploadService;

@Service
public class FileUploadServiceImpl implements IFileUploadService {

	@Autowired
	private IFileUploadDao dao;

	@Override
	public void saveUploadFile(UploadFile file) {
		dao.saveUploadFile(file);
	}

	@Override
	public List<Object[]> getFileIdAndNames() {
		return dao.getFileIdAndNames();
	}

	@Override
	public UploadFile getFileObjById(int fileId) {

		return dao.getFileObjById(fileId);
	}

}
