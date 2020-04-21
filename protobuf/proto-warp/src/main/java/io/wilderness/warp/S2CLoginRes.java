// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package io.wilderness.warp;

/**
 * Protobuf type {@code warp.S2CLoginRes}
 */
public final class S2CLoginRes extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:warp.S2CLoginRes)
        S2CLoginResOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use S2CLoginRes.newBuilder() to construct.
    private S2CLoginRes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private S2CLoginRes() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new S2CLoginRes();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    private S2CLoginRes(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistry == null) {
            throw new java.lang.NullPointerException();
        }
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
                    case 8: {

                        status_ = input.readInt32();
                        break;
                    }
                    default: {
                        if (!parseUnknownField(
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
        return io.wilderness.warp.Chat.internal_static_warp_S2CLoginRes_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
        return io.wilderness.warp.Chat.internal_static_warp_S2CLoginRes_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        io.wilderness.warp.S2CLoginRes.class, io.wilderness.warp.S2CLoginRes.Builder.class);
    }

    public static final int STATUS_FIELD_NUMBER = 1;
    private int status_;

    /**
     * <code>int32 status = 1;</code>
     *
     * @return The status.
     */
    public int getStatus() {
        return status_;
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
        if (status_ != 0) {
            output.writeInt32(1, status_);
        }
        unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (status_ != 0) {
            size += com.google.protobuf.CodedOutputStream
                    .computeInt32Size(1, status_);
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
        if (!(obj instanceof io.wilderness.warp.S2CLoginRes)) {
            return super.equals(obj);
        }
        io.wilderness.warp.S2CLoginRes other = (io.wilderness.warp.S2CLoginRes) obj;

        if (getStatus()
                != other.getStatus()) return false;
        if (!unknownFields.equals(other.unknownFields)) return false;
        return true;
    }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (37 * hash) + STATUS_FIELD_NUMBER;
        hash = (53 * hash) + getStatus();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static io.wilderness.warp.S2CLoginRes parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static io.wilderness.warp.S2CLoginRes parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static io.wilderness.warp.S2CLoginRes parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static io.wilderness.warp.S2CLoginRes parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static io.wilderness.warp.S2CLoginRes parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static io.wilderness.warp.S2CLoginRes parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static io.wilderness.warp.S2CLoginRes parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static io.wilderness.warp.S2CLoginRes parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static io.wilderness.warp.S2CLoginRes parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static io.wilderness.warp.S2CLoginRes parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static io.wilderness.warp.S2CLoginRes parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static io.wilderness.warp.S2CLoginRes parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(io.wilderness.warp.S2CLoginRes prototype) {
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
     * Protobuf type {@code warp.S2CLoginRes}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:warp.S2CLoginRes)
            io.wilderness.warp.S2CLoginResOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return io.wilderness.warp.Chat.internal_static_warp_S2CLoginRes_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return io.wilderness.warp.Chat.internal_static_warp_S2CLoginRes_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            io.wilderness.warp.S2CLoginRes.class, io.wilderness.warp.S2CLoginRes.Builder.class);
        }

        // Construct using io.wilderness.warp.S2CLoginRes.newBuilder()
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
            status_ = 0;

            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return io.wilderness.warp.Chat.internal_static_warp_S2CLoginRes_descriptor;
        }

        @java.lang.Override
        public io.wilderness.warp.S2CLoginRes getDefaultInstanceForType() {
            return io.wilderness.warp.S2CLoginRes.getDefaultInstance();
        }

        @java.lang.Override
        public io.wilderness.warp.S2CLoginRes build() {
            io.wilderness.warp.S2CLoginRes result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public io.wilderness.warp.S2CLoginRes buildPartial() {
            io.wilderness.warp.S2CLoginRes result = new io.wilderness.warp.S2CLoginRes(this);
            result.status_ = status_;
            onBuilt();
            return result;
        }

        @java.lang.Override
        public Builder clone() {
            return super.clone();
        }

        @java.lang.Override
        public Builder setField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                java.lang.Object value) {
            return super.setField(field, value);
        }

        @java.lang.Override
        public Builder clearField(
                com.google.protobuf.Descriptors.FieldDescriptor field) {
            return super.clearField(field);
        }

        @java.lang.Override
        public Builder clearOneof(
                com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return super.clearOneof(oneof);
        }

        @java.lang.Override
        public Builder setRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                int index, java.lang.Object value) {
            return super.setRepeatedField(field, index, value);
        }

        @java.lang.Override
        public Builder addRepeatedField(
                com.google.protobuf.Descriptors.FieldDescriptor field,
                java.lang.Object value) {
            return super.addRepeatedField(field, value);
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof io.wilderness.warp.S2CLoginRes) {
                return mergeFrom((io.wilderness.warp.S2CLoginRes) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(io.wilderness.warp.S2CLoginRes other) {
            if (other == io.wilderness.warp.S2CLoginRes.getDefaultInstance()) return this;
            if (other.getStatus() != 0) {
                setStatus(other.getStatus());
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
            io.wilderness.warp.S2CLoginRes parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (io.wilderness.warp.S2CLoginRes) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private int status_;

        /**
         * <code>int32 status = 1;</code>
         *
         * @return The status.
         */
        public int getStatus() {
            return status_;
        }

        /**
         * <code>int32 status = 1;</code>
         *
         * @param value The status to set.
         * @return This builder for chaining.
         */
        public Builder setStatus(int value) {

            status_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>int32 status = 1;</code>
         *
         * @return This builder for chaining.
         */
        public Builder clearStatus() {

            status_ = 0;
            onChanged();
            return this;
        }

        @java.lang.Override
        public final Builder setUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.setUnknownFields(unknownFields);
        }

        @java.lang.Override
        public final Builder mergeUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.mergeUnknownFields(unknownFields);
        }


        // @@protoc_insertion_point(builder_scope:warp.S2CLoginRes)
    }

    // @@protoc_insertion_point(class_scope:warp.S2CLoginRes)
    private static final io.wilderness.warp.S2CLoginRes DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new io.wilderness.warp.S2CLoginRes();
    }

    public static io.wilderness.warp.S2CLoginRes getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<S2CLoginRes>
            PARSER = new com.google.protobuf.AbstractParser<S2CLoginRes>() {
        @java.lang.Override
        public S2CLoginRes parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new S2CLoginRes(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<S2CLoginRes> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<S2CLoginRes> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public io.wilderness.warp.S2CLoginRes getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}

