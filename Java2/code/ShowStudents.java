import java.sql.*;
import java.util.*;

public class ShowStudents {
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
            String num=new String(),name=new String();
            for(int i=0;i<ins.length();i++){
                if(ins.charAt(i)>='0'&&ins.charAt(i)<='9') num+=ins.charAt(i);
                else if(ins.charAt(i)==' ') continue;
                else name+=ins.charAt(i);
            }
            if (connect()) {
                int rs = executeUpdate("insert into stu(num,name) values ('"+num+"','"+name+"');");
                System.out.println(rs+"����¼������");
            } else {
                System.out.println("Connect Error!");
            }
        }
    }

    // ��������
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

    //ִ��SQL��ѯ���, ���ؽ����
    static private int executeUpdate(String sqlSentence) {
        Statement stat;
        int rs =0;
        try {
            stat = conn.createStatement();       //��ȡִ��sql���Ķ���
            rs=stat.executeUpdate(sqlSentence);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    //��ʾ��ѯ���
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
    //����
    public static String[] getNextLineWords(){
        if (sno==1){
            System.out.println("����ѧ�ź�����(�ÿո���)��exit������˳�.\r\n");
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
