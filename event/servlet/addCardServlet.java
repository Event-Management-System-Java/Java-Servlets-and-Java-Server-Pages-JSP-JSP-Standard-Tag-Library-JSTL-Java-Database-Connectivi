package event.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event.model.Card;
import event.service.addCardService;

/**
 * Servlet implementation class addCardServlet
 */
@WebServlet("/addCardServlet")
public class addCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCardServlet() {
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
		
		response.setContentType("text/html");
		try {
			if(request.getSession(false).getAttribute("userEmail") != null ) {
				
				Card card = new Card();
				
				card.setCardNumber(request.getParameter("cardNumber"));
				card.setCcv(Integer.parseInt(request.getParameter("ccv")));
				card.setMonth(Integer.parseInt(request.getParameter("month")));
				card.setYear(Integer.parseInt(request.getParameter("year")));
				card.setUserEmail(request.getSession(false).getAttribute("userEmail").toString());
				
				addCardService cardService = new addCardService();
				cardService.addCard(card);
				
				if(cardService.getSuccess()==1) {
					HttpSession session = request.getSession();
					session.setAttribute("errors_success",1);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addCard.jsp");
					dispatcher.forward(request, response);
				}else if(cardService.getSuccess()==2) {
					HttpSession session = request.getSession();
					session.setAttribute("errors_success",2);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addCard.jsp");
					dispatcher.forward(request, response);
				}else if(cardService.getSuccess()==0) {
					HttpSession session = request.getSession();
					session.setAttribute("errors_success",3);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addCard.jsp");
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
