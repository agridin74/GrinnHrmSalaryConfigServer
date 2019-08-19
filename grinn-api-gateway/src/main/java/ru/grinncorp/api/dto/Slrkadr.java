/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.grinncorp.api.dto;

import java.util.Date;
import lombok.Data;

@Data
public class Slrkadr  {
	private Character lsex;
	private Character lworker;
	private Long id;
	private String sfirstname;
	private String ssecondname;
	private String sthirdname;
	private String snm;
	private Date dbirthdate;
	private String sbirthregion;
	private String sbirtharea;
	private String sbirthtown;
	private String sfirstnamerp;
	private String ssecondnamerp;
	private String sthirdnamerp;
	private String sfirstnamedp;
	private String ssecondnamedp;
	private String sthirdnamedp;
	private String semail;
	private String sinn;
	private String spfnumber;
	private String spfcategory;
	private String sgni;
	private Long idnationality;
	private Long idlanguage;
	private Long idcountry;
	private Long idcitizenship;
	private Long idalientcategory;
	private Long codct;

}
