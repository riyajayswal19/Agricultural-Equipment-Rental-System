<%@ page import = "rental.sys.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.sys.co.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Blob image = null;

	

	byte[ ] imgData = null ;

	Statement stmt = null;

	
	Connection con = ConnectDB.connect();
    try
    {
    	String pid=request.getParameter("pid");
		PreparedStatement ps1 = con.prepareStatement("select photo from product_tbl where pid=?");
		ps1.setString(1, pid); 
		
		
		ResultSet rs = ps1.executeQuery();
         
		if (rs.next()) {

		image = rs.getBlob(1);


		imgData = image.getBytes(1,(int)image.length());

	} else {

			out.println("Display Blob Example");

			out.println("image not found for given id>");

		return;

	}


// display the image

response.setContentType("image/gif");

OutputStream o = response.getOutputStream();

o.write(imgData);


o.flush();

o.close();

} catch (Exception e) {

out.println("Unable To Display image");



return;

} 



%>

</body>
</html>