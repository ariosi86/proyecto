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
private Carrito shop = new Carrito();

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext thisContext = getServletContext(); 
    String nombre = request.getParameter("producto");
    Connection cn = ConexionBD.getInstance();
    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from productos where nombre = '"+nombre+"' LIMIT 1");
        while(rs.next()){
            Productos p = new Productos(rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5));
            System.out.println(p.getNombre()+":"+ p.getPrecio());
            shop.ins(p);
            thisContext.setAttribute("shop", shop.getIt());
            for(int i = 0; i< shop.getIt().size(); i++){
                System.out.println(shop.getIt().get(i)+":"+ shop.getIt().get(i).getPrecio());
            }
            response.sendRedirect("inicio.jsp?addedto=success");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

}
