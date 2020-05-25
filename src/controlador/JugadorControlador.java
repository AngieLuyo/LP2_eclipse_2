package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Jugador;
import model.JugadorModel;

/**
 * Servlet implementation class JugadorControlador
 */
@WebServlet("/insertaJugador")
public class JugadorControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1 Recibe los parámetros
			//Son los nombres de las caja de textos en el JSP
			String nom = request.getParameter("nombre");
			String ali = request.getParameter("alias");
			String pai = request.getParameter("pais");
			String jueg = request.getParameter("juego");
			String exp = request.getParameter("experiencia");
			
			//2 Se crea el objeto Alumno
			Jugador obj = new Jugador();
			obj.setNombre(nom);
			obj.setAlias(ali);
			obj.setPais(pai);
			obj.setJuego(jueg);
			obj.setExperiencia(Integer.parseInt(exp));
			
			JugadorModel m = new JugadorModel();
			int s = m.insertaJugador(obj);
			if (s>0)
				request.getSession().setAttribute("MENSAJE", "registro exitoso");
			else
				request.getSession().setAttribute("MENSAJE", "registro erróneo");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("MENSAJE", "registro erróneo");
		} finally {
			response.sendRedirect("registraJugador.jsp");
		}
	}

}
