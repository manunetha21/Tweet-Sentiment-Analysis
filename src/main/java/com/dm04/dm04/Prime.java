import java.io.*;
import java.util.*;

class Prime{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean check=true;
        for(int i=2;i<n;i++){
            if(n%i==0){
                check=false;
            System.out.println("Not a prime");
            break;
            }
        }
        if(check==true)
        System.out.println("is a prime");
        

    }
}