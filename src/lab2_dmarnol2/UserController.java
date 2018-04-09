package lab2_dmarnol2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class UserController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("previous", "/enterLanguages");
		session.setAttribute("action", "/enterNames");
		StringBuilder sb = new StringBuilder("<html><head></head><body>");
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html"); // return content type
		res.setStatus(res.SC_OK);
		//String referer = req.getHeader("Referer");
		
		/*Document doc = (Document) session.getAttribute("document");
		NodeList nList = doc.getElementsByTagName("user");

		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = (Node) nList.item(temp);
			//sb.append("Current Element :" + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				sb.append("Student roll no : " + eElement.getAttribute("gender"));
				sb.append("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
				sb.append("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
				sb.append("day : " + eElement.getElementsByTagName("day").item(0).getTextContent());
				sb.append("Marks : " + eElement.getElementsByTagName("language").item(0).getTextContent());
			}
		}
		*/// change inputs to info from user selected from file page 1
		sb.append("<p>Here is the data for the user you selected:</p><br>");
		sb.append("<p>Name: "+session.getAttribute("firstname")+" "+session.getAttribute("lastname")+"</p>");
		sb.append("<p>Languages you know: "+session.getAttribute("languages")+"</p>");
		sb.append("<p>Days available: "+session.getAttribute("days")+"</p>");
		sb.append("<p>Gender: "+session.getAttribute("gender")+"</p><br><br>");
		sb.append("<a href=\"./welcome\" >Link to home page</a><br><br>");
		sb.append("<a href=\"./removeuser\" >Remove User</a><br><br>");
		sb.append("</body></html>");
		pw.print(sb.toString());
		
	}
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doPost(req, res);	
	}
}
