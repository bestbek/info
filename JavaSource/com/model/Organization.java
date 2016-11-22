package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "organizations")
@NamedQuery(name = "Staff.findOrganizationByUserId", query = "select o from Organization o where o.user.id = :userId")
/**
 * 
 * @author Mickey
 *
 */
public class Organization implements Serializable
{

	private static final long serialVersionUID = 1L;
	public static final String FIND_ORGANIZATION_BY_USER_ID = "Staff.findOrganizationByUserId";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String legalForm;
	private String organizationName;
	private String ceoName;
	private String fax;
	private String phone;
	private String website;
	private String licenseNumber;
	@Temporal(TemporalType.DATE)
	private Date obtainedLicenseDate;
	@Temporal(TemporalType.DATE)
	private Date obtainedSvidetelstvaDate;
	private String address;
	//
	// private Set<Upload> uploads;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "provov_forma_id")
	private ProvovForma provovForma;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getLegalForm()
	{
		return legalForm;
	}

	public void setLegalForm(String legalForm)
	{
		this.legalForm = legalForm;
	}

	public String getOrganizationName()
	{
		return organizationName;
	}

	public void setOrganizationName(String organizationName)
	{
		this.organizationName = organizationName;
	}

	public String getCeoName()
	{
		return ceoName;
	}

	public void setCeoName(String ceoName)
	{
		this.ceoName = ceoName;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	public String getLicenseNumber()
	{
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber)
	{
		this.licenseNumber = licenseNumber;
	}

	public Date getObtainedLicenseDate()
	{
		return obtainedLicenseDate;
	}

	public void setObtainedLicenseDate(Date obtainedLicenseDate)
	{
		this.obtainedLicenseDate = obtainedLicenseDate;
	}

	public Date getObtainedSvidetelstvaDate()
	{
		return obtainedSvidetelstvaDate;
	}

	public void setObtainedSvidetelstvaDate(Date obtainedSvidetelstvaDate)
	{
		this.obtainedSvidetelstvaDate = obtainedSvidetelstvaDate;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public ProvovForma getProvovForma()
	{
		return provovForma;
	}

	public void setProvovForma(ProvovForma provovForma)
	{
		this.provovForma = provovForma;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	//
	// @OneToMany(cascade={CascadeType.REMOVE}, fetch = FetchType.EAGER)
	// @JoinTable(name="org_upload",joinColumns=@JoinColumn(name="organization_id"),inverseJoinColumns=@JoinColumn(name="upload_id"))
	// public Set<Upload> getUploads()
	// {
	// return uploads;
	// }
	//
	// public void setUploads(Set<Upload> uploads)
	// {
	// this.uploads = uploads;
	// }

	@Override
	public int hashCode()
	{
		return getId();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Organization)
		{
			Organization organization = (Organization) obj;
			return organization.getId() == id;
		}

		return false;
	}
}
