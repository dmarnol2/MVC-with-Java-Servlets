package lab2_dmarnol2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EnterDays extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		StringBuilder sb = new StringBuilder("<html><head></head><body>");
		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession();
		session.setAttribute("action", "/enterGender");
		session.setAttribute("previous", "/enterLanguages");
		session.setAttribute("days", " ");

		String[] languages = req.getParameterValues("item");

		session.setAttribute("languages", languages);

		sb.append("<form action=\"controller\" method=\"POST\">\r\n" + "	 Days Available:  <br><br> \r\n"
				+ "         <input type = \"checkbox\" name = \"day\" value = \"Sun\" > Sun\r\n"
				+ "         <input type = \"checkbox\" name = \"day\" value = \"Mon\" > Mon\r\n"
				+ "         <input type = \"checkbox\" name = \"day\" value = \"Tue\"> Tue\r\n"
				+ "         <input type = \"checkbox\" name = \"day\" value = \"Wed\"> Wed\r\n"
				+ "         <input type = \"checkbox\" name = \"day\" value = \"Thur\"> Thur\r\n"
				+ "         <input type = \"checkbox\" name = \"day\" value = \"Fri\"> Fri\r\n"
				+ "         <input type = \"checkbox\" name = \"day\" value = \"Sat\"> Sat\r\n"
				+ "         <br><br>\r\n" + "        <input type=\"submit\">\r\n" + "      </div>\r\n" + "    </form>");
		sb.append("<form action=\"enterLanguages\" method=\"GET\" >\r\n"
				+ "    <input type=\"submit\" value=\"Previous\"><br><br>\r\n" + "  </form>");
		// sb.append("<br><a href=\"#\" action=\"/enterLanguages\"
		// name=\"2\">Previous</a>");
		sb.append("</body></html>");
		pw.print(sb.toString());

	} // end method

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
