def comprimento(lista):
    if lista==[]:
        return 0    
    
    return 1 + comprimento(lista[1:])

def main():
    l1=[2,3,4,5,7]
    print (comprimento(l1))

main()