def juntar(lista,lista2):
    if len(lista)!=len(lista2) :
        return None

    if lista==[]:
        return lista
    

    a1,b1=lista[0],lista2[0]
    return [(a1,b1)]+juntar(lista[1:],lista2[1:])


def main():
    l1=[1,2,3,4]
    l2=[5,6,7,8]
    print(juntar(l1,l2))

main()