package ch07.ex01;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;
//    String url = "jdbc:mysql://localhost:3306/javaDB";

    private void connDB() {


        try {

            Context envContext = (Context) new InitialContext().lookup("java:/comp/env");
            dataFactory= (DataSource) envContext.lookup("jdbc/mysql");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

        public List listMember() {
        ArrayList<MemberVO> list = new ArrayList<>();
        try {
            connDB();
            con = dataFactory.getConnection();
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
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return list;
    }
}
