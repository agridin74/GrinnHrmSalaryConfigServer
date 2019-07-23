/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.grinncorp.slrkadr.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author agridin74
 */
/*
 * @XmlRootElement
 * 
 * @NamedQueries({
 * 
 * @NamedQuery(name = "Slrkadr.findAll", query = "SELECT s FROM Slrkadr s"),
 * 
 * @NamedQuery(name = "Slrkadr.findById", query =
 * "SELECT s FROM Slrkadr s WHERE s.id = :id"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySfirstname", query =
 * "SELECT s FROM Slrkadr s WHERE s.sfirstname = :sfirstname"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySsecondname", query =
 * "SELECT s FROM Slrkadr s WHERE s.ssecondname = :ssecondname"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySthirdname", query =
 * "SELECT s FROM Slrkadr s WHERE s.sthirdname = :sthirdname"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySnm", query =
 * "SELECT s FROM Slrkadr s WHERE s.snm = :snm"),
 * 
 * @NamedQuery(name = "Slrkadr.findByLsex", query =
 * "SELECT s FROM Slrkadr s WHERE s.lsex = :lsex"),
 * 
 * @NamedQuery(name = "Slrkadr.findByDbirthdate", query =
 * "SELECT s FROM Slrkadr s WHERE s.dbirthdate = :dbirthdate"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySbirthregion", query =
 * "SELECT s FROM Slrkadr s WHERE s.sbirthregion = :sbirthregion"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySbirtharea", query =
 * "SELECT s FROM Slrkadr s WHERE s.sbirtharea = :sbirtharea"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySbirthtown", query =
 * "SELECT s FROM Slrkadr s WHERE s.sbirthtown = :sbirthtown"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySfirstnamerp", query =
 * "SELECT s FROM Slrkadr s WHERE s.sfirstnamerp = :sfirstnamerp"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySsecondnamerp", query =
 * "SELECT s FROM Slrkadr s WHERE s.ssecondnamerp = :ssecondnamerp"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySthirdnamerp", query =
 * "SELECT s FROM Slrkadr s WHERE s.sthirdnamerp = :sthirdnamerp"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySfirstnamedp", query =
 * "SELECT s FROM Slrkadr s WHERE s.sfirstnamedp = :sfirstnamedp"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySsecondnamedp", query =
 * "SELECT s FROM Slrkadr s WHERE s.ssecondnamedp = :ssecondnamedp"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySthirdnamedp", query =
 * "SELECT s FROM Slrkadr s WHERE s.sthirdnamedp = :sthirdnamedp"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySemail", query =
 * "SELECT s FROM Slrkadr s WHERE s.semail = :semail"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySinn", query =
 * "SELECT s FROM Slrkadr s WHERE s.sinn = :sinn"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySpfnumber", query =
 * "SELECT s FROM Slrkadr s WHERE s.spfnumber = :spfnumber"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySpfcategory", query =
 * "SELECT s FROM Slrkadr s WHERE s.spfcategory = :spfcategory"),
 * 
 * @NamedQuery(name = "Slrkadr.findBySgni", query =
 * "SELECT s FROM Slrkadr s WHERE s.sgni = :sgni"),
 * 
 * @NamedQuery(name = "Slrkadr.findByLworker", query =
 * "SELECT s FROM Slrkadr s WHERE s.lworker = :lworker")})
 */
