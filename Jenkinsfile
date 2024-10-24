pipeline {
    agent any
    environment {
        MAVEN_HOME = tool 'Maven from config' // Tên Maven đã cấu hình trong Jenkins
    }
    stages {
        stage('Hello') {
            steps {
                echo 'Hello World from slave_branch'
            }
        }
        stage('Check Maven Version') {
            steps {
                // Kiểm tra phiên bản Maven
                echo "MAVEN_HOME is ${MAVEN_HOME}"
                sh "${MAVEN_HOME}/bin/mvn -v"
            }
        }
    }
}
