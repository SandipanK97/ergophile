package com.audit.customer.dataAnalytics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AnalyticsAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (request.getParameter("bancassurance") != null && request.getParameter("bancassurance").trim().equals("view")) {
            BarChartExample example = new BarChartExample("Bar Chart Window");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setVisible(true);
        }
        if (request.getParameter("account") != null && request.getParameter("account").trim().equals("view")) {
            LineChartExample example = new LineChartExample("Line Chart Example");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setVisible(true);
        }
        if (request.getParameter("npa") != null && request.getParameter("npa").trim().equals("view")) {
            PieChartExample example = new PieChartExample("Pie Chart Example");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setVisible(true);
        }
        if (request.getParameter("profit") != null && request.getParameter("profit").trim().equals("view")) {
            LineChartExample example = new LineChartExample("Line Chart Example");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setVisible(true);
        }

        return mapping.findForward("success");
    }
}
