package interfaces.impl;

import java.util.List;

import dao.ProductosDAO;
import interfaces.ProductosService;
import modelo.Producto;

public class ProductosServiceImpl implements ProductosService{

	private ProductosDAO productosDAO;
	
	public ProductosServiceImpl() {
		// TODO Auto-generated constructor stub
		productosDAO= new ProductosDAO();
	}
	
	@Override
	public List<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		return productosDAO.obtenerProductos();
	}

	@Override
	public Producto obtenerProductoPorId(int idProducto) {
		// TODO Auto-generated method stub
		return productosDAO.obtenerProductoPorId(idProducto);
	}

	
	
}
