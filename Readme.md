Distributed/ versioned/ Centralized Cong Managamnet - cloud bus
Service Registtry - Eureka/Consuul
Load Balancing - Ribbon
Service to serice calls - FeignClietn
Circuit brakers - Hystrics
Routing - Zuul



-- Consul
open command promt at root of consul
consul agent -dev --http-port 5000

web console - http://localhost:5000/ui/#/dc1/services


-- config server
set up config server, in workspace
 - git URL (https://github.com/krishnamurthypradeep/ConfigData1)
localhost:8888/configprops

-- RabbitMQ server
rabbitmq-plugins enable rabbitmq_management (to enable MQ)

http://localhost:15672


-- Oauth keytool generation

C:\Users\Admin.admin1-PC>keytool -genkeypair -alias b3 -keyalg RSA -dname "CN=b3, L=Blore, S=KA, C=IN" -keypass mySecretKey -keystore jwt.jks -storepass mySecretKey

keytool -list -rfc --keystore jwt.jks | openssl x509 inform pem -pubkey


OAUTH
-----
1. mongodb
2. CloudConfigServer -> @enableConfigServer
3. EurekaServer      -> @EnableEureka
4. OauthServer
	- generateKeyStore
	- KeyStore should be mapped to Application
	- start the OAuth Server
5. Search API-Gateway
	- Configure the login
	- copy the pulblic key
	- start the api-gateway
6. Search Microservice
	- copy the public key
	- start the service


UI
- localhost:8769/sg/oauth/authorize?response_type=code&client_id=sg