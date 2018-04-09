package lab2_dmarnol2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayInputs extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String gender = "none selected";
		String[] languages = { "none selected" };
		String[] days = { "none selected" };
		StringBuilder sb = new StringBuilder("<html><head></head><body>");
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html"); // return content type
		res.setStatus(res.SC_OK);
		if (req.getParameter("gender") == null) {
			gender = (String) session.getAttribute("gender");
		}
		else
			gender=req.getParameter("gender");
		if (session.getAttribute("languages") != null) {
			languages = (String[]) session.getAttribute("languages");
		}
		if (session.getAttribute("days") != null) {
			days = (String[]) session.getAttribute("days");
		}

		

		sb.append("Below is the information you provided:<br><br>");
		sb.append("Name: " + session.getAttribute("firstname") + " " + session.getAttribute("lastname") + "<br><br>");
		sb.append("Languages Known: ");
		for (int i = 0; i < languages.length; i++) {
			sb.append(languages[i] + ", ");
		}
		sb.append("<br><br>");
		sb.append("Days Available: ");
		for (int i = 0; i < days.length; i++) {
			sb.append(days[i] + ", ");
		}
		sb.append("<br><br>");

		sb.append("Gender: " + gender + "<br><br>");
		sb.append("<form action=\".\\welcome\" method=\"POST\" >\r\n"
				+ "    <input type=\"hidden\" name=\"firstname\" value=" + session.getAttribute("firstname") + ">\r\n"
				+ "    <input type=\"hidden\"  name=\"lastname\" value=" + session.getAttribute("lastname") + ">\r\n"
				+ "    <input type=\"hidden\"  name=\"password\" value=\"ser422\">\r\n"
				+ "     <input type=\"submit\" value=\"CANCEL\"><br><br>\r\n" + "  </form>");
		sb.append("<form action=\"enterNames\" method=\"GET\" >\r\n"
				+ "    <input type=\"submit\" value=\"EDIT\"><br><br>\r\n" + "  </form>");
		sb.append("<form action=\"usercontroller\" method=\"GET\" >\r\n"
				+ "    <input type=\"submit\" value=\"CONFIRM\"><br><br>\r\n" + "  </form>");
		sb.append("</body></html>");
		pw.print(sb.toString());

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}