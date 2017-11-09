public class StringFunc{
    final static String s="扁担长，板凳宽，板凳没有扁担长，扁担没有板凳宽。扁担要绑在板凳上,板凳偏不让扁担绑在板凳上。";
    public static void main(String args[]){
        String s1=new String();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='板'&&s.charAt(i+1)=='凳'&&s.charAt(i+2)=='宽'){
                s1=s.substring(i,i+3);
                break;
            }
        }
        System.out.println(s1);

        int begin=0;
        while(begin<s.length()){
            if(s.indexOf("扁担",begin)==-1) break;
            System.out.print(s.indexOf("扁担",begin));
            System.out.print(" ");
            begin=s.indexOf("扁担",begin)+1;
        }
        System.out.print("\n");

        String s2=new String();
        long time_begin=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            s2+=s;
        }
        System.out.print("字符串相加的时间: ");
        System.out.print(System.currentTimeMillis()-time_begin);
        System.out.print("ms  字符串长度: ");
        System.out.print(s2.length());
        System.out.print("\n");

        time_begin=System.currentTimeMillis();
        StringBuilder stringBuilder=new StringBuilder(s2);
        String s3=new String(stringBuilder);
        System.out.print("StringBuilder的时间: ");
        System.out.print(System.currentTimeMillis()-time_begin);
        System.out.print("ms  字符串长度: ");
        System.out.print(s3.length());
        System.out.print("\n");
    }
}
