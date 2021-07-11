from PyKCS11 import *
from PyKCS11.LowLevel import *

def main():
    lib='C:\Windows\System32\pteidpkcs11.dll'
    pkcs11=PyKCS11.PyKCS11Lib()
    pkcs11.load(lib)
    slots=pkcs11.getSlotList()
    for slot in slots:
        print(pkcs11.getTokenInfo(slot))

main()