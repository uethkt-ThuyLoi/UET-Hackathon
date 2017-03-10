from flask import Flask
import mlab
from flask_restful import Api
from resources.user_resource import *
from resources.checkin_resource import *


mlab.connect()

app = Flask(__name__)

api = Api(app)
api.add_resource(UserRegister,"/register")
api.add_resource(UserLogin,"/login")
api.add_resource(Checkin,"/checkin")

if __name__ == '__main__':
    app.run()
