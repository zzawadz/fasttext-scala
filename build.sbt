name := "fasttext-scala"

scalaVersion := "2.12.4"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"

libraryDependencies += "org.scalanlp" %% "breeze" % "0.13.2"
libraryDependencies += "org.scalanlp" %% "breeze-natives" % "0.13.2"

resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
