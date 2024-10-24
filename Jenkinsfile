pipeline {
    
    agent any
    
    environment {
        MAVEN_HOME = tool 'Maven'
    }

     tools {
        Maven 'Maven'
    }
    
    stages {
        stage('Check Maven Version') {
            steps {
                // Kiểm tra phiên bản Maven
                echo "MAVEN_HOME is ${MAVEN_HOME}"
                sh "${MAVEN_HOME}/bin/mvn -v"
                sh 'mvn -v'
            }
        }
    }
}
