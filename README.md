# CLient-server STOMP messenger
This application consists of two main parts:
* Server
  >Server application implemented in *Java* using a *Spring framework* and implements message forwarding to the client via a websocket connection via *Streaming Text Oriented Messaging Protocol (STOMP)*.
* Client
  >Client application is an *HTML* page designed using the *Bootstrap 4* framework and executing a *JS* connection script.
## Server application
### Get start
The server application has been compiled into a *Docker image* so that it can be run anywhere. The image is available at the link [Docker Hub](https://hub.docker.com/repository/docker/krony/server/general "Server Image")
