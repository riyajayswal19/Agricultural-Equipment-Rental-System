package rental.sys;
import com.sys.co.*;
import java.time.LocalDate;
import  java.sql.*; 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sys.co.ConnectDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Req
 */
public class Req extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Req() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String status="pending";
		 String myObj="0"  ;
		
try		 
{
  int pid =Integer.parseInt(request.getParameter("pid"));
  Connection con=ConnectDB.connect();
  PreparedStatement ps=con.prepareStatement("select * from product_tbl where pid=?");
  ps.setInt(1,pid);
  ResultSet rs1 = ps.executeQuery();
	while(rs1.next())
	{
	   int i=rs1.getInt("pid");
	   String email=rs1.getString("email");
	   PreparedStatement ps1 = con.prepareStatement("insert into order_tbl values( ?, ?, ?, ?, ?)");
		
		ps1.setInt(1,0);
		ps1.setInt(2,i);
		ps1.setString(3,email);
		ps1.setString(4,myObj);
		ps1.setString(5,status);
		int p = ps1.executeUpdate();
		System.out.println(p+"record inserted");
		System.out.println(status);
	}
	  
  
	  
  }
  
  

catch(Exception e)
{
	 e.printStackTrace();
}
		
	
	
	}

}
