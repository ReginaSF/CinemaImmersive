package CinemaIntelligent;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class CinemaServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
            .addService(new CinemaImmersiveService())
            .build();

        server.start();
        System.out.println("Server for >CinemaImmersive< started, listening on " + 50051);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Runtime error UPS!");
            if (server != null) {
                server.shutdown();
            }
            System.err.println("Server DOWN X_x");
        }));

        server.awaitTermination();
    }

    static class CinemaImmersiveService extends CinemaImmersiveGrpc.CinemaImmersiveImplBase {
        @Override
        public void activateHeating(ActivateRequest req, StreamObserver<ActivateResponse> responseObserver) {
            ActivateResponse reply = ActivateResponse.newBuilder()
                .setMessage("Seat heating has been updated: " + req.getName())
                .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
