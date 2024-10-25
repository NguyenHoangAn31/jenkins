pipeline {

    agent any


    tools {
        jdk 'jdk-21'
        maven 'Maven'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/NguyenHoangAn31/jenkins.git'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
