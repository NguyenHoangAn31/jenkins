pipeline {
    
    agent any
    
  

    tools {
        maven 'Maven'
        jdk 'Jdk-21'
    }
    environment {
        JAVA_HOME = "${tool 'Jdk-21'}"
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
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
