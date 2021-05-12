/*Given a integer value N, indicates number of bits in a binary number.

Your task is to design a Binary Code System, 
where two consecutive values in BCS having N bits, must have one bit difference only.
For example refer the sample testcases.

Find and print the integer values of BCS, starting from 0.

NOTE: Always check from righ to left
(Suppose digits positions of 1011 are as follows: 
i.e., digit pos: 3 2 1 0
                 1 0 1 1
check from position 1)


Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3

Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4
*/

import java.util.*;
class gray_code{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        ArrayList<Integer>ans=new ArrayList<>();
        ArrayList<String>base=new ArrayList<>();
        base.add("0");
        base.add("1");
        for(int i=1;i<len;++i){
            ArrayList<String>newbase=new ArrayList<>();
            for(int j=0;j<base.size();++j){
                newbase.add("0"+base.get(j));
            }
            for(int j=base.size()-1;j>=0;--j){
                newbase.add("1"+base.get(j));
            }
            base=newbase;
        }
        for(String s:base) ans.add(Integer.parseInt(s,2));
        System.out.println(ans);
    }
}
