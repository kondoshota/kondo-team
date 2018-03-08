package beans;

public class ResBean {
	private int th_id;
	private int id;
	private String user_name;
	private String response;
	private String date;
	private String file;
	private int state;
	
	public void setTh_id(int th_id){
		this.th_id = th_id;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	public void setResponse(String response){
		this.response = response;
	}
	public void setDate(String date){
		this.date = date;
	}
	public void setFile(String file){
		this.file = file;
	}
	public void setState(int state){
		this.state = state;
	}
	
	public int getTh_id(){
		return this.th_id;
	}
	public int getId(){
		return this.id;
	}
	public String getUser_name(){
		return this.user_name;
	}
	public String getResponse(){
		return this.response;
	}
	public String getDate(){
		return this.date;
	}
	public String getFile(){
		return this.file;
	}
	public int getState(){
		return this.state;
	}
}