// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: S04.proto

package S04Cinema_Entrance;

/**
 * <pre>
 * Message for a ticket request
 * </pre>
 *
 * Protobuf type {@code Artifact_cinema.TicketRequest}
 */
public  final class TicketRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Artifact_cinema.TicketRequest)
    TicketRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TicketRequest.newBuilder() to construct.
  private TicketRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TicketRequest() {
    ticketNumber_ = "";
    clientName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TicketRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            ticketNumber_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            clientName_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return S04Cinema_Entrance.Serv04Cinema_Entrance.internal_static_Artifact_cinema_TicketRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return S04Cinema_Entrance.Serv04Cinema_Entrance.internal_static_Artifact_cinema_TicketRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            S04Cinema_Entrance.TicketRequest.class, S04Cinema_Entrance.TicketRequest.Builder.class);
  }

  public static final int TICKET_NUMBER_FIELD_NUMBER = 1;
  private volatile java.lang.Object ticketNumber_;
  /**
   * <pre>
   * Ticket number and client's name
   * </pre>
   *
   * <code>string ticket_number = 1;</code>
   */
  public java.lang.String getTicketNumber() {
    java.lang.Object ref = ticketNumber_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      ticketNumber_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Ticket number and client's name
   * </pre>
   *
   * <code>string ticket_number = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTicketNumberBytes() {
    java.lang.Object ref = ticketNumber_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      ticketNumber_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CLIENT_NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object clientName_;
  /**
   * <code>string client_name = 2;</code>
   */
  public java.lang.String getClientName() {
    java.lang.Object ref = clientName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      clientName_ = s;
      return s;
    }
  }
  /**
   * <code>string client_name = 2;</code>
   */
  public com.google.protobuf.ByteString
      getClientNameBytes() {
    java.lang.Object ref = clientName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      clientName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getTicketNumberBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, ticketNumber_);
    }
    if (!getClientNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, clientName_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTicketNumberBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, ticketNumber_);
    }
    if (!getClientNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, clientName_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof S04Cinema_Entrance.TicketRequest)) {
      return super.equals(obj);
    }
    S04Cinema_Entrance.TicketRequest other = (S04Cinema_Entrance.TicketRequest) obj;

    boolean result = true;
    result = result && getTicketNumber()
        .equals(other.getTicketNumber());
    result = result && getClientName()
        .equals(other.getClientName());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TICKET_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getTicketNumber().hashCode();
    hash = (37 * hash) + CLIENT_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getClientName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static S04Cinema_Entrance.TicketRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static S04Cinema_Entrance.TicketRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static S04Cinema_Entrance.TicketRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static S04Cinema_Entrance.TicketRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static S04Cinema_Entrance.TicketRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static S04Cinema_Entrance.TicketRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static S04Cinema_Entrance.TicketRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static S04Cinema_Entrance.TicketRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static S04Cinema_Entrance.TicketRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static S04Cinema_Entrance.TicketRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static S04Cinema_Entrance.TicketRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static S04Cinema_Entrance.TicketRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(S04Cinema_Entrance.TicketRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Message for a ticket request
   * </pre>
   *
   * Protobuf type {@code Artifact_cinema.TicketRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Artifact_cinema.TicketRequest)
      S04Cinema_Entrance.TicketRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return S04Cinema_Entrance.Serv04Cinema_Entrance.internal_static_Artifact_cinema_TicketRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return S04Cinema_Entrance.Serv04Cinema_Entrance.internal_static_Artifact_cinema_TicketRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              S04Cinema_Entrance.TicketRequest.class, S04Cinema_Entrance.TicketRequest.Builder.class);
    }

    // Construct using S04Cinema_Entrance.TicketRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      ticketNumber_ = "";

      clientName_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return S04Cinema_Entrance.Serv04Cinema_Entrance.internal_static_Artifact_cinema_TicketRequest_descriptor;
    }

    @java.lang.Override
    public S04Cinema_Entrance.TicketRequest getDefaultInstanceForType() {
      return S04Cinema_Entrance.TicketRequest.getDefaultInstance();
    }

    @java.lang.Override
    public S04Cinema_Entrance.TicketRequest build() {
      S04Cinema_Entrance.TicketRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public S04Cinema_Entrance.TicketRequest buildPartial() {
      S04Cinema_Entrance.TicketRequest result = new S04Cinema_Entrance.TicketRequest(this);
      result.ticketNumber_ = ticketNumber_;
      result.clientName_ = clientName_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof S04Cinema_Entrance.TicketRequest) {
        return mergeFrom((S04Cinema_Entrance.TicketRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(S04Cinema_Entrance.TicketRequest other) {
      if (other == S04Cinema_Entrance.TicketRequest.getDefaultInstance()) return this;
      if (!other.getTicketNumber().isEmpty()) {
        ticketNumber_ = other.ticketNumber_;
        onChanged();
      }
      if (!other.getClientName().isEmpty()) {
        clientName_ = other.clientName_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      S04Cinema_Entrance.TicketRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (S04Cinema_Entrance.TicketRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object ticketNumber_ = "";
    /**
     * <pre>
     * Ticket number and client's name
     * </pre>
     *
     * <code>string ticket_number = 1;</code>
     */
    public java.lang.String getTicketNumber() {
      java.lang.Object ref = ticketNumber_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ticketNumber_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Ticket number and client's name
     * </pre>
     *
     * <code>string ticket_number = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTicketNumberBytes() {
      java.lang.Object ref = ticketNumber_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ticketNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Ticket number and client's name
     * </pre>
     *
     * <code>string ticket_number = 1;</code>
     */
    public Builder setTicketNumber(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      ticketNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Ticket number and client's name
     * </pre>
     *
     * <code>string ticket_number = 1;</code>
     */
    public Builder clearTicketNumber() {
      
      ticketNumber_ = getDefaultInstance().getTicketNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Ticket number and client's name
     * </pre>
     *
     * <code>string ticket_number = 1;</code>
     */
    public Builder setTicketNumberBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      ticketNumber_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object clientName_ = "";
    /**
     * <code>string client_name = 2;</code>
     */
    public java.lang.String getClientName() {
      java.lang.Object ref = clientName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string client_name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getClientNameBytes() {
      java.lang.Object ref = clientName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        clientName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string client_name = 2;</code>
     */
    public Builder setClientName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      clientName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string client_name = 2;</code>
     */
    public Builder clearClientName() {
      
      clientName_ = getDefaultInstance().getClientName();
      onChanged();
      return this;
    }
    /**
     * <code>string client_name = 2;</code>
     */
    public Builder setClientNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      clientName_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Artifact_cinema.TicketRequest)
  }

  // @@protoc_insertion_point(class_scope:Artifact_cinema.TicketRequest)
  private static final S04Cinema_Entrance.TicketRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new S04Cinema_Entrance.TicketRequest();
  }

  public static S04Cinema_Entrance.TicketRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TicketRequest>
      PARSER = new com.google.protobuf.AbstractParser<TicketRequest>() {
    @java.lang.Override
    public TicketRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TicketRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TicketRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TicketRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public S04Cinema_Entrance.TicketRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

