package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            req.getRequestDispatcher("/add.jsp").forward(req,res);
        } catch (Exception ignored){}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        try {
            User user = new User(req.getParameter("firstName"), req.getParameter("secondName"));
            Warehouse.getInstance().addUser(user);
            req.setAttribute("add", user);
            res.sendRedirect("/add");
        } catch (Exception ignored){}
    }
}