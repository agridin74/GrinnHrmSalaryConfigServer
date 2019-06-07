/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.grinncorp.departments.entity;


import java.math.BigInteger;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

/**
 * Simple JavaBean domain object representing an slrfactory
 * @author agridin74
 */
@Entity
@Table(name = "SLRFACTORY")
public class Slrfactory  {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "SNM")
    private String snm;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SLONGNAME")
    private String slongname;
    
    @Size(max = 255)
    @Column(name = "SOKPO")
    private String sokpo;
    
    @Size(max = 255)
    @Column(name = "SOKONH")
    private String sokonh;
    
    @Size(max = 255)
    @Column(name = "STOWN")
    private String stown;
    
    @Size(max = 200)
    @Column(name = "SADRESS")
    private String sadress;
    
    @Size(max = 200)
    @Column(name = "SADRESSF")
    private String sadressf;
    
    @Size(max = 30)
    @Column(name = "SPHONE")
    private String sphone;
    
    @Size(max = 12)
    @Column(name = "SINN")
    private String sinn;
    
    @Size(max = 10)
    @Column(name = "SKPP")
    private String skpp;
    
    @Size(max = 10)
    @Column(name = "SGNI")
    private String sgni;
    
    @Size(max = 100)
    @Column(name = "SBANK")
    private String sbank;
    
    @Size(max = 255)
    @Column(name = "SFIO1")
    private String sfio1;
    
    @Size(max = 255)
    @Column(name = "SFIO2")
    private String sfio2;
    
    @Size(max = 255)
    @Column(name = "SFIO3")
    private String sfio3;
    
    @Size(max = 255)
    @Column(name = "SFIO4")
    private String sfio4;
    
    @Size(max = 255)
    @Column(name = "SFIO5")
    private String sfio5;
    
    @Column(name = "CODBR")
    private BigInteger codbr;
    
    @Size(max = 20)
    @Column(name = "SPFNUMBER")
    private String spfnumber;
    
    @Size(max = 255)
    @Column(name = "SFIO6")
    private String sfio6;
    
    @Size(max = 20)
    @Column(name = "SOKVED")
    private String sokved;
    
    @Size(max = 20)
    @Column(name = "SOKOPF")
    private String sokopf;
    
    @Size(max = 20)
    @Column(name = "SOKATO")
    private String sokato;
    
    @Size(max = 20)
    @Column(name = "SOKOGU")
    private String sokogu;
    
    @Size(max = 20)
    @Column(name = "SOKDP")
    private String sokdp;
    
    @Size(max = 60)
    @Column(name = "SGNINAME")
    private String sgniname;
    
    @Size(max = 20)
    @Column(name = "SOKFS")
    private String sokfs;
    
    @Size(max = 6)
    @Column(name = "SINDEX")
    private String sindex;
    
    @Size(max = 40)
    @Column(name = "SREGION")
    private String sregion;
    
    @Size(max = 40)
    @Column(name = "SVILLAGE")
    private String svillage;
    
    @Size(max = 40)
    @Column(name = "SSTREET")
    private String sstreet;
    
    @Size(max = 10)
    @Column(name = "SHOUSE")
    private String shouse;
    @Size(max = 10)
    @Column(name = "SKORPUS")
    private String skorpus;
    
    @Size(max = 10)
    @Column(name = "SFLAT")
    private String sflat;
    
    @Size(max = 13)
    @Column(name = "SOGRN")
    private String sogrn;
    
    @Size(max = 10)
    @Column(name = "SFSSNUMBER")
    private String sfssnumber;
    
    @Size(max = 5)
    @Column(name = "SFSSPARENTNUMBER")
    private String sfssparentnumber;
    
    @Size(max = 10)
    @Column(name = "SFSSADDNUMBER")
    private String sfssaddnumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfactory",fetch = FetchType.EAGER)
    private Set<Slrdepartment> slrdepartments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfactory",fetch = FetchType.EAGER)
    private Set<Slrbranches> slrbranchess;
   
 
    public Slrfactory() {
    }

    public Slrfactory(Long id) {
        this.id = id;
    }

    public Slrfactory(Long id, String snm, String slongname) {
        this.id = id;
        this.snm = snm;
        this.slongname = slongname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSnm() {
        return snm;
    }

    public void setSnm(String snm) {
        this.snm = snm;
    }

    public String getSlongname() {
        return slongname;
    }

    public void setSlongname(String slongname) {
        this.slongname = slongname;
    }

    public String getSokpo() {
        return sokpo;
    }

    public void setSokpo(String sokpo) {
        this.sokpo = sokpo;
    }

    public String getSokonh() {
        return sokonh;
    }

    public void setSokonh(String sokonh) {
        this.sokonh = sokonh;
    }

    public String getStown() {
        return stown;
    }

    public void setStown(String stown) {
        this.stown = stown;
    }

    public String getSadress() {
        return sadress;
    }

    public void setSadress(String sadress) {
        this.sadress = sadress;
    }

    public String getSadressf() {
        return sadressf;
    }

    public void setSadressf(String sadressf) {
        this.sadressf = sadressf;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSinn() {
        return sinn;
    }

    public void setSinn(String sinn) {
        this.sinn = sinn;
    }

    public String getSkpp() {
        return skpp;
    }

    public void setSkpp(String skpp) {
        this.skpp = skpp;
    }

    public String getSgni() {
        return sgni;
    }

    public void setSgni(String sgni) {
        this.sgni = sgni;
    }

    public String getSbank() {
        return sbank;
    }

    public void setSbank(String sbank) {
        this.sbank = sbank;
    }

    public String getSfio1() {
        return sfio1;
    }

    public void setSfio1(String sfio1) {
        this.sfio1 = sfio1;
    }

    public String getSfio2() {
        return sfio2;
    }

    public void setSfio2(String sfio2) {
        this.sfio2 = sfio2;
    }

    public String getSfio3() {
        return sfio3;
    }

    public void setSfio3(String sfio3) {
        this.sfio3 = sfio3;
    }

    public String getSfio4() {
        return sfio4;
    }

    public void setSfio4(String sfio4) {
        this.sfio4 = sfio4;
    }

    public String getSfio5() {
        return sfio5;
    }

    public void setSfio5(String sfio5) {
        this.sfio5 = sfio5;
    }

    public BigInteger getCodbr() {
        return codbr;
    }

    public void setCodbr(BigInteger codbr) {
        this.codbr = codbr;
    }

    public String getSpfnumber() {
        return spfnumber;
    }

    public void setSpfnumber(String spfnumber) {
        this.spfnumber = spfnumber;
    }

    public String getSfio6() {
        return sfio6;
    }

    public void setSfio6(String sfio6) {
        this.sfio6 = sfio6;
    }

    public String getSokved() {
        return sokved;
    }

    public void setSokved(String sokved) {
        this.sokved = sokved;
    }

    public String getSokopf() {
        return sokopf;
    }

    public void setSokopf(String sokopf) {
        this.sokopf = sokopf;
    }

    public String getSokato() {
        return sokato;
    }

    public void setSokato(String sokato) {
        this.sokato = sokato;
    }

    public String getSokogu() {
        return sokogu;
    }

    public void setSokogu(String sokogu) {
        this.sokogu = sokogu;
    }

    public String getSokdp() {
        return sokdp;
    }

    public void setSokdp(String sokdp) {
        this.sokdp = sokdp;
    }

    public String getSgniname() {
        return sgniname;
    }

    public void setSgniname(String sgniname) {
        this.sgniname = sgniname;
    }

    public String getSokfs() {
        return sokfs;
    }

    public void setSokfs(String sokfs) {
        this.sokfs = sokfs;
    }

    public String getSindex() {
        return sindex;
    }

    public void setSindex(String sindex) {
        this.sindex = sindex;
    }

    public String getSregion() {
        return sregion;
    }

    public void setSregion(String sregion) {
        this.sregion = sregion;
    }

    public String getSvillage() {
        return svillage;
    }

    public void setSvillage(String svillage) {
        this.svillage = svillage;
    }

    public String getSstreet() {
        return sstreet;
    }

    public void setSstreet(String sstreet) {
        this.sstreet = sstreet;
    }

    public String getShouse() {
        return shouse;
    }

    public void setShouse(String shouse) {
        this.shouse = shouse;
    }

    public String getSkorpus() {
        return skorpus;
    }

    public void setSkorpus(String skorpus) {
        this.skorpus = skorpus;
    }

    public String getSflat() {
        return sflat;
    }

    public void setSflat(String sflat) {
        this.sflat = sflat;
    }

    public String getSogrn() {
        return sogrn;
    }

    public void setSogrn(String sogrn) {
        this.sogrn = sogrn;
    }

    public String getSfssnumber() {
        return sfssnumber;
    }

    public void setSfssnumber(String sfssnumber) {
        this.sfssnumber = sfssnumber;
    }

    public String getSfssparentnumber() {
        return sfssparentnumber;
    }

    public void setSfssparentnumber(String sfssparentnumber) {
        this.sfssparentnumber = sfssparentnumber;
    }

    public String getSfssaddnumber() {
        return sfssaddnumber;
    }

    public void setSfssaddnumber(String sfssaddnumber) {
        this.sfssaddnumber = sfssaddnumber;
    }
    
    protected Set<Slrdepartment> getSlrdepartmentsInternal(){
    	if(this.slrdepartments == null) {
    		this.slrdepartments = new HashSet<>();
    	}
    	return this.slrdepartments;
    }
    

    public List<Slrdepartment> getSlrdepartments() {
    	final List<Slrdepartment> sortedDeps =  new ArrayList<>(getSlrdepartmentsInternal());
    	PropertyComparator.sort(sortedDeps, new MutableSortDefinition("snm",true,true));
        return Collections.unmodifiableList(sortedDeps);
    }
    
    public void addSlrdepartment(Slrdepartment dep) {
    	getSlrdepartmentsInternal().add(dep);
    	dep.setIdfactory(this);
    }

    public void setSlrdepartments(Set<Slrdepartment> slrdepartments) {
        this.slrdepartments = slrdepartments;
    }

    
    protected Set<Slrbranches> getSlrbranchessInternal(){
    	if(this.slrbranchess == null) {
    		this.slrbranchess = new HashSet<>();
    	}
    	return this.slrbranchess;
    }
    
    public List<Slrbranches> getSlrbranchess() {
    	final List<Slrbranches> sortedBranchess = new ArrayList<>(getSlrbranchessInternal());
    	PropertyComparator.sort(sortedBranchess, new MutableSortDefinition("snm", true, true));
        return Collections.unmodifiableList(sortedBranchess);
    }
    
    public void addSlrbranches(Slrbranches branches) {
    	getSlrbranchessInternal().add(branches);
    	branches.setIdfactory(this);
    }

    public void setSlrbranchesList(Set<Slrbranches> slrbranchess) {
        this.slrbranchess = slrbranchess;
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
        if (!(object instanceof Slrfactory)) {
            return false;
        }
        Slrfactory other = (Slrfactory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
        		.append("id", this.getId())
        		.append("snm", this.getSnm())
        		.toString();
    }

    
}
