package admin.company.model.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.company.model.service.CompanyService;
import admin.company.model.vo.Company;

/**
 * Servlet implementation class CompanyReadServlet
 */
@WebServlet("/companyRead.do")
public class CompanyReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CompanyReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Company> clist = new ArrayList<Company>();
		CompanyService cs = new CompanyService();
		
		
		clist = cs.readCompany();
		String page = null;
		
		if(clist!=null) {
			System.out.println("cReadServlet:" +clist);
			page= "company.jsp";
			request.setAttribute("clist", clist);
		}else {
			page = "errorPage.jsp";
			request.setAttribute("msg", "기업회원 목록 불러오기 에러!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
