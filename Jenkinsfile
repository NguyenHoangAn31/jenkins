pipeline {

    agent any


    tools {
        jdk 'jdk-21'
        maven 'Maven'
        dockerTool 'docker' // Sử dụng tool Docker đã đặt tên là "docker" trong Jenkins

    }
    
    stages {
        stage('check docker version') {
            steps {
                sh 'docker -v'
            }
        }
        
        // stage('Checkout') {
        //     steps {
        //         git branch: 'main', url: 'https://github.com/NguyenHoangAn31/jenkins.git'
        //     }
        // }
        // stage('Test') {
        //     steps {
        //         sh 'mvn test'
        //     }
        // }
        // stage('Build') {
        //     steps {
        //         sh 'mvn clean install'
        //     }
        // }
        // stage('Build Docker Image') {
        //     steps {
        //         sh 'docker build -t nguyenhoangan31/dockerhub:first_version .'
        //     }
        // }
    }
}
