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


/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("producto");
    Connection cn = ConexionBD.getInstance();
	ProductosDAO productosDAO= new ProductosDAO();
	Shop shop= productosDAO.obtenerProductoPorNombre(nombre);
	request.setAttribute("shop", shop.getIt());
	response.sendRedirect("inicio.jsp?addedto=success");

}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

}
