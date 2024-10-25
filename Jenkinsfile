pipeline {

    agent any


    tools {
        jdk 'jdk-21'
        maven 'Maven'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/NguyenHoangAn31/jenkins.git'
            }
        }
    }
}
