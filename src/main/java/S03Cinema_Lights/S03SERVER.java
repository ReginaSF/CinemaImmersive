package S03Cinema_Lights;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

import S02Seat_Water.S02SeatWaterGrpc;


public class S03SERVER extends CinemaLightsServiceGrpc.CinemaLightsServiceImplBase {
    public static void main(String[] args) { 
        Server server = ServerBuilder.forPort(1024)
            .addService(new CinemaLightsServiceImpl())
            .build();
        try {
        server.start(); //Initializing the server 
            System.out.println("Server_Lights_Cinema is working on Port: " + server.getPort());
            server.awaitTermination();
                   server.awaitTermination();  // Keep the server running
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Service implementation
    static class CinemaLightsServiceImpl extends CinemaLightsServiceGrpc.CinemaLightsServiceImplBase {
        @Override
        public StreamObserver<LightsRequest> controlLights(StreamObserver<LightsResponse> responseObserver) {
            return new StreamObserver<LightsRequest>() {
                @Override
                public void onNext(LightsRequest request) {
                    String roomNumber = request.getRoomNumber();
                    String command = request.getCommand();
                    String status;

                    if ("activate".equalsIgnoreCase(command)) {
                        status = "Lights on in room " + roomNumber;
                    } else if ("turn off".equalsIgnoreCase(command)) {
                        status = "Lights off in room " + roomNumber;
                    } else {
                        status = "Unknown command in room " + roomNumber;
                    }

                    // Send response back to the client
                    LightsResponse response = LightsResponse.newBuilder().setStatus(status).build();
                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable t) {
                    // Handle error
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    // Complete the response
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
