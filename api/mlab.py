import mongoengine

# mongodb://<dbuser>:<dbpassword>@ds127260.mlab.com:27260/user
host = "ds127260.mlab.com"
port = 27260
db_name = "user"
username = "1"
password = "1"


def connect():
    mongoengine.connect(db_name, host=host, port=port, username=username, password=password)


def list2json(l):
    import json
    return [json.loads(item.to_json()) for item in l]


def item2json(item):
    import json
    return json.loads(item.to_json())
