name := "geochat"

version := "1.0"

mainClass := Some("JettyLauncher")

seq(webSettings :_*)

port in container.Configuration := 8080

externalResolvers <<= resolvers map { rs =>
  Resolver.withDefaultResolvers(rs, scalaTools = false)
}

libraryDependencies ++= Seq(
  "org.mortbay.jetty" % "servlet-api" % "3.0.20100224" % "provided",
  "org.eclipse.jetty" % "jetty-server" % "8.0.0.M3" % "container",
  "org.eclipse.jetty" % "jetty-util" % "8.0.0.M3" % "container",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.0.M3" % "container",
  "org.mortbay.jetty" % "jsp-impl" % "2.2.2.b05.0" % "container",
  "javax.servlet.jsp" % "jsp-api" % "2.1" % "container"
)


