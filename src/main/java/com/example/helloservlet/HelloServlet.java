package com.example.helloservlet;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("init method");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("method doGet");
        resp.getWriter().write("<html>" +
                "<head></head>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='one' />" +
                "<input type='text' name='two' />" +
                "<button type='submit'>submit</button>" +
                "</form>" +
                "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("method doPost");
        resp.getWriter().write("data received");
        String oneData = req.getParameter("one");
        String twoData = req.getParameter("two");
        System.out.println(oneData + ", " + twoData);
    }

    public void destroy() {
        System.out.println("destroy method");
    }
}