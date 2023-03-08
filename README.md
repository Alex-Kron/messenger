# Client-server STOMP messenger
This application consists of two main parts:
* Server
  >Server application implemented in *Java* using a *Spring framework* and implements message forwarding to the client via a websocket connection via *Streaming Text Oriented Messaging Protocol (STOMP)*.
* Client
  >Client application is an *HTML* page designed using the *Bootstrap 4* framework and executing a *JS* connection script.
## Server application
### Get start
The server application has been compiled into a *Docker image* so that it can be run anywhere. The image is available at the link [Docker Hub](https://hub.docker.com/repository/docker/krony/server/general "Server Image").  
First of all download the image from docker hub:
```console
docker pull krony/server:latest
```
Than create and run the container:
```console
docker run -it -p 7171:7171 krony/server:latest
```
>**Note:** Binding port *7171* is mandatory, otherwise the server will not be able to communicate with the client. The parameter **-it** is required to send custom messages from the server.
### Sending custom messages
The server is able to send custom messages to its subscribers. To send a message, you need to run the following command in the server shell console:
```console
shell:>send -m "<Some message>"
```
>**Note:** If the shell does not appear, press *Enter* several times

The client will receive this message if it is connected to the server.
## Client application
### Get start
The html page can be launched using any browser. 
>**Note:** The browser must be allowed to execute JS scripts.
To start chatting, you need to switch the toggle to the "Connected" state. If the message *"SUCCESSFUL SUBSCRIBE"* was received from the server, then the connection to the server was successfully established and you can start chatting.
