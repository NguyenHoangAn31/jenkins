pipeline {

    agent any


    tools {
        jdk 'jdk-21'
        maven 'Maven'
    }
    
    stages {
        stage('Check Java Version') {
            steps {
                sh 'mvn -v'
                sh 'java --version'
            }
        }
    }
}
