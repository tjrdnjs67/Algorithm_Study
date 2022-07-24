import sys

if __name__ == "__main__":
    n = int(input())

    nextNum = 1
    tf = True

    li1 = []
    li2 = []

    for _ in range(n):
        val = int(input())

        if  nextNum <= val:
            while val >= nextNum:
                li1.append(nextNum)
                li2.append('+')
                nextNum += 1

            li1.pop()
            li2.append('-')
        else:                        
            if val != li1[-1]:
                tf = False
                break
            else:
                li1.pop()
                li2.append('-')
                
            

    if tf:
        for i in li2:
            print(i)
    else:
        print("NO")
