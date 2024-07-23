import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


import java.io.IOException;
import java.util.Map;

public class TicketServer {

    // Example allowed tickets
    private static final Map<String, String> ALLOWED_TICKETS = Map.of(
        "254", "Frida Sofia"
        // Add more allowed tickets here
    );

    // Implement the TicketService
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create and start the server
        Server server = ServerBuilder.forPort(50051)
                .addService(new TicketServiceImpl())
                .build()
                .start();

        System.out.println("Server started, listening on " + server.getPort());

        // Keep the server running
        server.awaitTermination();
    }
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
