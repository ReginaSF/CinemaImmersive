package CinemaIntelligent;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 *This service is the called SeatTemperature in the proposal Document. 
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Immersive.proto")
public final class CinemaImmersiveGrpc {

  private CinemaImmersiveGrpc() {}

  public static final String SERVICE_NAME = "CinemaIntelligent.CinemaImmersive";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CinemaIntelligent.ActivateRequest,
      CinemaIntelligent.ActivateResponse> getActivateHeatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActivateHeating",
      requestType = CinemaIntelligent.ActivateRequest.class,
      responseType = CinemaIntelligent.ActivateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CinemaIntelligent.ActivateRequest,
      CinemaIntelligent.ActivateResponse> getActivateHeatingMethod() {
    io.grpc.MethodDescriptor<CinemaIntelligent.ActivateRequest, CinemaIntelligent.ActivateResponse> getActivateHeatingMethod;
    if ((getActivateHeatingMethod = CinemaImmersiveGrpc.getActivateHeatingMethod) == null) {
      synchronized (CinemaImmersiveGrpc.class) {
        if ((getActivateHeatingMethod = CinemaImmersiveGrpc.getActivateHeatingMethod) == null) {
          CinemaImmersiveGrpc.getActivateHeatingMethod = getActivateHeatingMethod = 
              io.grpc.MethodDescriptor.<CinemaIntelligent.ActivateRequest, CinemaIntelligent.ActivateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CinemaIntelligent.CinemaImmersive", "ActivateHeating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CinemaIntelligent.ActivateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CinemaIntelligent.ActivateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CinemaImmersiveMethodDescriptorSupplier("ActivateHeating"))
                  .build();
          }
        }
     }
     return getActivateHeatingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CinemaImmersiveStub newStub(io.grpc.Channel channel) {
    return new CinemaImmersiveStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CinemaImmersiveBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CinemaImmersiveBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CinemaImmersiveFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CinemaImmersiveFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   *This service is the called SeatTemperature in the proposal Document. 
   * </pre>
   */
  public static abstract class CinemaImmersiveImplBase implements io.grpc.BindableService {

    /**
     */
    public void activateHeating(CinemaIntelligent.ActivateRequest request,
        io.grpc.stub.StreamObserver<CinemaIntelligent.ActivateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getActivateHeatingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getActivateHeatingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                CinemaIntelligent.ActivateRequest,
                CinemaIntelligent.ActivateResponse>(
                  this, METHODID_ACTIVATE_HEATING)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *This service is the called SeatTemperature in the proposal Document. 
   * </pre>
   */
  public static final class CinemaImmersiveStub extends io.grpc.stub.AbstractStub<CinemaImmersiveStub> {
    private CinemaImmersiveStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaImmersiveStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaImmersiveStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaImmersiveStub(channel, callOptions);
    }

    /**
     */
    public void activateHeating(CinemaIntelligent.ActivateRequest request,
        io.grpc.stub.StreamObserver<CinemaIntelligent.ActivateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getActivateHeatingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *This service is the called SeatTemperature in the proposal Document. 
   * </pre>
   */
  public static final class CinemaImmersiveBlockingStub extends io.grpc.stub.AbstractStub<CinemaImmersiveBlockingStub> {
    private CinemaImmersiveBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaImmersiveBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaImmersiveBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaImmersiveBlockingStub(channel, callOptions);
    }

    /**
     */
    public CinemaIntelligent.ActivateResponse activateHeating(CinemaIntelligent.ActivateRequest request) {
      return blockingUnaryCall(
          getChannel(), getActivateHeatingMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   *This service is the called SeatTemperature in the proposal Document. 
   * </pre>
   */
  public static final class CinemaImmersiveFutureStub extends io.grpc.stub.AbstractStub<CinemaImmersiveFutureStub> {
    private CinemaImmersiveFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaImmersiveFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaImmersiveFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaImmersiveFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CinemaIntelligent.ActivateResponse> activateHeating(
        CinemaIntelligent.ActivateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getActivateHeatingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACTIVATE_HEATING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CinemaImmersiveImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CinemaImmersiveImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACTIVATE_HEATING:
          serviceImpl.activateHeating((CinemaIntelligent.ActivateRequest) request,
              (io.grpc.stub.StreamObserver<CinemaIntelligent.ActivateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CinemaImmersiveBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CinemaImmersiveBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CinemaIntelligent.CinemaImmersiveServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CinemaImmersive");
    }
  }

  private static final class CinemaImmersiveFileDescriptorSupplier
      extends CinemaImmersiveBaseDescriptorSupplier {
    CinemaImmersiveFileDescriptorSupplier() {}
  }

  private static final class CinemaImmersiveMethodDescriptorSupplier
      extends CinemaImmersiveBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CinemaImmersiveMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CinemaImmersiveGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CinemaImmersiveFileDescriptorSupplier())
              .addMethod(getActivateHeatingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
