package event.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event.model.Type;
import event.service.addTypeService;

/**
 * Servlet implementation class addTypeServlet
 */
@WebServlet("/addTypeServlet")
public class addTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// event type post input
		
		response.setContentType("text/html");
		try {
			if(request.getSession(false).getAttribute("userEmail") != null ) {
				
				Type type = new Type();
				
				type.setType(request.getParameter("name"));
				type.setPrice(Double.parseDouble(request.getParameter("price")));
				
				addTypeService typeService = new addTypeService();
				typeService.addType(type);
				
				if(typeService.getSuccess()==1) {
					HttpSession session = request.getSession();
					session.setAttribute("errors_success",1);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addType.jsp");
					dispatcher.forward(request, response);
				}else if(typeService.getSuccess()==0) {
					HttpSession session = request.getSession();
					session.setAttribute("errors_success",2);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addType.jsp");
					dispatcher.forward(request, response);
				}
			}else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		}catch (NullPointerException e){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
