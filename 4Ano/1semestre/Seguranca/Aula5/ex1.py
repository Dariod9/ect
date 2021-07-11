import sys
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

def main(pwd, key_size):
    # Set variables key_size and pwd out of the program arguments
    
    # Use 65537 (2^16 + 1) as public exponent
    priv_key = rsa.generate_private_key(65537, int(key_size) , default_backend ())
    # Save the key pair to a PEM file protected by the password saved in variable pwd
    pem_encoding = priv_key.private_bytes(serialization.Encoding.PEM , serialization.PrivateFormat.PKCS8, serialization.BestAvailableEncryption(bytes(pwd,"utf -8")))
    # Save the contents of pem_encoding in a file
    file1 = open('enc.pem', 'wb')
    file1.write(pem_encoding)

main(sys.argv[1], sys.argv[2])