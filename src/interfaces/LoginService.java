package interfaces;

import java.util.List;

import modelo.Usuario;

public interface LoginService {

	public List<Usuario> validarUsuario(String username,String password);
	
}
