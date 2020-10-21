import math

def pol(n,n2):
    i=lambda x,y: math.hypot(x,y)
    teta= lambda x,y: math.atan2(x,y)
    return (i,teta)

def main():
    print(pol(3,2))
    print(pol(4,6))
    print(pol(0,-1))


main()