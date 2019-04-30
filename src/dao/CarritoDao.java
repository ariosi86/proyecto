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
	
	
	public List<Carrito> consultarCarrito(int idUsuario,String nombre ,String descripcion, float precio) {
		
		Connection conn=conexion.crearConexion();
		if(conn!=null) {
			try
			{
				PreparedStatement st= conn.prepareStatement("select p.nombre,c.precio,c.cantidad from productos p join carrito c on(c.idProducto=p.idProducto) where c.idUsuario=?");
				st.setInt(1,idUsuario);
				ResultSet rs=st.executeQuery();
				List<Carrito> carritos= new ArrayList<Carrito>();
				while(rs.next())
				{
					Carrito carrito= new Carrito();
					carrito.setNombre(rs.getString("nombre"));
				   	carrito.setCantidad(rs.getInt("cantidad"))
					carrito.setPrecio(rs.getFloat("precio"));
					carritos.add(carrito);
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
	
	public void agregarCarritoUsuario(int idUsuario,int idProducto,int cantidad, float precio)
	{
		Connection conn=conexion.crearConexion();
		if(conn!=null) {
			try
			{
				PreparedStatement st= conn.prepareStatement("insert into carrito(idUsuario,idProducto,cantidad,precio) values(?,?,?,?)");
				st.setInt(1, idUsuario);
				st.setInt(2, idProducto);
				st.setInt(3, cantidad);
				st.setFloat(4, precio);
				st.execute();
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
				return ;
			}
			
			
		}
		return ;
		
	}
	
}

	
	
	
	
	
	
	
	
