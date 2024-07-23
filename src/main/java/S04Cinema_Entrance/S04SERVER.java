package S04Cinema_Entrance;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.Map;

import S03Cinema_Lights.CinemaLightsServiceGrpc;


public class S04SERVER extends TicketServiceGrpc.TicketServiceImplBase{
	public static void main(String[] args) { 
        Server server = ServerBuilder.forPort(1025)
            .addService(new TicketServiceImpl())
            .build();
        try {
        server.start(); //Initializing the server for "cinema Entrance"
            System.out.println("Server_Lights_Cinema is working on Port: " + server.getPort());
            server.awaitTermination();
            server.awaitTermination();//server still working
                   
         private static  Map<String, String> ALLOWED_TICKETS = Map.of(
        "254", "Regina George"   
    );

    // Service implementation:
    static class TicketServiceImpl extends TicketServiceGrpc.TicketServiceImplBase {

        @Override
        public StreamObserver<TicketRequest> admitTickets(StreamObserver<TicketResponse> responseObserver) {
            return new StreamObserver<TicketRequest>() {
                @Override
                public void onNext(TicketRequest request) {
                    String ticketNumber = request.getTicketNumber();
                    String clientName = request.getClientName();

                    String message;
                    if (ALLOWED_TICKETS.containsKey(ticketNumber) && ALLOWED_TICKETS.get(ticketNumber).equals(clientName)) {
                        message = "Ticket Accepted. Enjoy the movie";
                    } else {
                        message = "Ticket Rejected";
                    }

                    TicketResponse response = TicketResponse.newBuilder()
                            .setMessage(message)
                            .build();
                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable t) {
                    // Handle errors here
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    // Signal that the server has finished sending responses
                    responseObserver.onCompleted();
                }
            };
        }
    }

  
}
