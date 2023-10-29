package com.audit.banking.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.audit.banking.entity.Customer;
import com.audit.banking.entity.Transaction;

@Repository
public class TransactionRepository {
	
	 // Read a single customer by ID
    public List<Transaction> getTransactionById(String id) throws SQLException, ClassNotFoundException{
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin");  
    	char check= id.charAt(0);
    	String sql="";
    	
    	if(check=='C') {
    	   sql =  "select * from trandetails t where t.acnumber in (select p.acnumber from account p where p.custid = ?)" ;
    	}else {
    	   sql =  "select * from trandetails t where t.acnumber = ?";
    	}
       
    	PreparedStatement stmt=conn.prepareStatement(sql); 
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        List<Transaction> list = new ArrayList<>();
        
        while(rs.next()) {
        	Transaction transaction = new Transaction();
        	   transaction.setTransactionNo(rs.getString("TNUMBER"));
               transaction.setAccountNo(rs.getString("ACNUMBER"));
    		   transaction.setDot(rs.getString("DOT"));
    		   transaction.setModeOfTransaction(rs.getString("MEDIUM_OF_TRANSACTION")); 
    		   transaction.setTransactionType(rs.getString("TRANSACTION_TYPE"));
    		   transaction.setAmtOfTransaction(rs.getString("TRANSACTION_AMOUNT")); 
    		   transaction.setBalance(rs.getString("BALANCE"));
    		   list.add(transaction);
    	}
       return list;
    }
    
    
    public void createTransaction(Transaction transaction) throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection conn=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","admin"); 
    	
        String sql = "INSERT INTO trandetails (TNUMBER,ACNUMBER,DOT,MEDIUM_OF_TRANSACTION,TRANSACTION_TYPE,TRANSACTION_AMOUNT,BALANCE)"
        		     +"VALUES (?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?)";
       
        PreparedStatement stmt=conn.prepareStatement(sql);  
		stmt.setString(1,transaction.getTransactionNo());
		stmt.setString(2,transaction.getAccountNo());
		stmt.setString(3,transaction.getDot());
		stmt.setString(4,transaction.getModeOfTransaction());
		stmt.setString(5,transaction.getTransactionType());
		stmt.setString(6,transaction.getAmtOfTransaction());
		stmt.setString(7, transaction.getBalance());
		
		stmt.executeUpdate();
		
		
    }

}
