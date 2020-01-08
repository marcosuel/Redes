from socket import *
import sys

clientSocket = socket(AF_INET, SOCK_STREAM)

host = sys.argv[1]
port = int(sys.argv[2])
file_name = sys.argv[3]

addres = host, port
clientSocket.connect(addres)

request = "GET /"+file_name+" HTTP/1.1\r\n"
clientSocket.send(request.encode())

response = clientSocket.recv(4096)
print(response)
