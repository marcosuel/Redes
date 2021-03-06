from socket import *
import sys

HOST = 'localhost'
PORT = 5555
ender = HOST, PORT
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(ender)
serverSocket.listen(100)

while True:
	print ('Ready to serve...')
	connectionSocket, addr = serverSocket.accept()
	try:
		message =  connectionSocket.recv(1024)
		filename = message.split()[1]
		f = open(filename[1:])
		outputdata = f.read()

		connectionSocket.send("HTTP/1.1 200 OK\r\n\r\n".encode())
 
		for i in range(0, len(outputdata)):  
			connectionSocket.send(outputdata[i].encode())
		connectionSocket.send("\r\n".encode())
		
		connectionSocket.close()

	except IOError:
		connectionSocket.send("HTTP/1.1 404 Not Found\r\n\r\n".encode())
		connectionSocket.send("<html><head></head><body><h1>404 Not Found</h1></body></html>\r\n".encode())
		connectionSocket.close()

serverSocket.close()
sys.exit()
 

