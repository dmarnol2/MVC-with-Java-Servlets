package lab2_dmarnol2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EnterLanguages extends HttpServlet{
	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder("<html><head></head><body>");
		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession();
		session.setAttribute("firstname", req.getParameter("firstname"));
		session.setAttribute("lastname", req.getParameter("lastname"));
		session.setAttribute("action", "/enterDays");
		//session.setAttribute("languages", "");
		
		//session.setAttribute("previous", "/enterLanguages");
		session.setAttribute("previous", "/enterNames");
		
		sb.append("<form action=\"controller\" method=\"POST\"> Languages you know:   \r\n" + 
				"         <input type = \"checkbox\" name = \"item\" value = \"Java\"> Java\r\n" + 
				"         <input type = \"checkbox\" name = \"item\" value = \"Python\"> Python\r\n" + 
				"         <input type = \"checkbox\" name = \"item\" value = \"C\"> C\r\n" + 
				"         <input type = \"checkbox\" name = \"item\" value = \"JavaScript\"> JavaScript\r\n" + 
				"         <input type = \"checkbox\" name = \"item\" value = \"HTML\"> HTML<br><br>\r\n" + 
				"        <input type=\"submit\"><br>\r\n" + 
				"      </div>\r\n" + 
				"    </form>");
		sb.append("<form action=\"enterNames\" method=\"GET\" >\r\n" + 
				"    <input type=\"submit\" value=\"Previous\"><br><br>\r\n" + 
				"  </form>");
		//sb.append("<br><a href=\"#\" action=\"/enterNames\" name=\"3\">Previous</a>");		
		sb.append("</body></html>");
		pw.print(sb.toString());
		
	} // end method
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doPost(req,res);	
	}

}
