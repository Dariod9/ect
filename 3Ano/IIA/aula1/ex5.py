def inv(lista):
    if lista==[]:
        return lista

    return [lista[-1]]+inv(lista[:-1])



def main():
    l1=[2,3,4,5]
    l2=[]
    print(inv(l1))

main()