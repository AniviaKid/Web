
import java.sql.*;
import java.util.*;

public class QueryStu {
    static private Connection conn;
    static int cnt = 0;
    static Scanner in = new Scanner(System.in);
    static int sno = 1;

    public static void main(String args[]) {
        String lineWords[];
        String ins=new String();
        while ((lineWords=getNextLineWords())!=null){
            ins="";
            for(int i=0;i<lineWords.length;i++) ins+=lineWords[i];
            if(ins.charAt(0)=='-'){ //查询ID
                ins=ins.substring(1);
                if (connect()) {
                    ResultSet rs = executeQuery("select * from stu where id="+ins+";");
                    showStudents(rs);
                } else {
                    System.out.println("Connect Error!");
                }
            }
            else if(ins.charAt(0)=='*'){
                if (connect()) {
                    ResultSet rs = executeQuery("select * from info;");
                    showStudents(rs);
                } else {
                    System.out.println("Connect Error!");
                }
            }
            else if(ins.equals("exit")){
                break;
            }
            else {
                if (connect()) {
                    ResultSet rs = executeQuery("select * from stu where num like \"%"+ins+"%\" or name=\""+ins+"\" order by num;");
                    showStudents(rs);
                } else {
                    System.out.println("Connect Error!");
                }
            }
        }
    }

    // 建立连接
    private static boolean connect() {
        String connectString = "jdbc:mysql://a.aniviakid.cn:3306/my_user_info";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectString, "root", "westlife1412");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //执行SQL查询语句, 返回结果集
    static private ResultSet executeQuery(String sqlSentence) {
        Statement stat;
        ResultSet rs = null;

        try {
            stat = conn.createStatement();       //获取执行sql语句的对象
            rs = stat.executeQuery(sqlSentence); //执行sql查询，返回结果集
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    //显示查询结果
    private static void showStudents(ResultSet rs){
        try {
            while(rs.next()){
                System.out.print("name:"+rs.getString("name")+" password:"+rs.getString("password")+" description:"+rs.getString("description")+"\n");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //输入
    public static String[] getNextLineWords(){
        if (sno==1){
            System.out.println("查询学号和姓名(部分匹配)，以-开头查询id，*查出所有记录，exit或空行退出.\r\n");
        }
        System.out.print("第"+sno+"行> ");
        if (!in.hasNextLine()) { // 是否还有输入
            return null;
        }
        String line = in.nextLine(); // 读取下一行
        line = line.trim();
        if (line.equals("exit") || line.length() == 0) {
            return null;
        }
        sno++;
        return line.split(" ");
    }

}
