/*Somanath is working on set of integers
He is given a set of integers of size N, his task is to find the priority element. 
The priority element is the element that appears more than [ N/2 ] times.

You may assume that the set is non-empty 
and the priority element always exist in the array.

Input Format:
-------------
line-1: an integer N.
line-2: N space separated integers

Output Format:
--------------
An integer, the priority element of the set.

Sample Input-1:
---------------
2
3 2 3

Sample Output-1:
----------------
3

Sample Input-1:
---------------
7
2 2 1 1 1 2 2

Sample Output-2:
----------------
2


*/
import java.util.*;
class priority{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        int ans=0,count=0;
        for(int i=0;i<n;++i){
            if(count==0) ans=arr[i];
            if(ans==arr[i]) count++;
            else count--;
        }
        System.out.println(ans);
    }
}
