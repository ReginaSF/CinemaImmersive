// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: S02.proto

package S02Seat_Water;

public final class Serv02Seat_Water {
  private Serv02Seat_Water() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_artifact_cinema_ActivateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_artifact_cinema_ActivateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_artifact_cinema_ActivateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_artifact_cinema_ActivateResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tS02.proto\022\017artifact_cinema\"\035\n\017Activate" +
      "Request\022\n\n\002on\030\001 \001(\t\"#\n\020ActivateResponse\022" +
      "\017\n\007message\030\001 \001(\t2v\n\014S02SeatWater\022f\n\035Acti" +
      "vateWaterImmersiveFeature\022 .artifact_cin" +
      "ema.ActivateRequest\032!.artifact_cinema.Ac" +
      "tivateResponse0\001B#\n\rS02Seat_WaterB\020Serv0" +
      "2Seat_WaterP\001b\006proto3"
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
    internal_static_artifact_cinema_ActivateRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_artifact_cinema_ActivateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_artifact_cinema_ActivateRequest_descriptor,
        new java.lang.String[] { "On", });
    internal_static_artifact_cinema_ActivateResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_artifact_cinema_ActivateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_artifact_cinema_ActivateResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
