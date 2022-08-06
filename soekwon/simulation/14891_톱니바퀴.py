import sys
from collections import deque as dq
#sys.stdin = open("input.txt","rt")

def sumVal():
    sum = 0
    if one[0] == 1:
        sum += 1
    if two[0] == 1:
        sum += 2
    if thr[0] == 1:
        sum += 4
    if four[0] == 1:
        sum += 8

    return sum


def rotation(n, dir):
    if n == 1:
        if li[0] == True:
            turn(n, dir)
        else:
            turn(n,dir)
            turn(n+1,-dir)
            if li[1] == False:
                turn(n+2,dir)
                if li[2] == False:
                    turn(n+3, -dir)

    if n == 2:
        if li[0] == True and li[1] == True:
            turn(n,dir)
        else:
            turn(n,dir)
            if li[0] == False:
                turn(n-1, -dir)
            if li[1] == False:
                turn(n+1, -dir)
                if li[2] == False:
                    turn(n+2, dir)

    if n == 3:
        if li[1] == True and li[2] == True:
            turn(n,dir)
        else:
            turn(n,dir)
            if li[2] == False:
                turn(n+1, -dir)
            if li[1] == False:
                turn(n-1, -dir)
                if li[0] == False:
                    turn(n-2, dir)
    
    if n == 4:
        if li[2] == True:
            turn(n,dir)
        else:
            turn(n,dir)
            turn(n-1, -dir)
            if li[1] == False:
                turn(n-2, dir)
                if li[0] == False:
                    turn(n-3, -dir)
                
    


def turn(n, dir):
    if n == 1 and dir == 1:
        val = one.pop()
        one.appendleft(val)
    elif n == 1:
        val = one.popleft()
        one.append(val)

    if n == 2 and dir == 1:
        val = two.pop();
        two.appendleft(val)
    elif n == 2:
        val = two.popleft()
        two.append(val)

    if n == 3 and dir == 1:
        val = thr.pop();
        thr.appendleft(val)
    elif n == 3:
        val = thr.popleft()
        thr.append(val)

    if n == 4 and dir == 1:
        val = four.pop();
        four.appendleft(val)
    elif n == 4:
        val = four.popleft()
        four.append(val)



if __name__ == "__main__":
    one = list(map(int,input()))
    one = dq(one)
    two = list(map(int,input()))
    two = dq(two)
    thr = list(map(int,input()))
    thr = dq(thr)
    four = list(map(int,input()))
    four = dq(four)

    li = [True, True, True]

    N = int(input())
    sum = 0
    for _ in range(N):
        cog, dir = map(int,input().split())
        
        if one[2] == two[6]:
            li[0] = True
        else:
            li[0] = False

        if two[2] == thr[6]:
            li[1] = True
        else:
            li[1] = False
       
        if thr[2] == four[6]:
            li[2] = True
        else:
            li[2] = False

        rotation(cog, dir)

    print(sumVal())
