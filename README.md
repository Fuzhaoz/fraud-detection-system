Fraud Detection System
A banking transaction fraud detection system integrating Machine Learning with a Spring Boot REST API for real-time fraud prediction.
Tech Stack

Backend: Java 17, Spring Boot 3, Spring Security
ML Service: Python, Flask, Scikit-learn (Random Forest)
API Docs: Swagger UI / OpenAPI 3
Build: Maven

System Architecture
Client → Spring Boot API (Port 8080) → Python Flask (Port 5000) → Random Forest Model

API Endpoint
Swagger UI: http://localhost:8080/swagger-ui/index.html
POST /api/transactions/predict
Authorization: Basic Auth (admin / fraud123)

Request:
{
"features": [-1.3598071, -0.0727812, 2.5363467, 1.3781552,
    -0.3383208, 0.4623878, 0.2395986, 0.0986979,
    0.3637870, 0.0908006, -0.5515995, -0.6178009,
    -0.9913898, -0.3111694, 1.4681770, -0.4704005,
    0.2079708, 0.0257906, 0.4039936, 0.2514121,
    -0.0183068, 0.2778376, -0.1104838, 0.0669281,
    0.1285394, -0.1891148, 0.1335584, -0.0210531,
    149.62]
}

Response:
{
  "fraud": true,
  "confidence": 0.98,
  "message": "Fraud detected"
}

Future Improvements

JWT authentication
PostgreSQL for transaction history
AWS cloud deployment
Docker containerisation
Explainable AI (SHAP)
