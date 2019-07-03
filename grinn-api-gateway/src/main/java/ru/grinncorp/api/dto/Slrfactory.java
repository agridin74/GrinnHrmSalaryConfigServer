/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.grinncorp.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

import java.math.BigInteger;

/**
 * Simple JavaBean domain object representing an slrfactory
 * @author agridin74
 */
@Data
public class Slrfactory  {

    private Long id;

    private String snm;

    private String slongname;

    private String sokpo;
 
    private String sokonh;
    
    private String stown;

    private String sadress;

    private String sadressf;
 
    private String sphone;
 
    private String sinn;

    private String skpp;

    private String sgni;

    private String sbank;

    private String sfio1;

    private String sfio2;

    private String sfio3;
    
    private String sfio4;

    private String sfio5;

    private BigInteger codbr;

    private String spfnumber;

    private String sfio6;

    private String sokved;

    private String sokopf;

    private String sokato;

    private String sokogu;

    private String sokdp;

    private String sgniname;

    private String sokfs;

    private String sindex;

    private String sregion;

    private String svillage;

    private String sstreet;

    private String shouse;

    private String skorpus;

    private String sflat;

    private String sogrn;

    private String sfssnumber;

    private String sfssparentnumber;

    private String sfssaddnumber;
    @JsonIgnore
    private final List<Slrdepartment> slrdepartments = new ArrayList<>();
    @JsonIgnore
    private final List<Slrbranches> slrbranchess = new ArrayList<>();
    
    @JsonIgnore
    public List<Long> getSlrdepartmentsIds(){
    	return slrdepartments.stream()
    			.map(Slrdepartment::getId)
    			.collect(toList());
    }
    
    @JsonIgnore
    public List<Long> getSlrbranchessIds(){
    	return slrbranchess.stream()
    			.map(Slrbranches::getId)
    			.collect(toList());
    }
   
}
