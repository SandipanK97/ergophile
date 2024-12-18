/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.audit.wrapper;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParameterHidingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse && !((HttpServletRequest)request).getMethod().equalsIgnoreCase("POST")) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            String queryString = httpRequest.getQueryString();

            // Check if query string exists
            if (queryString != null && !queryString.isEmpty()) {
                // Parse query string into a parameter map
                Map<String, String[]> parameterMap = new HashMap<>();
                for (String param : queryString.split("&")) {
                    String[] keyValue = param.split("=");
                    String key = keyValue[0];
                    String value = (keyValue.length > 1) ? keyValue[1] : "";
                    parameterMap.put(key, new String[]{value});
                }

                // Store parameters in session and redirect to clean URL
                httpRequest.getSession().setAttribute("maskedParams", parameterMap);
                String cleanUri = httpRequest.getRequestURI();
                httpResponse.sendRedirect(cleanUri);
                return;
            }

            // Retrieve parameters from session if available
            Map<String, String[]> storedParams = (Map<String, String[]>) httpRequest.getSession().getAttribute("maskedParams");
            if (storedParams != null) {
                httpRequest.getSession().removeAttribute("maskedParams"); // Clear after retrieval
                ParameterWrappingRequest wrappedRequest = new ParameterWrappingRequest(httpRequest, storedParams);
                chain.doFilter(wrappedRequest, response);
                return;
            }
        }

        // Proceed with the original request if no masking is needed
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
