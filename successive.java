/*Nehanth, a bubbly kid playing with digits and creating numbers using them.
The kid is creating the number called successive number. 
A number is called successive number, if and only if 
each digit in the number is one less than the next digit.

You are given two integers, start and end, both are inclusive.
Your task to find and print all the successive numbers in the given range (start, end).

Input Format:
-------------
Two space separated integers, start and end

Output Format:
--------------
Print the list of successive numbers in the range(start, end).


Sample Input-1:
---------------
50 150

Sample Output-1:
----------------
[56, 67, 78, 89, 123]


Sample Input-2:
---------------
100 600

Sample Output-2:
----------------
[123, 234, 345, 456, 567]
*/

import java.util.*;
class successive{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int low=sc.nextInt();
        int high=sc.nextInt();
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=1;i<=9;++i){
            generate_climbing(i,low,high,ans);
        }
        Collections.sort(ans);
        System.out.println(ans);
    }
    public static void generate_climbing(int curr,int low,int high,ArrayList<Integer>ans){
        if(curr>=low && curr<=high) ans.add(curr);
        if(curr>high || curr%10==9) return;
        int number=curr*10+(curr%10+1);
        generate_climbing(number,low,high,ans);
    }
}
