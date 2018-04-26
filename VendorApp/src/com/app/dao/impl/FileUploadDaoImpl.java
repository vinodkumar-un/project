package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IFileUploadDao;
import com.app.model.UploadFile;

@Repository
public class FileUploadDaoImpl implements IFileUploadDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public void saveUploadFile(UploadFile file) {
		ht.save(file);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getFileIdAndNames() {
		String hql = "select fileId,fileName from com.app.model.UploadFile";
		return (List<Object[]>) ht.find(hql);
	}

	@Override
	public UploadFile getFileObjById(int fileId) {

		return ht.get(UploadFile.class, fileId);
	}
}
