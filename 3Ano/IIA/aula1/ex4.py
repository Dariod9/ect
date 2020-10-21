def conc(lista,lista2):
    if lista==[] and lista2==[]:
        return lista

    if lista2==[]:
        return lista

    lista.append(lista2[0])
    return conc(lista,lista2[1:])

def main():
    l1=[2,3,4,5]
    l2=[6,7,8,9]
    print(conc(l1,l2))

main()