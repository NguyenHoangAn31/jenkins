pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        JAVA_HOME = '/var/jenkins_home/jdk-21' // Đường dẫn tới JDK 21 trong Docker container
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}" // Cập nhật PATH để sử dụng JDK 21
    }

    stages {
        stage('Check Java and Maven Version') {
            steps {
                sh 'echo $JAVA_HOME' // Kiểm tra biến JAVA_HOME đã thiết lập đúng chưa
                sh 'java -version' // Kiểm tra phiên bản Java
                sh 'mvn -v' // Kiểm tra phiên bản Maven
            }
        }
    }
}
