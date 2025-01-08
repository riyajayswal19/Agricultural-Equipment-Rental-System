

<%@ page import = "rental.sys.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.sys.co.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
		try{
			String id =request.getParameter("orderid");
			
			//changed
			String pid =request.getParameter("pid");
			System.out.println(pid);
			int p =Integer.parseInt(pid);
			
			int orderid =Integer.parseInt(id);
			Connection con = ConnectDB.connect();
			PreparedStatement ps = con.prepareStatement("update order_tbl set status =? where orderid=?");
			//START
			PreparedStatement pf = con.prepareStatement("select * from product_tbl where pid=? ");
			pf.setInt(1,p);
			ResultSet rs1 = pf.executeQuery();
			System.out.println(rs1);
			while(rs1.next())
			{
			   int i=rs1.getInt("pquantity");
			   i=i-1;
			   System.out.println(i);
			   PreparedStatement pr = con.prepareStatement("update product_tbl set pquantity =? where pid=?");
				
				pr.setInt(1,i);
				pr.setInt(2,p);
				int product = pr.executeUpdate();
				System.out.println(product+"record inserted");
			}
			  //END
			
		
			
			ps.setString(1, "Approve" );
			ps.setInt(2, orderid);
			int i= ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("viewReq.jsp");
			}
			else
			{
				response.sendRedirect("failed.html");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	%>

</body>
</html>