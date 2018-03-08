package beans;

public class UserBean {
	private int id;
	private String name;
	private String pass;
	private String fdate;
	private String ldate;
	
	public void setId(int _id){
		id = _id;
	}
	public void setName(String _name){
		name = _name;
	}
	public void setPass(String _pass){
		pass = _pass;
	}
	public void setFdate(String _fdate){
		fdate = _fdate;
	}
	public void setLdate(String _ldate){
		ldate = _ldate;
	}
	
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getPass(){
		return pass;
	}
	public String getFdate(){
		return fdate;
	}
	public String getLdate(){
		return ldate;
	}
}