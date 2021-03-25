from django.shortcuts import render

# Create your views here.
from simplegraph.simplegraph.simplegraph import *

a = SimpleGraph()
a.load('simplegraph/simplegraph/movies.csv')

def index(request):
    tparams = {}

    return render(request, 'index.html', tparams)

def listarC(request):

    sting = a.triples(None, None, None)
    movies=[]
    for mov in sting:
        print(mov[0])
        print(mov)
        if mov[0] not in movies and 'movie' in mov[0] and 'name' in mov[1]:
            movies.append(mov)

    tparams = {
        'triplos': movies
    }

    return render(request, 'listar.html', tparams)

def realizadorX(request):

    nome= input("Nome do filme: ")

    names=[]
    sting = a.triples(None, 'name', nome)
    for mov in sting:
        print(mov)
        temp= a.triples(mov[0], 'directed_by', None)
        for d in temp:
            print(d)
            names.append(d)

    tparams = {
        'triplos': names
    }

    return render(request, 'listar.html', tparams)

def atoresX(request):

    nome= input("Nome do filme: ")

    names=[]
    sting = a.triples(None, 'name', nome)
    for mov in sting:
        print(mov)
        temp= a.triples(mov[0], 'starring', None)
        for d in temp:
            print(d)
            names.append(d)

    tparams = {
        'triplos': names
    }

    return render(request, 'listar.html', tparams)
