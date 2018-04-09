package lab2_dmarnol2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EnterGender extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("previous", "/enterLanguages");
		session.setAttribute("action", "/displayInputs");
		StringBuilder sb = new StringBuilder("<html><head></head><body>");
		PrintWriter pw = res.getWriter();
		String[] days = req.getParameterValues("day");
		session.setAttribute("days", days);
		session.setAttribute("gender", " ");

		sb.append("<form action=\"controller\" method=\"POST\">\r\n" + "	 Select Gender:  <br><br> \r\n"
				+ "  <input type=\"radio\" name=\"gender\" value=\"male\"  > Male<br>\r\n"
				+ "  <input type=\"radio\" name=\"gender\" value=\"female\"> Female<br><br>\r\n"
				+ "    <input type=\"submit\">\r\n" + "	</div>\r\n" + "    </form>");

		sb.append("<form action=\"enterDays\" method=\"GET\" >\r\n"
				+ "    <input type=\"submit\" value=\"Previous\"><br><br>\r\n" + "  </form>");
		// sb.append("<br><a href=\"#\" action=\"/enterDays\" name=\"1\">Previous</a>");
		sb.append("</body></html>");
		pw.print(sb.toString());

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
