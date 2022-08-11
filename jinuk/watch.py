
N, M=map(int,input().split())
office = [list(map(int,input().split())) for i in range(N)]
zero = 0


def one(i,j):
    global a,b,c,d
    one_max=0
    a=0
    b=0
    c=0
    d=0
    for x in range(1,N):
        if  i+x>N-1 or office[i+x][j] == 6:
            break
        a+=1
    for x in range(1,N):
        if  i-x<0 or office[i-x][j] == 6:
            break
        b+=1
    for x in range(1,M):
        if j+x>M-1 or office[i][j+x] == 6:
            break
        c+=1
    for x in range(1,M):
        if j-x<0 or office[i][j-x] == 6:
            break
        d+=1
    one_max=max(a,b,c,d)

    if one_max==a:
        for x in range(1,N):
            if i+x>N-1 or office[i+x][j]==6:
                break
            if(office[i+x][j]==0):
                office[i+x][j]=7
    elif one_max==b:
        for x in range(1,N):
            if i-x<0 or office[i-x][j]==6:
                break
            if(office[i-x][j]==0):
                office[i-x][j]=7
    elif one_max==c:
        for x in range(1,M):
            if j+x>M-1 or office[i][j+x]==6:
                break
            if(office[i][j+x]==0):
                office[i][j+x]=7
    elif one_max==d: 
        for x in range(1,M):
            if j-x<0 or office[i][j-x]==6:
                break
            if(office[i][j-x]==0):
                office[i][j-x]=7


def two(i,j):
    global two_a,two_b,two_max
    two_a=0
    two_b=0
    for x in range(1,N):
        if i+x>N-1 or office[i+x][j]==6:
            break
        two_a+=1
    for x in range(1,N):
        if i-x<0 or office[i-x][j]==6:
            break
        two_a+=1
    for x in range(1,M):
        if j+x>M-1 or office[i][j+x]==6:
            break
        two_b+=1
    for x in range(1,M):
        if j-x<0 or office[i][j-x]==6:
            break
        two_b+=1

    if two_a>two_b:
        for x in range(1,N):
            if i+x>N-1 or office[i+x][j]==6:
                break
            if(office[i+x][j]==0):
                office[i+x][j]=7
        for x in range(1,N):
            if i-x<0 or office[i-x][j]==6:
                break
            if(office[i-x][j]==0):
                office[i-x][j]=7

    else:
        for x in range(1,M):
            if j+x>M-1 or office[i][j+x]==6:
                break
            if(office[i][j+x]==0):
                office[i][j+x]=7
        for x in range(1,M):
            if j-x<0 or office[i][j-x]==6:
                break
            if(office[i][j-x]==0):
                office[i][j-x]=7


def three(i,j):
    global three_a,three_b,three_c,three_d,three_max
    three_a=0
    three_b=0
    three_c=0
    three_d=0
    for x in range(1,N):
        if i+x>N-1 or office[i+x][j]==6:
            break
        three_a+=1
    for x in range(1,M):
        if j+x>M-1 or office[i][j+x]==6:
            break
        three_a+=1

    for x in range(1,N):
        if i+x>N-1 or office[i+x][j]==6:
            break
        three_b+=1
    for x in range(1,M):
        if j-x<0 or office[i][j-x]==6:
            break
        three_b+=1

    for x in range(1,N):
        if i-x<0 or office[i-x][j]==6:
            break
        three_c+=1
    for x in range(1,M):
        if j+x>M-1 or office[i][j+x]==6:
            break
        three_c+=1

    for x in range(1,N):
        if i-x<0 or office[i-x][j]==6:
            break
        three_d+=1
    for x in range(1,M):
        if j-x<0 or office[i][j-x]==6:
            break
        three_d+=1

    three_max=max(three_a,three_b,three_c,three_d)

    if three_max==three_a:
        for x in range(1,N):
            if i+x>N-1 or office[i+x][j]==6:
                break
            if(office[i+x][j]==0):
                office[i+x][j]=7
        for x in range(1,M):
            if j+x>M-1 or office[i][j+x]==6:
                break
            if(office[i][j+x]==0):
                office[i][j+x]=7

    elif three_max==three_b:
        for x in range(1,N):
            if i+x>N-1 or office[i+x][j]==6:
                break
            if(office[i+x][j]==0):
                office[i+x][j]=7
        for x in range(1,M):
            if j-x<0 or office[i][j-x]==6:
                break
            if(office[i][j-x]==0):
                office[i][j-x]=7

    elif three_max==three_c:
        for x in range(1,N):
            if i-x<0 or office[i-x][j]==6:
                break
            if(office[i-x][j]==0):
                office[i-x][j]=7
        for x in range(1,M):
            if j+x>M-1 or office[i][j+x]==6:
                break
            if(office[i][j+x]==0):
                office[i][j+x]=7

    elif three_max==three_d:
        for x in range(1,N):
            if i-x<0 or office[i-x][j]==6:
                break
            if(office[i-x][j]==0):
                office[i-x][j]=7
        for x in range(1,M):
            if j-x<0 or office[i][j-x]==6:
                break
            if(office[i][j-x]==0):
                office[i][j-x]=7


