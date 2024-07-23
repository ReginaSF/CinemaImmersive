package S03Cinema_Lights;

import java.util.Scanner;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class S03CLIENT {

    public static void main(String[] args) {
        // Create a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("HostIdServer03", 50053) // Use a valid non-privileged port
            .usePlaintext() // Disable SSL for simplicity
            .build();

        // Create a stub
        CinemaLightsServiceGrpc.CinemaLightsServiceStub asyncStub = CinemaLightsServiceGrpc.newStub(channel);

        // Create a response observer
        StreamObserver<LightsResponse> responseObserver = new StreamObserver<LightsResponse>() {
            @Override
            public void onNext(LightsResponse response) {
                // Print the response from the server
                System.out.println(response.getStatus());
            }

            @Override
            public void onError(Throwable t) {
                // Handle error
                System.err.println("Error occurred: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // Do something when the stream is completed
                System.out.println("Changes are applied - cinema lights updated.");
            }
        };

        // Create a client request observer
        StreamObserver<LightsRequest> ClientReq = asyncStub.controlLights(responseObserver);

        // Use Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                // Get room number from user
                System.out.print("Enter cinema hall number: ");
                String roomNumber = scanner.nextLine();

                // Get command from user
                System.out.print("Enter instruction (activate/turn off): ");
                String command = scanner.nextLine();

                // Send request to the server
                ClientReq.onNext(LightsRequest.newBuilder().setRoomNumber(roomNumber).setCommand(command).build());

                // Check if the user wants to exit
                System.out.print("Do you want to check another cinema room? (yes/no): ");
                String anotherCommand = scanner.nextLine();
                if (!anotherCommand.equalsIgnoreCase("yes")) {
                    break;
                }
            }

            // Mark the end of requests
            ClientReq.onCompleted();

            // Sleep for a while to let the responses be printed
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the channel and close the scanner
            channel.shutdown();
            scanner.close();
        }
    }
}


 
