package com.audit.customer;
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






public class LoginFirstAction extends Action {
	
	@Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    	LoginActionFormBean bean = (LoginActionFormBean) form;
    	HttpClient httpClient = HttpClient.newHttpClient();
    	if(request.getParameter("type")!=null && request.getParameter("type").trim().equalsIgnoreCase("LOGOUT")) {
    		response.sendRedirect("../AuditManagement");
    		return null;
    	}
    	if(request.getParameter("type")!=null && request.getParameter("type").trim().equalsIgnoreCase("GET")) {
    		 HttpRequest req = HttpRequest.newBuilder()
    	                .uri(URI.create("http://localhost:9000/api/customers/"+request.getParameter("id")))
    	                .build();

    	    HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
    	    response.setContentType("application/json");
            response.getWriter().write(res.body());
            return null;
    	}
    	
    	if(request.getParameter("type")!=null && request.getParameter("type").trim().equalsIgnoreCase("POST")) {
    		JSONObject data = new JSONObject();
    		data.put("custId", request.getParameter("custId"));
    		data.put("name", request.getParameter("name"));
    		data.put("fname", request.getParameter("fname"));
    		data.put("mname", request.getParameter("mname"));
    		data.put("lname", request.getParameter("lname"));
    		data.put("dob", request.getParameter("dob"));
    		data.put("mobileNo", request.getParameter("mobileNo"));
    		data.put("occupation", request.getParameter("occupation"));
    		data.put("city", request.getParameter("city"));
    		data.put("state", request.getParameter("state"));
    		data.put("addressPin", request.getParameter("addressPin"));
    		data.put("aadharNo", request.getParameter("aadharNo"));
    		data.put("panNo", request.getParameter("panNo"));
    		data.put("isEkycDone", request.getParameter("isEkycDone"));
    		data.put("passportNo", request.getParameter("passportNo"));
    		
            String jsonStringPost = data.toJSONString();
    		HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:9000/api/customers"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonStringPost))
                    .build();

            HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            response.setContentType("application/json");
            response.getWriter().write(res.body());
            return null;
    	}
    	
    	if(request.getParameter("type")!=null && request.getParameter("type").trim().equalsIgnoreCase("PUT")) {
    		JSONObject data = new JSONObject();
    		data.put("custId", request.getParameter("custId"));
    		data.put("name", request.getParameter("name"));
    		data.put("fname", request.getParameter("fname"));
    		data.put("mname", request.getParameter("mname"));
    		data.put("lname", request.getParameter("lname"));
    		data.put("dob", request.getParameter("dob"));
    		data.put("mobileNo", request.getParameter("mobileNo"));
    		data.put("occupation", request.getParameter("occupation"));
    		data.put("city", request.getParameter("city"));
    		data.put("state", request.getParameter("state"));
    		data.put("addressPin", request.getParameter("addressPin"));
    		data.put("aadharNo", request.getParameter("aadharNo"));
    		data.put("panNo", request.getParameter("panNo"));
    		data.put("isEkycDone", request.getParameter("isEkycDone"));
    		data.put("passportNo", request.getParameter("passportNo"));
    		
            String jsonString = data.toJSONString();
            
    		HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:9000/api/customers/"+request.getParameter("id")))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();

            HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            response.setContentType("application/json");
            response.getWriter().write(res.body());
            return null;
    	}
    	
    	if(request.getParameter("type")!=null && request.getParameter("type").trim().equalsIgnoreCase("DELETE")) {
    		HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:9000/api/customers/"+request.getParameter("id")))
                    .DELETE()
                    .build();

            HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            response.setContentType("text");
            response.getWriter().write(res.statusCode());
            return null;
    	}
          
          return mapping.findForward("success");
      }
	
	 
}
