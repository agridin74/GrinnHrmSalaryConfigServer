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



/**
 *
 * @author agridin74
 */
@Data
public class Slrbranches  {
    
    private Long id;
        
    private String smnemocode;
    
    private String snm;

    private Slrfactory idfactory;
    @JsonIgnore
    private final List<Slrdepartment> slrdepartments = new ArrayList<>();

    @JsonIgnore
    public List<Long> getSlrdepartmentIds(){
    	return slrdepartments.stream()
    			.map(Slrdepartment::getId)
    			.collect(toList());
    }

    
    
}
