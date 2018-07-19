# efikaNotification

```javaScript
  //Realizar a conexão
  var socket = new WebSocket('ws://{LocalSocket}/socket');
 
			//Evento para conexão realizada com sucesso
			socket.onopen = function() {
			  console.log('WebSocket connection opened.');
			 
			  //Enviar mensagem para o servidor
			  socket.send('matricula:aaaaa');
			};
			 
			//Cria um ouvinte para mensagens do servidor
			socket.onmessage = function(message) {
			  console.log(mensagem);
			};
 ```
