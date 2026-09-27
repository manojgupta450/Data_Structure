package creational.collections.sortTest;

public class Employee {

	private int eid;
	private String sname;
	private Long sal;
	
	public Employee(int eid, String sname, Long sal) {
		super();
		this.eid = eid;
		this.sname = sname;
		this.sal = sal;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Long getSal() {
		return sal;
	}

	public void setSal(Long sal) {
		this.sal = sal;
	}
	
	
	
}
