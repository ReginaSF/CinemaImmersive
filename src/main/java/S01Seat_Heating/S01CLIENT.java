package S01Seat_Heating;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


import java.util.Scanner;
public class S01CLIENT {
	// private static CinemaImmersiveGrpc.CinemaImmersiveBlockingStub blockingStub;
   // private static CinemaImmersiveGrpc.CinemaImmersiveStub asyncStub;
    public static void main(String[] args) {
        //Here the 
        ManagedChannel channel = ManagedChannelBuilder.forAddress("HostIdServer01", 9090)
            .usePlaintext() 
            .build();

        // The cinema stub will work under synchronous calls
        CinemaImmersiveGrpc.CinemaImmersiveBlockingStub stub = CinemaImmersiveGrpc.newBlockingStub(channel);
        try (Scanner scanner = new Scanner(System.in)) { //scanner to ask the end user if wants to use the heating:
            System.out.print("Activate seat heating? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if ("yes".equals(input)) {  // Setting the request 
                ActivateRequest request = ActivateRequest.newBuilder()
                    .setName("Seat")  
                    .build();
                ActivateResponse response = stub.activateHeating(request);//Updating the service as per the user request
                System.out.println(response.getMessage());
            } else {
                System.out.println("Seat heating was not activated.");
            }
        } catch (StatusRuntimeException e) {
            //EXCEPTIONS
            System.err.println("RPC failed: " + e.getStatus());
            e.printStackTrace();
        } finally {
            // Shut down the channel
            channel.shutdown();
        }
    }
}