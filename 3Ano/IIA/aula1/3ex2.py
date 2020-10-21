def cauda(lista):
    if lista==[]:
        return None
    
    return lista[1:]

def main():
    l=[1,2,3,4]
    print(cauda(l))

main()