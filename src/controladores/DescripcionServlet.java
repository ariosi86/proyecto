package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.ProductosService;
import interfaces.impl.ProductosServiceImpl;
import modelo.Producto;
import modelo.Usuario;

/**
 * Servlet implementation class DescripcionServlet
 */
@WebServlet("/DescripcionServlet")
public class DescripcionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DescripcionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Usuario usuario=(Usuario) request.getSession().getAttribute("usuario");
		if(usuario.getPrivilegio()==2)
		{
			String idProducto=request.getParameter("idProducto");
			
			ProductosService productosService= new ProductosServiceImpl();
			Producto producto=productosService.obtenerProductoPorId(Integer.parseInt(idProducto));
			request.setAttribute("producto", producto);
		}
		else
		{
			request.setAttribute("mensaje", "no tiene permisos para ver este producto");
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/descripcion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
