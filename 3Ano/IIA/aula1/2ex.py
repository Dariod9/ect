def split(lista):
    if lista==[] :
        return [],[]

    a1,b1=lista[0]
    l1,l2=split(lista[1:])
    return [a1]+l1, [b1]+l2


def main():
    l1=[[1,5],[2,6],[3,7]]
    print(split(l1))

main()