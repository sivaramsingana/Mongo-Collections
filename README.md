# Mongo-Collections
This repository contains springboot application which uses MongoDB and performs CURD operations using Redhat Openshift.

# Application Installation on RedHat Openshift

Redhat provides different options to build and deploy applications.Here I am using binary file to install my application.

# Note: 

1)Make sure you had tested and build you code before proceeding to deploy application.
2)Add your mongodb installation/pod details in application.properties file.

# Source code
Clone the source code from below github repository.
'https://github.com/sivaramsingana/Mongo-Collections/'

Get the JAR application archive or build the application locally from below github repository

# Building your Application

Try to run 'mvn clean package' to build your code.After this step is completed, A jar file will be generated in targer folder/directory.

# Deploy your application to RedHat OpenShift
Create new directory and copy jar file from target folder/directory to newly created directory.

'[root@p1299-bastion Mongo-Collections-master]# mkdir -p /home/cecuser/sivaram/mongoapp

[root@p1299-bastion Mongo-Collections-master]# cp target/demo-0.0.1-SNAPSHOT.jar /home/cecuser/sivaram/mongoapp/'

get list of image streams available in your namespace using below command
'oc get is -n <NAMESPACE>'
 
 Create a new build for you application mongo-collections
  '[root@p1299-bastion Mongo-Collections-master]# oc new-build --binary=true --name=mongo-collections --image-stream=openjdk18-openshift
--> Found image f726d5b (5 weeks old) in image stream "sivaram/openjdk18-openshift" under tag "latest" for "openjdk18-openshift"

    Java Applications
    -----------------
    Platform for building and running plain Java applications (fat-jar and flat classpath)

    Tags: builder, java

    * A source build using binary input will be created
      * The resulting image will be pushed to image stream tag "mongo-collections:latest"
      * A binary build was created, use 'oc start-build --from-dir' to trigger a new build

--> Creating resources with label build=mongo-collections ...
    imagestream.image.openshift.io "mongo-collections" created
    buildconfig.build.openshift.io "mongo-collections" created
--> Success '
  
  After creating build, Start your build 
  
'[root@p1299-bastion Mongo-Collections-master]# oc start-build mongo-collections --from-dir=/home/cecuser/sivaram/mongoapp --follow
Uploading directory "/home/cecuser/sivaram/mongoapp" as binary input for the build ...
.
Uploading finished
build.build.openshift.io/mongo-collections-1 started
Receiving source from STDIN as archive ...
Caching blobs under "/var/cache/blobs".
Getting image source signatures
Copying blob sha256:7d2d8330490119f01d1087adb98a324b3292f4711436cc4f64a8d9cb081fc345
Copying blob sha256:34daf4d14ac5dcdeedd611cf829dd51f54de97deed263eb64150920a9faed5cb
Copying blob sha256:8439df3c99adfcd1a5e2abd20579f0bbbf006ddbc140819a664cd363bb284714
Copying config sha256:f726d5ba29ccd27a25827ecd5b52e5a5364c0f9e75e245d5e567b928e2044847
Writing manifest to image destination
Storing signatures
Generating dockerfile with builder image registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift@sha256:cca0100eedb4e3596ff788a5370652989f890e2bd1d056302c5cd5c8ccb94739
STEP 1: FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift@sha256:cca0100eedb4e3596ff788a5370652989f890e2bd1d056302c5cd5c8ccb94739
STEP 2: LABEL "io.openshift.s2i.destination"="/tmp"       "io.openshift.build.image"="registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift@sha256:cca0100eedb4e3596ff788a5370652989f890e2bd1d056302c5cd5c8ccb94739"       "io.openshift.build.source-location"="/tmp/build/inputs"
STEP 3: ENV OPENSHIFT_BUILD_NAME="mongo-collections-1"     OPENSHIFT_BUILD_NAMESPACE="sivaram"
STEP 4: USER root
STEP 5: COPY upload/src /tmp/src
STEP 6: RUN chown -R 185:0 /tmp/src
time="2021-05-31T11:26:03Z" level=warning msg="Path \"/run/secrets/etc-pki-entitlement\" from \"/etc/containers/mounts.conf\" doesn't exist, skipping"
time="2021-05-31T11:26:03Z" level=warning msg="Path \"/run/secrets/redhat.repo\" from \"/etc/containers/mounts.conf\" doesn't exist, skipping"
STEP 7: USER 185
STEP 8: RUN /usr/local/s2i/assemble
time="2021-05-31T11:26:06Z" level=warning msg="Path \"/run/secrets/etc-pki-entitlement\" from \"/etc/containers/mounts.conf\" doesn't exist, skipping"
time="2021-05-31T11:26:06Z" level=warning msg="Path \"/run/secrets/redhat.repo\" from \"/etc/containers/mounts.conf\" doesn't exist, skipping"
INFO S2I source build with plain binaries detected
INFO Copying binaries from /tmp/src to /deployments ...
demo-0.0.1-SNAPSHOT.jar
STEP 9: CMD /usr/local/s2i/run
STEP 10: COMMIT temp.builder.openshift.io/sivaram/mongo-collections-1:41550ac2
Getting image source signatures
Copying blob sha256:48872510135f5f382446a7e4fb03a5d975a83211b14aa3ca76c5d04f6cb6c887
Copying blob sha256:e0f9057e45d82a6dae17d05792f54dead697435c73ef4248f878003fb3e5d270
Copying blob sha256:80916b81b4146d1cfab769c11f73a07ab67bd6ea0a6871aefef5134258316035
Copying blob sha256:e8bd5c205244f92acbddcf4f7fec30efb90563c18298166ed0ec22101b69cf6f
Copying config sha256:e174f8adc5dfefba3e23e97e78d20173fde6cd0822a427ca571a751079658c64
Writing manifest to image destination
Storing signatures
--> e174f8adc5d
e174f8adc5dfefba3e23e97e78d20173fde6cd0822a427ca571a751079658c64

