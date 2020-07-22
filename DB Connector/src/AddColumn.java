

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddColumn
 */
@WebServlet("/AddColumn")
public class AddColumn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddColumn() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String driver=request.getParameter("driver");
		String url=request.getParameter("url1");
		String tablename=request.getParameter("tablename");
		//out.print(name);
		//out.print(pass);
		//out.print(driver);
		//out.print(url);
		//out.print(tablename);
		out.print("<form action='AddColumnView'>");
		out.print("<label for='columnname' align='center'>"+"<b>"+"New Coumn Name"+"</b>"+"</label>");
		out.print("<input type='text'  name='columnname' required style='width: 299px; background-color: Aqua'>");
		//out.print("<a >");
		out.print("<button type='submit' form action='AddColumn?name="+name+"&pass="+pass+"&driver="+driver+"&url="+url+"&tablename="+tablename+"' style='width: 200px;'>"+"CREATE"+"</button>");
		//out.print("</a>");	
		out.print("</form>");
		
		
		
	}

}
