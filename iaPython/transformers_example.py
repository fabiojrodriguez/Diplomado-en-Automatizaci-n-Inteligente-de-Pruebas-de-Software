from transformers import pipeline

try:
    # Cargar el modelo de análisis de sentimientos
    classifier = pipeline("sentiment-analysis")

    # Texto de prueba
    text = "The new update is amazing! The application works flawlessly."

    # Analizar el sentimiento del texto
    result = classifier(text)
    print("Sentiment Analysis Result:", result)

except Exception as e:
    print(f"Error al ejecutar Transformers: {e}")
