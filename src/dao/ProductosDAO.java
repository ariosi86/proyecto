package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bd.ConexionBD;
import modelo.Producto;
import modelo.Usuario;

public class ProductosDAO {

private ConexionBD conexion;
	
	public ProductosDAO() {
		// TODO Auto-generated constructor stub
		conexion= new ConexionBD();
	}
	
	
public List<Producto> obtenerProductos() {
		
		Connection conn=conexion.crearConexion();
		if(conn!=null) {
			try
			{
				PreparedStatement st= conn.prepareStatement("select * from Productos");
			
				ResultSet rs=st.executeQuery();
				List<Producto> productos= new ArrayList<Producto>();
				while(rs.next())
				{
					Producto producto= new Producto();
					producto.setNombre(rs.getString("nombre"));
					producto.setIdProducto(rs.getInt("idProducto"));
					producto.setDescripcion(rs.getString("descripcion"));
					productos.add(producto);
				}
				return productos;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			
			
		}
		return null;
		
	}
	
public Producto obtenerProductoPorId(Integer idProducto) {
	
	Connection conn=conexion.crearConexion();
	if(conn!=null) {
		try
		{
			PreparedStatement st= conn.prepareStatement("select * from Productos where idProducto=?");
			st.setInt(1, idProducto);
			ResultSet rs=st.executeQuery();
			
			while(rs.next())
			{
				Producto producto= new Producto();
				producto.setNombre(rs.getString("nombre"));
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setDescripcion(rs.getString("descripcion"));
				return producto;
			}
			return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	return null;
	
}


}
