pipeline {
    agent any
    
    stages {
        stage('Build with Java 21') {
            agent {
                docker {
                    image 'openjdk:21-jdk'  // Sử dụng Docker image với Java 21
                    args '-v /root/.m2:/root/.m2'  // Mount thư mục Maven cache để giảm thời gian build
                }
            }
            steps {
                script {
                    // Chạy các lệnh Maven bên trong container với Java 21
                    sh 'mvn clean install'
                }
            }
        }
    }
}
