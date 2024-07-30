package generated.ds.examples.maths;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.longrunning.Operation;

import generated.ds.examples.maths.CalculateRequest;
import generated.ds.examples.maths.CalculateResponse;
import generated.ds.examples.maths.ConvertMessage;
import generated.ds.examples.maths.ConvertResponse;
import generated.ds.examples.maths.MathServiceGrpc;
import generated.ds.examples.maths.MathServiceGrpc.MathServiceBlockingStub;
import generated.ds.examples.maths.MathServiceGrpc.MathServiceStub;
import generated.ds.examples.maths.NumberMessage;
import generated.ds.examples.maths.NumberResponse;
import generated.ds.examples.maths.RandomRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


public class MathClient {

	private static MathServiceBlockingStub blockingStub;
	private static MathServiceStub asyncStub;


	public static void main(String[] args) {

		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();

		//stubs -- generate from proto

		// blocking Stub can be used for Unary rpc and for ServerStreaming synchronously
		// client does not process responses until server has completed responding
		blockingStub = MathServiceGrpc.newBlockingStub(channel);

		//non-blocking stub is for asynchronous calls
		//client does not wait for server to complete before starting to read responses
		//must use non-blocking stub for client streaming and bidirectional streaming
		//can also use for Server Streaming asynchronously 
		asyncStub = MathServiceGrpc.newStub(channel);

		// calculate();
		// generateRandomNumbersAsyn();
		// generateRandomNumbersBlocking();		
		// averageValues();
		 convertBase();

	}


	// UNARY RPC
	public static void calculate() {
		
		// set up the two operands and the operation//
		//create a CalculateRequest object with the values of the operands and the operation
		// invoke the service via the stub
		
		int num1 = 10;
		int num2 = 20;
		CalculateRequest.Operation theOperation = CalculateRequest.Operation.ADDITION;
		
		CalculateRequest req = CalculateRequest.newBuilder().setNumber1(num1).setNumber2(num2).setOperation(theOperation).build();
		 // this is unary RPC. We make the request on the blocking stub.
		 // the client gets the response directly like a local method call
		CalculateResponse response = blockingStub.calculate(req);

		System.out.println(LocalTime.now().toString() + ": result: " + response.getResult() + " message: " + response.getMessage());
		
		// Another call to the Calculate service
		 
		 num1 = 5;
		 num2 = 7;
		 theOperation = CalculateRequest.Operation.MULTIPLICATION;
			
		 req = CalculateRequest.newBuilder().setNumber1(num1).setNumber2(num2).setOperation(theOperation).build();
		 // this is unary RPC. We make the request on the blocking stub.
		 // the client gets the response directly like a local method call
		 response = blockingStub.calculate(req);
		 System.out.println(LocalTime.now().toString() + ": result: " + response.getResult() + " message: " + response.getMessage());
		
	}
     
	/* SERVER STREAMING ( BLOCKING) 
     * the client does not start processing the
	 * responses until the server has completed. 
     * We use the blocking stub. 
	 */	
	public static void generateRandomNumbersBlocking() {
		
		// request 5 random numbers between 0 and 100 
		RandomRequest request = RandomRequest.newBuilder()
				.setNumbers(5).setMin(0).setMax(100).build();

		try {
		
			// the blocking stub means that the iterator only returns to the client 
			// after the server has performed onComplete();
			// the client gets the response directly like a local method call
			// the client accesses the responses iterator  and loops through it
			// 
			Iterator<NumberResponse> responses = blockingStub.generateRandomNumbers(request);

			while(responses.hasNext()) {
				NumberResponse temp = responses.next();
				System.out.println(temp.getNumber());				
			}

		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}

	}

	
	/*
	 * SERVER STREAMING ( NON BLOCKING) client can start processing the responses
	 * before the server has completed responding We use the non blocking stub
	 */
    
