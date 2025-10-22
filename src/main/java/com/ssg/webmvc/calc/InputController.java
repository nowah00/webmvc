package com.ssg.webmvc.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "inputController", urlPatterns = "/calc/input")
public class InputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("inputController 요청된 doGet()");

        // 내가 원하는 위치로 이동 -> "calc/input.jsp"
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/calc/input.jsp");

        // 톰캣으로부터 받은 request, response 를 가지고 다른 페이지("calc/input.jsp")로 이동
        dispatcher.forward(request, response); // -> 서블릿에서 전달된 요청을 다른쪽으로 전달 또는 배포하는 역할 객체
    }
}
