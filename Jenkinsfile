pipeline {
    agent any

    tools {
        jdk 'jdk-21' // Cấu hình Jenkins để sử dụng JDK 21 đã được cài đặt
    }

    stages {
        stage('Check Maven Version') {
            steps {
                sh 'java -version' // Kiểm tra phiên bản Java hiện đang sử dụng
            }
        }
    }
}
