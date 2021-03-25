import xmltodict
from lxml import etree
from math import *

from django.shortcuts import render
from django.http import HttpResponse
from datetime import datetime


# Create your views here.
def cursos(request):
    root = etree.parse("app/cursos.xml")

    info = dict()

    pa = root.xpath('//curso')
    for a in pa:
        info[a.find('guid').text] = a.find('nome').text

    tparams = {
        'cursos': info
    }
    return render(request, 'page.html', tparams)


def cursosI(request, guid):
    input="xquery <root>{ for $a in collection('cursos')//curso return <elem> {$a/guid} {$a/nome} </elem> }</root>"
    query = session.execute(input)

    #root = etree.parse("app/cursos.xml")
    res = xmltodict.parse(query)

    info = dict()
    arr = dict()
    depas = []
    areas = []

    pa = root.xpath('//curso')
    for a in pa:

        if a.find('guid').text == str(guid):

            arr["GUID"] = a.find('guid').text
            arr["Nome"] = a.find('nome').text
            arr["Codigo"] = a.find('codigo').text
            arr["Grau"] = a.find('grau').text

            dep = a.find('departamentos')

            deps = dep.findall('departamento')
            for d in deps:
                depas.append(d.text)

            arr["Departamentos"] = depas

            areaHelp = a.find('areascientificas')
            areas1 = areaHelp.findall('areacientifica')
            for ar in areas1:
                areas.append(ar.text)

            arr["Local"] = a.find('local').text

            arr["Areas"] = areas

            # info[a.find('guid').text] = arr

    tparams = {
        'cursos': arr
    }
    return render(request, 'curso.html', tparams)


def tipo_val(request, tipo, valor):
    root = etree.parse("app/cursos.xml")

    info = dict()
    listaC = []

    pa = root.xpath('//curso')
    for a in pa:

        if tipo == "Departamentos":
            dep = a.find('departamentos')
            deps = dep.findall('departamento')
            for d in deps:
                if d.text == valor:
                    listaC.append(a.find('nome').text)
            info[valor] = listaC

        elif tipo == "Grau":
            if a.find('grau').text == valor:
                listaC.append(a.find('nome').text)
            info[valor] = listaC

        elif tipo == "Local":
            if a.find('local').text == valor:
                listaC.append(a.find('nome').text)
            info[valor] = listaC

        elif tipo == "Areas":
            dep = a.find('areascientificas')
            deps = dep.findall('areacientifica')
            for d in deps:
                if d.text == valor:
                    listaC.append(a.find('nome').text)
            info[valor] = listaC

    tparams = {
        'cursos': info
    }
    return render(request, 'dep.html', tparams)


def tipo(request, tipo):

    if tipo.isnumeric():
        return cursosI(request, tipo)

    file = ""
    cat = ""
    if tipo == "Departamentos":
        file = "app/departamentos.xml"
        cat = "//departamento"
    elif tipo == "Areas":
        file = "app/areas.xml"
        cat = "//area"

    root = etree.parse(file)

    info = dict()
    lista = []

    pa = root.xpath(cat)
    for a in pa:
        lista.append(a.find('nome').text)

    info[tipo] = lista

    tparams = {
        'cursos': info
    }
    return render(request, 'dep.html', tparams)

# def graus(request, grau):
#     root = etree.parse("app/cursos.xml")
#
#     info = dict()
#     listaC = []
#
#     pa = root.xpath('//curso')
#     for a in pa:
#         if a.find('grau').text == str(grau):
#             listaC.append(a.find('nome').text)
#
#         info[grau] = listaC
#
#     tparams = {
#         'cursos': info
#     }
#     return render(request, 'graus.html', tparams)
#
#
# def departs(request, departa):
#     root = etree.parse("app/cursos.xml")
#
#     info = dict()
#     listaC = []
#
#     pa = root.xpath('//curso')
#     for a in pa:
#         dep = a.find('departamentos')
#         deps = dep.findall('departamento')
#         for d in deps:
#             if d.text == departa:
#                 listaC.append(a.find('nome').text)
#
#     info[departa] = listaC
#
#     tparams = {
#         'cursos': info
#     }
#     return render(request, 'dep.html', tparams)
#
#
# def areas(request, area):
#     root = etree.parse("app/cursos.xml")
#
#     info = dict()
#     listaC = []
#     listaC.append(area)
#     pa = root.xpath('//curso')
#     for a in pa:
#         dep = a.find('areascientificas')
#         deps = dep.findall('areacientifica')
#         for d in deps:
#             if d.text == area:
#                 listaC.append(a.find('nome').text)
#
#     info[area] = listaC
#     info["TESTE"] = area
#
#     tparams = {
#         'cursos': info
#     }
#     return render(request, 'areas.html', tparams)
