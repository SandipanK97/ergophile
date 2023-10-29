package com.audit.banking.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.audit.banking.entity.Account;
@Repository
public class AccountRepository {
	
    public void createAccount(Account account) throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin"); 
    	
        String sql = "INSERT INTO ACCOUNT (ACNUMBER,CUSTID,BID,OPENING_BALANCE,AOD,ATYPE,ASTATUS,LOC,LOANACNUMBER,LOANAMT,ROI,TENURE,IFSC)"
        		     +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
        PreparedStatement stmt=conn.prepareStatement(sql);  
		stmt.setString(1,account.getAccountNo());
		stmt.setString(2,account.getCustId());
		stmt.setString(3,account.getBranch());
		stmt.setString(4,account.getOpeningBalance());
		stmt.setString(5,account.getAod());
		stmt.setString(6,account.getAccountType());
		stmt.setString(7, account.getStatus());
		stmt.setString(8,account.getLocation());
		stmt.setString(9,account.getLoanAccountNo());
		stmt.setString(10,account.getLoanAmt());
		stmt.setString(11,account.getRoi());
		stmt.setString(12,account.getTenure());
		stmt.setString(13,account.getIfscCd());
		stmt.executeUpdate();
		
		
    }

    // Read all customers
    public List<Account> getAllAccounts() throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin"); 
    	
    	List<Account> list = new ArrayList<>();
        String sql = "select * from account";
        PreparedStatement stmt=conn.prepareStatement(sql); 
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
        	Account account = new Account();
           account.setAccountNo(rs.getString("ACNUMBER")); 
           account.setCustId(rs.getString("CUSTID"));
  		   account.setBranch(rs.getString("BID"));
  		   account.setOpeningBalance(rs.getString("OPENING_BALANCE")); 
  		   account.setAod(rs.getString("AOD"));
  		   account.setAccountType(rs.getString("ATYPE")); 
  		   account.setStatus(rs.getString("ASTATUS"));
  		   account.setLocation(rs.getString("LOC")); 
  		   account.setLoanAccountNo(rs.getString("LOANACNUMBER"));
  		   account.setLoanAmt(rs.getString("LOANAMT")); 
  		   account.setRoi(rs.getString("ROI"));
  		   account.setTenure(rs.getString("TENURE")); 
  		   account.setIfscCd(rs.getString("IFSC"));
  		   
  		 list.add(account);
        }
        
        return list;
        
    }

    // Read a single customer by ID
    public Account getAccountById(String id) throws SQLException, ClassNotFoundException{
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin");  
    	char check= id.charAt(0);
    	String sql="";
    	
    	if(check=='C') {
    	   sql =  "select * from ACCOUNT t where t.custid = ?" ;
    	}else {
    	   sql =  "select * from ACCOUNT t where t.acnumber = ?";
    	}
       
    	PreparedStatement stmt=conn.prepareStatement(sql); 
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        Account account = new Account();
        while(rs.next()) {
        	   account.setAccountNo(rs.getString("ACNUMBER")); 
               account.setCustId(rs.getString("CUSTID"));
    		   account.setBranch(rs.getString("BID"));
    		   account.setOpeningBalance(rs.getString("OPENING_BALANCE")); 
    		   account.setAod(rs.getString("AOD"));
    		   account.setAccountType(rs.getString("ATYPE")); 
    		   account.setStatus(rs.getString("ASTATUS"));
    		   account.setLocation(rs.getString("LOC")); 
    		   account.setLoanAccountNo(rs.getString("LOANACNUMBER"));
    		   account.setLoanAmt(rs.getString("LOANAMT")); 
    		   account.setRoi(rs.getString("ROI"));
    		   account.setTenure(rs.getString("TENURE")); 
    		   account.setIfscCd(rs.getString("IFSC"));
  		}
       return account;
    }

    // Update a customer
    public void updateAccount(Account account) throws SQLException, ClassNotFoundException, ParseException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin"); 
 
    	
        String sql = "UPDATE ACCOUNT SET ACNUMBER=?,CUSTID=?,BID=?,OPENING_BALANCE=?,AOD=to_date(?,'dd/mm/yyyy'),ATYPE=?,ASTATUS=?,LOC=?,LOANACNUMBER=?,LOANAMT=?,ROI=?,TENURE=?,IFSC=? WHERE CUSTID = ?";
        PreparedStatement stmt=conn.prepareStatement(sql);  
        stmt.setString(1,account.getAccountNo());
		stmt.setString(2,account.getCustId());
		stmt.setString(3,account.getBranch());
		stmt.setString(4,account.getOpeningBalance());
		stmt.setString(5,account.getAod());
		stmt.setString(6,account.getAccountType());
		stmt.setString(7,account.getStatus());
		stmt.setString(8,account.getLocation());
		stmt.setString(9,account.getLoanAccountNo());
		stmt.setString(10,account.getLoanAmt());
		stmt.setString(11,account.getRoi());
		stmt.setString(12,account.getTenure());
		stmt.setString(13,account.getIfscCd());
		stmt.setString(14,account.getCustId());
		stmt.executeUpdate();
		
    }

    // Delete a customer
    public void deleteAccount(String id)  throws SQLException, ClassNotFoundException  {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin"); 
    	char check= id.charAt(0);
    	String sql="";
    	if(check=='C') {
     	   sql =  "delete from ACCOUNT t where t.custid = ?" ;
     	}else {
     	   sql =  "delete from ACCOUNT t where t.acnumber = ?";
     	}
        PreparedStatement stmt=conn.prepareStatement(sql);  
		stmt.setString(1,id);
		stmt.executeQuery();
    }

}
