node{
    echo "begin"
    stage("run node file"){
        bat(/node hellonode.js/)
    }
}