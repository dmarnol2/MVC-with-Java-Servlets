package lab2_dmarnol2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemoveUser extends HttpServlet{
	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		//session.setAttribute("previous", "/enterLanguages");
		//session.setAttribute("action", "/enterNames");
		StringBuilder sb = new StringBuilder("<html><head></head><body>");
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html"); // return content type
		res.setStatus(res.SC_OK);
		//String referer = req.getHeader("Referer");
		
		// change inputs to info from user selected from file page 1
		sb.append("<h4>Are you sure you want to delete?</h4><br>");

		sb.append("<form action=\"welcome\" method=\"POST\" >\r\n" + 
				 "    <input type=\"hidden\" name=\"firstname\" value=" + session.getAttribute("firstname") + "><br><br>\r\n"+
				 "    <input type=\"hidden\"  name=\"lastname\" value=" + session.getAttribute("lastname") + "><br><br>\r\n"+
				 "    <input type=\"hidden\"  name=\"password\" value=\"ser422\"><br><br>\r\n"+
				 "	Click remove button to confirm<br>" + 
				"     <input type=\"submit\" name=\"remove\" value=\"REMOVE\"><br><br>\r\n" + 
				"  </form>");
				
		sb.append("<form action=\"usercontroller\" method=\"GET\" >\r\n" + 
				"    <input type=\"submit\" value=\"CANCEL\"><br><br>\r\n" + 
				"  </form>");
		
		sb.append("</body></html>");
		pw.print(sb.toString());
		
	}
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doPost(req, res);	
	}
}
