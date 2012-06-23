package br.com.scrummanager.model;

import java.io.Serializable;

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
public class Task implements Serializable{

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
	private String effortHours;
	
	@Column
	private String status;
	
	@Column
	private String statusTest;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sprint", referencedColumnName = "id")
    private Sprint sprint;// vem do (mappedBy="sprint", fetch=FetchType.LAZY)

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

	public String getEffortHours() {
		return effortHours;
	}

	public void setEffortHours(String effortHours) {
		this.effortHours = effortHours;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusTest() {
		return statusTest;
	}

	public void setStatusTest(String statusTest) {
		this.statusTest = statusTest;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((effortHours == null) ? 0 : effortHours.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((identification == null) ? 0 : identification.hashCode());
		result = prime * result + ((sprint == null) ? 0 : sprint.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((statusTest == null) ? 0 : statusTest.hashCode());
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
		Task other = (Task) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (effortHours == null) {
			if (other.effortHours != null)
				return false;
		} else if (!effortHours.equals(other.effortHours))
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
		if (sprint == null) {
			if (other.sprint != null)
				return false;
		} else if (!sprint.equals(other.sprint))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusTest == null) {
			if (other.statusTest != null)
				return false;
		} else if (!statusTest.equals(other.statusTest))
			return false;
		return true;
	}
}
