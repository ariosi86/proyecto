package interfaces;

import java.util.List;

import modelo.Producto;

public interface ProductosService {

	public List<Producto> obtenerProductos();
	
	public Producto obtenerProductoPorId(int idProducto);
	
}
