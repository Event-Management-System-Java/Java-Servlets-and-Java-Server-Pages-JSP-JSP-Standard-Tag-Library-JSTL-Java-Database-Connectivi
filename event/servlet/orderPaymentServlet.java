package event.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event.model.Card;
import event.model.Type;
import event.service.paymentService;

/**
 * Servlet implementation class orderPaymentServlet
 */
@WebServlet("/orderPaymentServlet")
public class orderPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderPaymentServlet() {
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
		
		response.setContentType("text/html");
		try {
			if(request.getSession(false).getAttribute("userEmail") != null ) {
		
				Card card=new Card();
				
				card.setCardNumber(request.getParameter("cardNumber"));
				card.setCcv(Integer.parseInt(request.getParameter("ccv")));
				card.setMonth(Integer.parseInt(request.getParameter("month")));
				card.setYear(Integer.parseInt(request.getParameter("year")));
				card.setUserEmail(request.getSession(false).getAttribute("userEmail").toString());
				
				Type type = new Type();
				
				type.setId(Integer.parseInt(request.getSession(false).getAttribute("orderId").toString()));
				type.setPrice(Double.parseDouble(request.getSession(false).getAttribute("orderPrice").toString()));
				
				paymentService payment = new paymentService();
				payment.confirmPayment(type,card);
				
				if(payment.getSuccess()==1) {
					HttpSession session = request.getSession();
					session.setAttribute("errors_success",1);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile.jsp");
					dispatcher.forward(request, response);
				}else if(payment.getSuccess()==0) {
					HttpSession session = request.getSession();
					session.setAttribute("errors_success",2);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/buyOrder.jsp");
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
