#!/bin/bash

# Define CWD
CURRENT_WORKING_DIRECTORY=$(pwd)

# Define Directories
TMP_DIRECTORY="${CURRENT_WORKING_DIRECTORY}/tmp"
BUILD_DIRECTORY="${CURRENT_WORKING_DIRECTORY}/Build"
SOURCE_DIRECTORY="${CURRENT_WORKING_DIRECTORY}/JVMSource"
OS_HW_VARIANTS=""

# Clean Source Directory First
rm -rf ${SOURCE_DIRECTORY}
mkdir ${SOURCE_DIRECTORY}

# Check for directory exists
if [ ! -d "${TMP_DIRECTORY}" ]; then
    mkdir $TMP_DIRECTORY
fi

# Download GRPC-Kotlin
KOTLIN_GRPC_PACKAGE="${TMP_DIRECTORY}/protoc_plugin"
curl -L https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/1.40.1/protoc-gen-grpc-java-1.40.1-osx-x86_64.exe > $KOTLIN_GRPC_PACKAGE
chmod a+x $KOTLIN_GRPC_PACKAGE

# Execute
PROTOC=$(which protoc)
$PROTOC --plugin=protoc-gen-grpc=$KOTLIN_GRPC_PACKAGE --proto_path=./Protos --java_out=${SOURCE_DIRECTORY} --grpc_out=${SOURCE_DIRECTORY} AuthenticationService/UserService.proto
$PROTOC --plugin=protoc-gen-grpc=$KOTLIN_GRPC_PACKAGE --proto_path=./Protos --java_out=${SOURCE_DIRECTORY} --grpc_out=${SOURCE_DIRECTORY} AuthenticationService/CommunicationMessage.proto

# Cleanup
rm -rf $TMP_DIRECTORY