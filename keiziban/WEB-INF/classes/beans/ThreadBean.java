package beans;

public class ThreadBean {
	private int id;
	private String title;
	private String fdate;
	private String ldate;
	private String maker;
	
	public void setId(int id){
		this.id = id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setFdate(String fdate){
		this.fdate = fdate;
	}
	public void setLdate(String ldate){
		this.ldate = ldate;
	}
	public void setMaker(String maker){
		this.maker = maker;
	}
	
	public int getId(){
		return this.id;
	}
	public String getTitle(){
		return this.title;
	}
	public String getFdate(){
		return this.fdate;
	}
	public String getLdate(){
		return this.ldate;
	}
	public String getMaker(){
		return this.maker;
	}
}