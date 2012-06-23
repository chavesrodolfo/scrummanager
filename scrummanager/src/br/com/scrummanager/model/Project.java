package br.com.scrummanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;

	@Column
	private String identification;

	@Column
	private String description;
	
	@Column
	private Date openingDate;
	
	@Column
	private Date closingDate;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<Sprint> sprints = new ArrayList<Sprint>();
	
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<Requirement> requirements = new ArrayList<Requirement>();
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<Impediment> impediments = new ArrayList<Impediment>();
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<People> people = new ArrayList<People>();
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<Conference> conferences = new ArrayList<Conference>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

	public List<Requirement> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirement> requirements) {
		this.requirements = requirements;
	}

	public List<Impediment> getImpediments() {
		return impediments;
	}

	public void setImpediments(List<Impediment> impediments) {
		this.impediments = impediments;
	}

	public List<People> getPeople() {
		return people;
	}

	public void setPeople(List<People> people) {
		this.people = people;
	}

	public List<Conference> getConferences() {
		return conferences;
	}

	public void setConferences(List<Conference> conferences) {
		this.conferences = conferences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((closingDate == null) ? 0 : closingDate.hashCode());
		result = prime * result
				+ ((conferences == null) ? 0 : conferences.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((identification == null) ? 0 : identification.hashCode());
		result = prime * result
				+ ((impediments == null) ? 0 : impediments.hashCode());
		result = prime * result
				+ ((openingDate == null) ? 0 : openingDate.hashCode());
		result = prime * result + ((people == null) ? 0 : people.hashCode());
		result = prime * result
				+ ((requirements == null) ? 0 : requirements.hashCode());
		result = prime * result + ((sprints == null) ? 0 : sprints.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (closingDate == null) {
			if (other.closingDate != null)
				return false;
		} else if (!closingDate.equals(other.closingDate))
			return false;
		if (conferences == null) {
			if (other.conferences != null)
				return false;
		} else if (!conferences.equals(other.conferences))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identification == null) {
			if (other.identification != null)
				return false;
		} else if (!identification.equals(other.identification))
			return false;
		if (impediments == null) {
			if (other.impediments != null)
				return false;
		} else if (!impediments.equals(other.impediments))
			return false;
		if (openingDate == null) {
			if (other.openingDate != null)
				return false;
		} else if (!openingDate.equals(other.openingDate))
			return false;
		if (people == null) {
			if (other.people != null)
				return false;
		} else if (!people.equals(other.people))
			return false;
		if (requirements == null) {
			if (other.requirements != null)
				return false;
		} else if (!requirements.equals(other.requirements))
			return false;
		if (sprints == null) {
			if (other.sprints != null)
				return false;
		} else if (!sprints.equals(other.sprints))
			return false;
		return true;
	}
}
