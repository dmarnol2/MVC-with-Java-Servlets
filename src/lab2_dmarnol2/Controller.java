package lab2_dmarnol2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
	}

	public void doAction(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		res.setContentType("text/html"); // return content type
		res.setStatus(res.SC_OK);
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String toDo = req.getParameter("name");
		if (toDo != null) {
			session.setAttribute("action", "/enterNames");
		}

		if (firstname != null) {
			session.setAttribute("firstname", firstname);

		} else {
			firstname = (String) session.getAttribute("firstname");
		}

		if (lastname != null) {
			session.setAttribute("lastname", lastname);
			res.addCookie(new Cookie("lastname", lastname)); // is this needed?
		} else {
			lastname = (String) session.getAttribute("lastname");
		}

		req.getRequestDispatcher((String) session.getAttribute("action")).forward(req, res);

		// }

	} // end doAction()

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doAction(req, res); // take incoming Post requests and route to doAction
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doAction(req, res);

	}
}
