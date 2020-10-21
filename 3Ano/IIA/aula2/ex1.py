def imp(n):
    i=lambda x: x%2==1
    return i(n)

def main():
    print(imp(3))
    print(imp(4))
    print(imp(0))


main()