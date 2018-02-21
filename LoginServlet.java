package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		
		//���N�G�X�g�p�����[�^�̎擾
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		//User�C���X�^���X(���[�U�[���)�̍쐬
		User user = new User(name, pass);
		
		//���O�C������
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);
		
		//���O�C���������̏���
		if(isLogin){
		//���[�U�[�����Z�b�V�����X�R�[�v�ɕۑ�
			HttpSession session =request.getSession();
			session.setAttribute("loginUser", user);
		}
		//���O�C�����ʉ�ʂɃt�H���[�h
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/loginresult.jsp");
		dispatcher.forward(req, res);
	}
}