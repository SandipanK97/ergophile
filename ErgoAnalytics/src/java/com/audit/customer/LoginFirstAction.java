package com.audit.customer;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
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
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        FormBean bean = (FormBean) form;
        ActionErrors errors = new ActionErrors();
        Properties properties = new Properties();
        Map<String, String> credential = new HashMap<>();
        
        String filePath = "C:\\Project\\ergophile/file.properties";

        FileInputStream fileInputStream = new FileInputStream(filePath); 

            properties.load(fileInputStream);

            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            credential.put(username, password);

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");

            session.setAttribute("db_credential", credential);
            session.setAttribute("db_connection", conn);

        

        if (request.getParameter("submit") != null && request.getParameter("submit").trim().equalsIgnoreCase("Login")) {

            String qry = "select count(1) from USER_LOGIN t where t.user_id=? and t.user_password=? and t.user_status='A'";
            Connection con = (Connection) session.getAttribute("db_connection");
            PreparedStatement p = con.prepareStatement(qry);
            p.setString(1, request.getParameter("username"));
            p.setString(2, request.getParameter("password"));
            ResultSet rs = p.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count == 0) {
                errors.add("login", new ActionMessage("invalid user credential"));
                saveErrors(request, errors);
                return mapping.getInputForward();
            }
        }
        return mapping.findForward("success");
    }

}
