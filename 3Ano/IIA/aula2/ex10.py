def menor_e_remove(lista, ordem):
    if len(lista) ==1:
        return lista[0],[]
    
    m,l = menor_e_remove(lista[1:],ordem)
    
    if ordem(lista[0],m):
        return lista[0],[m]+l
    else:
        return m, [lista[0]]+l


def main():
    l=[-2,-4,2,-8,4,7,3]
    print(menor_e_remove(l, lambda x,y: x<y))

main()