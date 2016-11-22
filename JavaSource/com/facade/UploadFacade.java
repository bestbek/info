package com.facade;

import java.io.Serializable;
import java.util.List;

import com.dao.UploadDAO;
import com.model.Upload;

/**
 * @author Mickey
 */
public class UploadFacade implements Serializable
{

	private static final long serialVersionUID = 1L;
	public UploadDAO uploadDAO = new UploadDAO();

	/**
	 * saves upload POJO (path to file location and organization which it
	 * belongs to)
	 * 
	 * @see com.dao.UploadDAO
	 * @param upload
	 * @return nothing
	 */
	public void createUpload(Upload upload)
	{
		uploadDAO.beginTransaction();
		uploadDAO.save(upload);
		uploadDAO.commitAndCloseTransaction();
	}

	/**
	 * @see com.dao.UploadDAO
	 * @return list of uploads from DB
	 */
	public List<Upload> listAll()
	{
		uploadDAO.beginTransaction();
		List<Upload> result = uploadDAO.findAll();
		uploadDAO.closeTransaction();
		return result;
	}
}
