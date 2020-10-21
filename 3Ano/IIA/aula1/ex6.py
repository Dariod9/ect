def cap(lista):
    if lista==[] or len(lista)==1:
        return True

    return lista[0]==lista[-1] and cap(lista[1:-1])



def main():
    l1=[1,2,3]
    print(cap(l1))

main()