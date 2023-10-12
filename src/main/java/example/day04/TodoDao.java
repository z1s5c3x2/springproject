package example.day04;


import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class TodoDao{
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private TodoDao()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb","root","1234");
            System.out.println("성공");
        }catch (Exception e)
        {
            System.out.println("e = " + e);
        }
    }
    public boolean doPost(TodoDto dto)
    {
        try{
            String sql = "insert into todo(tcontent,tstate) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,dto.getTContent());
            ps.setBoolean(2,dto.isTState());
            return ps.executeUpdate() == 1;

        }catch(Exception e){
            System.out.println("doPost"+e);
        }
        return false;
    }

    public List<TodoDto> doGet()
    {
        List<TodoDto> list = new ArrayList<>();
        try{
            String sql = "select * from todo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                list.add(TodoDto.builder()
                        .tno(rs.getInt("tno")).tState(rs.getBoolean("tstate")).tContent(rs.getString("tcontent")).build());
            }
            return list;
        }catch(Exception e){
            System.out.println("doGet"+e);
        }
        return null;
    }
    public boolean doPut(TodoDto dto)
    {
        try{
            String sql = "update todo set tstate = ? where tno = ?";

            ps = conn.prepareStatement(sql);
            ps.setBoolean(1,dto.isTState());
            ps.setInt(2,dto.getTno());

            return ps.executeUpdate() == 1;
        }catch(Exception e){
            System.out.println("doPut"+e);
        }
        return false;
    }
    public boolean doDelete(int tno)
    {
        try{
            String sql = "delete from todo where tno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,tno);
            return ps.executeUpdate() == 1;
        }catch(Exception e){
            System.out.println("doDelete"+e);
        }

        return false;
    }

}
