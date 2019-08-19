package ru.grinncorp.api.dto;


import lombok.Data;
import java.util.Date;

/**
 * Simple JavaBean domain object representing an slrdepartment.
 * @author agridin74
 */
@Data
public class Slrdepartment  {
    private Long id;
    private long idparent;
    private String snm;
    private Long codinref;
    private Long idcard;
    private String sremark;
    private String smnemocode;
    private String slevel;
    private String snmlong;
    private Date dbegin;
    private Date dend;
    private Date dendorder;
    private Date dendclose;
    private Character llist;
    private Character lhide;
    private Character lnvd;
    private Character lnoishl;
    private Slrfactory idfactory;
    private Slrbranches idbranches;

}
