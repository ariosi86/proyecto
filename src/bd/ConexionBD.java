package bd;


import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConexionBD {

	public Connection crearConexion() {
		
		try
		{
			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:comp/env/jdbc/carrito");
			Connection conn = ds.getConnection();
			return conn;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
	
		}
	}


	public static Connection getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
