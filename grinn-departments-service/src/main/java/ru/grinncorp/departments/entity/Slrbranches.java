/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.grinncorp.departments.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 *
 * @author agridin74
 */
@Entity
@Table(name = "SLRBRANCHES")
public class Slrbranches  {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SMNEMOCODE")
    private String smnemocode;
    
    @Basic(optional = false)
    @NotEmpty
    @Size(min = 1, max = 255)
    @Column(name = "SNM")
    private String snm;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbranches",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Slrdepartment> slrdepartments;
    
    @JoinColumn(name = "IDFACTORY", referencedColumnName = "ID")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Slrfactory idfactory;


    public Slrbranches() {
    }

    public Slrbranches(Long id) {
        this.id = id;
    }

    public Slrbranches(Long id, String smnemocode, String snm) {
        this.id = id;
        this.smnemocode = smnemocode;
        this.snm = snm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSmnemocode() {
        return smnemocode;
    }

    public void setSmnemocode(final String smnemocode) {
        this.smnemocode = smnemocode;
    }

    public String getSnm() {
        return snm;
    }

    public void setSnm(final String snm) {
        this.snm = snm;
    }

    
    public List<Slrdepartment> getSlrdepartments() {
    	final List<Slrdepartment> sortedDep = new ArrayList<>(getSlrdepartmentsInternal());
    	PropertyComparator.sort(sortedDep, new MutableSortDefinition("snm",true,true));
    	
        return Collections.unmodifiableList(sortedDep);
    }
    
    public void addSlrdepartment(Slrdepartment dep) {
    	getSlrdepartmentsInternal().add(dep);
    	dep.setIdbranches(this);
    }

    public void setSlrdepartments(Set<Slrdepartment> slrdepartments) {
        this.slrdepartments = slrdepartments;
    }

    public Slrfactory getIdfactory() {
        return idfactory;
    }

    public void setIdfactory(Slrfactory idfactory) {
        this.idfactory = idfactory;
    }
    
    protected Set<Slrdepartment> getSlrdepartmentsInternal(){
    	if(this.slrdepartments == null) {
    		this.slrdepartments = new HashSet<>();
    	}
    	return this.slrdepartments;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Slrbranches)) {
            return false;
        }
        Slrbranches other = (Slrbranches) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
        		.append("id", this.getId())
        		.append("snm",this.getSnm())
        		.toString();
    }
    
}
