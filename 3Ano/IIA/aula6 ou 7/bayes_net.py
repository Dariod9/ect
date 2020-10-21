from itertools import product
import pprint

class BayesNet:

    def __init__(self, ldep=None):  # Why not ldep={}? See footnote 1.
        if not ldep:
            ldep = {}
        self.dependencies = ldep

    # Os dados estao num dicionario (var,dependencies)
    # em que as dependencias de cada variavel
    # estao num dicionario (mothers,prob);
    # "mothers" e' um frozenset de pares (mothervar,boolvalue)
    def add(self,var,mothers,prob):
        self.dependencies.setdefault(var,{})[frozenset(mothers)] = prob

    # Probabilidade conjunta de uma dada conjuncao 
    # de valores de todas as variaveis da rede
    def jointProb(self,conjunction):
        prob = 1.0
        for (var,val) in conjunction:
            for (mothers,p) in self.dependencies[var].items():
                if mothers.issubset(conjunction):
                    prob*=(p if val else 1-p)
        return prob


    def individualProb(self, var, val):
        pp = pprint.PrettyPrinter(indent=4)
        all_conjunctions = [c for c in self._gen_conjunctions(list(self.dependencies.keys())) if (var,val) in c]
#        valores= [c for c in self._gen_conjunctions(list(self.dependencies.))]
        pp.pprint(all_conjunctions)
        
        return sum([self.jointProb(c) for c in all_conjunctions])

    def _gen_conjunctions(self, variables):
        if len(variables)==1:
            return [[(variables[0],True)], [(variables[0],False)]]
        
        l=[]
        for c in self._gen_conjunctions(variables[1:]):
            l.append(c + [(variables[0],True)])
            l.append(c + [(variables[0],False)])
        return l
        
    
    def product(*args, **kwds):
    # product('ABCD', 'xy') --> Ax Ay Bx By Cx Cy Dx Dy
    # product(range(2), repeat=3) --> 000 001 010 011 100 101 110 111
        pools = map(tuple, args) * kwds.get('repeat', 1)
        result = [[]]
        for pool in pools:
            result = [x+[y] for x in result for y in pool]
        for prod in result:
            yield tuple(prod)

# Footnote 1:
# Default arguments are evaluated on function definition,
# not on function evaluation.
# This creates surprising behaviour when the default argument is mutable.
# See:
# http://docs.python-guide.org/en/latest/writing/gotchas/#mutable-default-arguments

