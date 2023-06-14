package com.Ergophile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String user_name = req.getParameter("user_name");
		String user_dateOfBirth = req.getParameter("user_dateOfBirth");
		String user_gender = req.getParameter("user_gender");
		String user_email = req.getParameter("user_email");
		String user_phone = req.getParameter("user_phone");
		String user_city = req.getParameter("user_city");
		String user_state = req.getParameter("user_state");
		String user_college = req.getParameter("user_college");
		String user_degree = req.getParameter("user_degree");
		String user_degree_marks = req.getParameter("user_degree_marks");
		String user_GradPassoutYear = req.getParameter("user_GradPassoutYear");
		String user_school = req.getParameter("user_school");
		String user_major = req.getParameter("user_major");
		String user_HS_marks = req.getParameter("user_HS_marks");
		String user_HSpassoutYear = req.getParameter("user_HSpassoutYear");
		String user_skills = req.getParameter("user_skills");
		String user_expCheck = req.getParameter("user_expCheck");
		String user_workExp = req.getParameter("user_workExp");
		String user_ExpYears = req.getParameter("user_ExpYears");
		String user_language = req.getParameter("user_language");
//		Part filePart = req.getPart("file");
//		InputStream inStream = filePart.getInputStream();
		
		Random r = new Random( System.currentTimeMillis() );
		int user_id = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
		
		if(user_expCheck ==null) {
			user_workExp="NA";
			user_ExpYears="0";
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/ergo","root","admin");  
			
			String qry = "insert into ergo.ergophile_user  (user_id,user_name,user_dateOfBirth,user_gender,user_email,"
					+ " user_phone,user_state,user_city,user_college,user_degree,user_degree_marks,user_GradPassoutYear,"
					+ " user_school,user_major,user_HS_marks,user_HSpassoutYear,user_skills,user_workExp,user_ExpYears,user_language)"
					+ "  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(qry);  
			stmt.setInt(1,user_id);
			stmt.setString(2,user_name);
			stmt.setString(3,user_dateOfBirth);
			stmt.setString(4,user_gender);
			stmt.setString(5,user_email);
			stmt.setString(6,user_phone);
			stmt.setString(7,user_state);
			stmt.setString(8,user_city);
			stmt.setString(9,user_college);
			stmt.setString(10,user_degree);
			stmt.setString(11,user_degree_marks);
			stmt.setString(12,user_GradPassoutYear);
			stmt.setString(13,user_school);
			stmt.setString(14,user_major);
			stmt.setString(15,user_HS_marks);
			stmt.setString(16,user_HSpassoutYear);
			stmt.setString(17,user_skills);
			stmt.setString(18,user_workExp);
			stmt.setString(19,user_ExpYears);
			stmt.setString(20,user_language);
//			stmt.setBinaryStream(21,inStream,(int)((File) filePart).length());

			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  ;  
			
			con.close();
		} catch (Exception  e1) {
			e1.printStackTrace();
		}  


		try {
			 Font catFont = new Font(Font.FontFamily.COURIER, 21,
			            Font.BOLD,BaseColor.LIGHT_GRAY);
			    Font redFont = new Font(Font.FontFamily.COURIER, 10,
			            Font.BOLD, BaseColor.RED);
			    Font subFont = new Font(Font.FontFamily.COURIER, 16,
			            Font.NORMAL);
			    Font smallBold = new Font(Font.FontFamily.COURIER, 11,
			            Font.BOLD);
			Document document = new Document();
			OutputStream out = resp.getOutputStream();
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(new Paragraph("Ergophile",catFont));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Application submitted successfully!",subFont));
			document.add(new Paragraph("Generated application ID : " +"APP"+user_id+"ERG"+user_phone,smallBold));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Hi "+user_name+", you will be informed via your registered email id and phone number for future updates.",redFont));
			document.close();

			out.flush();
			out.close();

			System.out.println("Pdf created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}