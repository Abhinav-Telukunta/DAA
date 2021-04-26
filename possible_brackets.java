/*Achilles Reselfelt is a mathematician who invented BODMAS rule.
He wants to test his invention on an expression which is given as a string.
The expression contains digits and operators(+, - , *) only.

He wants try BODMAS rule on the given expression by adding brackets in different ways.
To check whether the rule is working properly or not.

Your task is to help Reselfelt to check his BODMAS rule is working or not.
You have to return all possible results from evaluating all the different possible ways 
to group digits and operators by using brackets.

Input Format:
-------------
A string, an expression consist of digits and operators.

Output Format:
--------------
Print the list of all possible results in sorted order.


Sample Input-1:
---------------
2-3+4

Sample Output-1:
----------------
[-5, 3]


Sample Input-2:
---------------
1+2-3*4

Sample Output-2:
----------------
[-9, -9, -3, 0, 0]

Explanation:
------------
(1+(2-(3*4))) = -9
((1+2)-(3*4)) = -9
((1+(2-3))*4) = 0
(1+((2-3)*4)) = -3
(((1+2)-3)*4) = 0

*/
import java.util.*;
class bodmas{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Map<String,ArrayList<Integer>>map=new HashMap<>();
        ArrayList<Integer>ans=evaluate(map,s);
        Collections.sort(ans);
        System.out.println(ans);
    }
    public static ArrayList<Integer> evaluate(Map<String,ArrayList<Integer>>map,String s){
        if(map.get(s)!=null) return map.get(s);
        ArrayList<Integer>temp=new ArrayList<Integer>();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*'){
                ArrayList<Integer>left_part=evaluate(map,s.substring(0,i));
                ArrayList<Integer>right_part=evaluate(map,s.substring(i+1));
                for(int j=0;j<left_part.size();++j){
                    for(int k=0;k<right_part.size();++k){
                        if(s.charAt(i)=='+') temp.add(left_part.get(j)+right_part.get(k));
                        else if(s.charAt(i)=='-') temp.add(left_part.get(j)-right_part.get(k));
                        else if(s.charAt(i)=='*') temp.add(left_part.get(j)*right_part.get(k));
                    }
                }
            }
        }
        if(temp.size()==0) temp.add(Integer.parseInt(s));
        map.put(s,temp);
        return temp;
    }
}
