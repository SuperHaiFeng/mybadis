package jdbc;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class CRUDao {
    public static String driverClass = "com.mysql.jdbc.Driver";
    public static String userName = "root";
    public static String password = "123456";
    public static String url = "jdbc:mysql://localhost:3306/mybatisDemo";
    public static Connection conn = null;
    //定义声明数据库语句,使用 预编译声明 PreparedStatement提高数据库执行性能
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;

    public static List<Person> readPerson(){
        List<Person> list = new ArrayList<>();
        try {
            //加载数据库驱动
            Class.forName(driverClass);
            //获取数据库链接
            conn = DriverManager.getConnection(url,userName,password);
            //定义sql语句
            String sql = "select * from user where id=2";
            //获取预编译处理
            ps = conn.prepareStatement(sql);
//            ps.setString(2,"qzy");
            rs = ps.executeQuery();
            while (rs.next()){
                Person p = new Person();
                p.setName(rs.getString(2));
                list.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null){
                    rs.close();
                }
                if (ps != null){
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args){
        System.out.println(CRUDao.readPerson());
    }
}
