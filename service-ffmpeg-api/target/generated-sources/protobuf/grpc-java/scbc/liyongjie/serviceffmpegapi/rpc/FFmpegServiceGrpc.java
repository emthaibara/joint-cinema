package scbc.liyongjie.serviceffmpegapi.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.0)",
    comments = "Source: FFmpegService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FFmpegServiceGrpc {

  private FFmpegServiceGrpc() {}

  public static final String SERVICE_NAME = "scbc.liyongjie.serviceffmpegapi.rpc.FFmpegService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest,
      scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> getFfmpegBuildDASHServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ffmpegBuildDASHService",
      requestType = scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest.class,
      responseType = scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest,
      scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> getFfmpegBuildDASHServiceMethod() {
    io.grpc.MethodDescriptor<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest, scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> getFfmpegBuildDASHServiceMethod;
    if ((getFfmpegBuildDASHServiceMethod = FFmpegServiceGrpc.getFfmpegBuildDASHServiceMethod) == null) {
      synchronized (FFmpegServiceGrpc.class) {
        if ((getFfmpegBuildDASHServiceMethod = FFmpegServiceGrpc.getFfmpegBuildDASHServiceMethod) == null) {
          FFmpegServiceGrpc.getFfmpegBuildDASHServiceMethod = getFfmpegBuildDASHServiceMethod =
              io.grpc.MethodDescriptor.<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest, scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ffmpegBuildDASHService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FFmpegServiceMethodDescriptorSupplier("ffmpegBuildDASHService"))
              .build();
        }
      }
    }
    return getFfmpegBuildDASHServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest,
      scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> getFfmpegBuildThumbnailServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ffmpegBuildThumbnailService",
      requestType = scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest.class,
      responseType = scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest,
      scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> getFfmpegBuildThumbnailServiceMethod() {
    io.grpc.MethodDescriptor<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest, scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> getFfmpegBuildThumbnailServiceMethod;
    if ((getFfmpegBuildThumbnailServiceMethod = FFmpegServiceGrpc.getFfmpegBuildThumbnailServiceMethod) == null) {
      synchronized (FFmpegServiceGrpc.class) {
        if ((getFfmpegBuildThumbnailServiceMethod = FFmpegServiceGrpc.getFfmpegBuildThumbnailServiceMethod) == null) {
          FFmpegServiceGrpc.getFfmpegBuildThumbnailServiceMethod = getFfmpegBuildThumbnailServiceMethod =
              io.grpc.MethodDescriptor.<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest, scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ffmpegBuildThumbnailService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FFmpegServiceMethodDescriptorSupplier("ffmpegBuildThumbnailService"))
              .build();
        }
      }
    }
    return getFfmpegBuildThumbnailServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest,
      scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> getFfmpegCalculateDurationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ffmpegCalculateDuration",
      requestType = scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest.class,
      responseType = scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest,
      scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> getFfmpegCalculateDurationMethod() {
    io.grpc.MethodDescriptor<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest, scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> getFfmpegCalculateDurationMethod;
    if ((getFfmpegCalculateDurationMethod = FFmpegServiceGrpc.getFfmpegCalculateDurationMethod) == null) {
      synchronized (FFmpegServiceGrpc.class) {
        if ((getFfmpegCalculateDurationMethod = FFmpegServiceGrpc.getFfmpegCalculateDurationMethod) == null) {
          FFmpegServiceGrpc.getFfmpegCalculateDurationMethod = getFfmpegCalculateDurationMethod =
              io.grpc.MethodDescriptor.<scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest, scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ffmpegCalculateDuration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FFmpegServiceMethodDescriptorSupplier("ffmpegCalculateDuration"))
              .build();
        }
      }
    }
    return getFfmpegCalculateDurationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FFmpegServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FFmpegServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FFmpegServiceStub>() {
        @java.lang.Override
        public FFmpegServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FFmpegServiceStub(channel, callOptions);
        }
      };
    return FFmpegServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FFmpegServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FFmpegServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FFmpegServiceBlockingStub>() {
        @java.lang.Override
        public FFmpegServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FFmpegServiceBlockingStub(channel, callOptions);
        }
      };
    return FFmpegServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FFmpegServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FFmpegServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FFmpegServiceFutureStub>() {
        @java.lang.Override
        public FFmpegServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FFmpegServiceFutureStub(channel, callOptions);
        }
      };
    return FFmpegServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FFmpegServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void ffmpegBuildDASHService(scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest request,
        io.grpc.stub.StreamObserver<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFfmpegBuildDASHServiceMethod(), responseObserver);
    }

    /**
     */
    public void ffmpegBuildThumbnailService(scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest request,
        io.grpc.stub.StreamObserver<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFfmpegBuildThumbnailServiceMethod(), responseObserver);
    }

    /**
     */
    public void ffmpegCalculateDuration(scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest request,
        io.grpc.stub.StreamObserver<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFfmpegCalculateDurationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFfmpegBuildDASHServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest,
                scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse>(
                  this, METHODID_FFMPEG_BUILD_DASHSERVICE)))
          .addMethod(
            getFfmpegBuildThumbnailServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest,
                scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse>(
                  this, METHODID_FFMPEG_BUILD_THUMBNAIL_SERVICE)))
          .addMethod(
            getFfmpegCalculateDurationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest,
                scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse>(
                  this, METHODID_FFMPEG_CALCULATE_DURATION)))
          .build();
    }
  }

  /**
   */
  public static final class FFmpegServiceStub extends io.grpc.stub.AbstractAsyncStub<FFmpegServiceStub> {
    private FFmpegServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FFmpegServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FFmpegServiceStub(channel, callOptions);
    }

    /**
     */
    public void ffmpegBuildDASHService(scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest request,
        io.grpc.stub.StreamObserver<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFfmpegBuildDASHServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void ffmpegBuildThumbnailService(scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest request,
        io.grpc.stub.StreamObserver<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFfmpegBuildThumbnailServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void ffmpegCalculateDuration(scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest request,
        io.grpc.stub.StreamObserver<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFfmpegCalculateDurationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FFmpegServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FFmpegServiceBlockingStub> {
    private FFmpegServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FFmpegServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FFmpegServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse ffmpegBuildDASHService(scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFfmpegBuildDASHServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse ffmpegBuildThumbnailService(scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFfmpegBuildThumbnailServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse ffmpegCalculateDuration(scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFfmpegCalculateDurationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FFmpegServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FFmpegServiceFutureStub> {
    private FFmpegServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FFmpegServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FFmpegServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> ffmpegBuildDASHService(
        scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFfmpegBuildDASHServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> ffmpegBuildThumbnailService(
        scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFfmpegBuildThumbnailServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse> ffmpegCalculateDuration(
        scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFfmpegCalculateDurationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FFMPEG_BUILD_DASHSERVICE = 0;
  private static final int METHODID_FFMPEG_BUILD_THUMBNAIL_SERVICE = 1;
  private static final int METHODID_FFMPEG_CALCULATE_DURATION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FFmpegServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FFmpegServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FFMPEG_BUILD_DASHSERVICE:
          serviceImpl.ffmpegBuildDASHService((scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildDASHServiceRequest) request,
              (io.grpc.stub.StreamObserver<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse>) responseObserver);
          break;
        case METHODID_FFMPEG_BUILD_THUMBNAIL_SERVICE:
          serviceImpl.ffmpegBuildThumbnailService((scbc.liyongjie.serviceffmpegapi.rpc.FFmpegBuildThumbnailServiceRequest) request,
              (io.grpc.stub.StreamObserver<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse>) responseObserver);
          break;
        case METHODID_FFMPEG_CALCULATE_DURATION:
          serviceImpl.ffmpegCalculateDuration((scbc.liyongjie.serviceffmpegapi.rpc.FFmpegCalculateDurationRequest) request,
              (io.grpc.stub.StreamObserver<scbc.liyongjie.serviceffmpegapi.rpc.ResultResponse>) responseObserver);
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

  private static abstract class FFmpegServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FFmpegServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return scbc.liyongjie.serviceffmpegapi.rpc.FFmpegServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FFmpegService");
    }
  }

  private static final class FFmpegServiceFileDescriptorSupplier
      extends FFmpegServiceBaseDescriptorSupplier {
    FFmpegServiceFileDescriptorSupplier() {}
  }

  private static final class FFmpegServiceMethodDescriptorSupplier
      extends FFmpegServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FFmpegServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FFmpegServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FFmpegServiceFileDescriptorSupplier())
              .addMethod(getFfmpegBuildDASHServiceMethod())
              .addMethod(getFfmpegBuildThumbnailServiceMethod())
              .addMethod(getFfmpegCalculateDurationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
