package com.bgy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = (String) req.getSession().getAttribute("code");
        String inputCode = req.getParameter("code");
        if (code.toLowerCase().equals(inputCode.toLowerCase())) {
            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/fail.jsp").forward(req, resp);
        }
    }

}
