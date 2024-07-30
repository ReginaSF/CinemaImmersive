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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: OtroRegina.proto")
public final class ImmersiveWaterGrpc {

  private ImmersiveWaterGrpc() {}

  public static final String SERVICE_NAME = "ImmersiveWater";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CinemaIntelligent.OtroService.ActivateRequest,
      CinemaIntelligent.OtroService.ActivateResponse> getActivateWaterImwwwwmersiveFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActivateWaterImwwwwmersiveFeature",
      requestType = CinemaIntelligent.OtroService.ActivateRequest.class,
      responseType = CinemaIntelligent.OtroService.ActivateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CinemaIntelligent.OtroService.ActivateRequest,
      CinemaIntelligent.OtroService.ActivateResponse> getActivateWaterImwwwwmersiveFeatureMethod() {
    io.grpc.MethodDescriptor<CinemaIntelligent.OtroService.ActivateRequest, CinemaIntelligent.OtroService.ActivateResponse> getActivateWaterImwwwwmersiveFeatureMethod;
    if ((getActivateWaterImwwwwmersiveFeatureMethod = ImmersiveWaterGrpc.getActivateWaterImwwwwmersiveFeatureMethod) == null) {
      synchronized (ImmersiveWaterGrpc.class) {
        if ((getActivateWaterImwwwwmersiveFeatureMethod = ImmersiveWaterGrpc.getActivateWaterImwwwwmersiveFeatureMethod) == null) {
          ImmersiveWaterGrpc.getActivateWaterImwwwwmersiveFeatureMethod = getActivateWaterImwwwwmersiveFeatureMethod = 
              io.grpc.MethodDescriptor.<CinemaIntelligent.OtroService.ActivateRequest, CinemaIntelligent.OtroService.ActivateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ImmersiveWater", "ActivateWaterImwwwwmersiveFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CinemaIntelligent.OtroService.ActivateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CinemaIntelligent.OtroService.ActivateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ImmersiveWaterMethodDescriptorSupplier("ActivateWaterImwwwwmersiveFeature"))
                  .build();
          }
        }
     }
     return getActivateWaterImwwwwmersiveFeatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ImmersiveWaterStub newStub(io.grpc.Channel channel) {
    return new ImmersiveWaterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ImmersiveWaterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ImmersiveWaterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ImmersiveWaterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ImmersiveWaterFutureStub(channel);
  }

  /**
   */
  public static abstract class ImmersiveWaterImplBase implements io.grpc.BindableService {

    /**
     */
    public void activateWaterImwwwwmersiveFeature(CinemaIntelligent.OtroService.ActivateRequest request,
        io.grpc.stub.StreamObserver<CinemaIntelligent.OtroService.ActivateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getActivateWaterImwwwwmersiveFeatureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getActivateWaterImwwwwmersiveFeatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                CinemaIntelligent.OtroService.ActivateRequest,
                CinemaIntelligent.OtroService.ActivateResponse>(
                  this, METHODID_ACTIVATE_WATER_IMWWWWMERSIVE_FEATURE)))
          .build();
    }
  }

  /**
   */
  public static final class ImmersiveWaterStub extends io.grpc.stub.AbstractStub<ImmersiveWaterStub> {
    private ImmersiveWaterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImmersiveWaterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImmersiveWaterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImmersiveWaterStub(channel, callOptions);
    }

    /**
     */
    public void activateWaterImwwwwmersiveFeature(CinemaIntelligent.OtroService.ActivateRequest request,
        io.grpc.stub.StreamObserver<CinemaIntelligent.OtroService.ActivateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getActivateWaterImwwwwmersiveFeatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ImmersiveWaterBlockingStub extends io.grpc.stub.AbstractStub<ImmersiveWaterBlockingStub> {
    private ImmersiveWaterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImmersiveWaterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImmersiveWaterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImmersiveWaterBlockingStub(channel, callOptions);
    }

    /**
     */
    public CinemaIntelligent.OtroService.ActivateResponse activateWaterImwwwwmersiveFeature(CinemaIntelligent.OtroService.ActivateRequest request) {
      return blockingUnaryCall(
          getChannel(), getActivateWaterImwwwwmersiveFeatureMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ImmersiveWaterFutureStub extends io.grpc.stub.AbstractStub<ImmersiveWaterFutureStub> {
    private ImmersiveWaterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImmersiveWaterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImmersiveWaterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImmersiveWaterFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CinemaIntelligent.OtroService.ActivateResponse> activateWaterImwwwwmersiveFeature(
        CinemaIntelligent.OtroService.ActivateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getActivateWaterImwwwwmersiveFeatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACTIVATE_WATER_IMWWWWMERSIVE_FEATURE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ImmersiveWaterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ImmersiveWaterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACTIVATE_WATER_IMWWWWMERSIVE_FEATURE:
          serviceImpl.activateWaterImwwwwmersiveFeature((CinemaIntelligent.OtroService.ActivateRequest) request,
              (io.grpc.stub.StreamObserver<CinemaIntelligent.OtroService.ActivateResponse>) responseObserver);
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

  private static abstract class ImmersiveWaterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ImmersiveWaterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CinemaIntelligent.OtroService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ImmersiveWater");
    }
  }

  private static final class ImmersiveWaterFileDescriptorSupplier
      extends ImmersiveWaterBaseDescriptorSupplier {
    ImmersiveWaterFileDescriptorSupplier() {}
  }

  private static final class ImmersiveWaterMethodDescriptorSupplier
      extends ImmersiveWaterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ImmersiveWaterMethodDescriptorSupplier(String methodName) {
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
      synchronized (ImmersiveWaterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ImmersiveWaterFileDescriptorSupplier())
              .addMethod(getActivateWaterImwwwwmersiveFeatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
