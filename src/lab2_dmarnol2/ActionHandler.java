package lab2_dmarnol2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionHandler {
	public String handleIt(HttpServletRequest req, HttpServletResponse response);

}
