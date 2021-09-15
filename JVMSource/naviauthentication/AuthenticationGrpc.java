package naviauthentication;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service Description
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: AuthenticationService/UserService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthenticationGrpc {

  private AuthenticationGrpc() {}

  public static final String SERVICE_NAME = "naviauthentication.Authentication";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<naviauthentication.CommunicationMessage.RegisterRequest,
      naviauthentication.CommunicationMessage.Result> getRegisterUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterUser",
      requestType = naviauthentication.CommunicationMessage.RegisterRequest.class,
      responseType = naviauthentication.CommunicationMessage.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<naviauthentication.CommunicationMessage.RegisterRequest,
      naviauthentication.CommunicationMessage.Result> getRegisterUserMethod() {
    io.grpc.MethodDescriptor<naviauthentication.CommunicationMessage.RegisterRequest, naviauthentication.CommunicationMessage.Result> getRegisterUserMethod;
    if ((getRegisterUserMethod = AuthenticationGrpc.getRegisterUserMethod) == null) {
      synchronized (AuthenticationGrpc.class) {
        if ((getRegisterUserMethod = AuthenticationGrpc.getRegisterUserMethod) == null) {
          AuthenticationGrpc.getRegisterUserMethod = getRegisterUserMethod =
              io.grpc.MethodDescriptor.<naviauthentication.CommunicationMessage.RegisterRequest, naviauthentication.CommunicationMessage.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  naviauthentication.CommunicationMessage.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  naviauthentication.CommunicationMessage.Result.getDefaultInstance()))
              .setSchemaDescriptor(new AuthenticationMethodDescriptorSupplier("RegisterUser"))
              .build();
        }
      }
    }
    return getRegisterUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<naviauthentication.CommunicationMessage.LoginRequest,
      naviauthentication.CommunicationMessage.Result> getLoginUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoginUser",
      requestType = naviauthentication.CommunicationMessage.LoginRequest.class,
      responseType = naviauthentication.CommunicationMessage.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<naviauthentication.CommunicationMessage.LoginRequest,
      naviauthentication.CommunicationMessage.Result> getLoginUserMethod() {
    io.grpc.MethodDescriptor<naviauthentication.CommunicationMessage.LoginRequest, naviauthentication.CommunicationMessage.Result> getLoginUserMethod;
    if ((getLoginUserMethod = AuthenticationGrpc.getLoginUserMethod) == null) {
      synchronized (AuthenticationGrpc.class) {
        if ((getLoginUserMethod = AuthenticationGrpc.getLoginUserMethod) == null) {
          AuthenticationGrpc.getLoginUserMethod = getLoginUserMethod =
              io.grpc.MethodDescriptor.<naviauthentication.CommunicationMessage.LoginRequest, naviauthentication.CommunicationMessage.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LoginUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  naviauthentication.CommunicationMessage.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  naviauthentication.CommunicationMessage.Result.getDefaultInstance()))
              .setSchemaDescriptor(new AuthenticationMethodDescriptorSupplier("LoginUser"))
              .build();
        }
      }
    }
    return getLoginUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthenticationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthenticationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthenticationStub>() {
        @java.lang.Override
        public AuthenticationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthenticationStub(channel, callOptions);
        }
      };
    return AuthenticationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthenticationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthenticationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthenticationBlockingStub>() {
        @java.lang.Override
        public AuthenticationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthenticationBlockingStub(channel, callOptions);
        }
      };
    return AuthenticationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthenticationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthenticationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthenticationFutureStub>() {
        @java.lang.Override
        public AuthenticationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthenticationFutureStub(channel, callOptions);
        }
      };
    return AuthenticationFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service Description
   * </pre>
   */
  public static abstract class AuthenticationImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerUser(naviauthentication.CommunicationMessage.RegisterRequest request,
        io.grpc.stub.StreamObserver<naviauthentication.CommunicationMessage.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterUserMethod(), responseObserver);
    }

    /**
     */
    public void loginUser(naviauthentication.CommunicationMessage.LoginRequest request,
        io.grpc.stub.StreamObserver<naviauthentication.CommunicationMessage.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                naviauthentication.CommunicationMessage.RegisterRequest,
                naviauthentication.CommunicationMessage.Result>(
                  this, METHODID_REGISTER_USER)))
          .addMethod(
            getLoginUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                naviauthentication.CommunicationMessage.LoginRequest,
                naviauthentication.CommunicationMessage.Result>(
                  this, METHODID_LOGIN_USER)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Description
   * </pre>
   */
  public static final class AuthenticationStub extends io.grpc.stub.AbstractAsyncStub<AuthenticationStub> {
    private AuthenticationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthenticationStub(channel, callOptions);
    }

    /**
     */
    public void registerUser(naviauthentication.CommunicationMessage.RegisterRequest request,
        io.grpc.stub.StreamObserver<naviauthentication.CommunicationMessage.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void loginUser(naviauthentication.CommunicationMessage.LoginRequest request,
        io.grpc.stub.StreamObserver<naviauthentication.CommunicationMessage.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service Description
   * </pre>
   */
  public static final class AuthenticationBlockingStub extends io.grpc.stub.AbstractBlockingStub<AuthenticationBlockingStub> {
    private AuthenticationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthenticationBlockingStub(channel, callOptions);
    }

    /**
     */
    public naviauthentication.CommunicationMessage.Result registerUser(naviauthentication.CommunicationMessage.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public naviauthentication.CommunicationMessage.Result loginUser(naviauthentication.CommunicationMessage.LoginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service Description
   * </pre>
   */
  public static final class AuthenticationFutureStub extends io.grpc.stub.AbstractFutureStub<AuthenticationFutureStub> {
    private AuthenticationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthenticationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<naviauthentication.CommunicationMessage.Result> registerUser(
        naviauthentication.CommunicationMessage.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<naviauthentication.CommunicationMessage.Result> loginUser(
        naviauthentication.CommunicationMessage.LoginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_USER = 0;
  private static final int METHODID_LOGIN_USER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthenticationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthenticationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_USER:
          serviceImpl.registerUser((naviauthentication.CommunicationMessage.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<naviauthentication.CommunicationMessage.Result>) responseObserver);
          break;
        case METHODID_LOGIN_USER:
          serviceImpl.loginUser((naviauthentication.CommunicationMessage.LoginRequest) request,
              (io.grpc.stub.StreamObserver<naviauthentication.CommunicationMessage.Result>) responseObserver);
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

  private static abstract class AuthenticationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthenticationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return naviauthentication.UserService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Authentication");
    }
  }

  private static final class AuthenticationFileDescriptorSupplier
      extends AuthenticationBaseDescriptorSupplier {
    AuthenticationFileDescriptorSupplier() {}
  }

  private static final class AuthenticationMethodDescriptorSupplier
      extends AuthenticationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthenticationMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthenticationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthenticationFileDescriptorSupplier())
              .addMethod(getRegisterUserMethod())
              .addMethod(getLoginUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
