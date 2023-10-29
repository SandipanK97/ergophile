package com.audit.banking.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.stereotype.Repository;

import com.audit.banking.entity.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CustomerRepository {
	
   

    // Create a new customer
    public void createCustomer(Customer customer) throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin"); 
    	conn.setAutoCommit(false);
    	
        String sql = "INSERT INTO customer (custid,fname,mname,ltname,city,mobileno,occupation,dob,state,pin,aadharno,panno,passportno,ekyc)"
        		     +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
        PreparedStatement stmt=conn.prepareStatement(sql);  
		stmt.setString(1,customer.getCustId());
		stmt.setString(2,customer.getFname());
		stmt.setString(3,customer.getMname());
		stmt.setString(4,customer.getLname());
		stmt.setString(5,customer.getCity());
		stmt.setString(6,customer.getMobileNo());
		stmt.setString(7, customer.getOccupation());
		stmt.setString(8,customer.getDob());
		stmt.setString(9,customer.getState());
		stmt.setString(10,customer.getAddressPin());
		stmt.setString(11,customer.getAadharNo());
		stmt.setString(12,customer.getPanNo());
		stmt.setString(13,customer.getPassportNo());
		stmt.setString(14,customer.getIsEkycDone());
		stmt.executeUpdate();
		
		
    }

    // Read all customers
    public List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin"); 
    	
    	List<Customer> list = new ArrayList<>();
        String sql = "select * from customer";
        PreparedStatement stmt=conn.prepareStatement(sql); 
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
        	Customer customer = new Customer();
           customer.setCustId(rs.getString("custid")); 
           customer.setName(rs.getString("fname")+" "+rs.getString("ltname"));
  		   customer.setFname(rs.getString("fname"));
  		   customer.setMname(rs.getString("mname")); 
  		   customer.setLname(rs.getString("ltname"));
  		   customer.setCity(rs.getString("city")); 
  		   customer.setMobileNo(rs.getString("mobileno"));
  		   customer.setOccupation(rs.getString("occupation")); 
  		   customer.setDob(rs.getString("dob"));
  		   customer.setState(rs.getString("state")); 
  		   customer.setAddressPin(rs.getString("pin"));
  		   customer.setAadharNo(rs.getString("aadharno")); 
  		   customer.setPanNo(rs.getString("panno"));
  		   customer.setPassportNo(rs.getString("passportno")); 
  		   customer.setIsEkycDone(rs.getString("ekyc"));
  		   
  		 list.add(customer);
        }
        
        return list;
        
    }

    // Read a single customer by ID
    public Customer getCustomerById(String id) throws SQLException, ClassNotFoundException{
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin");  
    	char check= id.charAt(0);
    	String sql="";
    	
    	if(check=='C') {
    	   sql =   "select t.*,a.acnumber from CUSTOMER t, ACCOUNT a where t.custid = a.custid and t.custid = ?" ;
    	}else {
    	   sql =  "select t.*,a.acnumber from CUSTOMER t, ACCOUNT a where t.custid = a.custid and a.acnumber = ?";
    	}
       
    	PreparedStatement stmt=conn.prepareStatement(sql); 
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        Customer customer = new Customer();
        while(rs.next()) {
           customer.setCustId(rs.getString("custid")); 
           customer.setName(rs.getString("fname")+" "+rs.getString("ltname"));
  		   customer.setFname(rs.getString("fname"));
  		   customer.setMname(rs.getString("mname")); 
  		   customer.setLname(rs.getString("ltname"));
  		   customer.setCity(rs.getString("city")); 
  		   customer.setMobileNo(rs.getString("mobileno"));
  		   customer.setOccupation(rs.getString("occupation")); 
  		   customer.setDob(rs.getString("dob"));
  		   customer.setState(rs.getString("state")); 
  		   customer.setAddressPin(rs.getString("pin"));
  		   customer.setAadharNo(rs.getString("aadharno")); 
  		   customer.setPanNo(rs.getString("panno"));
  		   customer.setPassportNo(rs.getString("passportno")); 
  		   customer.setIsEkycDone(rs.getString("ekyc"));
  		   customer.setAccountNo(rs.getString("acnumber"));
  		}
       return customer;
    }

    // Update a customer
    public void updateCustomer(Customer customer) throws SQLException, ClassNotFoundException, ParseException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin"); 
 
    	
        String sql = "UPDATE customer SET fname=?,mname=?,ltname=?,city=?,mobileno=?,occupation=?,dob=to_date(?,'dd/mm/yyyy'),state=?,pin=?,aadharno=?,panno=?,passportno=?,ekyc=? WHERE custid = ?";
        PreparedStatement stmt=conn.prepareStatement(sql);  
		stmt.setString(1,customer.getFname());
		stmt.setString(2,customer.getMname());
		stmt.setString(3,customer.getLname());
		stmt.setString(4,customer.getCity());
		stmt.setString(5,customer.getMobileNo());
		stmt.setString(6, customer.getOccupation());
		stmt.setString(7,customer.getDob());
		stmt.setString(8,customer.getState());
		stmt.setString(9,customer.getAddressPin());
		stmt.setString(10,customer.getAadharNo());
		stmt.setString(11,customer.getPanNo());
		stmt.setString(12,customer.getPassportNo());
		stmt.setString(13,customer.getIsEkycDone());
		stmt.setString(14,customer.getCustId());
		
		stmt.executeUpdate();
		
    }

    // Delete a customer
    public void deleteCustomer(String id)  throws SQLException, ClassNotFoundException  {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin"); 
    	char check= id.charAt(0);
    	String sql="";
    	if(check=='C') {
     	   sql =  "delete from CUSTOMER t where t.custid =  ?" ;
     	}else {
     	   sql =  "delete from CUSTOMER t where t.custid = (select a.custid from account a where a.acnumber = ?)";
     	}
        PreparedStatement stmt=conn.prepareStatement(sql);  
		stmt.setString(1,id);
		stmt.executeQuery();
    }
}
