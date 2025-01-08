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
			int orderid =Integer.parseInt(id);
			Connection con = ConnectDB.connect();
			PreparedStatement ps = con.prepareStatement("update order_tbl set status =? where orderid=?");
			ps.setString(1, "Disapprove" );
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