package com.svastrad.adEnhancer.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class HttpForbiddenStatusAuthenticationEntryPoint implements AuthenticationEntryPoint
{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException
    {
        response.setStatus(HttpURLConnection.HTTP_FORBIDDEN);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("{\"message\":\"This ip is forbidden\"}");
    }

}
