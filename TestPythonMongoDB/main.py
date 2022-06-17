# sudo pip install pymongo

import pymongo

DB_NAME = "bdContactos"
COLLECTION_NAME = "contacto"

mongo = pymongo.MongoClient("mongodb://localhost:27017/")

dblist = mongo.list_database_names()
if DB_NAME in dblist:
    print("The database exists.")

db = mongo[DB_NAME]
contactos = db[COLLECTION_NAME]

while True:
    print("-------------------")
    print("Contactos")
    print("-------------------")
    print("1.- Create")
    print("2.- Read")
    print("3.- Update [PENDIENTE]")
    print("4.- Delete [PENDIENTE]")
    print("5.- Search [NO COMPLETO]")
    print("6.- Exit")
    print("-------------------")

    op = int(input("OP: "))

    if op == 6:
        break

    if op == 1:
        # Create (https://www.w3schools.com/python/python_mongodb_insert.asp)
        '''
        nombre = input("Nombre: ")
        telefono = input("Telefono: ")

        contacto = {
            "nombre": nombre,
            "telefono": telefono
        }'''

        contacto = dict()

        contacto["nombre"] = input("Nombre: ")
        contacto["telefono"] = input("Telefono: ")

        new_contact = contactos.insert_one(contacto)
        print("Nuevo contacto: ",new_contact.inserted_id)

    elif op == 2:
        # Read
        for con in contactos.find():
            print(con["_id"], con["nombre"], con["telefono"])

    elif op == 5:
        # Search
        # REGEX  (https://medium.com/factory-mind/regex-tutorial-a-simple-cheatsheet-by-examples-649dc1c3f285)
        # Querys (https://www.w3schools.com/python/python_mongodb_query.asp)

        # Flag (?i): Case insensitive
        # Queda pendiente el buscar Pérez como perez
        nombre = input("Nombre a buscar: ")

        # filtro = {"nombre":{ "$regex": "(?i)("+nombre+")" }}
        filtro = {"nombre":{ "$regex": nombre, "$options": "i"}

        for con in contactos.find(filtro):
            print(con["_id"], con["nombre"], con["telefono"])