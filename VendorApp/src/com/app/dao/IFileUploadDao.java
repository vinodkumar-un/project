package com.app.dao;

import java.util.List;

import com.app.model.UploadFile;

public interface IFileUploadDao {

	public void saveUploadFile(UploadFile file);

	public List<Object[]> getFileIdAndNames();

	public UploadFile getFileObjById(int fileId);

}
