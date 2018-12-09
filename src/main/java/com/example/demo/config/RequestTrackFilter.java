package com.example.demo.config;

import com.example.demo.entities.BrowserStats;
import com.example.demo.repositories.BrowserRepo;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class RequestTrackFilter implements Filter {

    @Autowired
    BrowserRepo browserrepo;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String header = servletRequest.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);

        Browser browserRep = userAgent.getBrowser();
        String browserName = browserRep.getName();

        String os = userAgent.getOperatingSystem().getName();

        String URI = servletRequest.getRequestURI();



        BrowserStats browserInfo = new BrowserStats(browserName, os, URI);
        browserrepo.save(browserInfo);


    }

    @Override
    public void destroy() {}
}
