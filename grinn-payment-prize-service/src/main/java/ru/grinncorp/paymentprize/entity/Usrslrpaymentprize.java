package ru.grinncorp.paymentprize.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "USRSLRPAYMENTPRIZE")
public class Usrslrpaymentprize {
	@Id
	@SequenceGenerator(name="SEQ_PAYMENTPRIZE", 
						sequenceName="sequsrslrpaymentprize", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_PAYMENTPRIZE")
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
    private Long id ; 
	@Basic(optional = false)
	@NotNull
	@Column(name = "IDFACTORY")
    private Long idfactory ; 
	@Basic(optional = false)
	@NotNull
	@Column(name = "IDBRANCHES")
    private Long idbranches ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "IDDEPARTMENT")
    private Long iddepartment ;
	@Size(max = 255)
	@Column(name = "SNM")
	private String snm ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "IDKADR")
	private Long idkadr ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "IDINCOME")
	private Long idincome  ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "NMONEY")
	private BigDecimal nmoney  ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "NMONEYVICHET")
	private BigDecimal nmoneyvichet   ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "NTAXPRC")
	private BigDecimal ntaxprc   ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "NTAXMONEY")
	private BigDecimal ntaxmoney  ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DPERIOD")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dperiod  ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DPERIODFROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dperiodfrom  ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DPERIODFROMUSER")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dperiodfromuser  ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DFACTPAYED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dfactpayed  ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DPERIODTAX")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dperiodtax ;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DPAYOFFTAX")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dpayofftax;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DTIMELIMITTAX")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtimelimittax ;
	@Size(max=255)
	@Column(name = "SREMARK")
	private String sremark ;
	
	@Column(name = "IDCREATOR")
	private Long idcreator ;
	
	@Column(name = "IDEDITOR")
	private Long ideditor ;
	
	@Column(name = "DCREATEDATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dcreatedatetime ;
	
	@Column(name = "DEDITDATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deditdatetime;

	public Usrslrpaymentprize() {}
	
	public Usrslrpaymentprize(Long id) {
		
	}
	
	public Usrslrpaymentprize(@NotNull Long id, @NotNull Long idfactory, @NotNull Long idbranches,
			@NotNull Long iddepartment, @Size(max = 255) String snm, @NotNull Long idkadr, @NotNull Long idincome,
			@NotNull BigDecimal nmoney, @NotNull BigDecimal nmoneyvichet, @NotNull BigDecimal ntaxprc,
			@NotNull BigDecimal ntaxmoney, @NotNull Date dperiod, @NotNull Date dperiodfrom,
			@NotNull Date dperiodfromuser, @NotNull Date dfactpayed, @NotNull Date dperiodtax, @NotNull Date dpayofftax,
			@NotNull Date dtimelimittax, @Size(max = 255) String sremark, Long idcreator, Long ideditor,
			Date dcreatedatetime, Date deditdatetime) {
		super();
		this.id = id;
		this.idfactory = idfactory;
		this.idbranches = idbranches;
		this.iddepartment = iddepartment;
		this.snm = snm;
		this.idkadr = idkadr;
		this.idincome = idincome;
		this.nmoney = nmoney;
		this.nmoneyvichet = nmoneyvichet;
		this.ntaxprc = ntaxprc;
		this.ntaxmoney = ntaxmoney;
		this.dperiod = dperiod;
		this.dperiodfrom = dperiodfrom;
		this.dperiodfromuser = dperiodfromuser;
		this.dfactpayed = dfactpayed;
		this.dperiodtax = dperiodtax;
		this.dpayofftax = dpayofftax;
		this.dtimelimittax = dtimelimittax;
		this.sremark = sremark;
		this.idcreator = idcreator;
		this.ideditor = ideditor;
		this.dcreatedatetime = dcreatedatetime;
		this.deditdatetime = deditdatetime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdfactory() {
		return idfactory;
	}

	public void setIdfactory(Long idfactory) {
		this.idfactory = idfactory;
	}

	public Long getIdbranches() {
		return idbranches;
	}

	public void setIdbranches(Long idbranches) {
		this.idbranches = idbranches;
	}

	public Long getIddepartment() {
		return iddepartment;
	}

	public void setIddepartment(Long iddepartment) {
		this.iddepartment = iddepartment;
	}

	public String getSnm() {
		return snm;
	}

	public void setSnm(String snm) {
		this.snm = snm;
	}

	public Long getIdkadr() {
		return idkadr;
	}

	public void setIdkadr(Long idkadr) {
		this.idkadr = idkadr;
	}

	public Long getIdincome() {
		return idincome;
	}

	public void setIdincome(Long idincome) {
		this.idincome = idincome;
	}

	public BigDecimal getNmoney() {
		return nmoney;
	}

	public void setNmoney(BigDecimal nmoney) {
		this.nmoney = nmoney;
	}

	public BigDecimal getNmoneyvichet() {
		return nmoneyvichet;
	}

	public void setNmoneyvichet(BigDecimal nmoneyvichet) {
		this.nmoneyvichet = nmoneyvichet;
	}

	public BigDecimal getNtaxprc() {
		return ntaxprc;
	}

	public void setNtaxprc(BigDecimal ntaxprc) {
		this.ntaxprc = ntaxprc;
	}

	public BigDecimal getNtaxmoney() {
		return ntaxmoney;
	}

	public void setNtaxmoney(BigDecimal ntaxmoney) {
		this.ntaxmoney = ntaxmoney;
	}

	public Date getDperiod() {
		return dperiod;
	}

	public void setDperiod(Date dperiod) {
		this.dperiod = dperiod;
	}

	public Date getDperiodfrom() {
		return dperiodfrom;
	}

	public void setDperiodfrom(Date dperiodfrom) {
		this.dperiodfrom = dperiodfrom;
	}

	public Date getDperiodfromuser() {
		return dperiodfromuser;
	}

	public void setDperiodfromuser(Date dperiodfromuser) {
		this.dperiodfromuser = dperiodfromuser;
	}

	public Date getDfactpayed() {
		return dfactpayed;
	}

	public void setDfactpayed(Date dfactpayed) {
		this.dfactpayed = dfactpayed;
	}

	public Date getDperiodtax() {
		return dperiodtax;
	}

	public void setDperiodtax(Date dperiodtax) {
		this.dperiodtax = dperiodtax;
	}

	public Date getDpayofftax() {
		return dpayofftax;
	}

	public void setDpayofftax(Date dpayofftax) {
		this.dpayofftax = dpayofftax;
	}

	public Date getDtimelimittax() {
		return dtimelimittax;
	}

	public void setDtimelimittax(Date dtimelimittax) {
		this.dtimelimittax = dtimelimittax;
	}

	public String getSremark() {
		return sremark;
	}

	public void setSremark(String sremark) {
		this.sremark = sremark;
	}

	public Long getIdcreator() {
		return idcreator;
	}

	public void setIdcreator(Long idcreator) {
		this.idcreator = idcreator;
	}

	public Long getIdeditor() {
		return ideditor;
	}

	public void setIdeditor(Long ideditor) {
		this.ideditor = ideditor;
	}

	public Date getDcreatedatetime() {
		return dcreatedatetime;
	}

	public void setDcreatedatetime(Date dcreatedatetime) {
		this.dcreatedatetime = dcreatedatetime;
	}

	public Date getDeditdatetime() {
		return deditdatetime;
	}

	public void setDeditdatetime(Date deditdatetime) {
		this.deditdatetime = deditdatetime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Usrslrpaymentprize other = (Usrslrpaymentprize) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usrslrpaymentprize [id=" + id + ", idfactory=" + idfactory + ", idbranches=" + idbranches
				+ ", iddepartment=" + iddepartment + ", snm=" + snm + ", idkadr=" + idkadr + ", idincome=" + idincome
				+ ", nmoney=" + nmoney + ", nmoneyvichet=" + nmoneyvichet + ", ntaxprc=" + ntaxprc + ", ntaxmoney="
				+ ntaxmoney + ", dperiod=" + dperiod + ", dperiodfrom=" + dperiodfrom + ", dperiodfromuser="
				+ dperiodfromuser + ", dfactpayed=" + dfactpayed + ", dperiodtax=" + dperiodtax + ", dpayofftax="
				+ dpayofftax + ", dtimelimittax=" + dtimelimittax + ", sremark=" + sremark + ", idcreator=" + idcreator
				+ ", ideditor=" + ideditor + ", dcreatedatetime=" + dcreatedatetime + ", deditdatetime=" + deditdatetime
				+ "]";
	}
	
	

	
}
