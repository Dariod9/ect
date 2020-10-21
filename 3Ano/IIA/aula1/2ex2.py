def remCount(lista,num):
    if lista==[]: 
        return lista,0

    l,c=remCount(lista[1:],num)

    if lista[0]==num:
        return l,c+1
    else:
        return [lista[0]]+l,c


def main():
    l1=[1,2,3]
    print(remCount(l1,2))

main()