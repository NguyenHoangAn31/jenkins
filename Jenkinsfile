pipeline {

    agent any


    tools {
        jdk 'jdk-21'
        maven 'Maven'
        dockerTool 'docker'
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
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t nguyenhoangan31/dockerhub:first_version .'
            }
        }
        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker_credential', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    sh 'docker push nguyenhoangan31/dockerhub:first_version'
                }
            }
        }
        stage('SSH to Remote Server') {
            steps {
                sshagent(['private_key']) {
                    sh 'ssh -o StrictHostKeyChecking=no root@172.17.0.2 "
                        docker-compose -f /source/docker-compose.yml down &&
                        docker image prune -f &&
                        docker-compose -f /source/docker-compose.yml up -d
                    "'
                }
            }
        }
    }
}
