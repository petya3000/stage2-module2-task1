package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        try {
            Set<User> users = Warehouse.getInstance().getUsers();
            req.setAttribute("users", users);
            res.sendRedirect("/users");
        } catch (Exception ignored){}
    }
}