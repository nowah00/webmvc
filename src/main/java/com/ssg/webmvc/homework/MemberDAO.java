package com.ssg.webmvc.homework;

import java.sql.*;

public class MemberDAO {
    private Statement stmt;
    private PreparedStatement pstmt;
    private Connection conn;

    private void connDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/memberInfo_DB?serverTimezone=Asia/Seoul&characterEncoding=UTF-8",
                    "root",
                    "mysql1234"
            );
            System.out.println("Connection 생성 성공");

            stmt = conn.createStatement();
            System.out.println("Statement 생성 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addMember(MemberVO member) throws SQLException {
        System.out.println("[MemberDAO - addMember ok]");
        try {
            connDB();
            String sql = "INSERT INTO memberInfo (id, password, gender, hobby) VALUES (?, ?, ?, ?);";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUser_id());
            pstmt.setString(2, member.getUser_pwd());
            pstmt.setString(3, member.getGender());
            pstmt.setString(4, member.getHobby());
            return pstmt.executeUpdate();
        } finally{
            if (pstmt!=null) pstmt.close();
            if (conn != null) conn.close();
        }
    }


}
