package com.example.thedemotest.thedemotest;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

public class DMDCAuthFilter extends RequestHeaderAuthenticationFilter {

    public DMDCAuthFilter() {
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
    	System.out.println("HIT PREAUTH");
    	String returnHeader = "";
    		if(request.getHeader("test1") != null && !request.getHeader("test1").trim().equals("")) {
    			System.out.println("TEST1");
    			returnHeader = request.getHeader("test1");
    		}
    		if(request.getHeader("test2") != null && !request.getHeader("test2").trim().equals("")) {
    			System.out.println("TEST2");
    			returnHeader = request.getHeader("test2");
    		}
        return returnHeader;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }

}