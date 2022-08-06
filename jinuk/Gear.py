while True:
    try:
        gear = [list(map(int,input())) for i in range(4)]
        K=int(input()) #회전횟수
        r=2
        l=6
        for t in range(K):
            num,direction = map(int,input().split())
            arr = [0]*4
            num -=1
            arr[num]=direction
            c = num
            while c+1<4:
                if gear[c][2]!=gear[c+1][6]:
                    arr[c+1]=1
                c+=1
            c=num
            while c-1>-1:
                if gear[c][6]!=gear[c-1][2]:
                    arr[c-1]=1
                c-=1

            
            
            for i in range(4):
                if i<num:
                    if arr[i]==0:
                        for j in range(i):
                            arr[j]=0
                elif i>num:
                    if arr[i]==0:
                        for j in range(i,4):
                            arr[j]=0
            for i in range(4):
                if arr[i]==1:
                    if i==num-1:
                        if direction==1:
                            arr[i]=-1
                        elif direction ==-1:
                            arr[i]=1
                    elif i==num+1:
                        if direction==1:
                            arr[i]=-1
                        elif direction ==-1:
                            arr[i]=1

                    if i==num-2:
                        if direction==1:
                            arr[i]=1
                        elif direction ==-1:
                            arr[i]=-1
                    elif i==num+2:
                        if direction==1:
                            arr[i]=1
                        elif direction ==-1:
                            arr[i]=-1

                    elif i==num-3:
                        if direction==1:
                            arr[i]=-1
                        elif direction==-1:
                            arr[i]=1
                    elif i == num+3:
                        if direction==1:
                            arr[i]=-1
                        elif direction==-1:
                            arr[i]=1
            snum=num
            for i in range(4):
                if snum>3:
                    snum%=4
                direction = arr[snum]
                
                if arr[snum]==1 or arr[snum]==-1:
                    if direction==1:
                        last = gear[snum].pop()
                        gear[snum].insert(0,last)

            

                    elif direction == -1:
                        first = gear[snum].pop(0)
                        gear[snum].append(first)

                snum+=1
        sum=0
        for i in range(4):
            sum += gear[i][0]*(2**i)
        print(sum)

    except Exception:
        break
