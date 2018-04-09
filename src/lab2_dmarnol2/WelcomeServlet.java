package lab2_dmarnol2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WelcomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String firstname = "";
	private String lastname = "";
	private String pass = "";
	

	public void init(ServletConfig sc) throws ServletException {
		super.init(sc);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		StringBuilder sb = new StringBuilder("<html><head></head><body>");
		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession();
		session.setAttribute("previous", ""); // take note
		pass = req.getParameter("password");
		firstname = req.getParameter("firstname");
		lastname = req.getParameter("lastname");
		
		String[] languages = (String[]) session.getAttribute("languages");
		String[] days = (String[]) session.getAttribute("days");
		String gender =  (String) session.getAttribute("gender");
		// String userData = null;

		Document doc = (Document) session.getAttribute("document");
		NodeList nList = doc.getElementsByTagName("user");

		res.setContentType("text/html"); // return content type
		
		session.setAttribute("action", "/enterNames");

		if (pass.equals("ser422")) {
			
			session.setAttribute("action", "/enterNames"); // if user
			sb.append("<p>Welcome " + firstname + " " + lastname + "<p><br>");

			if (session.getAttribute("priorInput").equals("no")) {

				session.setAttribute("firstname", firstname);
				session.setAttribute("lastname", lastname);
				sb.append(
						"<p>You have not entered any information yet. Please click the Create link below to begin.</p><br>");
				sb.append("<a href=\"controller\" method=\"GET\" >Create</a><br><br>");
			} else {

				sb.append("<p>Here is the information you have entered previously:<p>");
				sb.append("Name: " + firstname + " " + lastname + "<br>");

				if (languages != null) {
					sb.append("Languages Known: ");
					for (int i = 0; i < languages.length; i++) {
						sb.append(languages[i] + ", ");
					}
					sb.append("<br>");
				}
				if (days != null) {
					sb.append("Days Available: ");
					for (int i = 0; i < days.length; i++) {
						sb.append(days[i] + ", ");
					}
					sb.append("<br>");
				}
				if (gender != null) {
					sb.append("Gender: " + gender + "<br>");
				}
				sb.append("<br><a href=\"controller\" method=\"GET\" name=\"edit\">Edit</a><br><br>");

			} // end inner else
			sb.append("<a href='/lab2_dmarnol2/'  >Logout</a><br><br>");
		} // end outer if

		else { // outer else
			res.setStatus(res.SC_UNAUTHORIZED);
			sb.append("<h3>Password does not match any user in our system. Please try again.</h3><br><br>");
		} // end outer else

		if (session.getAttribute("data").equals("yes")) {
			sb.append("<p>Here is hyperlinked list of names with existing data:</p><br>");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					sb.append("<a href=\"./usercontroller \">" +eElement.getElementsByTagName("firstname").item(0).getTextContent() +  
							             eElement.getElementsByTagName("lastname").item(0).getTextContent() + "<br></a>");
				}
			} // end for loop
		} // end if

		sb.append("</body></html>");

		pw.print(sb.toString());
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
