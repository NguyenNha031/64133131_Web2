package vn.edu.nguyennha.AboutMe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AboutMe
 */
@WebServlet("/aboutme")
public class AboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default constructor. 
     */
    public AboutMe() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        String htmlResponse = """
            <!DOCTYPE html>
            <html lang="vi">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>About Me</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        text-align: center;
                        background: linear-gradient(to right, #f7cac9, #92a8d1);
                        padding: 50px;
                    }
                    .card {
                        background: white;
                        border-radius: 10px;
                        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                        padding: 20px;
                        max-width: 600px;
                        margin: auto;
                    }
                    h1 {
                        color: #444;
                    }
                    p {
                        color: #666;
                        line-height: 1.6;
                    }
                    .avatar {
                        border-radius: 50%;
                        width: 150px;
                        height: 150px;
                        object-fit: cover;
                        margin-bottom: 20px;
                    }
                </style>
            </head>
            <body>
                <div class="card">
                    <img src="images/avatar.jpg" alt="Avatar" class="avatar">
                    <h1>Nguyễn Thanh Nhã </h1>
                    <p><strong>Tuổi:</strong> 21</p>
                    <p><strong>Sở thích:</strong> Lập trình, đọc sách, du lịch</p>
                    <p><strong>Email:</strong> cirsnha123@gmail.com</p>
                </div>
            </body>
            </html>
        """;

        response.getWriter().write(htmlResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
