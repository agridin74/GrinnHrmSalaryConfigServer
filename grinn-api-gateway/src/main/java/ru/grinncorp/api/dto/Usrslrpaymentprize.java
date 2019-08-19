package ru.grinncorp.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Usrslrpaymentprize {
	
    private Long id ; 
	private Long idfactory ; 
	private Long idbranches ;
	private Long iddepartment ;
	private String snm ;
	private Long idkadr ;
	private Long idincome  ;
	private BigDecimal nmoney  ;
	private BigDecimal nmoneyvichet   ;
	private BigDecimal ntaxprc   ;
	private BigDecimal ntaxmoney  ;
	private Date dperiod  ;
	private Date dperiodfrom  ;
	private Date dperiodfromuser  ;
	private Date dfactpayed  ;
	private Date dperiodtax ;
	private Date dpayofftax;
	private Date dtimelimittax ;
	private String sremark ;
	private Long idcreator ;
	private Long ideditor ;
	private Date dcreatedatetime ;
	private Date deditdatetime;

}
