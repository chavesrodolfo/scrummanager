package br.com.scrummanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Conference implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private Date registrationDate;
	
	@Column
	private String identification;
	
	@Column
	private String description;
	
	@Column
	private String sprintReview;
	
	@Column
	private String approved;
	
	@Column
	private String approvedReason;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project", referencedColumnName = "id")
    private Project project;// vem do (mappedBy="sprint", fetch=FetchType.LAZY)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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

	public String getSprintReview() {
		return sprintReview;
	}

	public void setSprintReview(String sprintReview) {
		this.sprintReview = sprintReview;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getApprovedReason() {
		return approvedReason;
	}

	public void setApprovedReason(String approvedReason) {
		this.approvedReason = approvedReason;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((approved == null) ? 0 : approved.hashCode());
		result = prime * result
				+ ((approvedReason == null) ? 0 : approvedReason.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((identification == null) ? 0 : identification.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime
				* result
				+ ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result
				+ ((sprintReview == null) ? 0 : sprintReview.hashCode());
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
		Conference other = (Conference) obj;
		if (approved == null) {
			if (other.approved != null)
				return false;
		} else if (!approved.equals(other.approved))
			return false;
		if (approvedReason == null) {
			if (other.approvedReason != null)
				return false;
		} else if (!approvedReason.equals(other.approvedReason))
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
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (sprintReview == null) {
			if (other.sprintReview != null)
				return false;
		} else if (!sprintReview.equals(other.sprintReview))
			return false;
		return true;
	}
}
