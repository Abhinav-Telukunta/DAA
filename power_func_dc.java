/*A school kid named Chitti Naidu wants to find the value of N^P
Pth power of a number N.

You will be given two integers N and P.
Your task is to help Chitti Naidu to find the value of N^P.

NOTE:
---------
Value of N and P can be both positive and negative

Can you solve this problem in O(log|n|) time?

Input Format:
-------------
Two integers N and P, where N is the number and P is the power

Output Format:
--------------
Print a float number, N power P


Sample Input-1:
---------------
3 2

Sample Output-1:
----------------
9.000000


Sample Input-2:
---------------
2 -3

Sample Output-2:
----------------
0.125000
*/
import java.util.*;
public class power_func_dc{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        double ans=compute_pow(n,p);
        System.out.println(String.format("%.6f",ans));
    }
    public static double compute_pow(int n,int p){
        if(p==0) return 1;
        else if(p<0 && p%2!=0) return (compute_pow(n,p/2)*compute_pow(n,p/2))/n;
        else if(p<0 && p%2==0) return compute_pow(n,p/2)*compute_pow(n,p/2);
        else if(p%2==0) return compute_pow(n,p/2)*compute_pow(n,p/2);
        return compute_pow(n,p/2)*compute_pow(n,p/2)*n;
        
    }
}
