

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login1
 */
@WebServlet("/login1")
public class login1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String driver = request.getParameter("driver");
		String url = request.getParameter("url");
		
		/*LoginData logindata=new LoginData();
		logindata.setName(name);
		logindata.setPass(pass);
		logindata.setDriver(driver);
		logindata.setUrl(url);
		*/
			try {
				Class.forName(driver);
				Connection c = DriverManager.getConnection(url,name,pass);		
				//out.print("connection is created");
				out.println("<div>");
				out.println("<h>User: SYSTEM/ROOT</h>");
				out.println("</div>");
				DatabaseMetaData metadata = c.getMetaData();
				
				String types[] = {"TABLE"};
				ResultSet rs = metadata.getTables(null, null, null, types);
				
				while(rs.next())
				{	
					 
			          out.print("<table border='1' width='10%'");
			          out.println("<br>");				 
					 out.println("<a href='View?name="+name+"&pass="+pass+"&driver="+driver+"&url="+url+"&tablename="+rs.getString(3)+"'>"+rs.getString(3)+"</a>");	
			          //out.print("<button value='tab'>"+"<a href='View'>"+rs.getString(3)+"</a>"+"</button>");
				      
					 out.println("</br>");
			          out.println("</table>");
			          out.print("</form>");
			
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
	}

}
