package br.site.model.patient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jsoup.helper.StringUtil;

@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String rg;
	
	@Column
	private String photo;
	
	public Patient() {
	}
	
	public Patient(String name, String rg, String photo) {
		this.name = name;
		this.setRg(rg);
		this.photo = photo;
	}
	
	public Patient(Integer id, String name, String rg, String photo) {
		this(name, rg, photo);
		this.id = id;
	}
	
	public Patient(String name, String rg) {
		this(name, rg, null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		if(StringUtil.isBlank(rg)) {
			this.rg = null;
		} else {
			this.rg = rg;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Patient other = (Patient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
