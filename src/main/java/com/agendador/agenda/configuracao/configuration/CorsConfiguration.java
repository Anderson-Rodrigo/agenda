package com.agendador.agenda.configuracao.configuration;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfiguration implements Filter {

    private static final String ALLOW_ORIGIN = "*";
    private static final String ALLOW_METHODS = "PATCH, POST, PUT, GET, OPTIONS, DELETE, HEAD";
    private static final String MAX_AGE = "3600";
    private static final String ALLOW_HEADERS = "X-Requested-With, Content-Type, Accept, Origin, Authorization, Credential, X-XSRF-Token, Access-Control-Request-Method, Access-Control-Request-Headers";
    private static final String EXPOSE_HEADERS = "Location, Access-Control-Allow-Origin, Access-Control-Allow-Credentials";
    private static final String OPTIONS = "OPTIONS";

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        response.setHeader("Access-Control-Allow-Origin", ALLOW_ORIGIN);
        response.setHeader("Access-Control-Allow-Methods", ALLOW_METHODS);
        response.setHeader("Access-Control-Max-Age", MAX_AGE);
        response.setHeader("Access-Control-Allow-Headers", ALLOW_HEADERS);
        response.setHeader("Access-Control-Expose-Headers", EXPOSE_HEADERS);

        if (request.getMethod().equalsIgnoreCase(OPTIONS)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

}
