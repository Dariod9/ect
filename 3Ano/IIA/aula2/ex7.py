def quant_any(lista, f):
    #return not in [f(e) for e in lista]

    #return lista == [e for e in lista if f(e)]

def main():
    l= [2,5,8]
    print(quant_any(l,lambda x: x<7))

if __name__  == "__main__":
    main()