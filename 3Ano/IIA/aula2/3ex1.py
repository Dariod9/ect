
class Value():
    def __init__(self):
        pass
    def value(self):
        return self.v

    def __str__(self):
        return str(self.v)
        


class Constante(Value):
    def __init__(self,c):
        self.v=c

class Variavel(Value):
    def __init__(self):
        pass

    def atribuir(self,e):
        self.v = e.value()

class Soma(Value):
    def __init__(self,e1,e2):
        assert isinstance(e1,Value)
        assert isinstance(e2,Value)

        self.v=e1.value()+e2.value()

#class Produto

def main():
    x=Variavel()
    x.atribuir(Soma(Constante(3),Constante(4)))
    y=Variavel()
    y.atribuir(Constante(4))
    print(Soma(x, y))


main()