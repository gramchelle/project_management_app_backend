from fastapi import FastAPI
from pydantic import BaseModel
import requests

app = FastAPI()

class MessageRequest(BaseModel):
    user_message: str

@app.post("/chat")
def chat(request: MessageRequest):
    response = requests.post("http://localhost:11434/api/generate", json={
        "model": "mistral",
        "prompt": request.user_message,
        "stream": False
    })
    
    data = response.json()
    return {"bot_response": data['response']}
