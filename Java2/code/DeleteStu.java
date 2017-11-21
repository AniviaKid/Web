import java.sql.*;
import java.util.*;

public class DeleteStu {
    static private Connection conn;
    static int cnt = 0;
    static Scanner in = new Scanner(System.in);
    static int sno = 1;

    public static void main(String args[]) {
        String lineWords[];
        String ins=new String();
        while ((lineWords=getNextLineWords())!=null){
            ins="";
            for(int i=0;i<lineWords.length;i++){
                ins+=lineWords[i];
                ins+=" ";
            }
            ins=ins.substring(0,ins.length()-1);
            if(ins.charAt(0)=='-'){ //id
                String id=new String();
                id=ins.substring(1);
                if (connect()) {
                    int rs = executeUpdate("delete from stu where id="+id+";");
                    System.out.println(rs+"条记录被删除");
                } else {
                    System.out.println("Connect Error!");
                }
            }
            else{
                if (connect()) {
                    int rs = executeUpdate("delete from stu where num like '%"+ins+"%' or name like '%"+ins+"%';");
                    System.out.println(rs+"条记录被删除");
                } else {
                    System.out.println("Connect Error!");
                }
            }
        }
    }

    // 建立连接
    private static boolean connect() {
        String connectString = "jdbc:mysql://172.18.187.230:53306/teaching"
                + "?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&&useSSL=false";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectString, "user", "123");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //执行SQL查询语句, 返回结果集
    static private int executeUpdate(String sqlSentence) {
        Statement stat;
        int rs =0;
        try {
            stat = conn.createStatement();       //获取执行sql语句的对象
            rs=stat.executeUpdate(sqlSentence);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    //显示查询结果
    private static void showStudents(ResultSet rs){
        try {
            while(rs.next()){
                System.out.print("name:"+rs.getString("name")+" num:"+rs.getString("num")+" id:"+rs.getString("id")+"\n");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //输入
    public static String[] getNextLineWords(){
        if (sno==1){
            System.out.println("输入学号或姓名(部分匹配)以删除记录，输入以-开头的数组则按id删除，exit或空行退出.\r\n");
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
