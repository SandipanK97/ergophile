package com.audit.customer;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.simple.JSONObject;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class LoginThirdAction extends Action {
	
	@Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    	LoginActionFormBean bean = (LoginActionFormBean) form;
    	HttpClient httpClient = HttpClient.newHttpClient();
    	
    	if(request.getParameter("type")!=null && request.getParameter("type").trim().equalsIgnoreCase("GET")) {
    		 HttpRequest req = HttpRequest.newBuilder()
    	                .uri(URI.create("http://localhost:9000/api/transactions/"+request.getParameter("id")))
    	                .build();

    	    HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
    	    response.setContentType("application/json");
            response.getWriter().write(res.body());
            return null;
    	}
    	
    	if(request.getParameter("type")!=null && request.getParameter("type").trim().equalsIgnoreCase("POST")) {
    		JSONObject data = new JSONObject();
    		data.put("modeOfTransaction", request.getParameter("modeOfTransaction"));
    		data.put("amtOfTransaction", request.getParameter("amtOfTransaction"));
    		data.put("transactionType", request.getParameter("transactionType"));
    		data.put("dot", request.getParameter("dot"));
    		data.put("transactionNo", request.getParameter("transactionNo"));
    		data.put("balance", request.getParameter("balance"));
    		data.put("accountNo", request.getParameter("accountNo"));
    		
    		
            String jsonStringPost = data.toJSONString();
    		HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:9000/api/transactions"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonStringPost))
                    .build();

            HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            response.setContentType("application/json");
            response.getWriter().write(res.body());
            return null;
    	}
    	if(request.getParameter("type")!=null && request.getParameter("type").trim().equalsIgnoreCase("STATEMENT")) {
    		 try {
            	Font catFont = new Font(Font.FontFamily.COURIER, 21,
			            Font.BOLD,BaseColor.LIGHT_GRAY);
			    Font redFont = new Font(Font.FontFamily.COURIER, 10,
			            Font.BOLD, BaseColor.RED);
			    Font subFont = new Font(Font.FontFamily.COURIER, 16,
			            Font.NORMAL);
			    Font smallBold = new Font(Font.FontFamily.COURIER, 11,
			            Font.BOLD);
			Document document = new Document();
			OutputStream out = response.getOutputStream();
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(new Paragraph("Ergophile",catFont));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Application submitted successfully!",subFont));
			document.add(new Paragraph("Generated application ID : " ,smallBold));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Hi , you will be informed via your registered email id and phone number for future updates.",redFont));
			document.close();
			out.flush();
			out.close();
			
            } catch (Exception e) {
                e.printStackTrace();
            }
    		return mapping.findForward("success");
    	}
          
          return mapping.findForward("success");
      }
	
	 
}
