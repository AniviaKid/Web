
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
            if(ins.charAt(0)=='-'){ //��ѯID
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

    // ��������
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

    //ִ��SQL��ѯ���, ���ؽ����
    static private ResultSet executeQuery(String sqlSentence) {
        Statement stat;
        ResultSet rs = null;

        try {
            stat = conn.createStatement();       //��ȡִ��sql���Ķ���
            rs = stat.executeQuery(sqlSentence); //ִ��sql��ѯ�����ؽ����
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    //��ʾ��ѯ���
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
    //����
    public static String[] getNextLineWords(){
        if (sno==1){
            System.out.println("��ѯѧ�ź�����(����ƥ��)����-��ͷ��ѯid��*������м�¼��exit������˳�.\r\n");
        }
        System.out.print("��"+sno+"��> ");
        if (!in.hasNextLine()) { // �Ƿ�������
            return null;
        }
        String line = in.nextLine(); // ��ȡ��һ��
        line = line.trim();
        if (line.equals("exit") || line.length() == 0) {
            return null;
        }
        sno++;
        return line.split(" ");
    }

}
