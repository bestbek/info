package com.dao;

import com.model.Upload;

public class UploadDAO extends GenericDAO<Upload>
{

	private static final long serialVersionUID = 1L;

	public UploadDAO()
	{
		super(Upload.class);
	}

	public void delete(Upload upload)
	{
		super.delete(upload.getId(), Upload.class);
	}

}
