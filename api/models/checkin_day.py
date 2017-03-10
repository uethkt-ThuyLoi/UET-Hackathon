from mongoengine import *

class CheckinClass(Document):
    name=StringField()
    date=StringField()
    students=ListField()