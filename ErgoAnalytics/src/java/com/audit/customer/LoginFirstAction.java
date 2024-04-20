package com.audit.customer;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginFirstAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        try{
        HttpSession session = request.getSession(true);
        FormBean bean = (FormBean) form;
        ActionErrors errors = new ActionErrors();
        Properties properties = new Properties();
        
        
        String filePath = "C:\\Project\\ergophile/file.properties";

        FileInputStream fileInputStream = new FileInputStream(filePath); 

            properties.load(fileInputStream);

            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            String connectstr = properties.getProperty("db.connectstr");
            
            
            Class.forName("org.postgresql.Driver");  
            Connection conn = DriverManager.getConnection(connectstr,username,password);

            session.setAttribute("user", request.getParameter("username"));
            session.setAttribute("db_connection", conn);
            
            if(conn==null){
                errors.add("error.generic",new ActionMessage("error.generic","database connection failed"));
                saveErrors(request, errors);
                return mapping.getInputForward();
            }
        

        if (request.getParameter("submit") != null && request.getParameter("submit").trim().equalsIgnoreCase("Login")) {
            
            String qry = "select count(1) from USER_LOGIN t where t.username=? and t.password_hash=? and t.user_status='A'";
            Connection con = (Connection) session.getAttribute("db_connection");
            PreparedStatement p = con.prepareStatement(qry);
            p.setString(1, request.getParameter("username"));
            p.setString(2, request.getParameter("password"));
            ResultSet rs = p.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count == 0) {
                errors.add("error.generic", new ActionMessage("error.generic","Invalid user credential"));
                saveErrors(request, errors);
                return mapping.getInputForward();
            }
        }
        
        
        }catch(Exception e){
            e.printStackTrace();
       }
        return mapping.findForward("success");
    }

}
