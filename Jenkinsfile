pipeline {
    
    agent any
    
  

    tools {
        maven 'Maven'
    }
    
    stages {
        stage('Check Maven Version') {
            steps {
             
                sh 'mvn -v'
            }
        }
    }
}
