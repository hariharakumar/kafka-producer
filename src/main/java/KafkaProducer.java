import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

public class KafkaProducer {
    private static Scanner in;

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Please specify atleast one topic name for producer to send messages");
            System.exit(-1);
        }

        String topicName = args[0];
        in = new Scanner(System.in);
        System.out.println("Start entering messages - type exit to quit");

        Properties configProperties = new Properties();

        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        Producer kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(configProperties);
        String inputString = in.nextLine();

        while (!inputString.equalsIgnoreCase("exit")) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topicName, inputString);
            kafkaProducer.send(producerRecord);
            inputString = in.nextLine();
        }

        in.close();
        kafkaProducer.close();

    }
}
