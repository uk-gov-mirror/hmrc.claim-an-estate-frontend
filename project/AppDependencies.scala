import sbt._

object AppDependencies {
  import play.core.PlayVersion

  private val compile: Seq[ModuleID] = Seq(
    play.sbt.PlayImport.ws,
    "org.reactivemongo" %% "play2-reactivemongo"           % "0.18.8-play27",
    "uk.gov.hmrc"       %% "logback-json-logger"           % "4.8.0",
    "uk.gov.hmrc"       %% "govuk-template"                % "5.56.0-play-27",
    "uk.gov.hmrc"       %% "play-health"                   % "3.15.0-play-27",
    "uk.gov.hmrc"       %% "play-ui"                       % "8.12.0-play-27",
    "uk.gov.hmrc"       %% "play-conditional-form-mapping" % "1.3.0-play-26",
    "uk.gov.hmrc"       %% "bootstrap-frontend-play-27"    % "2.25.0",
    "uk.gov.hmrc"       %% "play-language"                 % "4.10.0-play-27"
  )

  private val test: Seq[ModuleID] = Seq(
    "org.scalatest"          %% "scalatest"          % "3.0.7",
    "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.0",
    "org.pegdown"            %  "pegdown"            % "1.6.0",
    "org.jsoup"              %  "jsoup"              % "1.12.1",
    "com.typesafe.play"      %% "play-test"          % PlayVersion.current,
    "org.mockito"            %  "mockito-all"        % "1.10.19",
    "org.scalacheck"         %% "scalacheck"         % "1.14.1",
    "com.github.tomakehurst" % "wiremock-standalone" % "2.17.0"
  ).map(_ % Test)

  def apply(): Seq[ModuleID] = compile ++ test

  private val akkaVersion: String = "2.6.7"
  private val akkaHttpVersion: String = "10.1.12"

  val overrides = Seq(
    "com.typesafe.akka" %% "akka-stream_2.12"    % akkaVersion,
    "com.typesafe.akka" %% "akka-protobuf_2.12"  % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j_2.12"     % akkaVersion,
    "com.typesafe.akka" %% "akka-actor_2.12"     % akkaVersion,
    "com.typesafe.akka" %% "akka-http-core_2.12" % akkaHttpVersion
  )
}
