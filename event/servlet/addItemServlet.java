package event.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event.model.Item;
import event.service.addItemService;

/**
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addItemServlet")
public class addItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addItemServlet() {
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
		
		// event item post input
		
		response.setContentType("text/html");
		response.setContentType("text/html");
		try {
			if(request.getSession(false).getAttribute("userEmail") != null ) {
				
				Item item = new Item();
				
				item.setTypeId(Integer.parseInt(request.getParameter("typeId")));
				item.setName(request.getParameter("name"));
				item.setHours(Integer.parseInt(request.getParameter("hours")));
				item.setMinutes(Integer.parseInt(request.getParameter("minutes")));
				
				addItemService itemService = new addItemService();
				itemService.addItem(item);
				
				if(itemService.getSuccess()==1) {
					HttpSession session = request.getSession();
					session.setAttribute("errors_success",1);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addItem.jsp");
					dispatcher.forward(request, response);
				}else if(itemService.getSuccess()==0) {
					HttpSession session = request.getSession();
					session.setAttribute("errors_success",2);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addItem.jsp");
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
