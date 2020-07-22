

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DropTable
 */
@WebServlet("/DropTable")
public class DropTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropTable() {
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
		out.print(pass);
		
		try {
			Class.forName(driver);
			Connection c=DriverManager.getConnection(url,name,pass);
			out.print(c);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
			
			//PreparedStatement ps=c.prepareStatement("delete from "+tablename);
			//ps.executeUpdate();
			//ResultSet rs=ps.executeQuery();
	}

}
