package zoomqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class ZooSuscriber {

    public static void main(String[] args) {

        String broker = "tcp://localhost:1883";
        String clientId = "Subscriber ZOO";
        
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
         
            //if cleanSession is true before connecting the client, 
            //then all pending publication deliveries for the client are removed 
            //when the client connects.
            connOpts.setCleanSession(true);
            
            sampleClient.setCallback(new SampleSubscriber());
            
            System.out.println("Connecting to broker ZOO: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected TO ZOO");
            
            //subscribe to topic
            sampleClient.subscribe("/HABITAT/#");
            
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
}
