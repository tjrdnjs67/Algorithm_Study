def sol(idx):
    if idx==6:
        for i in range(6):
            print(brr[i], end=" ")
            
        print()
        return
    
    for i in range(1,len(arr)):
        if v[i]==False and brr[idx-1]<arr[i]:
            v[i] = True
            brr[idx]=arr[i]
            sol(idx+1)
            v[i]=False



k=1
while k!=0:  
    arr = list(map(int,input().split()))
    k=arr[0]
    brr=[0]*7
    v=[False] * (len(arr)+1)
    sol(0)
    print()


