package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "staffs")
@NamedQuery(name = "Staff.sortedList", query = "select s from Staff s where s.organization.id = :organizationId")
/**
 * 
 * @author Mickey
 *
 */
public class Staff implements Serializable
{

	private static final long serialVersionUID = 1L;
	public static final String FIND_SORTED_STAFF_LIST = "Staff.sortedList";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	@Column(name = "home_phone")
	private String homePhone;
	@Column(name = "mobile_phone")
	private String mobilePhone;
	@Column(name = "working_phone")
	private String workingPhone;
	@Column(name = "home_address")
	private String homeAddress;
	private String website;
	@Column(name = "bank_rekvezit")
	private String bankRekvezit;
	private String position;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organization_id")
	private Organization organization;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getHomePhone()
	{
		return homePhone;
	}

	public void setHomePhone(String homePhone)
	{
		this.homePhone = homePhone;
	}

	public String getMobilePhone()
	{
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone)
	{
		this.mobilePhone = mobilePhone;
	}

	public String getWorkingPhone()
	{
		return workingPhone;
	}

	public void setWorkingPhone(String workingPhone)
	{
		this.workingPhone = workingPhone;
	}

	public String getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress)
	{
		this.homeAddress = homeAddress;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	public String getBankRekvezit()
	{
		return bankRekvezit;
	}

	public void setBankRekvezit(String bankRekvezit)
	{
		this.bankRekvezit = bankRekvezit;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public Organization getOrganization()
	{
		return organization;
	}

	public void setOrganization(Organization organization)
	{
		this.organization = organization;
	}

	@Override
	public int hashCode()
	{
		return getId();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Staff)
		{
			Staff staff = (Staff) obj;
			return staff.getId() == id;
		}
		return false;
	}
}
