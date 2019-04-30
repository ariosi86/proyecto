package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carrito;
import modelo.Productos;
import bd.ConexionBD;
import dao.*;
import java.util.List;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProducto = request.getParameter("idProducto");
	int cantidad = Integer.parseInt(request.getParameter("cantidad"));
	int id=Integer.parseInt(idProducto);
	ProductosDAO productosDAO= new ProductosDAO();
	Producto seleccionado= productosDAO.obtenerProductoPorId(id);
	CarritoDao carritoDAO= new CarritoDao();
	Usuario usuario=(Usuario) request.getSession().getAttribute("usuario");
	
	carritoDAO.agregarCarritoUsuario( usuario.getIdUsuario() ,seleccionado.getId(), cantidad,seleccionado.getPrecio()*cantidad);
	List<Carrito> shop=carritoDAO.consultarCarrito(usuario.getIdUsuario());
	
	
	request.setAttribute("shop", shop);
	//response.sendRedirect("inicio.jsp?addedto=success");
	request.getRequestDispatcher("WEB-INF/jsp/inicio.jsp?addedto=success").forward(request, response);

}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

}
