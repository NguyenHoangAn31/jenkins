pipeline {
    agent any

    tools {
        jdk 'jdk-21' // Cấu hình Jenkins để sử dụng JDK 21 đã được cài đặt
    }

    stages {
        stage('Check Maven Version') {
            steps {
                script {
                    // Lấy đường dẫn đến JDK 21
                    def jdkHome = tool(name: 'jdk-21', type: 'jdk')
                    // Cài đặt JAVA_HOME cho Java 21
                    env.JAVA_HOME = jdkHome
                    // Kiểm tra phiên bản Java bằng lệnh với đường dẫn đầy đủ
                    sh "${env.JAVA_HOME}/bin --version"
                }
                // Kiểm tra phiên bản Java hiện đang sử dụng
                sh 'java -version' // Có thể cần thêm thông tin nếu không sử dụng JAVA_HOME
            }
        }
    }
}
