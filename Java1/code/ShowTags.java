import java.io.*;
import java.util.*;

class ShowTags{
    public static void main(String[] args)throws IOException{
        String content = readFile(".\\grassland.htm");
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<content.length();i++){
            if(content.charAt(i)=='<'){
                String key=new String();
                for (int j=i;j<content.length();j++){
                    if(content.charAt(j)==' '||content.charAt(j)=='>') break;
                    key+=change(content.charAt(j));
                }
                if(key.equals("<!--")||key.equals("<")){
                    continue;
                }
				key+='>';
                if(map.get(key)==null){
                    map.put(key,1);
                }
                else{
                    int cur_value=map.get(key);
                    map.remove(key);
                    map.put(key,cur_value+1);
                }
            }
        }
        for(String key:map.keySet()){
            System.out.print(key+":");
            System.out.print(map.get(key));
            System.out.print("  ");
        }
    }

    static String readFile(String fileName) throws IOException{
        StringBuilder sb = new StringBuilder("");
        int c1;
        FileInputStream f1= new FileInputStream(fileName);
        InputStreamReader in = new InputStreamReader(f1, "UTF-8");

        while ((c1 = in.read()) != -1) {
            sb.append((char) c1);
        }
        return sb.toString();
    }
    static char change(char ch){
        if(ch>='a'&&ch<='z'){
            ch-=32;
        }
        return ch;
    }
}


