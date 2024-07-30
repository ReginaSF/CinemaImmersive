package grpc.examples.helloworld;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import grpc.examples.helloworld.GreeterGrpc.GreeterBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class HelloWorldClient {

	private static final Logger logger = Logger.getLogger(HelloWorldClient.class.getName());

		  
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50052;
		
		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		
		GreeterBlockingStub  blockingStub = GreeterGrpc.newBlockingStub(channel);
				
	    HelloWorldClient client = new HelloWorldClient();
	    
	    try {
	    	 String name = "Paul";
	    	 HelloRequest request = HelloRequest.newBuilder().setName(name).build();
	    	 
	    	 HelloReply response = blockingStub.sayHello(request);
	    	 HelloReply response1 = blockingStub.sayGoodbye(request); //aqui cambiamos el metodo to saygoodbye (va el mensaje que enviaremos.)
	    	 
	    	 logger.info("Greeting: " + response.getMessage()+ " GoodBye" +response1.getMessage()); //
	    	 
	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }
	
	
}
