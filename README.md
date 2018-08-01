This application sends messages to a kafka topic.

Build the Jar : gradle clean build fatjar -x test

Run the application :

java -jar <jarForApplication> <topicName>

We need to pass 1 command line arguement : topicName when starting the application.

Ex : java -jar build/2419060/kafka-producer-2419060-all-1.0-SNAPSHOT.jar hari

After you start the application, you can start sending messages by typing in the console - these messages will be sent to the kafka topic specified as
command line argument.