// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: recordercomm.proto

package com.yiyou.appsvr.recorder;

public final class Recordercomm {
  private Recordercomm() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RecorderWorkerDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:recorder.RecorderWorkerData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *r00001, r000xx
     * </pre>
     *
     * <code>required string id = 1;</code>
     */
    boolean hasId();
    /**
     * <pre>
     *r00001, r000xx
     * </pre>
     *
     * <code>required string id = 1;</code>
     */
    java.lang.String getId();
    /**
     * <pre>
     *r00001, r000xx
     * </pre>
     *
     * <code>required string id = 1;</code>
     */
    com.google.protobuf.ByteString
        getIdBytes();

    /**
     * <code>required string host = 2;</code>
     */
    boolean hasHost();
    /**
     * <code>required string host = 2;</code>
     */
    java.lang.String getHost();
    /**
     * <code>required string host = 2;</code>
     */
    com.google.protobuf.ByteString
        getHostBytes();

    /**
     * <code>required int32 port = 3;</code>
     */
    boolean hasPort();
    /**
     * <code>required int32 port = 3;</code>
     */
    int getPort();

    /**
     * <code>required int32 capacity = 4;</code>
     */
    boolean hasCapacity();
    /**
     * <code>required int32 capacity = 4;</code>
     */
    int getCapacity();
  }
  /**
   * Protobuf type {@code recorder.RecorderWorkerData}
   */
  public  static final class RecorderWorkerData extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:recorder.RecorderWorkerData)
      RecorderWorkerDataOrBuilder {
    // Use RecorderWorkerData.newBuilder() to construct.
    private RecorderWorkerData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private RecorderWorkerData() {
      id_ = "";
      host_ = "";
      port_ = 0;
      capacity_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private RecorderWorkerData(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              id_ = bs;
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              host_ = bs;
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              port_ = input.readInt32();
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              capacity_ = input.readInt32();
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
      return com.yiyou.appsvr.recorder.Recordercomm.internal_static_recorder_RecorderWorkerData_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.yiyou.appsvr.recorder.Recordercomm.internal_static_recorder_RecorderWorkerData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData.class, com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData.Builder.class);
    }

    private int bitField0_;
    public static final int ID_FIELD_NUMBER = 1;
    private volatile java.lang.Object id_;
    /**
     * <pre>
     *r00001, r000xx
     * </pre>
     *
     * <code>required string id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     *r00001, r000xx
     * </pre>
     *
     * <code>required string id = 1;</code>
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          id_ = s;
        }
        return s;
      }
    }
    /**
     * <pre>
     *r00001, r000xx
     * </pre>
     *
     * <code>required string id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int HOST_FIELD_NUMBER = 2;
    private volatile java.lang.Object host_;
    /**
     * <code>required string host = 2;</code>
     */
    public boolean hasHost() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string host = 2;</code>
     */
    public java.lang.String getHost() {
      java.lang.Object ref = host_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          host_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string host = 2;</code>
     */
    public com.google.protobuf.ByteString
        getHostBytes() {
      java.lang.Object ref = host_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        host_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PORT_FIELD_NUMBER = 3;
    private int port_;
    /**
     * <code>required int32 port = 3;</code>
     */
    public boolean hasPort() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required int32 port = 3;</code>
     */
    public int getPort() {
      return port_;
    }

    public static final int CAPACITY_FIELD_NUMBER = 4;
    private int capacity_;
    /**
     * <code>required int32 capacity = 4;</code>
     */
    public boolean hasCapacity() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required int32 capacity = 4;</code>
     */
    public int getCapacity() {
      return capacity_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasHost()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasPort()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasCapacity()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, host_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt32(3, port_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt32(4, capacity_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, host_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, port_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, capacity_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData)) {
        return super.equals(obj);
      }
      com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData other = (com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData) obj;

      boolean result = true;
      result = result && (hasId() == other.hasId());
      if (hasId()) {
        result = result && getId()
            .equals(other.getId());
      }
      result = result && (hasHost() == other.hasHost());
      if (hasHost()) {
        result = result && getHost()
            .equals(other.getHost());
      }
      result = result && (hasPort() == other.hasPort());
      if (hasPort()) {
        result = result && (getPort()
            == other.getPort());
      }
      result = result && (hasCapacity() == other.hasCapacity());
      if (hasCapacity()) {
        result = result && (getCapacity()
            == other.getCapacity());
      }
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
      if (hasId()) {
        hash = (37 * hash) + ID_FIELD_NUMBER;
        hash = (53 * hash) + getId().hashCode();
      }
      if (hasHost()) {
        hash = (37 * hash) + HOST_FIELD_NUMBER;
        hash = (53 * hash) + getHost().hashCode();
      }
      if (hasPort()) {
        hash = (37 * hash) + PORT_FIELD_NUMBER;
        hash = (53 * hash) + getPort();
      }
      if (hasCapacity()) {
        hash = (37 * hash) + CAPACITY_FIELD_NUMBER;
        hash = (53 * hash) + getCapacity();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
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
     * Protobuf type {@code recorder.RecorderWorkerData}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:recorder.RecorderWorkerData)
        com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.yiyou.appsvr.recorder.Recordercomm.internal_static_recorder_RecorderWorkerData_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.yiyou.appsvr.recorder.Recordercomm.internal_static_recorder_RecorderWorkerData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData.class, com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData.Builder.class);
      }

      // Construct using com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData.newBuilder()
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
      public Builder clear() {
        super.clear();
        id_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        host_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        port_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        capacity_ = 0;
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.yiyou.appsvr.recorder.Recordercomm.internal_static_recorder_RecorderWorkerData_descriptor;
      }

      public com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData getDefaultInstanceForType() {
        return com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData.getDefaultInstance();
      }

      public com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData build() {
        com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData buildPartial() {
        com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData result = new com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.host_ = host_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.port_ = port_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.capacity_ = capacity_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData) {
          return mergeFrom((com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData other) {
        if (other == com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData.getDefaultInstance()) return this;
        if (other.hasId()) {
          bitField0_ |= 0x00000001;
          id_ = other.id_;
          onChanged();
        }
        if (other.hasHost()) {
          bitField0_ |= 0x00000002;
          host_ = other.host_;
          onChanged();
        }
        if (other.hasPort()) {
          setPort(other.getPort());
        }
        if (other.hasCapacity()) {
          setCapacity(other.getCapacity());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasId()) {
          return false;
        }
        if (!hasHost()) {
          return false;
        }
        if (!hasPort()) {
          return false;
        }
        if (!hasCapacity()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object id_ = "";
      /**
       * <pre>
       *r00001, r000xx
       * </pre>
       *
       * <code>required string id = 1;</code>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <pre>
       *r00001, r000xx
       * </pre>
       *
       * <code>required string id = 1;</code>
       */
      public java.lang.String getId() {
        java.lang.Object ref = id_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            id_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       *r00001, r000xx
       * </pre>
       *
       * <code>required string id = 1;</code>
       */
      public com.google.protobuf.ByteString
          getIdBytes() {
        java.lang.Object ref = id_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          id_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *r00001, r000xx
       * </pre>
       *
       * <code>required string id = 1;</code>
       */
      public Builder setId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *r00001, r000xx
       * </pre>
       *
       * <code>required string id = 1;</code>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *r00001, r000xx
       * </pre>
       *
       * <code>required string id = 1;</code>
       */
      public Builder setIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object host_ = "";
      /**
       * <code>required string host = 2;</code>
       */
      public boolean hasHost() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string host = 2;</code>
       */
      public java.lang.String getHost() {
        java.lang.Object ref = host_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            host_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string host = 2;</code>
       */
      public com.google.protobuf.ByteString
          getHostBytes() {
        java.lang.Object ref = host_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          host_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string host = 2;</code>
       */
      public Builder setHost(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        host_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string host = 2;</code>
       */
      public Builder clearHost() {
        bitField0_ = (bitField0_ & ~0x00000002);
        host_ = getDefaultInstance().getHost();
        onChanged();
        return this;
      }
      /**
       * <code>required string host = 2;</code>
       */
      public Builder setHostBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        host_ = value;
        onChanged();
        return this;
      }

      private int port_ ;
      /**
       * <code>required int32 port = 3;</code>
       */
      public boolean hasPort() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required int32 port = 3;</code>
       */
      public int getPort() {
        return port_;
      }
      /**
       * <code>required int32 port = 3;</code>
       */
      public Builder setPort(int value) {
        bitField0_ |= 0x00000004;
        port_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 port = 3;</code>
       */
      public Builder clearPort() {
        bitField0_ = (bitField0_ & ~0x00000004);
        port_ = 0;
        onChanged();
        return this;
      }

      private int capacity_ ;
      /**
       * <code>required int32 capacity = 4;</code>
       */
      public boolean hasCapacity() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required int32 capacity = 4;</code>
       */
      public int getCapacity() {
        return capacity_;
      }
      /**
       * <code>required int32 capacity = 4;</code>
       */
      public Builder setCapacity(int value) {
        bitField0_ |= 0x00000008;
        capacity_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 capacity = 4;</code>
       */
      public Builder clearCapacity() {
        bitField0_ = (bitField0_ & ~0x00000008);
        capacity_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:recorder.RecorderWorkerData)
    }

    // @@protoc_insertion_point(class_scope:recorder.RecorderWorkerData)
    private static final com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData();
    }

    public static com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<RecorderWorkerData>
        PARSER = new com.google.protobuf.AbstractParser<RecorderWorkerData>() {
      public RecorderWorkerData parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new RecorderWorkerData(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RecorderWorkerData> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RecorderWorkerData> getParserForType() {
      return PARSER;
    }

    public com.yiyou.appsvr.recorder.Recordercomm.RecorderWorkerData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_recorder_RecorderWorkerData_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_recorder_RecorderWorkerData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022recordercomm.proto\022\010recorder\"N\n\022Record" +
      "erWorkerData\022\n\n\002id\030\001 \002(\t\022\014\n\004host\030\002 \002(\t\022\014" +
      "\n\004port\030\003 \002(\005\022\020\n\010capacity\030\004 \002(\005B\033\n\031com.yi" +
      "you.appsvr.recorder"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_recorder_RecorderWorkerData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_recorder_RecorderWorkerData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_recorder_RecorderWorkerData_descriptor,
        new java.lang.String[] { "Id", "Host", "Port", "Capacity", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
