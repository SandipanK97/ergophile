/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.audit.customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author User
 */
public class CustomerDtlsAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws SQLException, ParseException {
        FormBean bean = (FormBean) form;
        ActionErrors errors = new ActionErrors();
        HttpSession session = request.getSession(true);
        Connection con = (Connection) session.getAttribute("db_connection");
        con.setAutoCommit(false);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {

            if (request.getParameter("id") != null) {
                String qry = "SELECT * FROM CUST_DTLS WHERE cust_id=?";
                PreparedStatement p = con.prepareStatement(qry);
                p.setInt(1, Integer.parseInt(request.getParameter("id")));
                ResultSet rs = p.executeQuery();
                while (rs.next()) {
                    bean.setCustId(rs.getString("cust_id"));
                    bean.setName(rs.getString("name"));
                    bean.setFname(rs.getString("fname"));
                    bean.setMname(rs.getString("mname"));
                    bean.setLname(rs.getString("lname"));
                    bean.setDob(sdf.format(rs.getDate("dob")));
                    bean.setMobileNo(rs.getString("mobileNo"));
                    bean.setOccupation(rs.getString("occupation"));
                    bean.setCity(rs.getString("city"));
                    bean.setState(rs.getString("state"));
                    bean.setAddressPin(rs.getString("addressPin"));
                    bean.setAadharNo(rs.getString("aadharNo"));
                    bean.setPanNo(rs.getString("panNo"));
                    bean.setIsEkycDone(rs.getString("isEkycDone"));
                    bean.setPassportNo(rs.getString("passportNo"));
                }

            }
            if (request.getParameter("updateById") != null) {
                String updateQuery = "UPDATE CUST_DTLS SET name=?, fname=?, mname=?, lname=?, dob=?, mobileNo=?, occupation=?, city=?, state=?, addressPin=?, aadharNo=?, panNo=?, isEkycDone=?, passportNo=? WHERE cust_id=?";
                PreparedStatement p = con.prepareStatement(updateQuery);
                p.setString(1, bean.getName());
                p.setString(2, bean.getFname());
                p.setString(3, bean.getMname());
                p.setString(4, bean.getLname());
                java.util.Date utilDate = sdf.parse(bean.getDob());
                Date sqlDate = new Date(utilDate.getTime());
                p.setDate(5, sqlDate);
                p.setString(6, bean.getMobileNo());
                p.setString(7, bean.getOccupation());
                p.setString(8, bean.getCity());
                p.setString(9, bean.getState());
                p.setString(10, bean.getAddressPin());
                p.setString(11, bean.getAadharNo());
                p.setString(12, bean.getPanNo());
                p.setString(13, bean.getIsEkycDone());
                p.setString(14, bean.getPassportNo());
                p.setInt(15, Integer.parseInt(request.getParameter("updateById")));
                int row = p.executeUpdate();

                if (row > 0) {
                    errors.add("error.generic", new ActionMessage("error.generic", "Successfully Updated"));
                    saveErrors(request, errors);
                } else {
                    errors.add("error.generic", new ActionMessage("error.generic", "Updation Failed"));
                    saveErrors(request, errors);
                }

            }
            con.commit();
        } catch (SQLException ex) {
            con.rollback();
            Logger.getLogger(CustomerDtlsAction.class.getName()).log(Level.SEVERE, null, ex);

        }
        return mapping.findForward("success");
    }
}
