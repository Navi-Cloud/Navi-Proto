// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: StorageService/FolderService.proto

package navistorage;

public final class FolderService {
  private FolderService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\"StorageService/FolderService.proto\022\013na" +
      "vistorage\032#StorageService/StorageMessage" +
      ".proto\032\031CommonCommunication.proto2\214\001\n\006Fo" +
      "lder\022A\n\020CreateRootFolder\022$.navistorage.C" +
      "reateRootFolderRequest\032\007.Result\022?\n\017FindI" +
      "nsideFiles\022#.navistorage.FindInsideFiles" +
      "Request\032\007.ResultB\025\252\002\022NaviStorageServiceb" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          navistorage.StorageMessage.getDescriptor(),
          CommonCommunication.getDescriptor(),
        });
    navistorage.StorageMessage.getDescriptor();
    CommonCommunication.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}