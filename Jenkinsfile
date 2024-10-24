pipeline {
    
    agent any
    
  

    tools {
        Maven 'Maven'
    }
    
    stages {
        stage('Check Maven Version') {
            steps {
             
                sh 'mvn -v'
            }
        }
    }
}
