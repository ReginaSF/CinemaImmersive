package S02Seat_Water;

import io.grpc.stub.StreamObserver;


public class S02SERVER extends S02SeatWaterGrpc.S02SeatWaterImplBase {

    @Override
    public void activateWaterImmersiveFeature(ActivateRequest request, StreamObserver<ActivateResponse> responseObserver) {
        String userInput = request.getOn().trim().toLowerCase();
        String message;

        if (userInput.equals("yes")) {
            message = "Immersive Water features activated";
        } else if (userInput.equals("no")) {
            message = "Immersive Water features not activated";
        } else {
            message = "Invalid input. Please provide 'yes' or 'no'.";
        }

        ActivateResponse response = ActivateResponse.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
