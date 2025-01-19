import nltk
from nltk.sentiment import SentimentIntensityAnalyzer

# Descargar recursos necesarios
try:
    nltk.download('punkt')
    nltk.download('punkt_tab')
    nltk.download('vader_lexicon')
except Exception as e:
    print(f"Error al descargar recursos: {e}")

# Verificar si el recurso 'punkt' está disponible
try:
    nltk.data.find('tokenizers/punkt')
except LookupError:
    nltk.download('punkt')

# Texto de prueba
text = "The system crashes frequently. This is a critical issue!"

# Tokenización alternativa
try:
    from nltk.tokenize import word_tokenize
    tokens = word_tokenize(text)
    print("Tokens:", tokens)
except Exception as e:
    print(f"Error con word_tokenize, usando split: {e}")
    tokens = text.split()
    print("Tokens (con split):", tokens)

# Análisis de sentimientos
try:
    sia = SentimentIntensityAnalyzer()
    sentiment = sia.polarity_scores(text)
    print("Sentiment Analysis:", sentiment)
except Exception as e:
    print(f"Error con SentimentIntensityAnalyzer: {e}")
