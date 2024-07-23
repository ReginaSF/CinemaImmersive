package S02Seat_Water;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class S02CLIENT {

    public static void main(String[] args) {
        // Create a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("HostIdServer02", 8080)
                .usePlaintext()
                .build();

        S02SeatWaterGrpc.S02SeatWaterStub stub = S02SeatWaterGrpc.newStub(channel);

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Do you want to activate the immersive water feature? (yes/no): ");
        String userInput = scanner.nextLine().trim().toLowerCase();

        // Create a request with the user's input
        ActivateRequest request = ActivateRequest.newBuilder()
        		
                .setOn(userInput)
                .build();

        stub.activateWaterImmersiveFeature(request, new StreamObserver<ActivateResponse>() {
       	 CountDownLatch latchWater = new CountDownLatch(1);
        	 @Override
             public void onNext(ActivateResponse response) {
                 System.out.println("Server Response: " + response.getMessage());
             }
        
             @Override
             public void onError(Throwable t) {
                 System.err.println("Error: " + t.getMessage());
                 latchWater.countDown();  // Ensure the latch is counted down in case of error
             }

             @Override
             public void onCompleted() {
                 System.out.println("Server has completed sending responses.");
                 latchWater.countDown();  // Ensure the latch is counted down when completed
             }

        });


         // Clean up resources
         scanner.close();
         channel.shutdown();
     }
 }