def four(i,j):
    global four_a,four_b,four_c,four_d,four_max
    four_a=0
    four_b=0
    four_c=0
    four_d=0
    for x in range(1,N):
        if i+x>N-1 or office[i+x][j]==6:
            break
        four_a+=1
    for x in range(1,N):
        if i-x<0 or office[i-x][j]==6:
            break
        four_a+=1
    for x in range(1,M):
        if j+x>M-1 or office[i][j+x]==6:
            break
        four_a+=1


    for x in range(1,N):
        if i+x>N-1 or office[i+x][j]==6:
            break
        four_b+=1
    for x in range(1,N):
        if i-x<0 or office[i-x][j]==6:
            break
        four_b+=1
    for x in range(1,M):
        if j-x<0 or office[i][j-x]==6:
            break
        four_b+=1

    for x in range(1,N):
        if i+x>N-1 or office[i+x][j]==6:
            break
        four_c+=1
    for x in range(1,M):
        if j+x>M-1 or office[i][j+x]==6:
            break
        four_c+=1
    for x in range(1,M):
        if j-x<0 or office[i][j-x]==6:
            break
        four_c+=1

    for x in range(1,N):
        if i-x<0 or office[i-x][j]==6:
            break
        four_d+=1
    for x in range(1,M):
        if j+x>M-1 or office[i][j+x]==6:
            break
        four_d+=1
    for x in range(1,M):
        if j-x<0 or office[i][j-x]==6:
            break
        four_d+=1

    four_max = max(four_a,four_b,four_c,four_d)
    if(four_max == four_a):
        for x in range(1,N):
            if i+x>N-1 or office[i+x][j]==6:
                break
            if(office[i+x][j]==0):
                office[i+x][j]=7
        for x in range(1,N):
            if i-x<0 or office[i-x][j]==6:
                break
            if(office[i-x][j]==0):
                office[i-x][j]=7
        for x in range(1,M):
            if j+x>M-1 or office[i][j+x]==6:
                break
            if(office[i][j+x]==0):
                office[i][j+x]=7
    elif(four_max == four_b):
        for x in range(1,N):
            if i+x>N-1 or office[i+x][j]==6:
                break
            if(office[i+x][j]==0):
                office[i+x][j]=7
        for x in range(1,N):
            if i-x<0 or office[i-x][j]==6:
                break
            if(office[i-x][j]==0):
               office[i-x][j]=7
        for x in range(1,M):
            if j-x<0 or office[i][j-x]==6:
                break
            if(office[i][j-x]==0):
                office[i][j-x]=7

    elif(four_max == four_c):
        for x in range(1,N):
            if i+x>N-1 or office[i+x][j]==6:
                break
            if(office[i+x][j]==0):
                office[i+x][j]=7
        for x in range(1,M):
            if j+x>M-1 or office[i][j+x]==6:
                break
            if(office[i][j+x]==0):
                office[i][j+x]=7
        for x in range(1,M):
            if j-x<0 or office[i][j-x]==6:
                break
            if(office[i][j-x]==0):
                office[i][j-x]=7

    elif(four_max == four_d):
        for x in range(1,N):
            if i-x<0 or office[i-x][j]==6:
                break
            if(office[i-x][j]==0):
                office[i-x][j]=7
        for x in range(1,M):
            if j+x>M-1 or office[i][j+x]==6:
                break
            if(office[i][j+x]==0):
                office[i][j+x]=7
        for x in range(1,M):
            if j-x<0 or office[i][j-x]==6:
                break
            if(office[i][j-x]==0):
                office[i][j-x]=7

def five(i,j):
    
    for x in range(1,N):
        if i+x>N-1 or office[i+x][j]==6:
            break
        if(office[i+x][j]==0):
            office[i+x][j]=7
  
    for x in range(1,N):
        if i-x<0 or office[i-x][j]==6:
            break
        if(office[i-x][j]==0):
            office[i-x][j]=7
     
    for x in range(1,M):
        if j+x>M-1 or office[i][j+x]==6:
            break
        if(office[i][j+x]==0):
            office[i][j+x]=7
 
    for x in range(1,M):
        if j-x<0 or office[i][j-x]==6:
            break
        if(office[i][j-x]==0):
            office[i][j-x]=7

    


for i in range(N):
    for j in range(M):
        if office[i][j]==1:
            one(i,j)
        elif office[i][j]==2:
            two(i,j)
        elif office[i][j]==3:
            three(i,j)
        elif office[i][j]==4:
            four(i,j)
        elif office[i][j]==5:
            five(i,j)


cnt=0
for i in range(N):
    for j in range(M):
        if office[i][j]==0:
            cnt+=1
print(cnt)
