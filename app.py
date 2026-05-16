from flask import Flask, request, jsonify
import joblib
import numpy as np

app = Flask(__name__)

# Load the trained model
model = joblib.load(r'C:\Users\User\Desktop\Theory\fraud_detection_model.pkl')

@app.route('/predict', methods=['POST'])
def predict():
    try:
        data = request.get_json()
        features = data['features']
        features_array = np.array(features).reshape(1, -1)
        prediction = model.predict(features_array)[0]
        probability = model.predict_proba(features_array)[0][1]
        
        return jsonify({
            'isFraud': bool(prediction),
            'confidence': round(float(probability), 4),
            'message': 'Fraud detected' if prediction == 1 else 'Transaction is normal'
        })
    
    except Exception as e:
        return jsonify({'error': str(e)}), 400

@app.route('/health', methods=['GET'])
def health():
    return jsonify({'status': 'running'})

if __name__ == '__main__':
    app.run(port=5000, debug=True)