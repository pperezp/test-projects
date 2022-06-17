"""
pip install fastapi
yay -S uvicorn
uvicorn main:app --reload
pip install SQLAlchemy
"""
from fastapi import FastAPI, Request
from routes import ClientRouter

app = FastAPI()

app.include_router(ClientRouter.api_router)


@app.middleware("http")
async def middle(request: Request, call_next):
    response = await call_next(request)
    print("Hola!")
    return response
