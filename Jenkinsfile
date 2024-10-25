pipeline {

    agent any


    tools {
        jdk 'jdk-21'
        maven 'Maven'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/NguyenHoangAn31/jenkins.git'
            }
        }
    }
}
