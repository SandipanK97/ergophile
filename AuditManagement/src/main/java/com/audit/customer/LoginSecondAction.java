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






public class LoginSecondAction extends Action {
	
	@Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    	LoginActionFormBean bean = (LoginActionFormBean) form;
    	HttpClient httpClient = HttpClient.newHttpClient();
    	
    	if(request.getParameter("type")!=null && request.getParameter("type").trim().equalsIgnoreCase("GET")) {
    		 HttpRequest req = HttpRequest.newBuilder()
    	                .uri(URI.create("http://localhost:9000/api/accounts/"+request.getParameter("id")))
    	                .build();

    	    HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
    	    response.setContentType("application/json");
            response.getWriter().write(res.body());
            return null;
    	}
    	
    	if(request.getParameter("type")!=null && request.getParameter("type").trim().equalsIgnoreCase("POST")) {
    		JSONObject data = new JSONObject();
    		data.put("accountNo", request.getParameter("accountNo"));
    		data.put("ifscCd", request.getParameter("ifscCd"));
    		data.put("branch", request.getParameter("branch"));
    		data.put("location", request.getParameter("location"));
    		data.put("accountType", request.getParameter("accountType"));
    		data.put("status", request.getParameter("status"));
    		data.put("aod", request.getParameter("aod"));
    		data.put("openingBalance", request.getParameter("openingBalance"));
    		data.put("loanAccountNo", request.getParameter("loanAccountNo"));
    		data.put("loanAmt", request.getParameter("loanAmt"));
    		data.put("roi", request.getParameter("roi"));
    		data.put("tenure", request.getParameter("tenure"));
    		data.put("custId", request.getParameter("custId"));
    		
    		
            String jsonStringPost = data.toJSONString();
    		HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:9000/api/accounts"))
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
    		data.put("accountNo", request.getParameter("accountNo"));
    		data.put("ifscCd", request.getParameter("ifscCd"));
    		data.put("branch", request.getParameter("branch"));
    		data.put("location", request.getParameter("location"));
    		data.put("accountType", request.getParameter("accountType"));
    		data.put("status", request.getParameter("status"));
    		data.put("aod", request.getParameter("aod"));
    		data.put("openingBalance", request.getParameter("openingBalance"));
    		data.put("loanAccountNo", request.getParameter("loanAccountNo"));
    		data.put("loanAmt", request.getParameter("loanAmt"));
    		data.put("roi", request.getParameter("roi"));
    		data.put("tenure", request.getParameter("tenure"));
    		data.put("custId", request.getParameter("custId"));
    		
            String jsonString = data.toJSONString();
            
    		HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:9000/api/accounts/"+request.getParameter("id")))
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
                    .uri(URI.create("http://localhost:9000/api/accounts/"+request.getParameter("id")))
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
