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
 * Servlet implementation class InicioServlet
 */
@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
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
			ProductosService productosService= new ProductosServiceImpl();
			List<Producto> productos=productosService.obtenerProductos();
			request.setAttribute("productos", productos);
			request.setAttribute("mensaje", "bienvenido "+usuario.getNombre());
			
		}
		else if(usuario.getPrivilegio()==3)
		{
			request.setAttribute("mensaje", "bienvenido invitado "+usuario.getNombre());
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/inicio.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
