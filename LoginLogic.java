package model;

//���[�U�[���ʂ̃p�X���[�h1234�̔��������
//�Ƃ肠�����̉��u��
public class LoginLogic{
	public boolean execute(User user){
		if(user.getPass().equals("1234")){return true;}
		return false;
	}
}