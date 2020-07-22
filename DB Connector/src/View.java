

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }
      
    
	//Connection c=null;
    Integer page_no;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String driver=request.getParameter("driver");
		String url1=request.getParameter("url");
		String tablename=request.getParameter("tablename");
		//out.println(name);
		//out.println(pass);
		//out.println(driver);
		//out.println(url1);
		//out.println(tablename);
		/*
		Connection c;
		try 
		{
			Class.forName(driver);
			c=DriverManager.getConnection(url1,pass,name);
			out.print(c);
					*/
		try
		{
			Class.forName(driver);
			Connection c = DriverManager.getConnection(url1,name,pass);		
			Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	 		ResultSet rs=s.executeQuery("select * from "+tablename);
	 		ResultSetMetaData rsmd=rs.getMetaData();
	 		out.print("<h1>"+"Table Name is : "+tablename+"</h1>");
	 		int cc = rsmd.getColumnCount();
	 		rs.last();
	 	    int tr = rs.getRow();
	 		int rpp = 100;
	 		int p = tr/rpp;
	 		int r = tr%rpp;
	 		if(r ==0)
	 		{
	 			p = p;
	 		}
	 		else
	 		{
	 			p = p+1;	
	 		}	 			 
	 		for(int l=1;l<=p;l++)
	 		{
	 			out.print("<a href='view?page_no="+l+"'>"+l+"</a>");
	 		}	 		 
	 		String url = request.getParameter("page_no");
	 		if(url==null)
	 		{
	 			page_no = new Integer(1);
	 		}
	 		else	 
	 		{
	 			page_no=new Integer(Integer.parseInt(request.getParameter("page_no")));
	 		}	 			 
	 		int start = page_no.intValue();
	 		int last = start*100;
	 		int first = last+1-100;
	 		out.println("<table bgcolor='white' border='1' width='200'>");
	 		out.println("<tr>");
	 		for(int i=1;i<=rsmd.getColumnCount();i++)
	 		{
	 			out.println("<th>"+ rsmd.getColumnName(i)+"</th>");
	 		}
	 		for(int i = first;i<=last;i++)
	 		{
	 	     	 rs.absolute(first);
	 			 out.print("<tr>");

	 			 for(int m = 1;m<=cc;m++)
	 			 {
	 				
	 				 out.println("<td>"+rs.getString(m)+"</td>");
	 			 }
	 			 first++;
	 			out.print("</tr>");
	 		 }
	 		 c.close();
	 		 out.print("</tr>");
	 		 out.print("</table>");
	 		 
		} 
		catch(Exception e)
		{
			out.print(e);
		}
		out.print("<p align='right'>");
		out.print("<a href='AddColumn?name="+name+"&pass="+pass+"&driver="+driver+"&url="+url1+"&tablename="+tablename+"'>"+"ADD COLUMN   "+"</a>");
		out.print("<a href='DropTable?name="+name+"&pass="+pass+"&driver="+driver+"&url="+url1+"'>"+"DROP TABLE  "+"</a>");
		out.print("<button>"+"<a href='View?name="+name+"&pass="+pass+"&driver="+driver+"&url="+url1+"'>"+"RENAME TABLE"+"</a>"+"</button>");
	
		out.print("<button>"+"<a href=''>"+"CREATE TABLE"+"</a>"+"</button>");
		out.print("</p>");
		
	}
	

}
