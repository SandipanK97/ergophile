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
public class AccountDtlsAction extends Action {

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
                String qry = "SELECT * FROM ACC_DTLS WHERE cust_id=? OR accountNo = ?";
                PreparedStatement p = con.prepareStatement(qry);
                p.setLong(1, Long.parseLong(request.getParameter("id")));
                p.setString(2, request.getParameter("id"));
                ResultSet rs = p.executeQuery();
                while (rs.next()) {
                    bean.setCustId(rs.getString("cust_id"));
                    bean.setAccountNo(rs.getString("accountNo"));
                    bean.setIfscCd(rs.getString("ifscCd"));
                    bean.setBranch(rs.getString("branch"));
                    bean.setLocation(rs.getString("location"));
                    bean.setAccountType(rs.getString("accountType"));
                    bean.setStatus(rs.getString("status"));
                    bean.setAod(sdf.format(rs.getDate("aod")));
                    bean.setOpeningBalance(rs.getString("openingBalance"));
                    bean.setLoanAccountNo(rs.getString("loanAccountNo"));
                    bean.setLoanAmt(rs.getString("loanAmt"));
                    bean.setRoi(rs.getString("roi"));
                    bean.setTenure(rs.getString("tenure"));
                }
            }

            if (request.getParameter("updateById") != null) {
                String updateQuery = "UPDATE ACC_DTLS SET  ifscCd=?, branch=?, location=?, accountType=?, status=?, aod=?, openingBalance=?, loanAccountNo=?, loanAmt=?, roi=?, tenure=? WHERE cust_id=?";
                PreparedStatement p = con.prepareStatement(updateQuery);
               
                p.setString(1, bean.getIfscCd());
                p.setString(2, bean.getBranch());
                p.setString(3, bean.getLocation());
                p.setString(4, bean.getAccountType());
                p.setString(5, bean.getStatus());
                java.util.Date utilDate = sdf.parse(bean.getAod());
                Date sqlDate = new Date(utilDate.getTime());
                p.setDate(6, sqlDate);
                p.setDouble(7, Double.parseDouble(bean.getOpeningBalance()));
                p.setString(8, bean.getLoanAccountNo());
                p.setDouble(9, Double.parseDouble(bean.getLoanAmt()));
                p.setDouble(10, Double.parseDouble(bean.getRoi()));
                p.setInt(11, Integer.parseInt(bean.getTenure()));
                p.setInt(12, Integer.parseInt(request.getParameter("updateById")));
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
