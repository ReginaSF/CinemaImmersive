// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: S03.proto

package S03Cinema_Lights;

public final class S03CinemaLights {
  private S03CinemaLights() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_S03Cinema_lights_LightsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_S03Cinema_lights_LightsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_S03Cinema_lights_LightsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_S03Cinema_lights_LightsResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tS03.proto\022\020S03Cinema_lights\"5\n\rLightsR" +
      "equest\022\023\n\013room_number\030\001 \001(\t\022\017\n\007command\030\002" +
      " \001(\t\" \n\016LightsResponse\022\016\n\006status\030\001 \001(\t2k" +
      "\n\023CinemaLightsService\022T\n\rControlLights\022\037" +
      ".S03Cinema_lights.LightsRequest\032 .S03Cin" +
      "ema_lights.LightsResponse(\001B%\n\020S03Cinema" +
      "_LightsB\017S03CinemaLightsP\001b\006proto3"
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
    internal_static_S03Cinema_lights_LightsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_S03Cinema_lights_LightsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_S03Cinema_lights_LightsRequest_descriptor,
        new java.lang.String[] { "RoomNumber", "Command", });
    internal_static_S03Cinema_lights_LightsResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_S03Cinema_lights_LightsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_S03Cinema_lights_LightsResponse_descriptor,
        new java.lang.String[] { "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
