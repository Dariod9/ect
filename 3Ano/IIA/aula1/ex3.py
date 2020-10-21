def existe(lista,num):
    if lista==[]:
        return False

    if lista[0]==num:
        return True

    return existe(lista[1:],num)

def main():
    l1=[2,3,4,5]
    print(existe(l1,7))

main()