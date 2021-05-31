/*Ganesh is working on numbers,
He is given a list of integers 1,2,3,...,N, the list is indexed from 1 to N.

Now he can shuffle the list in whatever way he want.
Shuffled list is said to be valid, if one of the following is true for 
i-th position in the list.
	- The integer at the i-th position is divisible by i.
	- 'i' is divisible by the integer at the i-th position.

Now your task is to find out, How many valid shuffles can Ganesh do?

Input Format:
-------------
An integer N, where N<=20.

Output Format:
--------------
Print an integer, number of ways ganesh can shuffle.


Sample Input:
---------------
2

Sample Output:
----------------
2

Explanation:
------------
The first shuffled list is [1, 2]:
Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second shuffled list is [2, 1]:
Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
*/
import java.util.*;
class shuffle{
    static int ans=0;
    static Set<Integer>visited=new HashSet<>();
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n+1];
        compute(arr,1,n);
        System.out.println(ans);
    }
    public static void compute(int[] arr,int idx,int n){
        if(idx==n+1){
            ans++;
            return;
        }
        for(int i=1;i<=n;++i){
            if(!visited.contains(i) && (i%idx==0 || idx%i==0)){
                visited.add(i);
                arr[idx]=i;
                compute(arr,idx+1,n);
                arr[idx]=0;
                visited.remove(i);
            }
        }
    }
}