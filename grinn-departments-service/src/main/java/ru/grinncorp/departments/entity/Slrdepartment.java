/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.grinncorp.departments.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.core.style.ToStringCreator;

/**
 * Simple JavaBean domain object representing an slrdepartment.
 * @author agridin74
 */
@Entity
@Table(name = "SLRDEPARTMENT")
public class Slrdepartment  {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPARENT")
    private long idparent;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SNM")
    private String snm;
    
    @Column(name = "CODINREF")
    private Long codinref;
    
    @Column(name = "IDCARD")
    private Long idcard;
    
    @Size(max = 255)
    @Column(name = "SREMARK")
    private String sremark;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SMNEMOCODE")
    private String smnemocode;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SLEVEL")
    private String slevel;
    
    @Size(max = 255)
    @Column(name = "SNMLONG")
    private String snmlong;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DBEGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dbegin;
    
    @Column(name = "DEND")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dend;
    
    @Column(name = "DENDORDER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dendorder;
    
    @Column(name = "DENDCLOSE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dendclose;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "LLIST")
    private Character llist;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "LHIDE")
    private Character lhide;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "LNVD")
    private Character lnvd;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "LNOISHL")
    private Character lnoishl;

    @JoinColumn(name = "IDFACTORY", referencedColumnName = "ID")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Slrfactory idfactory;
    
    @JoinColumn(name = "IDBRANCHES", referencedColumnName = "ID")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Slrbranches idbranches;

    public Slrdepartment() {
    }

    public Slrdepartment(Long id) {
        this.id = id;
    }

    public Slrdepartment(Long id, long idparent, String snm, char llist, char lhide, String smnemocode, String slevel, char lnvd, Date dbegin, char lnoishl) {
        this.id = id;
        this.idparent = idparent;
        this.snm = snm;
        this.llist = llist;
        this.lhide = lhide;
        this.smnemocode = smnemocode;
        this.slevel = slevel;
        this.lnvd = lnvd;
        this.dbegin = dbegin;
        this.lnoishl = lnoishl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdparent() {
        return idparent;
    }

    public void setIdparent(long idparent) {
        this.idparent = idparent;
    }

    public String getSnm() {
        return snm;
    }

    public void setSnm(String snm) {
        this.snm = snm;
    }


    public Long getCodinref() {
        return codinref;
    }

    public void setCodinref(Long codinref) {
        this.codinref = codinref;
    }


    public Long getIdcard() {
        return idcard;
    }

    public void setIdcard(Long idcard) {
        this.idcard = idcard;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
    }

    public String getSmnemocode() {
        return smnemocode;
    }

    public void setSmnemocode(String smnemocode) {
        this.smnemocode = smnemocode;
    }

    public String getSlevel() {
        return slevel;
    }

    public void setSlevel(String slevel) {
        this.slevel = slevel;
    }


    public String getSnmlong() {
        return snmlong;
    }

    public void setSnmlong(String snmlong) {
        this.snmlong = snmlong;
    }

    public Date getDbegin() {
        return dbegin;
    }

    public void setDbegin(Date dbegin) {
        this.dbegin = dbegin;
    }

    public Date getDend() {
        return dend;
    }

    public void setDend(Date dend) {
        this.dend = dend;
    }


    public Date getDendorder() {
        return dendorder;
    }

    public void setDendorder(Date dendorder) {
        this.dendorder = dendorder;
    }

    public Date getDendclose() {
        return dendclose;
    }

    public void setDendclose(Date dendclose) {
        this.dendclose = dendclose;
    }


    public Slrfactory getIdfactory() {
        return idfactory;
    }

    public void setIdfactory(Slrfactory idfactory) {
        this.idfactory = idfactory;
    }

    public Slrbranches getIdbranches() {
        return idbranches;
    }

    public void setIdbranches(Slrbranches idbranches) {
        this.idbranches = idbranches;
    }

    public Character getLlist() {
        return llist;
    }

    public void setLlist(Character llist) {
        this.llist = llist;
    }

    public Character getLhide() {
        return lhide;
    }

    public void setLhide(Character lhide) {
        this.lhide = lhide;
    }

    public Character getLnvd() {
        return lnvd;
    }

    public void setLnvd(Character lnvd) {
        this.lnvd = lnvd;
    }

    public Character getLnoishl() {
        return lnoishl;
    }

    public void setLnoishl(Character lnoishl) {
        this.lnoishl = lnoishl;
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
        if (!(object instanceof Slrdepartment)) {
            return false;
        }
        Slrdepartment other = (Slrdepartment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return new ToStringCreator(this)
        		.append("id",this.getId())
        		.append("smnemocode",smnemocode)
        		.append("snm", snm)
        		.toString();
    }
}
