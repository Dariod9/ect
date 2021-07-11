from cryptography . hazmat . primitives import hashes
from cryptography . hazmat . primitives import serialization
from cryptography . hazmat . primitives . asymmetric import padding
from cryptography . hazmat . backends import default_backend

def main():
    # Load key pair to a PEM file protected by a password
    password="pass"
    with open("enc.pem", "rb" ) as kf :
        priv_key = serialization.load_pem_private_key(kf.read(), bytes(password, "utf-8"), default_backend())
    
    pub_key = priv_key.public_key ()

    # Calculate the maximum amount of data we can encrypt with OAEP + SHA256
    maxLen = ( pub_key.key_size // 8) - 2 * hashes . SHA256 . digest_size - 2
    # Read for plaintext no more than maxLen bytes from the input file
    fIn= open("input.txt", "rb")
    plaintext= fIn.read(maxLen)
    # Encrypt the plaintext using OAEP + MGF1 ( SHA256 ) + SHA256
    ciphertext = pub_key.encrypt(plaintext, padding.OAEP(padding.MGF1(hashes.SHA256()), hashes.SHA256(), None))
    # Write ciphertext in the ouput file
    fOut= open("out.txt", "x")
    fOut.write(str(ciphertext))

main()