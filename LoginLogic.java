package model;

//ユーザー共通のパスワード1234の判定をする
//とりあえずの仮置き
public class LoginLogic{
	public boolean execute(User user){
		if(user.getPass().equals("1234")){return true;}
		return false;
	}
}