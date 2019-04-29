package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.LoginService;
import interfaces.impl.LoginServiceImpl;
import modelo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginService loginService= new LoginServiceImpl();
		List<Usuario> usuarios=loginService.validarUsuario(username, password);
		if(usuarios!=null && !usuarios.isEmpty()) {
			
			Usuario usuario=usuarios.get(0);
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("InicioServlet");
			return;
		}
		request.setAttribute("error", "inicio de sesion incorrecto ingresa tu informacion :D ");
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}

}
