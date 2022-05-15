package com.web.demo.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/demo/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url = ((HttpServletRequest)req).getRequestURL().toString();
        HttpSession session = req.getSession(false);
        if (url.contains("verify.jsp") || (session != null && session.getAttribute("investor") != null)) {
            chain.doFilter(req, res);
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, res);
    }

}
