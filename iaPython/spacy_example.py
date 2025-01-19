import spacy


try:

# Intentar cargar el modelo de SpaCy

nlp = spacy.load("en_core_web_sm")

except OSError:

print("El modelo de SpaCy no está instalado. Descárgalo ejecutando:")

print("python -m spacy download en_core_web_sm")

exit()


# Texto de prueba

text = "The login button is not functioning as expected."


# Procesar el texto

doc = nlp(text)


# Identificar entidades y palabras clave

print("Entities:")

for ent in doc.ents:

print(f" - {ent.text} ({ent.label_})")


print("\nTokens:")

for token in doc:

print(f" - {token.text}: {token.pos_} ({token.dep_})")