pipeline {
    agent any

   

    stages {
        stage('Set Java Home') {
            steps {
                script {
                    // Thiết lập JAVA_HOME
                    env.JAVA_HOME = '/var/jenkins_home/jdk-21'
                    env.PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
                }
            }
        }
        stage('Check Java and Maven Version') {
            steps {
                sh 'echo $JAVA_HOME' // Kiểm tra biến JAVA_HOME đã thiết lập đúng chưa
                sh 'java -version' // Kiểm tra phiên bản Java
            }
        }
    }
}
