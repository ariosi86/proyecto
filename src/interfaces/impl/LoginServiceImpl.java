package interfaces.impl;

import java.util.List;

import dao.LoginDAO;
import interfaces.LoginService;
import modelo.Usuario;

public class LoginServiceImpl implements LoginService{

	private LoginDAO loginDAO;
	
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
		loginDAO= new LoginDAO();
	}
	
	
	@Override
	public List<Usuario> validarUsuario(String username, String password) {
		// TODO Auto-generated method stub
		return loginDAO.verificarUsuario(username, password);
	}

}
