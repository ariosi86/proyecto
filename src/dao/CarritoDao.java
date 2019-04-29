package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bd.ConexionBD;
import modelo.Carrito;
import modelo.Usuario;


public class CarritoDao {
	
private ConexionBD conexion;
	
	public void LoginDAO() {
		// TODO Auto-generated constructor stub
		conexion= new ConexionBD();
	}
	
	
	public List<Carrito> agregarCarrito(String nombre ,String descripcion, float precio) {
		
		Connection conn=conexion.crearConexion();
		if(conn!=null) {
			try
			{
				PreparedStatement st= conn.prepareStatement("select nombre,descripcion,precio from productos where idProducto=?");
				st.setString(1, nombre);
				st.setString(2, descripcion);
				st.setFloat(3, precio);
				ResultSet rs=st.executeQuery();
				List<Carrito> usuarios= new ArrayList<Carrito>();
				List<Carrito> carritos;
				while(rs.next())
				{
					Carrito carrito= new Carrito();
					carrito.setNombre(rs.getString("nombre"));
				    carrito.setDescripcion(rs.getString("descripcion"));
					carrito.setPrecio(rs.getFloat("precio"));
					Carrito carrito1;
					carritos.add(carrito1);
				}
				return carritos;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			
			
		}
		return null;
		
	}
	
}

	
	
	
	
	
	
	
	
