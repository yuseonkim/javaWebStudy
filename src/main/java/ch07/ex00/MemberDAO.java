package ch07.ex00;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    Connection con;
    Statement st;
    PreparedStatement pstmt;
    String url = "jdbc:mysql://localhost:3306/javaDB";

    private void connDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("mysql 드라이버 로딩 성공");
            con = DriverManager.getConnection(url, "root", "0143");
            System.out.println("Connection 성공");
            st = con.createStatement();
            System.out.println("Statement 생성 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public List listMember() {
        ArrayList<MemberVO> list = new ArrayList<>();
        try {
            connDB();
            String sql = "select * from t_member";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String pw = rs.getString("pw");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPw(pw);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);
                list.add(vo);
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return list;
    }
}
