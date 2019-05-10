package utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 防止xss攻击 过滤器（顺便过滤了 sql攻击）
 */
public class XSSFilter implements Filter {
	
	@Override
    public void init(FilterConfig arg0) throws ServletException {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
 
        chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
 
    }


}
