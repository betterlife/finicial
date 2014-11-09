package io.betterlife.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Lawrence Liu(lawrence@betterlife.io)
 * Date: 11/9/14
 * This is a filter to forward request to correct AngularJS way.
 * Eg: forward /dashboard to /#dashboard to avoid application server 404 error.
 */
public class IndexFilter implements Filter {

    private static final Log logger = LogFactory.getLog(IndexFilter.class.getName());
    private static final Map<String, String> redirectCache = new HashMap<>(16);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Init index filter...");
        if (logger.isTraceEnabled()){
            logger.trace("Filter Name: " + filterConfig.getFilterName());
            logger.trace("Filter Servlet Context" + filterConfig.getServletContext());
            Enumeration<String> initParams = filterConfig.getInitParameterNames();
            while (initParams.hasMoreElements()){
                String param = initParams.nextElement();
                logger.trace(String.format("\tParam: %s, Value: %s", param, filterConfig.getInitParameter(param)));
            }
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String pathInfo =  request.getPathInfo();
        if (logger.isDebugEnabled()) {
            logger.debug("Request path info: " + pathInfo);
        }
        String redirectResult = redirectCache.get(pathInfo);
        if (null == redirectResult) {
            if (pathInfo.startsWith("/")) {
                redirectResult = "/#" + pathInfo.substring(1, pathInfo.length());
                redirectCache.put(pathInfo, redirectResult);
            }
        }
        response.sendRedirect(redirectResult);
    }

    @Override
    public void destroy() {

    }
}
