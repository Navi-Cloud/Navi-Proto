#!/bin/bash

# Define CWD
CURRENT_WORKING_DIRECTORY=$(pwd)

# Define Directories
TMP_DIRECTORY="${CURRENT_WORKING_DIRECTORY}/tmp"
BUILD_DIRECTORY="${CURRENT_WORKING_DIRECTORY}/Build"
SOURCE_DIRECTORY="${CURRENT_WORKING_DIRECTORY}/JVMSource"
JVM_OUT_DIRECTORY="${SOURCE_DIRECTORY}/lib/src/main/java"
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
curl -L https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/1.40.1/protoc-gen-grpc-java-1.40.1-linux-x86_64.exe > $KOTLIN_GRPC_PACKAGE
chmod a+x $KOTLIN_GRPC_PACKAGE

# Setup Gradle Jar Repository
cd ${SOURCE_DIRECTORY}
unzip $CURRENT_WORKING_DIRECTORY/gradle_template.zip
rm -rf lib/src/main/java/io
cd ${CURRENT_WORKING_DIRECTORY}

# Execute
PROTOC=$(which protoc)
$PROTOC --plugin=protoc-gen-grpc=$KOTLIN_GRPC_PACKAGE --proto_path=./Protos --java_out=${JVM_OUT_DIRECTORY} --grpc_out=${JVM_OUT_DIRECTORY} CommonCommunication.proto
$PROTOC --plugin=protoc-gen-grpc=$KOTLIN_GRPC_PACKAGE --proto_path=./Protos --java_out=${JVM_OUT_DIRECTORY} --grpc_out=${JVM_OUT_DIRECTORY} AuthenticationService/UserService.proto
$PROTOC --plugin=protoc-gen-grpc=$KOTLIN_GRPC_PACKAGE --proto_path=./Protos --java_out=${JVM_OUT_DIRECTORY} --grpc_out=${JVM_OUT_DIRECTORY} AuthenticationService/CommunicationMessage.proto
$PROTOC --plugin=protoc-gen-grpc=$KOTLIN_GRPC_PACKAGE --proto_path=./Protos --java_out=${JVM_OUT_DIRECTORY} --grpc_out=${JVM_OUT_DIRECTORY} StorageService/FolderService.proto
$PROTOC --plugin=protoc-gen-grpc=$KOTLIN_GRPC_PACKAGE --proto_path=./Protos --java_out=${JVM_OUT_DIRECTORY} --grpc_out=${JVM_OUT_DIRECTORY} StorageService/StorageMessage.proto
PROTOC_RESULT=$?
# If Protoc failed, Log it
if [ $PROTOC_RESULT -ne 0 ]; then
    echo "Seems like protoc failed, with code number ${PROTOC_RESULT}."
fi

# Build Library
cd ${SOURCE_DIRECTORY}

# Publish to Repository
./gradlew clean build publish
buildResult=$?

# If publishing failed, exit now.
if [ $buildResult -ne 0 ]; then
    echo "Gradlew exited with ${buildResult}. Exiting Script."

    # Cleanup
    cd ${CURRENT_WORKING_DIRECTORY}
    rm -rf $TMP_DIRECTORY # ${SOURCE_DIRECTORY}
    exit $buildResult
fi

./gradlew closeRepository
cd ${CURRENT_WORKING_DIRECTORY}

# Cleanup
rm -rf $TMP_DIRECTORY # ${SOURCE_DIRECTORY}