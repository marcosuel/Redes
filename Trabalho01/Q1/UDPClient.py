from socket import *
from time import *

HOST = 'localhost'
PORT = 12000

clientSocket = socket(AF_INET, SOCK_DGRAM)
dest = (HOST, PORT)

message = 'OK...'

for i in range(1, 11):
	time_start = time()
	hora = localtime()
	clientSocket.sendto(str.encode(message), dest)
	clientSocket.settimeout(1)
	try:
		response, serverAddress = clientSocket.recvfrom(1024)
		time_end = time()
		total_time = time_end - time_start
		#devemos converter a mensagem de volta para string antes de imprimí-la
		response = bytes.decode(response)
		print('Ping '+str(i)+' '+strftime('%H:%M:%S', hora))
		print(response)
		print('Tempo de resposta: '+str(total_time))
		pass
	#exceção para quando o servidor demorar mais de 1 segundo para responder
	except timeout as e:
		print('Ping '+str(i)+' '+strftime('%H:%M:%S', hora))
		print('Solicitação expirada')
		pass
	pass
#fecha conexão
clientSocket.close()
