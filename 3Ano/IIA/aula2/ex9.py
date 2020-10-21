def check(lista, n):
    return lambda x : lista[0]==n

def menor(lista, ordem):
    
    if len(lista) ==1:
        return lista[0]

    m=menor(lista[1:],ordem)
    if ordem(lista[0],m):
        return lista[0]
    else:
            return m

def main():
    l= [4,1,5,8]
    print(menor(l,lambda x,y: x<y))

if __name__  == "__main__":
    main()