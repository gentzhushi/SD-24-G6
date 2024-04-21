import warnings
warnings.filterwarnings("ignore", category=ResourceWarning)
# Pseudo-Kodi per Enkriptim:
# - Kena me nda mesazhin n blloqe t gjata se celesi, celesi duhet me kan string,
#   sipas renditjes t alfabetit t karaktereve t celesit, kena me ja u ndrru vendet
#   karaktereve t secilit bllok t mesazhit.
#     - Per shembull:
#         - Per celesin "BA", fjala "FIEK" do te kthehet ne "IFKE"
#         - Visualizimi:
#             1. FIEK ==> Plaintexti
#             2. FI EK ==> Plaintexti i ndame ne blloqe
#             3.  +---+---+
#                 | B | A | ==> Celesi(Table Header)
#                 +---+---+
#                 | F | I |
#                 +---+---+
#                 | E | K |
#                 +---+---+
#             4.  +---+---+
#                 | A | B | ==> Celesi i Sortum(Table Header)
#                 +---+---+
#                 | I | F |
#                 +---+---+
#                 | K | E |
#                 +---+---+

def permutation_cipher(msg, key, decrypt=False):
    
    # cast to string qelsin
    # key = str(key)
    
    # gjatsia e qelesit/blloqeve
    key_len = len(key)
    
    # deklaro ni empty string per me shku tu e ndertu ka pak
    result = ''

    # boje pad me pjesen mrena thojzave
    msg += 'E' * ((key_len - (len(msg) % key_len)) % key_len)
    """ 
    (key_len - (len(msg) % key_len)) -> e llogarit se sa na vyn per me pad, per lehtesi, po ja lojm ni alias "A"
                         A % key_len -> siguron qe me dal resulti gjithqysh mes 0 edhe key_len-1. 
                                        (sigurohet prej overpadding), Aliasi tash osht "B"
                         msg += 'X' * B -> ja bon append B numer t karaktereve
    """

    # numri i blloqeve = gjatesia e mesazhit te padum / key len 
    # ka me kan gjith integer
    num_blocks = int(len(msg) / key_len)

    # per cdo  bllok
    for i in range(num_blocks):
        # shkoj blloqeve me ren, indeksi 0 i secilit substring ka me kan shumfish i key_len
        start_idx = i * key_len
        block = [x for x in msg[start_idx:(start_idx + key_len)]]

        # ni bllok tri tthat
        new_block = [' '] * key_len

        # ni for loop qe shkon tu iteru basically sikur key => value
        for idx1, idx2 in enumerate(key):
            # indeksi i par osht 0, per qata decrement, gjithashtu bone cast to int se osht string
            idx2 = int(idx2) - 1
            if decrypt:  # nese parametri decrypt, ashtu qpshtjelli charsat
                new_block[idx2] = block[idx1]  # mbishkruje qat bllokun e that qe e deklarum
            else:  # nese jo, pshtjelli
                new_block[idx1] = block[idx2]

        # shko to e ndertu resultin, tu e bo append bllokun e ri
        result += ''.join(new_block)

    return result

# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
