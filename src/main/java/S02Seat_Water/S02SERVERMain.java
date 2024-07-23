package S02Seat_Water;
import io.grpc.Server;
import io.grpc.ServerBuilder;
public class S02SERVERMain {
	


    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(8080)
                .addService(new S02SERVER())
                .build()
                .start();

        System.out.println("Server_Heating is working on Port: " + server.getPort());
        server.awaitTermination();
    }
}