	public static void generateRandomNumbersAsyn() {
		
		//request 10 random numbers between 0 and 1000
		// 
		RandomRequest request = RandomRequest.newBuilder()
				.setNumbers(10).setMin(0).setMax(1000).build();

        // set up the responseObserver - this is a new object where the client specifies the
		// behaviour to be performed for onNext , onCompleted and onError 
		// the responseObserver is passed to the server when the request is made.
		// The server calls onNext() for each response and onComplete() when its finished responding 
		// The client is able to observe these events via the responseObserver.
		// note that we are calling the same server side method as for the synchronous call  
		// the server behaves the same - the clients reaction to the responses is different - it is 
		// asynchronous
		
		StreamObserver<NumberResponse> responseObserver = new StreamObserver<NumberResponse>() {

			int count =0 ;

			@Override
			public void onNext(NumberResponse value) {
				System.out.println(LocalTime.now().toString() + ": receiving random num " + value.getNumber());
				count += 1;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println(LocalTime.now().toString() + ": stream is completed ... received "+ count+ " rand numbers");
			}

		};

		
		// the client does not have to wait for the server to return - it can just fire off the request and go to sleep.
		asyncStub.generateRandomNumbers(request, responseObserver);

		// the sleep here is optional - its purpose is to slow things down so we can observe what is happening
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * CLIENT STREAMING 
	 * client sends a stream of numbers and when its done the
	 * server sends a response which is the average of all 
	 * the numbers.
	 *
	 */
	  public static void averageValues() {
		
		// set up the responseObserver - this is a new object where the client specifies the
		// behaviour to be performed for onNext() , onCompleted() and onError() 
		// the responseObserver is passed to the server when the interaction is initiated.
		// The server calls onNext() on the response observer when it responds 
		// and onComplete() when its finished responding 
		// 
		// The client is able to observe these events via the responseObserver.
	
		StreamObserver<CalculateResponse> responseObserver = new StreamObserver<CalculateResponse>() {

			@Override
			public void onNext(CalculateResponse msg) {
				System.out.println(LocalTime.now().toString() + ": response from server " + msg.getResult() );
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println(LocalTime.now().toString() + ": stream is completed.");
			}

		};

        // client opens the interaction using the asynchronous stub 
		// the client passes in its responseObserver and gets back a requestObserver 
		// the client sends requests using onNext() method on the requestObserver 
		// 
		StreamObserver<NumberMessage> requestObserver = asyncStub.averageValues(responseObserver);
		try {
			requestObserver.onNext(NumberMessage.newBuilder().setNumber(125).build());
			// here the client sleeps for a bit between each request to slow things down so we can see
			// whats happening
			Thread.sleep(500);

			requestObserver.onNext(NumberMessage.newBuilder().setNumber(112).build());
			Thread.sleep(500);

			requestObserver.onNext(NumberMessage.newBuilder().setNumber(34).build());
			Thread.sleep(500);

			requestObserver.onNext(NumberMessage.newBuilder().setNumber(56.75f).build());
			Thread.sleep(500);

			requestObserver.onNext(NumberMessage.newBuilder().setNumber(34).build());
			Thread.sleep(500);

			requestObserver.onNext(NumberMessage.newBuilder().setNumber(200).build());
			Thread.sleep(500);

			requestObserver.onNext(NumberMessage.newBuilder().setNumber(40).build());
			Thread.sleep(500);

			requestObserver.onNext(NumberMessage.newBuilder().setNumber(85).build());
			Thread.sleep(500);

			requestObserver.onNext(NumberMessage.newBuilder().setNumber(90.25f).build());
			Thread.sleep(500);

			requestObserver.onNext(NumberMessage.newBuilder().setNumber(70).build());
			Thread.sleep(500);


			// tell the server that there are no more requests 
			requestObserver.onCompleted();

			// if the client sleeps now then it will see the server response when it wakes
			// Thread.sleep(10000);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}


	}	
	
	
	// bi-directional streaming
	// client sends a stream of convert requests 
	// server performs each conversion as it gets the request and returns a stream of results
	//rpc convertBase(stream ConvertMessage) returns (stream ConvertResponse ) {}

	public static void convertBase() {
		// set up the responseObserver - this is a new object where the client specifies the
		// behaviour to be performed for onNext() , onCompleted() and onError() 
		// the responseObserver is passed to the server when the interaction is initiated.
		// The server calls onNext() when it responds and onComplete() when its finished responding 
		// 
		// The client is able to observe these events via the responseObserver.

		StreamObserver<ConvertResponse> responseObserver = new StreamObserver<ConvertResponse>() {

			int count =0 ;

			@Override
			public void onNext(ConvertResponse msg) {
				System.out.println(LocalTime.now().toString() + ": received a number " + msg.getNumber() + " base: "+ msg.getBase() );
				count += 1;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println(LocalTime.now().toString()+ ": stream is completed ... received "+ count+ " converted numbers");
			}

		};

		// client opens the interaction using the asynchronous stub
		// the client passes in its responseObserver and gets back a requestObserver
		// the client sends requests using onNext() method on the requestObserver

		StreamObserver<ConvertMessage> requestObserver = asyncStub.convertBase(responseObserver);

		try {
			
			// Client sends messages to the server using onNext() on the requestObserver

			requestObserver.onNext(ConvertMessage.newBuilder().setNumber("100").setFromBase(10).setToBase(2).build());
			requestObserver.onNext(ConvertMessage.newBuilder().setNumber("177").setFromBase(8).setToBase(10).build());
			requestObserver.onNext(ConvertMessage.newBuilder().setNumber("10100010").setFromBase(2).setToBase(10).build());
			requestObserver.onNext(ConvertMessage.newBuilder().setNumber("AF45").setFromBase(16).setToBase(2).build());
			requestObserver.onNext(ConvertMessage.newBuilder().setNumber("AF45").setFromBase(16).setToBase(10).build());


			// Client signals there are no more requests to send 
			requestObserver.onCompleted();


			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);


		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}



		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	



}
