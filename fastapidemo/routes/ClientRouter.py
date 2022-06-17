from fastapi import APIRouter, Response, status

from model.Client import Client

api_router = APIRouter(
    prefix="/api/v1/clients",
    tags=["clients"]
)


@api_router.get("/")
def get_client():
    return Client(id=1, name="Patricio Pérez")


@api_router.get("/{client_id}")
def read_client(client_id: int):
    if client_id == 1:
        client = {
            "id": 1,
            "name": "Patricio Pérez"
        }
        return Client(**client)
    else:
        # https://docs.python.org/3/library/http.html#http.HTTPStatus
        # return Response(status_code = 204)
        return Response(status_code=status.HTTP_204_NO_CONTENT)


@api_router.post("/")
def post_client(client: Client):
    return client
