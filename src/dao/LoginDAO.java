package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bd.ConexionBD;
import modelo.Usuario;

public class LoginDAO {

	private ConexionBD conexion;
	
	public LoginDAO() {
		// TODO Auto-generated constructor stub
		conexion= new ConexionBD();
	}
	
	
	public List<Usuario> verificarUsuario(String username,String password) {
		
		Connection conn=conexion.crearConexion();
		if(conn!=null) {
			try
			{
				PreparedStatement st= conn.prepareStatement("select correo,privilegio,nombre from Usuario where correo=? and password=?");
				st.setString(1, username);
				st.setString(2, password);
				ResultSet rs=st.executeQuery();
				List<Usuario> usuarios= new ArrayList<Usuario>();
				while(rs.next())
				{
					Usuario usuario= new Usuario();
					usuario.setCorreo(rs.getString("correo"));
					usuario.setPrivilegio(rs.getInt("privilegio"));
					usuario.setNombre(rs.getString("nombre"));
					usuarios.add(usuario);
				}
				return usuarios;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			
			
		}
		return null;
		
	}
	
}
