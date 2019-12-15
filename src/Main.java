import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            boolean flag=false;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='.'){
                    flag=true;
                    dzs(s);
                    break;
                }
            }
            if(!flag){
                Szd(s);
            }
        }
    }
    public static void dzs(String s){
        String[] w=s.split("\\.");
        int[] v=new int[w.length];
        for(int i=0;i<w.length;i++){
            v[i]=Integer.parseInt(w[i]);
        }
        //System.out.println(Arrays.toString(v));
        StringBuilder sb=new StringBuilder();
        StringBuilder sc=new StringBuilder();
        StringBuilder sd=new StringBuilder();
        StringBuilder se=new StringBuilder();
        int[] x=new int[8];
        for(int i=0;i<v.length;i++){
            for(int j=v[i];j>0;j/=2){
                sb.append(j%2);
            }
            sc=sb.reverse();
            //System.out.println(sc);
            if(sc.length()<8){
                for(int j=0;j<8-sc.length();j++){
                    sd.append("0");
                }
                sd.append(sc);
            }else{
                sd=sc;
            }
           // System.out.println(sd);
            se.append(sd);
            sc.setLength(0);
            sb.setLength(0);
            sd.setLength(0);
        }
        //System.out.println(se);
        int sum=0;
        se=se.reverse();
        for(int i=0;i<se.length();i++){
            int p=se.charAt(i)-48;
            if(p==1){
                sum=sum+(int)Math.pow(2,i);
            }
        }
        System.out.println(sum);
    }
    public static void Szd(String s){
        int a=Integer.parseInt(s);
        StringBuilder sb=new StringBuilder();
        StringBuilder sc=new StringBuilder();
        StringBuilder sd=new StringBuilder();
        for(int i=a;i>0;i/=2){
            sb.append(i%2);
        }
        //System.out.println(sb);
        sc=sb.reverse();
        if(sc.length()<32){
            for(int i=0;i<32-sc.length();i++){
                sd.append("0");
            }
        }
        sd.append(sc);
        //System.out.println(sd);
        String[] ip=new String[4];
        for(int i=0;i<4;i++){
            ip[i]=sd.substring(8*i,8*i+8);
        }
        //System.out.println(Arrays.toString(ip));
        StringBuilder sr=new StringBuilder();
        int sum=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<ip[i].length();j++){
                StringBuilder sw=new StringBuilder(ip[i]);
                sw=sw.reverse();
                //System.out.println(sw);
                int p=sw.charAt(j)-48;
                if(p==1){
                    sum=sum+(int)Math.pow(2,j);
                }
                //System.out.println(sum);
            }
            sr.append(sum);
            sum=0;
            if(i!=3){
                sr.append(".");
            }
        }
        System.out.println(sr);
    }
}
