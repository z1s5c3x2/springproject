package example.day01.consoleMvc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsoleDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ConsoleDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb","root","1234");
            System.out.println("성공");
        }catch (Exception e)
        {
            System.out.println("e = " + e);
        }

    }



    public List<ConsoleDto> doGet()
    {
        List<ConsoleDto> res = new ArrayList<>();
        try {
            String sql = "select * from doto";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                res.add(new ConsoleDto(rs.getInt(1),
                        rs.getString(2),
                        LocalDate.parse(rs.getString(3)),
                        rs.getBoolean(4)));
            }
            return res;
        } catch (SQLException e) {
            System.out.println("불러오기 에러 " + e);
        }
        return null;

    }
    public boolean doPost(ConsoleDto cdt)
    {
        try {
            String sql = "insert into doto(title,duedate,finishied) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,cdt.getTitle());
            ps.setString(2,cdt.getDueDate().toString());
            ps.setBoolean(3,cdt.isFinished());
            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            System.out.println("저장 에러"+e);
        }

        return false;
    }
}