@Entity
@Table(name = "SLRKADR")
public class Slrkadr implements Serializable {
	@Basic(optional = false)
	@NotNull
	@Column(name = "LSEX")
	private Character lsex;
	@Basic(optional = false)
	@NotNull
	@Column(name = "LWORKER")
	private Character lworker;
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	private Long id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "SFIRSTNAME")
	private String sfirstname;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 40)
	@Column(name = "SSECONDNAME")
	private String ssecondname;
	@Size(max = 20)
	@Column(name = "STHIRDNAME")
	private String sthirdname;
	@Size(max = 255)
	@Column(name = "SNM")
	private String snm;
	@Column(name = "DBIRTHDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dbirthdate;
	@Size(max = 255)
	@Column(name = "SBIRTHREGION")
	private String sbirthregion;
	@Size(max = 255)
	@Column(name = "SBIRTHAREA")
	private String sbirtharea;
	@Size(max = 255)
	@Column(name = "SBIRTHTOWN")
	private String sbirthtown;
	@Size(max = 20)
	@Column(name = "SFIRSTNAMERP")
	private String sfirstnamerp;
	@Size(max = 40)
	@Column(name = "SSECONDNAMERP")
	private String ssecondnamerp;
	@Size(max = 20)
	@Column(name = "STHIRDNAMERP")
	private String sthirdnamerp;
	@Size(max = 20)
	@Column(name = "SFIRSTNAMEDP")
	private String sfirstnamedp;
	@Size(max = 40)
	@Column(name = "SSECONDNAMEDP")
	private String ssecondnamedp;
	@Size(max = 20)
	@Column(name = "STHIRDNAMEDP")
	private String sthirdnamedp;
	@Size(max = 255)
	@Column(name = "SEMAIL")
	private String semail;
	@Size(max = 12)
	@Column(name = "SINN")
	private String sinn;
	@Size(max = 14)
	@Column(name = "SPFNUMBER")
	private String spfnumber;
	@Size(max = 20)
	@Column(name = "SPFCATEGORY")
	private String spfcategory;
	@Size(max = 10)
	@Column(name = "SGNI")
	private String sgni;
	
	@Column(name = "IDNATIONALITY")
	private Long idnationality;
	
	@Column(name = "IDLANGUAGE")
	private Long idlanguage;
	
	@Column(name = "IDCOUNTRY")
	private Long idcountry;
	  
	@Column(name = "IDCITIZENSHIP")
	private Long idcitizenship;
	  
	@Column(name = "IDALIENTCATEGORY")
	private Long idalientcategory;

	@Column(name = "CODCT")
	private Long codct;
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "idkadr",fetch =
	 * FetchType.LAZY) private List<Slrcard> slrcardList;
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "idkadr",fetch =
	 * FetchType.LAZY) private List<Slrworker> slrworkerList;
	 * 
	 * @JoinColumn(name = "IDNATIONALITY", referencedColumnName = "ID")
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY) private Slrnationality idnationality;
	 * 
	 * @JoinColumn(name = "IDLANGUAGE", referencedColumnName = "ID")
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY) private Slrlanguage idlanguage;
	 * 
	 * @JoinColumn(name = "IDCOUNTRY", referencedColumnName = "ID")
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY) private Slrcountry idcountry;
	 * 
	 * @JoinColumn(name = "IDCITIZENSHIP", referencedColumnName = "ID")
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY) private Slrcitizenship idcitizenship;
	 * 
	 * @JoinColumn(name = "IDALIENTCATEGORY", referencedColumnName = "ID")
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY) private Slralientcategory
	 * idalientcategory;
	 * 
	 * @JoinColumn(name = "CODCT", referencedColumnName = "COD")
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY) private Contras codct;
	 */

	public Slrkadr() {
	}

	public Slrkadr(Long id) {
		this.id = id;
	}

	public Slrkadr(Long id, String sfirstname, String ssecondname, char lsex, char lworker) {
		this.id = id;
		this.sfirstname = sfirstname;
		this.ssecondname = ssecondname;
		this.lsex = lsex;
		this.lworker = lworker;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSfirstname() {
		return sfirstname;
	}

	public void setSfirstname(String sfirstname) {
		this.sfirstname = sfirstname;
	}

	public String getSsecondname() {
		return ssecondname;
	}

	public void setSsecondname(String ssecondname) {
		this.ssecondname = ssecondname;
	}

	public String getSthirdname() {
		return sthirdname;
	}

	public void setSthirdname(String sthirdname) {
		this.sthirdname = sthirdname;
	}

	public String getSnm() {
		return snm;
	}

	public void setSnm(String snm) {
		this.snm = snm;
	}

	public Date getDbirthdate() {
		return dbirthdate;
	}

	public void setDbirthdate(Date dbirthdate) {
		this.dbirthdate = dbirthdate;
	}

	public String getSbirthregion() {
		return sbirthregion;
	}

	public void setSbirthregion(String sbirthregion) {
		this.sbirthregion = sbirthregion;
	}

	public String getSbirtharea() {
		return sbirtharea;
	}

	public void setSbirtharea(String sbirtharea) {
		this.sbirtharea = sbirtharea;
	}

	public String getSbirthtown() {
		return sbirthtown;
	}

	public void setSbirthtown(String sbirthtown) {
		this.sbirthtown = sbirthtown;
	}

	public String getSfirstnamerp() {
		return sfirstnamerp;
	}

	public void setSfirstnamerp(String sfirstnamerp) {
		this.sfirstnamerp = sfirstnamerp;
	}

	public String getSsecondnamerp() {
		return ssecondnamerp;
	}

	public void setSsecondnamerp(String ssecondnamerp) {
		this.ssecondnamerp = ssecondnamerp;
	}

	public String getSthirdnamerp() {
		return sthirdnamerp;
	}

	public void setSthirdnamerp(String sthirdnamerp) {
		this.sthirdnamerp = sthirdnamerp;
	}

	public String getSfirstnamedp() {
		return sfirstnamedp;
	}

	public void setSfirstnamedp(String sfirstnamedp) {
		this.sfirstnamedp = sfirstnamedp;
	}

	public String getSsecondnamedp() {
		return ssecondnamedp;
	}

	public void setSsecondnamedp(String ssecondnamedp) {
		this.ssecondnamedp = ssecondnamedp;
	}

	public String getSthirdnamedp() {
		return sthirdnamedp;
	}

	public void setSthirdnamedp(String sthirdnamedp) {
		this.sthirdnamedp = sthirdnamedp;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSinn() {
		return sinn;
	}

	public void setSinn(String sinn) {
		this.sinn = sinn;
	}

	public String getSpfnumber() {
		return spfnumber;
	}

	public void setSpfnumber(String spfnumber) {
		this.spfnumber = spfnumber;
	}

	public String getSpfcategory() {
		return spfcategory;
	}

	public void setSpfcategory(String spfcategory) {
		this.spfcategory = spfcategory;
	}

	public String getSgni() {
		return sgni;
	}

	public void setSgni(String sgni) {
		this.sgni = sgni;
	}

	
	/*
	 * @XmlTransient public List<Slrcard> getSlrcardList() { return slrcardList; }
	 * 
	 * public void setSlrcardList(List<Slrcard> slrcardList) { this.slrcardList =
	 * slrcardList; }
	 * 
	 * @XmlTransient public List<Slrworker> getSlrworkerList() { return
	 * slrworkerList; }
	 * 
	 * public void setSlrworkerList(List<Slrworker> slrworkerList) {
	 * this.slrworkerList = slrworkerList; }
	 */

	public Long getIdnationality() {
		return idnationality;
	}

	public void setIdnationality(Long idnationality) {
		this.idnationality = idnationality;
	}

	public Long getIdlanguage() {
		return idlanguage;
	}

	public void setIdlanguage(Long idlanguage) {
		this.idlanguage = idlanguage;
	}

	public Long getIdcountry() {
		return idcountry;
	}

	public void setIdcountry(Long idcountry) {
		this.idcountry = idcountry;
	}

	public Long getIdcitizenship() {
		return idcitizenship;
	}

	public void setIdcitizenship(Long idcitizenship) {
		this.idcitizenship = idcitizenship;
	}

	public Long getIdalientcategory() {
		return idalientcategory;
	}

	public void setIdalientcategory(Long idalientcategory) {
		this.idalientcategory = idalientcategory;
	}

	public Long getCodct() {
		return codct;
	}

	public void setCodct(Long codct) {
		this.codct = codct;
	}

	
	public Character getLsex() {
		return lsex;
	}

	public void setLsex(Character lsex) {
		this.lsex = lsex;
	}

	public Character getLworker() {
		return lworker;
	}

	public void setLworker(Character lworker) {
		this.lworker = lworker;
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
		if (!(object instanceof Slrkadr)) {
			return false;
		}
		Slrkadr other = (Slrkadr) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ru.grinn.entity.Slrkadr[ id=" + id + " ]";
	}


}
