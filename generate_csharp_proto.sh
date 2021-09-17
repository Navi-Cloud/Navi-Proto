#!/bin/bash

# First Argument - Package Version
PUSH_VERSION=$1

# Second Argument - API Key
PUSH_API=$2

# Declaration
TMP_DIRECTORY="./tmp"
BUILD_DIRECTORY="./Build"
OS_HW_VARIANTS="macosx_x64"

# Clean Source Directory First
rm -rf ./Source
mkdir ./Source

# Check for directory exists
if [ ! -d "${TMP_DIRECTORY}" ]; then
    mkdir $TMP_DIRECTORY
fi

# Download Files
NUGET_GRPC_PACKAGE="${TMP_DIRECTORY}/grpc_tools.zip"
curl -L https://www.nuget.org/api/v2/package/Grpc.Tools/2.40.0 > $NUGET_GRPC_PACKAGE

# Install GRPC Tools
unzip $NUGET_GRPC_PACKAGE -d $TMP_DIRECTORY

# Permission...
chmod -R a+x $TMP_DIRECTORY

# Default Hardware / OS Type is set to macOS.
# But if this script is running on some linux-environment, we have to set HW Variants to Linux.
if [[ "$OSTYPE" == "linux"* ]]; then
    OS_HW_VARIANTS="linux_x64"
fi

# Setup tool path
PROTOC_TOOLS_PATH=$TMP_DIRECTORY/tools/$OS_HW_VARIANTS
PROTOC=$PROTOC_TOOLS_PATH/protoc
PROTOC_GRPC_CSHARP_PLUGIN=$PROTOC_TOOLS_PATH/grpc_csharp_plugin

# Do execute protoc
$PROTOC --plugin=protoc-gen-grpc=$PROTOC_GRPC_CSHARP_PLUGIN --proto_path=./Protos --proto_path=$TMP_DIRECTORY/build/native/include --csharp_out=./Source --grpc_out=./Source AuthenticationService/CommunicationMessage.proto
$PROTOC --plugin=protoc-gen-grpc=$PROTOC_GRPC_CSHARP_PLUGIN --proto_path=./Protos --proto_path=$TMP_DIRECTORY/build/native/include --csharp_out=./Source --grpc_out=./Source AuthenticationService/UserService.proto
$PROTOC --plugin=protoc-gen-grpc=$PROTOC_GRPC_CSHARP_PLUGIN --proto_path=./Protos --proto_path=$TMP_DIRECTORY/build/native/include --csharp_out=./Source --grpc_out=./Source StorageService/StorageMessage.proto
$PROTOC --plugin=protoc-gen-grpc=$PROTOC_GRPC_CSHARP_PLUGIN --proto_path=./Protos --proto_path=$TMP_DIRECTORY/build/native/include --csharp_out=./Source --grpc_out=./Source CommonCommunication.proto

# Create CSProject
cat << EOF > ./Source/SharedService.csproj
<Project Sdk="Microsoft.NET.Sdk">
  <PropertyGroup>
    <TargetFramework>net5.0</TargetFramework>
    <PackageId>NaviSharedService</PackageId>
EOF

# We need to set version manually;
echo "<Version>${PUSH_VERSION}</Version>" >> ./Source/SharedService.csproj

# Append Again
cat << EOF >> ./Source/SharedService.csproj
    <Authors>Jason. HW. Kang[KangDroid]</Authors>
    <Company>Navi-Cloud</Company>
  </PropertyGroup>
  <ItemGroup>
    <PackageReference Include="Grpc.AspNetCore.Server" Version="2.39.0" />
    <PackageReference Include="Grpc.Tools" Version="2.40.0">
        <IncludeAssets>runtime; build; native; contentfiles; analyzers; buildtransitive</IncludeAssets>
        <PrivateAssets>all</PrivateAssets>
    </PackageReference>
    <PackageReference Include="Microsoft.AspNetCore.Grpc.HttpApi" Version="0.1.0-alpha.21317.5" />
  </ItemGroup>
</Project>
EOF

# Change CWD
cd ./Source

# Build it
dotnet pack

# Locate File
NUGET_PACKAGE_LOCATION=$(pwd)/bin/Debug/NaviSharedService.${PUSH_VERSION}.nupkg

# Push it
# dotnet nuget push ${NUGET_PACKAGE_LOCATION} --api-key ${PUSH_API} --source https://api.nuget.org/v3/index.json

# Cleanup
cd ..
rm -rf $TMP_DIRECTORY ./Source