# hazelcast-distributed-caching
Distributed caching showcase with hazelcast written in java using SpringBoot. 
Endpoint uses cache, which means that values (in this case User objects) are stored in cache - check UserServiceImpl.java for more details.

## Usage
Application available on: http://localhost:8081/api/hazelcast
- /{id} : GET
- /user : POST
- /     : DELETE

## Prequences
- git clone https://github.com/timv5/hazelcast-distributed-caching.git
- Installed: Docker (docker compose)
- Maven, Java - no need just for running

## Run the application
In a root directory execute: docker-compose -f docker-compose up -d
