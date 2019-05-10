import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionServlet2 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");// ����������ݵı����ʽ
        response.setContentType("text/html");// ����������ļ�����
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();//ʹ��request�����ȡsession
        String account=(String) session.getAttribute("account");//��session�л�ȡ��Ϣ
        String password=(String) session.getAttribute("password");
        int inactiveTime=session.getMaxInactiveInterval();//��ȡsession����Чʱ��
        out.println("��session�л�ȡ��<br/>" +
                "account="+account+"<br/>" +
                "password="+password+"<br/>" +
                "��Чʱ�䣨�룩��"+inactiveTime);
        out.println("��¼��Ϣ�ɹ����浽session�У�<br/>" +
                "������ӽ��з���:<a href='SessionServlet'>����</a><br/>");
    }

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
