def sig(n):
    i=lambda x: x>0
    return i(n)

def main():
    print(sig(3))
    print(sig(-4))
    print(sig(0))


main()