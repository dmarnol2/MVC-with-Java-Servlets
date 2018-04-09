package lab2_dmarnol2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EnterNames extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
	} // end method

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		StringBuilder sb = new StringBuilder("<html><head></head><body>");
		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession();

		String firstname = (String) session.getAttribute("firstname");
		String lastname = (String) session.getAttribute("lastname");
		// String languages=(String) session.getAttribute("languages");
		// String days = (String) session.getAttribute("days");
		// String gender = (String) session.getAttribute("gender");
		session.setAttribute("action", "/enterLanguages");
		session.setAttribute("previous", "");

		sb.append("<form action=\"controller\" method=\"POST\">\r\n" + "    <div>\r\n"
				+ "    Firstname: <input type=\"text\"  name=\"firstname\" value=" + firstname + "><br><br>\r\n"
				+ "    Lastname: <input type=\"text\"  name=\"lastname\" value=" + lastname + "><br><br>\r\n"
				+ "    <input type=\"submit\">\r\n" + "	</div>\r\n" + "  </form> ");

		sb.append("</body></html>");
		pw.print(sb.toString());

	} // end method

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
} // end class