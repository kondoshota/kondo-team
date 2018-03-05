package beans;

public class UserBean {
	private int id;
	private String name;
	private String pass;
	private String fdate;
	private String ldate;
	
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	public void setFdate(String fdate){
		this.fdate = fdate;
	}
	public void setLdate(String ldate){
		this.ldate = ldate;
	}
	
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getPass(){
		return this.pass;
	}
	public String getFdate(){
		return this.fdate;
	}
	public String getLdate(){
		return this.ldate;
	}
}