n=int(input())
a=1
for i in range(1,n+1):
    a*=i
d=0
a=str(a)
for i in range(len(a)):
    if a[-i-1]=='0':
        d+=1
    else:
        break
print(d)