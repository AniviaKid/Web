import java.util.*;

public class Fib{
    public static void main(String args[]){
        long fib0=0,fib1=1,fib2=1;
        List<Long> fibs=new ArrayList<>();
        fibs.add(fib0);
        fibs.add(fib1);
        fibs.add(fib2);
        while (true){
            if(fibs.get(fibs.size()-1)<0){
                fibs.remove(fibs.size()-1);
                break;
            }
            fibs.add(fibs.get(fibs.size()-1)+fibs.get(fibs.size()-2));
        }
        System.out.print("Max_Fib(Long): ");
        System.out.print(fibs.get(fibs.size()-1));
        System.out.print("  ");
        System.out.println(fibs.size());

        double ratios[]=new double[fibs.size()-1];
        int i=0;
        Iterator it=fibs.iterator();
        Long cur=(Long) it.next(),next;
        for(;it.hasNext();){
            next=(Long) it.next();
            ratios[i]=cur*1.0/next;
            i++;
            cur=next;
        }
        for(double tmp:ratios){
            System.out.print(tmp);
            System.out.print("  ");
        }
    }
}
