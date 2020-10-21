def sum(lista):
    if lista==[]:
        return 0

    return lista[0] + sum(lista[1:])

def main():
    l1=[2,3,4,5]
    print(sum(l1))

main()