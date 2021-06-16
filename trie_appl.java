/*In an english training institute, the trainer Reeta given a task to the trainees.
We know that, in english we have prefixes and suffixes for the words.
You can divide a word as concatenation of prefix and suffix.
i.e., word = prefix + suffix, another = an + other

You will be given a list of prefixes and a statement consisting of words.
Now, the task given to the trainees is as follows:
	- Replace all the words in the statement with the prefix, 
	  if you found prefix of that word in the list.
	- If you found more than one prefix in the list for a word in the statement,
	  replace the word with the prefix that has the shortest length.

Your task is to help the trainees to prepare and print the final statement
after all the replacements done.


Input Format:
-------------
Line-1: Space separated strings, prefixes.
Line-2: A single line of words, statement.

Output Format:
--------------
Print the String, the final statement.


Sample Input-1:
---------------
am add mean ref 
amigos used to address or refer to a friend

Sample Output-1:
----------------
am used to add or ref to a friend


Sample Input-2:
---------------
th the pa tho
thomas the trainer teaches theroy part of thermodynamics

Sample Output-2:
----------------
th th trainer teaches th pa of th
*/
import java.util.*;
class trie{
    static class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd;
        TrieNode(){
            isEnd=false;
            for(int i=0;i<26;++i) children[i]=null;
        }
    }
    static TrieNode root;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        root=new TrieNode();
        String[] strs=sc.nextLine().split(" ");
        String[] queries=sc.nextLine().split(" ");
        for(String str:strs){
            insert(str);
        }
        for(String q:queries){
            String res=search(q);
            System.out.print(res+" ");
        }
    }
    public static void insert(String key){
        TrieNode curr=root;
        for(int level=0;level<key.length();++level){
            int idx=key.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr=curr.children[idx];
        }
        curr.isEnd=true;
    }
    public static String search(String key){
        TrieNode curr=root;
        String res="";
        int f=0;
        for(int level=0;level<key.length();++level){
            int idx=key.charAt(level)-'a';
            if(curr.isEnd) break;
            if(curr.children[idx]==null){
                f=1;
                break;
            }
            res+=key.charAt(level);
            curr=curr.children[idx];
        }
        if(f==0) return res;
        return key;
    }
    
}
