def mo(n,n2):
    i=lambda x: (n*n) < (n2*n2)
    return i(n)

def main():
    print(mo(3,2))
    print(mo(4,6))
    print(mo(0,-1))


main()