val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "rock-paper-scissors-scala",
    version := "0.1.0-SNAPSHOT",
    javacOptions ++= Seq("-source", "17"),
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
 
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.8.0",

    // https://mvnrepository.com/artifact/org.jsoup/jsoup
    libraryDependencies += "org.jsoup" % "jsoup" % "1.15.3",
    
    // spring
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-data-jpa" % "2.2.5.RELEASE",
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-parent" % "2.2.5.RELEASE" pomOnly (),
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "2.2.5.RELEASE",
    // webjars
    libraryDependencies += "org.webjars" % "bootstrap" % "3.1.1",
    libraryDependencies += "org.webjars" % "jquery" % "2.1.0-2",

    // thymeleaf
    // libraryDependencies += "org.thymeleaf" % "thymeleaf-spring4" % "2.1.2.RELEASE",
    // libraryDependencies += "org.hibernate" % "hibernate-validator" % "5.0.2.Final",
    // libraryDependencies += "nz.net.ultraq.thymeleaf" % "thymeleaf-layout-dialect" % "1.2.1",
    // libraryDependencies += "org.hsqldb" % "hsqldb" % "2.3.1",
    // libraryDependencies += "org.springframework.boot" % "spring-boot-starter-tomcat" % "1.0.2.RELEASE" % "provided",
    // libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",
    // libraryDependencies += "org.apache.tomcat.embed" % "tomcat-embed-core" % "7.0.53" % "container",
    // libraryDependencies += "org.apache.tomcat.embed" % "tomcat-embed-logging-juli" % "7.0.53" % "container",
    // libraryDependencies += "org.apache.tomcat.embed" % "tomcat-embed-jasper" % "7.0.53" % "container"
  )
