/*Given a 2d grid with M*N size. 
The grid contains M*N cells of 1*1 size.
Each cell is printed a number on it.

You will be given a number, you need to find whether the number is printed on 
any of the cells or not. If found print true, otherwise print false.

NOTE: This numbers in the grid in each row and each column are in increasing order.
And all the numbers are unique.

Input Format:
-------------
Line-1 -> Two integers M and N, board size.
Next M lines -> N space separated integers.
Last Line -> An integer T, number to search.

Output Format:
--------------
Print a boolean value, 'true' if number found.
otherwise, 'false'.


Sample Input-1:
---------------
4 4
1 3 6 10
2 5 9 13
4 8 12 16
7 11 14 17
5

Sample Output-1:
----------------
true


Sample Input-2:
---------------
4 4
1 3 6 10
2 5 9 13
4 8 12 16
7 11 14 17
15

Sample Output-2:
----------------
false
*/
import java.util.*;
class search{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] mat=new int[r][c];
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j) mat[i][j]=sc.nextInt();
        }
        int key=sc.nextInt();
        int rp=0,cp=c-1,f=0;
        while(rp>=0 && rp<r && cp>=0 && cp<c){
            if(mat[rp][cp]<key) rp++;
            else if(mat[rp][cp]>key) cp--;
            else{
                f=1;
                break;
            }
        }
        System.out.println(f==1?"true":"false");
    }
}