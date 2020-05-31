node{
    echo "begin"
    def curPath=pwd();
//    def jenkinsPipelinFolder="jenkinsPipeline"
//    bat("/mkdir -p ${jenkinsPipelinFolder}")


    stage("run node file"){
        dir("${curPath}"){

            echo "checkout js script..."
            checkout([$class: 'GitSCM', branches: [[name: '*/master']],
                      doGenerateSubmoduleConfigurations: false,
                      extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'mcm']],
                      submoduleCfg: [],
                      userRemoteConfigs: [[credentialsId: '26c21ae3-d9f2-4ddd-b68d-ca4d38042eb7', url: 'https://github.com/xiongyf/mcm.git']]]
            )
            echo "run js script..."
            bat(/node mcm\jenkinsfile\hellonode.js/)
            echo "run js script end."
        }
    }
}