pipeline {
    agent any
    
    tools {
        maven 'Maven'
        jdk 'Jdk-21' // Cấu hình Jenkins để sử dụng JDK 21 đã được cài đặt
    }

    environment {
        JAVA_HOME = '/var/jenkins_home/jdk-21' // Đường dẫn tới JDK 21 trong Docker container
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}" // Cập nhật PATH để sử dụng JDK 21
    }
    
    stages {
        stage('Check Maven Version') {
            steps {
                sh 'mvn -v' // Kiểm tra phiên bản Maven và Java
                sh 'java -version' // Kiểm tra phiên bản Java hiện đang sử dụng
            }
        }
    }
}
