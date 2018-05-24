package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SearchBean;
import service.KaiinnService;
import vo.KaiinnVo;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String num1id = request.getParameter("id");
		int key = Integer.parseInt(num1id);
		KaiinnVo kaiinnVo= new KaiinnVo();

		KaiinnService kaiinnService = new KaiinnService();

			kaiinnVo=kaiinnService.searchs(key);


		SearchBean searchBean = new SearchBean();
		searchBean.setId(kaiinnVo.getKaiinnno());
		searchBean.setName(kaiinnVo.getName());
		searchBean.setDate(kaiinnVo.getRegistdate());
		searchBean.setSex(kaiinnVo.getSex());

		request.setAttribute("bean", searchBean);

		RequestDispatcher disp = request.getRequestDispatcher("/search.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
