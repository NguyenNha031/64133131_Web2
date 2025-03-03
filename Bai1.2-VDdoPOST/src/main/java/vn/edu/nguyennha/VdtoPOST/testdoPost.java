package vn.edu.nguyennha.VdtoPOST;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testdoPost
 */
@WebServlet("/testdoPost")
public class testdoPost extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public testdoPost() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter traVe = response.getWriter();
        traVe.append("Bạn vừa gửi Yêu cầu dạng GET, đây là đáp ứng của tôi");
        String noiDungHTML = "<form method = POST action=\"/ViduHelloWorldServlet/testdoPost\">"
                + "<label>Họ:</label>"
                + "<input type=\"text\" name=\"fname\"><br>\r\n"
                + "<label>Tên:</label>"
                + "<input type=\"text\" name=\"lname\"><br>\r\n"
                + "<input type=\"submit\" value=\"Gửi đi\">"
                + "</form>";
        traVe.append(noiDungHTML);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String value1 = request.getParameter("fname");
        String value2 = request.getParameter("lname");
        PrintWriter traVe = response.getWriter();
        traVe.append("Bạn vừa gửi Yêu cầu dạng POST, đây là đáp ứng của tôi");
        traVe.append("Giá trị tham số fname = ").append(value1).append("\n");
        traVe.append("Giá trị tham số lname = ").append(value2);
    }
}
