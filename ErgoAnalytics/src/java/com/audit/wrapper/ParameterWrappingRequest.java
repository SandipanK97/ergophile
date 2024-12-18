/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.audit.wrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ParameterWrappingRequest extends HttpServletRequestWrapper {
    private final Map<String, String[]> customParams;

    public ParameterWrappingRequest(HttpServletRequest request, Map<String, String[]> params) {
        super(request);
        this.customParams = new HashMap<>(params);
    }

    @Override
    public String getParameter(String name) {
        String[] values = customParams.get(name);
        return (values != null && values.length > 0) ? values[0] : super.getParameter(name);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(customParams.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return customParams.containsKey("name") ? customParams.get("name") : super.getParameterValues(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> allParams = new HashMap<>(super.getParameterMap());
        allParams.putAll(customParams);
        return allParams;
    }
}
