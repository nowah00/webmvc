package com.ssg.webmvc.homework;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet("/homework/memberRegister")
public class MemberRegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("[MemberRegisterController - doPost OK]");
        doHandle(req, resp);
    }

    public void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("[MemberRegisterController - doHandle OK]");
        MemberVO member = new MemberVO();
        MemberDAO memberDAO = new MemberDAO();

        request.setCharacterEncoding("UTF-8");
        member.setUser_id(request.getParameter("user_id"));
        member.setUser_pwd(request.getParameter("user_pwd"));
        member.setGender(request.getParameter("gender"));

        String[] hobby = request.getParameterValues("hobby");
        String hobbies = " ";
        for (int i = 0; i < hobby.length; i++) {
            hobbies += hobby[i] + " ";
        }
        member.setHobby(hobbies);

        System.out.println(member.getUser_id());
        System.out.println(member.getUser_pwd());
        System.out.println(member.getGender());
        System.out.println(Arrays.toString(request.getParameterValues("hobby")));

        try {
            int pass = memberDAO.addMember(member);
            if(pass==1){
                request.setAttribute("success", "회원가입 성공!");
            } else {
                request.setAttribute("success", "회원가입 실패..");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/homework/result.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

