pipeline {

    agent any


    tools {
        jdk 'jdk-21'
    }
    
    stages {
        stage('Check Java Version') {
            steps {

                sh 'java --version'
            }
        }
    }
}
