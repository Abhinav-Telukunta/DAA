import numpy as np
n=int(input())
mat1=[[int(x) for x in input().split()] for _ in range(n)]
mat2=[[int(x) for x in input().split()] for _ in range(n)]
mat1=np.array(mat1)
mat2=np.array(mat2)
def strassen(mat1,mat2):
    if len(mat1)==1:
        return mat1*mat2
    a,b,c,d=split(mat1)
    e,f,g,h=split(mat2)
    p1 = strassen(a, f - h)  
    p2 = strassen(a + b, h)        
    p3 = strassen(c + d, e)        
    p4 = strassen(d, g - e)        
    p5 = strassen(a + d, e + h)        
    p6 = strassen(b - d, g + h)  
    p7 = strassen(a - c, e + f)
    c11 = p5 + p4 - p2 + p6  
    c12 = p1 + p2           
    c21 = p3 + p4            
    c22 = p1 + p5 - p3 - p7 
    c = np.vstack((np.hstack((c11, c12)), np.hstack((c21, c22)))) 
    return c
def split(mat):
    row,col=mat.shape
    new_row,new_col=row//2,col//2
    return mat[:new_row,:new_col],mat[:new_row,new_col:],mat[new_row:,:new_col],mat[new_row:,new_col:]
ans=strassen(mat1,mat2)
for i in range(len(ans)):
    for j in range(len(ans[i])):
        print(ans[i][j],end=" ")
    print()
