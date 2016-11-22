package com.facade;

import java.io.Serializable;
import java.util.List;

import com.dao.ProvovFormaDAO;
import com.model.ProvovForma;

/**
 * 
 * @author Mickey
 *
 */
public class ProvovFormaFacade implements Serializable
{

	private static final long serialVersionUID = 1L; // required by Serializable
	private ProvovFormaDAO provovFormaDAO = new ProvovFormaDAO();

	public void createProvovForma(ProvovForma provovForma)
	{
		provovFormaDAO.beginTransaction();
		provovFormaDAO.save(provovForma);
		provovFormaDAO.commitAndCloseTransaction();
	}

	public List<ProvovForma> listAll()
	{
		provovFormaDAO.beginTransaction();
		List<ProvovForma> result = provovFormaDAO.findAll();
		provovFormaDAO.closeTransaction();
		return result;
	}

	public void deleteProvovForma(ProvovForma provovForma)
	{
		provovFormaDAO.beginTransaction();
		ProvovForma provovFormaRef = provovFormaDAO.findReferenceOnly(provovForma.getId());
		provovFormaDAO.delete(provovFormaRef);
		provovFormaDAO.commitAndCloseTransaction();
	}

	public void updateProvovForma(ProvovForma provovForma)
	{
		provovFormaDAO.beginTransaction();
		ProvovForma provovFormaPersist = provovFormaDAO.find(provovForma.getId());
		provovFormaPersist.setName(provovForma.getName());
		provovFormaPersist.setDescription(provovForma.getDescription());
		provovFormaDAO.update(provovFormaPersist);
		provovFormaDAO.commitAndCloseTransaction();
	}

	public ProvovForma findProvovForma(Integer provovFormaId)
	{
		provovFormaDAO.beginTransaction();
		ProvovForma provovForma = provovFormaDAO.find(provovFormaId);
		provovFormaDAO.closeTransaction();
		return provovForma;
	}
}
