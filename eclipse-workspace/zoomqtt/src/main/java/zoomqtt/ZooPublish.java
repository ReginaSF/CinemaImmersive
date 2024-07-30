package zoomqtt;
import java.time.LocalDateTime;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class ZooPublish {

	private static MqttClient sampleClientZOO ;


	public static void main(String[] args) {

		int qos = 2;

		String broker = "tcp://localhost:1883";
		String clientId = "Publisher";

		MemoryPersistence persistence = new MemoryPersistence();

		try {

			sampleClientZOO = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();

			//if cleanSession is true before connecting the client, 
			//then all pending publication deliveries for the client are removed 
			//when the client connects.
			connOpts.setCleanSession(true);

			connOpts.setKeepAliveInterval(180);
			
			//connOpts.setUserName("");
			//connOpts.setPassword("");
			
			/*
			 * connect
			 */
			System.out.println("HERE WE ARE CONNECTING TO THIS BROKER_: " + broker);
			sampleClientZOO.connect(connOpts);
			System.out.println("CONNECTED TO THE BROKER SUCCESFULLY!!! HAPPY DAYS!");


			/*
			 * sending messages
			 */

			publishMessage("/HABITAT/CEILING LIGHTS", LocalDateTime.now()+ "--- CHECK LIGHTS ON LIONS SECTION ---", 2, false);

			publishMessage("/ZONE/SIGNS LIGHTS", LocalDateTime.now()+ "LIONS SIGN DOOR IS BLINKING", 1, false);

			publishMessage("/DEVICE APP ZOO",LocalDateTime.now() + "APP ACTION REQUIRED", 1, false);

			publishMessage("/ZOO PARKING/PARKING PAYMENT DEVICE", LocalDateTime.now() + "PARKING BARRIER BLOCKED !!", 1, false);

			/*
			 * disconnect
			 */        		   
			sampleClientZOO.disconnect();

			System.out.println("Disconnected From Zoo :) good bye!!!");
			
			sampleClientZOO.close();
	        
			System.exit(0);

		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc-msg " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("exception " + me);
			me.printStackTrace();
		}

	}

	private static void publishMessage(String topic, String payload, int qos, boolean retained) {

		System.out.println("Publishing message: " + payload + " on topic "+ topic );            

		MqttMessage messagezoo = new MqttMessage(payload.getBytes());
		messagezoo.setRetained(retained);
		messagezoo.setQos(qos);     

		try {

			sampleClientZOO.publish(topic, messagezoo);

		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc-msg " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("exception " + me);
			me.printStackTrace();
		}

		System.out.println("Message published for zoo :) ");


	}

}
