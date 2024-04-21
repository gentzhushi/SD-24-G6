from temp import permutation_cipher

# inputi
key = input("Sheno celesin [Numra]: ")
message = input("Sheno plain text: ")
print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")

encrypted = permutation_cipher(message, key)
print("Teksti i Enkriptuar:\n>>>" + encrypted)

decrypted = permutation_cipher(encrypted, key, decrypt=True)
print("Teksti i Dekriptuar:\n>>>" + decrypted)