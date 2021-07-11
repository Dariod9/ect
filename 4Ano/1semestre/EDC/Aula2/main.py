from lxml import etree
from pip._vendor.distlib.compat import raw_input


def print_menu():
    print("*** MENU ***\n1. Leitura Doc XML\n2. Validar Doc XMl\n3. Mostrar Info Curso\n0. Sair")


def readdocxml():
    root = etree.parse("lei.xml")
    doc = root.getroot()
    print(root)


def validate_doc_xml():
    xmlschema_doc = etree.parse("curso.xsd")
    xmlschema = etree.XMLSchema(xmlschema_doc)
    root = etree.parse("lei.xml")
    doc = root.getroot()
    print(xmlschema.validate(doc))


# def showInfo():


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    x=-1
    while x != 0:
        print_menu()
        x = raw_input("Escolha: ")
        a = x
        if a == "1":
            readdocxml()

        elif a == "2":
            print(x)
            validate_doc_xml()
    # elif (x == 3):
    #
    # elif (x == 0):
