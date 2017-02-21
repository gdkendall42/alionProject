package protoTypeLayout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;


@WebServlet(urlPatterns = "/projectListView.html")
public class projectViewServelt extends HttpServlet {
	
	/**
	 * @WebServlet(urlPatterns = "/login.do")
	 */
	
	
	
	
	private static final long serialVersionUID = 1L;
	private UserValidationService service = new UserValidationService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/views/projectListView.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        
        boolean isUserValid = service.isUserValid(name, password);
        
        
        if(isUserValid){
        	request.setAttribute("name", name);
    		request.setAttribute("password", password);
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
        }
        else{
        	request.setAttribute("errorMessage", "Invalid login");
        	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }

}