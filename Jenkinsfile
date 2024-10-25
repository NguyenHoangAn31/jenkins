pipeline {
    
    agent any
    
  

    tools {
        maven 'Maven'
        jdk 'Jdk-21'
    }
    
    stages {
        stage('Check Maven Version') {
            steps {
             
                sh 'mvn -v'
                sh 'java --version'
            }
        }
    }
}
