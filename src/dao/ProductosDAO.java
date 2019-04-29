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

public List<Productos> obtenerProductoPorNombre(String nombre){
	List<Productos> shop = new ArrayList<Productos>();
	try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from productos where nombre = '"+nombre+"' LIMIT 1");
        while(rs.next()){
            Productos p = new Productos(rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5));
            System.out.println(p.getNombre()+":"+ p.getPrecio());
            shop.add(p);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return shop;
}


}
