package model;
import java.io.Serializable;

public class User implements Serializable{
	private String name; //���[�U�[��
	private String pass; //�p�X���[�h
	
	public User(){}
	public User(String name, String pass){
		this.name = name;
		this.pass = pass;
	}
	public String getName(){return name;}
	public String getPass(){return pass;}
}