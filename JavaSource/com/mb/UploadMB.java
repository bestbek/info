package com.mb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.facade.UploadFacade;
import com.model.Organization;
import com.model.Upload;

/**
 * @author Mickey
 */
@ManagedBean(name = "uploadMB")
public class UploadMB extends AbstractMB
{
	private UploadFacade uploadFacade;
	private Upload upload;
	private List<Upload> uploads;
	private UploadedFile uploadedFile;

	/**
	 * assumes that upload is not equal to null and reset upload to new Upload;
	 * 
	 * @param Upload
	 */
	public void createUpload()
	{	
		File file = new File("uploads");
		file.mkdirs();
		if(upload == null){
			System.out.println(" This is null value ");
		}
		getUploadFacade().createUpload(upload);
		closeDialog();
		displayInfoMessageToUser("Created With Sucess");
		loadUploads();
		resetUpload();
	}

	public void uploadHandler(FileUploadEvent event)
	{
		FacesMessage message = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded");
		FacesContext.getCurrentInstance().addMessage(null, message);
		try
		{
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException io)
		{
			io.printStackTrace();
		}
	}

	// future me pls forgive me for this smell code
	public void copyFile(String fileName, InputStream in)
	{
		File file = new File("uploads");
		if (!file.exists())
		{
			file.mkdirs();
		}
		try (OutputStream out = new FileOutputStream(new File("uploads/" + fileName));)
		{

			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = in.read(bytes)) != -1)
			{
				out.write(bytes, 0, read);
			}
			out.flush();
			in.close();
			getUpload().setPath(fileName);
			getUpload().setOrganization(new Organization());
			System.out.println("FInishedn \n\n\n");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public UploadFacade getUploadFacade()
	{
		if (uploadFacade == null)
			uploadFacade = new UploadFacade();
		return uploadFacade;
	}

	public Upload getUpload()
	{
		if (upload == null)
			upload = new Upload();
		return upload;
	}

	public void setUpload(Upload upload)
	{
		this.upload = upload;
	}

	/**
	 * reset upload
	 */
	public void resetUpload()
	{
		upload = new Upload();
	}

	public List<Upload> getAllUploads()
	{
		if (uploads == null)
			loadUploads();
		return uploads;
	}

	public void loadUploads()
	{
		uploads = getUploadFacade().listAll();
	}

	public UploadedFile getUploadedFile()
	{
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile)
	{
		this.uploadedFile = uploadedFile;
	}

}
