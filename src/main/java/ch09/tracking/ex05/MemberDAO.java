package ch09.tracking.ex05;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public MemberDAO(){
        try{
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/mysql");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List listMember(MemberVO memberVO){
        List membersList = new ArrayList();
        String _name = memberVO.getName();
        try{
            con = dataFactory.getConnection();
            String query = "select * from t_member";
            if((_name != null && _name.length() != 0)){
                query +=" where name=?";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1,_name);
            }else{
                pstmt = con.prepareStatement(query);
            }
            System.out.println("preparedStatement : " + query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String pwd=  rs.getString("pw");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate =rs.getDate("joinDate");
                MemberVO vo = new MemberVO(id,pwd,name,email,joinDate);
                membersList.add(vo);
            }
            rs.close();
            pstmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return membersList;
    }
    public List listMember(){
        List list = new ArrayList();
        try{
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
                MemberVO memberVO = new MemberVO(id,pw,name,email,joinDate);
               list.add(memberVO);
            }

            rs.close();
            pstmt.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void addMember(MemberVO memberVO){
        try{
            Connection con = dataFactory.getConnection();
            String id = memberVO.getId();
            String pw = memberVO.getPw();
            String name = memberVO.getName();
            String email = memberVO.getEmail();

            String sql = "insert into t_member";
            sql += "(id,pw,name,email)";
            sql += "values(?,?,?,?)";

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
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean isExisted(MemberVO memberVO){
        boolean result = false;
        String id = memberVO.getId();
        String pw = memberVO.getPw();
        try{
            Connection con = dataFactory.getConnection();
            String sql = "select pw from t_member where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String dbPw = rs.getString("pw");
            if(pw.equals(dbPw))
                result = true;

            System.out.println(result);

        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
