from mongoengine import *


class User(Document):
    name=StringField()
    password=StringField()
