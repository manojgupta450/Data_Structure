package creational.collections.sortTest;

public class Student implements Comparable<Student>{

	int sid;
	String sname;
	int rno;
	
	
	public Student(int sid, String sname, int rno) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.rno = rno;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getRno() {
		return rno;
	}


	public void setRno(int rno) {
		this.rno = rno;
	}


	@Override
	public int compareTo(Student o) {
		/*if (this.sid > o.sid)
			return 1;
		else if (this.sid < o.sid)
			return -1;
		else
			return 0;*/
		
		return this.sname.compareTo(o.sname);
	}

	
}
