def posFind(A, i):
##Find Position where A[i] should be inserted in A   
    x = A[i]
    j = i - 1
    while j >= 0 and A[j] > x:
        j = j - 1
    return j + 1
    
def shift(A, i, j):
## Shift A[i] to A[j] where j < i
    x = A[i]
    k = i - 1
    while k >= j:
        A[k + 1] = A[k]
        k -= 1
    A[k] = x   

def insertionSort(A):
    for i in range(1, len(A)):
        print(A)        
        j = posFind(A, i)
        print(i, j)
        if i != j:
            shift(A, j, i)
    print(A)
            
insertionSort([3, 9, 1, 8, 7, 4])