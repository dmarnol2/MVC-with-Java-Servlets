package lab2_dmarnol2;

import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String firstname;
	String lastname;
	private static String _filename = null;

	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
		_filename = sc.getInitParameter("personfile");
		if (_filename == null || _filename.length() == 0) {
			throw new ServletException();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		StringBuilder sb = new StringBuilder("<html><head></head><body>");
		PrintWriter pw = res.getWriter();
		
		

		File inputFile = new File(_filename);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			doc = dBuilder.parse(inputFile);
		} catch (SAXException e) {

			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();

		if (doc == null || doc.getElementsByTagName("user").equals("")) {
			session.setAttribute("data", "no");
		} else {
			session.setAttribute("data", "yes");
		}

		session.setAttribute("document", doc);
		
		//String fname=(String) session.getAttribute("firstname");
		
		if (session.getAttribute("firstname") != null) {
			session.setAttribute("priorInput", "yes");
			firstname = (String) session.getAttribute("firstname");
			lastname = (String) session.getAttribute("lastname");

			sb.append("<form action=\"welcome\" method=\"POST\">\r\n" + "    <div>\r\n"
					+ "    Firstname: <input type=\"text\"  name=\"firstname\" value=" + firstname + "><br><br>\r\n"
					+ "    Lastname: <input type=\"text\"  name=\"lastname\" value=" + lastname + "><br><br>\r\n"
					+ "    Password: <input type=\"text\"  name=\"password\"><br><br>\r\n");
		} else {
			session.setAttribute("priorInput", "no");
			sb.append("<form action=\"welcome\" method=\"POST\">\r\n" + "    <div>\r\n"
					+ "    Firstname: <input type=\"text\"  name=\"firstname\"><br><br>\r\n"
					+ "    Lastname: <input type=\"text\"  name=\"lastname\"><br><br>\r\n"
					+ "    Password: <input type=\"text\"  name=\"password\"><br><br>\r\n");
		}
		sb.append("<input type=\"submit\" class=\"btn btn-default submitLoginButton\" value=\"Login\"><br><br>\r\n"
				+ "	</div>\r\n" + "  </form> ");
		sb.append("</body></html>");

		pw.print(sb.toString());

	}
}
