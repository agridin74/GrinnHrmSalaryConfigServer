package ru.grinncorp.factorydashboardservice.slrfactory;



/**
 *
 * @author agridin74
 */

public class SlrfactoryInfo  {
 
    private Long id;
    
    private String snm;
    
    private String slongname;

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

	@Override
	public String toString() {
		return "Slrfactory [id=" + id + ", snm=" + snm + ", slongname=" + slongname + "]";
	}
    
    
    
}
