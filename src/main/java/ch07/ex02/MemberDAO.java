package ch07.ex02;

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

    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/mysql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    String url = "jdbc:mysql://localhost:3306/javaDB";


    public ArrayList<MemberVO> listMember() {
        ArrayList<MemberVO> list = new ArrayList<>();
        try {
            con = dataFactory.getConnection();
            String sql = "select * from t_member";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
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

    public void addMember(MemberVO memberVo) {
        try {
            Connection con = dataFactory.getConnection();
            String id = memberVo.getId();
            String pw = memberVo.getPw();
            String name = memberVo.getName();
            String email = memberVo.getEmail();

            String sql = "insert into t_member";
            sql += " (id,pw,name,email)";
            sql += " values(?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,pw);
            pstmt.setString(3,name);
            pstmt.setString(4,email);
            pstmt.executeUpdate();
            pstmt.close();

        }catch(Exception e){
            e.printStackTrace();
        }


    }
    public void delMember(String id){
        try{
            Connection con = dataFactory.getConnection();
            String sql = "delete from t_member"+ " where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.executeUpdate();
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
}