Pushing image image-registry.openshift-image-registry.svc:5000/sivaram/mongo-collections:latest ...
Getting image source signatures
Copying blob sha256:8439df3c99adfcd1a5e2abd20579f0bbbf006ddbc140819a664cd363bb284714
Copying blob sha256:34daf4d14ac5dcdeedd611cf829dd51f54de97deed263eb64150920a9faed5cb
Copying blob sha256:7d2d8330490119f01d1087adb98a324b3292f4711436cc4f64a8d9cb081fc345
Copying blob sha256:e8bd5c205244f92acbddcf4f7fec30efb90563c18298166ed0ec22101b69cf6f
Copying config sha256:e174f8adc5dfefba3e23e97e78d20173fde6cd0822a427ca571a751079658c64
Writing manifest to image destination
Storing signatures
Successfully pushed image-registry.openshift-image-registry.svc:5000/sivaram/mongo-collections@sha256:0271e456ae34b2114b313a0e0d18cdf5dfeab18a322c9fb58777403c3aed5a47
Push successful '

Now create your application
  
'[root@p1299-bastion Mongo-Collections-master]# oc new-app mongo-collections
--> Found image e174f8a (57 seconds old) in image stream "sivaram/mongo-collections" under tag "latest" for "mongo-collections"

    Java Applications
    -----------------
    Platform for building and running plain Java applications (fat-jar and flat classpath)

    Tags: builder, java


--> Creating resources ...
    deployment.apps "mongo-collections" created
    service "mongo-collections" created
--> Success
    Application is not exposed. You can expose services to the outside world by executing one or more of the commands below:
     'oc expose service/mongo-collections'
    Run 'oc status' to view your app. '
  
Now check if pod is created

'[root@p1299-bastion Mongo-Collections-master]# oc get pods
NAME                                                              READY   STATUS      RESTARTS   AGE
helm-mongo-ibm-mongodb-enterprise-helm-deployment-bfc946b88lnlt   1/1     Running     0          11d
mongo-collections-1-build                                         0/1     Completed   0          3m3s
mongo-collections-5f778dbbb8-5pd9x                                1/1     Running     0          76s '
 
Now check your service for mongo-collections app and expose your service
 
'[root@p1299-bastion Mongo-Collections-master]# oc get svc -o name
service/helm-mongo-ibm-mongodb-enterprise-helm-service
service/mongo-collections
[root@p1299-bastion Mongo-Collections-master]# oc expose svc/mongo-collections
route.route.openshift.io/mongo-collections exposed '


  


