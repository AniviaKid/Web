public class StringFunc{
    final static String s="�ⵣ������ʿ����û�бⵣ�����ⵣû�а�ʿ��ⵣҪ���ڰ����,���ƫ���ñⵣ���ڰ���ϡ�";
    public static void main(String args[]){
        String s1=new String();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='��'&&s.charAt(i+1)=='��'&&s.charAt(i+2)=='��'){
                s1=s.substring(i,i+3);
                break;
            }
        }
        System.out.println(s1);

        int begin=0;
        while(begin<s.length()){
            if(s.indexOf("�ⵣ",begin)==-1) break;
            System.out.print(s.indexOf("�ⵣ",begin));
            System.out.print(" ");
            begin=s.indexOf("�ⵣ",begin)+1;
        }
        System.out.print("\n");

        String s2=new String();
        long time_begin=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            s2+=s;
        }
        System.out.print("�ַ�����ӵ�ʱ��: ");
        System.out.print(System.currentTimeMillis()-time_begin);
        System.out.print("ms  �ַ�������: ");
        System.out.print(s2.length());
        System.out.print("\n");

        time_begin=System.currentTimeMillis();
        StringBuilder stringBuilder=new StringBuilder(s2);
        String s3=new String(stringBuilder);
        System.out.print("StringBuilder��ʱ��: ");
        System.out.print(System.currentTimeMillis()-time_begin);
        System.out.print("ms  �ַ�������: ");
        System.out.print(s3.length());
        System.out.print("\n");
    }
}
