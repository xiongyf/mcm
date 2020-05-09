node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
    //   git 'https://github.com/xiongyf/mcm.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.
    //   mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
      withEnv(["MVN_HOME=$mvnHome"]) {
         if (isUnix()) {
            sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
         } else {
            //bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
         }
      }
   }
   stage('Deploy') {
       bat(/java -jar C:\dev\Jenkins\workspace\mcm\target\mcm-0.0.1-SNAPSHOT.jar /)
   }

}