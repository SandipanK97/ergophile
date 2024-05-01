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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

                String qry = "SELECT * FROM TRAN_DTLS WHERE accountNo=? OR cust_id =? order by updateno desc LIMIT 1";
                PreparedStatement p = con.prepareStatement(qry);
                p.setString(1, request.getParameter("id"));
                p.setLong(2, Long.parseLong(request.getParameter("id")));
                ResultSet rs = p.executeQuery();
                List<FormBean> resultList = new ArrayList<>();
                while (rs.next()) {
                    bean.setAccountNo(rs.getString("accountNo"));
                    bean.setMot(rs.getString("modeOfTransaction"));
                    bean.setAmt(rs.getString("amtOfTransaction"));
                    bean.setCrdbt(rs.getString("transactionType"));
                    bean.setTransDate(sdf.format(rs.getDate("dot")));
                    bean.setTransNo(rs.getString("transactionNo"));
                    bean.setBalance(rs.getString("balance"));
                    bean.setCustId(rs.getString("cust_id"));
                    bean.setUpdateNo(rs.getInt("updateno"));
                    resultList.add(bean);
                }
                bean.setList(resultList);
            }

            if (request.getParameter("updateById") != null) {

                String updateQuery = "INSERT INTO TRAN_DTLS (modeOfTransaction, amtOfTransaction, transactionType, dot, transactionNo, balance,cust_id,accountno) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement p = con.prepareStatement(updateQuery);
                p.setString(1, bean.getModeOfTransaction());
                p.setDouble(2, Double.parseDouble(bean.getAmtOfTransaction()));
                p.setString(3, bean.getTransactionType());
                java.util.Date utilDate = sdf.parse(bean.getDot());
                Date sqlDate = new Date(utilDate.getTime());
                p.setDate(4, sqlDate);
                int randomNumber = new Random().nextInt(9000) + 1000;
                p.setString(5, "ERG".concat(String.valueOf(randomNumber)));

                String qr = "select balance from TRAN_DTLS WHERE cust_id =? order by updateno desc limit 1";
                PreparedStatement ps = con.prepareStatement(qr);
                ps.setInt(1, Integer.parseInt(request.getParameter("updateById")));
                ResultSet rst = ps.executeQuery();
                while (rst.next()) {
                    bean.setCurrBalance(rst.getDouble("balance"));
                }

                Double remainingAmt = 0.0;
                if (bean.getTransactionType().equalsIgnoreCase("CREDIT")) {
                    remainingAmt = bean.getCurrBalance() + Double.parseDouble(bean.getAmtOfTransaction());
                } else {
                    if (bean.getCurrBalance() == 0.0) {
                        errors.add("error.generic", new ActionMessage("error.generic", "Transaction Failed! Balance :0"));
                        saveErrors(request, errors);
                        return mapping.findForward("success");
                    } else {
                        remainingAmt = bean.getCurrBalance() - Double.parseDouble(bean.getAmtOfTransaction());
                    }
                }

                p.setDouble(6, remainingAmt);
                p.setInt(7, Integer.parseInt(request.getParameter("updateById")));
                p.setString(8, request.getParameter("acc"));
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
            bean.setModeOfTransaction("");
            bean.setAmtOfTransaction("");
            bean.setTransactionType("");
            bean.setDot("");

        } catch (SQLException ex) {
            con.rollback();
            ex.printStackTrace();

        }
        return mapping.findForward("success");
    }
}
