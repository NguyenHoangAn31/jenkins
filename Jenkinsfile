pipeline {
    agent any
    
    tools {
        maven 'Maven'
        jdk 'jdk-21' // Cấu hình Jenkins để sử dụng JDK 21 đã được cài đặt
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
