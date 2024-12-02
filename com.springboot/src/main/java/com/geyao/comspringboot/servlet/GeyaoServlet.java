package com.geyao.comspringboot.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GeyaoServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("我进来了get");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("我进来了post");
    }
}
