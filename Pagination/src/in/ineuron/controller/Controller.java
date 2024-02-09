package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import in.ineuron.businessObject.StudentBusiness;
import in.ineuron.model.Student;
import in.ineuron.service.IService;
import in.ineuron.service.IServiceImpl;

/**
 * Servlet implementation class Controller
 */
@WebServlet(description = "To pick up and process the requests", urlPatterns = { "/controller/*" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IService IServiceImpl = new IServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String second = request.getParameter("s1");
		int totalNoOfRecords =IServiceImpl.totalNoOfRecords();
		if("/first".equalsIgnoreCase(request.getPathInfo()))
		{
			System.out.println("hi");
			int pageSize =Integer.parseInt(request.getParameter("pageSize"));
			System.out.println("hi");
			HttpSession session=request.getSession();
			session.setAttribute("pageSize", pageSize);
			int startPos=IServiceImpl.getPosition((Integer)request.getSession().getAttribute("pageSize"),1);
			int pageCount= IServiceImpl.pageCount(pageSize, totalNoOfRecords);
			List<StudentBusiness> list= IServiceImpl.fetchData(startPos,(Integer)request.getSession().getAttribute("pageSize"));				
			System.out.println(list);
			request.setAttribute("list",list);
			request.setAttribute("pageCount",pageCount);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("../Result.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(second!=null)
		{				
			try
			{
				int startPos=IServiceImpl.getPosition((Integer)request.getSession().getAttribute("pageSize"),Integer.parseInt(second));
				List<StudentBusiness> list= IServiceImpl.fetchData(startPos,(Integer)request.getSession().getAttribute("pageSize"));				
				System.out.println(list);
				request.setAttribute("list",list);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("../Result.jsp");
				requestDispatcher.forward(request, response);
				
			}
			catch(HibernateException e)
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("../Error.jsp");
			}
		
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
