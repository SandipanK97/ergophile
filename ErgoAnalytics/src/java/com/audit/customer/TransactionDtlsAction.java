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
public class TransactionDtlsAction extends Action {

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
                String qry = "SELECT * FROM TRAN_DTLS WHERE accountNo=? OR cust_id =?";
                PreparedStatement p = con.prepareStatement(qry);
                p.setString(1, request.getParameter("id"));
                p.setLong(2, Long.parseLong(request.getParameter("id")));
                ResultSet rs = p.executeQuery();
                while (rs.next()) {
                    bean.setAccountNo(rs.getString("accountNo"));
                    bean.setModeOfTransaction(rs.getString("modeOfTransaction"));
                    bean.setAmtOfTransaction(rs.getString("amtOfTransaction"));
                    bean.setTransactionType(rs.getString("transactionType"));
                    bean.setDot(sdf.format(rs.getDate("dot")));
                    bean.setTransactionNo(rs.getString("transactionNo"));
                    bean.setBalance(rs.getString("balance"));
                    bean.setCustId(rs.getString("cust_id"));
                }
            }

            if (request.getParameter("updateById") != null) {
                String updateQuery = "UPDATE TRAN_DTLS SET modeOfTransaction=?, amtOfTransaction=?, transactionType=?, dot=?, transactionNo=?, balance=? WHERE accountNo=?";
                PreparedStatement p = con.prepareStatement(updateQuery);
                p.setString(1, bean.getModeOfTransaction());
                p.setDouble(2, Double.parseDouble(bean.getAmtOfTransaction()));
                p.setString(3, bean.getTransactionType());
                java.util.Date utilDate = sdf.parse(bean.getDot());
                Date sqlDate = new Date(utilDate.getTime());
                p.setDate(4, sqlDate);
                p.setString(5, bean.getTransactionNo());
                p.setDouble(6, Double.parseDouble(bean.getBalance()));
                p.setString(7, request.getParameter("updateById"));
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
            ex.printStackTrace();

        }
        return mapping.findForward("success");
    }
}
