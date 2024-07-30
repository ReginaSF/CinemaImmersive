package generated.ds.examples.maths;


import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

import generated.ds.examples.maths.CalculateRequest;
import generated.ds.examples.maths.CalculateRequest.Operation;
import generated.ds.examples.maths.CalculateResponse;
import generated.ds.examples.maths.ConvertMessage;
import generated.ds.examples.maths.ConvertResponse;
import generated.ds.examples.maths.MathServiceGrpc.MathServiceImplBase;

import generated.ds.examples.maths.NumberMessage;
import generated.ds.examples.maths.NumberResponse;
import generated.ds.examples.maths.RandomRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class MathServer extends MathServiceImplBase {

	public static void main(String[] args) {
		MathServer mathserver = new MathServer();

		int port = 50051;

		try {

			Server server = ServerBuilder.forPort(port)
					.addService(mathserver)
					.build()
					.start();
			
		

			System.out.println(LocalTime.now().toString()+ ": Math Server started, listening on " + port);

			server.awaitTermination();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	

	/* UNARY RPC
	 * client sends two numbers and an operator in the request. The server method also gets input of  a responseObsever
	 * notice that the call from the client does not include this responseObserver - the gRPC framework provides it
	 * this is in contrast with asynchronous RPC types where the client provides the responseObserver and reacts to updates on it
	 * 
	 * the server sends its response using the responseObserver
	 * Server calculates the result and returns it 
	 * rpc calculate(CalculateRequest) returns (CalculateResponse) {}
	 */
	public void calculate(CalculateRequest request, StreamObserver<CalculateResponse> responseObserver) {

		System.out.println("receiving calculate request with values : " + request.getNumber1() +  " " + request.getNumber2() + " " + request.getOperation() );
		
		// extract the operation value from the message to know if we are adding, substracting multiplying or dividing 
		// and then do the calculation
		float theResult;
		String msg = "";
		switch (request.getOperation()) {  
		     case ADDITION:
		       theResult = request.getNumber1() + request.getNumber2();
		       break;
		       
		     case SUBTRACTION:
		    	 theResult = request.getNumber1() - request.getNumber2();
			       break;
			       
		     case MULTIPLICATION:
		    	 theResult = request.getNumber1() * request.getNumber2();
			       break;
			       
		     case DIVISION:
		    	 if (request.getNumber2()== 0) {
		    		 theResult = Float.NaN;
		    		 msg = "Zero divide. No valid result";
		    	 }  
		    	 else {
		    		 theResult = theResult = request.getNumber1() / request.getNumber2();
		    	 }
			     break;  
			       
			 default :
				 theResult = Float.NaN;
				 msg = "Operation is not supported";
				 
	
		      }
		
		// create the response object using its builder method and the set methods for each of its attributes
		
		 CalculateResponse response = CalculateResponse.newBuilder().setResult(theResult).setMessage(msg).build();
	     
		 // respond to the client using onNext() on the responseObserver
		 responseObserver.onNext(response);
	     // tell the client we are done using onComplete() on the responseOberver
	     responseObserver.onCompleted();
	}
	
	
	/*
	 * Server streaming operation. client sends 3 numbers x, y, z - requesting
	 * random numbers within the range y to z .server sends back a stream of
	 * numbers in the range 
	 * rpc generateRandomNumbers(RandomRequest) returns (stream NumberResponse ) {}
	 */
	public void generateRandomNumbers(RandomRequest request,
			StreamObserver<NumberResponse> responseObserver) {

		System.out.println(LocalTime.now().toString() + " : receiving convert request with values : " + request.getNumbers() +  " " + request.getMin() + " " + request.getMax() );
		Random rand = new Random();
		
		int max = request.getMax();
		int min = request.getMin();
		
		
		for (int i=0; i < request.getNumbers(); i++) {
			
			int random_value = rand.nextInt(max - min) + min + 1;
			NumberResponse response = NumberResponse.newBuilder().setNumber(random_value).build();
			responseObserver.onNext(response);
			
			//slow it all down a bit so we can observe the behaviour 
			try {
				//wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// signal that there are no more responses
		responseObserver.onCompleted();
	}
	
	
	// Client streaming operation
	// client sends a stream of numbers 
	// server calculates the average of all the numbers and returns it ( and a message)
	// rpc averageValues(stream NumberMessage) returns (CalculateResponse ) {}

	public StreamObserver<NumberMessage> averageValues(
			StreamObserver<CalculateResponse> responseObserver) {


		// server sets up a new observer that can gather each client request when it sees onNext() and 
		// calculate the average once it sees onCompleted()
		// 
		return new StreamObserver<NumberMessage>() {

			// the observer will collect each number that arrives from the client into this ArrayList
			ArrayList<Float> list = new ArrayList();

			@Override
			// when a new number arrives , put it into the array
			public void onNext(NumberMessage request) {

				System.out.println(LocalTime.now().toString()+ ": received a NumberMessage: "+ request.getNumber()  );

				list.add(request.getNumber());		           

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			// when there are no more messages coming from the client( the client calls onCompleted() on the message stream ) ,
			// calculate the average, 
			// create the response and send to the client via  responseObserver.onNext()
			// as the server is only going to send one response, it also does responseObserver.onCompleted() 

			public void onCompleted() {
				System.out.printf(LocalTime.now().toString() + ": NumberMessage stream complete \n" );

				// System.out.println("mean "+ list.size());

				double temp = 0;	
				for(float v:  list) {
					temp = temp + v;
				}
				float mean = (float) (temp/list.size());

				CalculateResponse reply = CalculateResponse.newBuilder().setResult(mean).build();

				// System.out.println("mean "+ mean);
				responseObserver.onNext(reply);

				responseObserver.onCompleted();

			}

		};


	}
	
	
	// Bi-directional streaming operation
	// client sends a stream of messages
	// server processes each message and returns a response
	
	
	// rpc averageValues(stream NumberMessage) returns (CalculateResponse ) {}


	public StreamObserver<ConvertMessage> convertBase(StreamObserver<ConvertResponse> responseObserver) {
		
		// server sets up a new observer that processes each client request when it sees onNext()  
			  	
		return new StreamObserver<ConvertMessage> () {

			@Override
			public void onNext(ConvertMessage msg) {
				System.out.println(LocalTime.now().toString() + ": receiving convertBase num: "+ msg.getNumber() + " from-base: "+ msg.getFromBase() + " to-base: "+ msg.getToBase()  );
				
				// calculate the result using Integer.parseInt() and Integer.toString()
				String converted =  Integer.toString(Integer.parseInt(msg.getNumber(), msg.getFromBase()), msg.getToBase());
				
				ConvertResponse reply = ConvertResponse.newBuilder().setNumber(converted).setBase(msg.getToBase()).build();
				
				responseObserver.onNext(reply);
				
			}

			@Override
			public void onError(Throwable t) {
				
				t.printStackTrace();
				
			}

			@Override
			public void onCompleted() {
				System.out.println(LocalTime.now().toString() + ": receiving convertBase completed ");
				
				//completed too
				responseObserver.onCompleted();
			}
			
		};
	}

}

