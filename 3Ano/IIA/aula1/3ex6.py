def max_min(lista):
    if lista==[] :
        return None
    
    mx, mn = max_min(lista[1:])
    if mx, mn = None, None:
        return lista[0], lista[0]
    if lista[0] > mx:
        return lista[0], mn
    if lista[0] < mn:
        return mx, lista[0]:
    return mx, mn

def main():
    l1=[2,45,7,6,3]
    print(min(l1))

main()