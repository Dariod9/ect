def min(lista):
    if lista==[] :
        return None
    
    m=min(lista[1:])
    if m==None or lista[0] < m :
        return lista[0]
    else:
        return m

def main():
    l1=[2,45,7,6,3]
    print(min(l1))

main()