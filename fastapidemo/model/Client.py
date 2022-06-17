from typing import Optional
from pydantic import BaseModel


class Client(BaseModel):
    id: int
    name: str
    address: Optional[str]