kafka-publisher
Apache Kafka Publisher Example using SpringBoot

start zookeeper.start bat file like below
.\bin\windows\zookeeper-server-start.bat C:\kafka\config\zookeeper.properties

start kafka server
.\bin\windows\kafka-server-start.bat C:\kafka\config\config\server.properties

Create Topic:
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic TestTopic

Produce a message
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic TestTopic

Consume a message
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic TestTopic