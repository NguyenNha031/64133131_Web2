package vn.edu.nguyennha.VdtoGET;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class subpage
 */
@WebServlet("/subpage")
public class subpage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public subpage() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value1 = request.getParameter("param1");
        String value2 = request.getParameter("param2");
        PrintWriter traVe = response.getWriter();
        traVe.append("Giá trị tham số param1 = ").append(value1).append("\n");
        traVe.append("Giá trị tham số param2 = ").append(value2);
    }
}
