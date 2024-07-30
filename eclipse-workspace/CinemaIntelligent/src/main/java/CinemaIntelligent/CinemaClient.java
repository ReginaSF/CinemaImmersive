package CinemaIntelligent;

import java.util.Scanner;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class CinemaClient {
    private final ManagedChannel channel;
    private final CinemaImmersiveGrpc.CinemaImmersiveBlockingStub blockingStub;

    public CinemaClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = CinemaImmersiveGrpc.newBlockingStub(channel);
    }

    public void shutdown() {
        channel.shutdown();
    }

    public void activateHeating(String name) {
        ActivateRequest request = ActivateRequest.newBuilder().setName(name).build();
        ActivateResponse response;
        try {
            response = blockingStub.activateHeating(request);
            System.out.println("Response: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public static void main(String[] args) {
        CinemaClient client = new CinemaClient("localhost", 50051);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Activate immersive water? (yes or no)");
            String userInput = scanner.nextLine().trim();

            // Use the client's method to activate heating
            client.activateHeating(userInput);
        } finally {
            client.shutdown();
        }
    }
}

