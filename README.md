This application sends messages to a kafka topic. Make sure Kafka and zookeper are up and running on the machine we want to run kafka producer.

Instructions for Kafka setup : http://kafka.apache.org/documentation.html#quickstart

Build the Jar : gradle clean build fatjar -x test

Run the application :

java -jar [jarForApplication] [topicName]

We need to pass 1 command line arguement : topicName when starting the application.

Ex : java -jar build/2419060/kafka-producer-2419060-all-1.0-SNAPSHOT.jar hari

After you start the application, you can start sending messages by typing in the console - these messages will be sent to the kafka topic specified as
command line argument.

You can type exit anytime to exit the producer application.