fabric-distributed-osgi-sample
==============================

Fuse Fabric Distributed OSGi Sample

This is a an example application that is very loosely based on the Unix finger command. Users can update their
plan, and the plan of any user can be examined.

This example shows a simple CXF REST service (the finger service) that can be deployed to a Fuse Fabric container. The
REST service references an OSGi service in the usual manner.

The plan service is the OSGi service. There is an API project (plan-iface) and an implementation service (plan-impl).
The implementation service takes advantage of the distributed OSGi extensions to indicate the service is to 
be registered with the Fabric registry. Components that need to bind to the service first look to the local OSGi
registry, and then look in the Fabric registry for a service exporting the desired interface, all of this happening
behind the scenes based on Fabric magic.

After building the project and deploying it to a repository your fabric can install profiles from, create
the following profiles:

fabric:profile-create --version 2.0 finger-service
fabric:profile-edit --repositories mvn:fuse-sample/finger-feature/1.0-SNAPSHOT/xml/features finger-service 2.0
fabric:profile-edit --features finger-service finger-service 2.0
fabric:profile-edit --pid org.ops4j.pax.web.properties/org.osgi.service.http.port=9666 finger-service 2.0

fabric:profile-create --version 2.0 plan-service
fabric:profile-edit --repositories mvn:fuse-sample/finger-feature/1.0-SNAPSHOT/xml/features plan-service 2.0
fabric:profile-edit --features plan-service plan-service 2.0

Create a container to install the finger-service profile into, and a container to install the plan-service profile
into. The finger-service container will need to have the cxf and dosgi profiles installed as well, and 
the plan-service container needs to dosgi profile installed.

Once installed the REST service can be invoked on the finger-service container:

PUT http://vc2c09dal2317:9666/cxf/finger-rs/finger/plan/a045103 HTTP/1.1
Accept-Encoding: gzip,deflate
Content-Type: application/xml
User-Agent: Jakarta Commons-HttpClient/3.1
Host: ahost:9666
Content-Length: 25

Trying out some services.

GET http://vc2c09dal2317:9666/cxf/finger-rs/finger/plan/a045103 HTTP/1.1
Accept-Encoding: gzip,deflate
User-Agent: Jakarta Commons-HttpClient/3.1
Host: ahost:9666
