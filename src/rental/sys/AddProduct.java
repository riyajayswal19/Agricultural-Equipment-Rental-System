package rental.sys;

import com.sys.co.*;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class AddProduct
 */
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
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
		
		
		String pname = request.getParameter("pname");
		System.out.println(pname);
		String pproduct = request.getParameter("pproduct");
		System.out.println(pproduct);
		String pmob = request.getParameter("pmob");
		System.out.println(pmob);
		String plocation = request.getParameter("plocation");
		System.out.println(plocation);
		String pcity = request.getParameter("pcity");
		System.out.println(pcity);
		String ptaluka = request.getParameter("ptaluka");
		System.out.println(ptaluka);
		String pprize = request.getParameter("pprize");
		System.out.println(pprize);
		String pdeposit = request.getParameter("pdeposit");
		System.out.println(pdeposit);
		String pquantity = request.getParameter("pquantity");
		System.out.println(pquantity);
		
		InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
		
		
		String email = User1.getEmail();
		
		
		
		try
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into product_tbl values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, pname);
			ps1.setString(3, pproduct);
			ps1.setString(4, email);
			ps1.setString(5, pmob);
			ps1.setString(6, plocation);
			ps1.setString(7, pcity);
			ps1.setString(8, ptaluka);
			ps1.setString(9, pprize);
			ps1.setString(10, pdeposit);
			ps1.setString(11, pquantity);
			
			 if (inputStream != null) {
	                // fetches input stream of the upload file for the blob column
	                ps1.setBlob(12, inputStream);
	            }
			
			
			int i = ps1.executeUpdate();
			if(i==1)
			{
				System.out.println("added");
				response.sendRedirect("Menu.html");
				
			}
			else
			{
				System.out.println("Failed");

				response.sendRedirect("AddProduct.html");

			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
}
}