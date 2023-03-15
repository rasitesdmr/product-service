pipeline{
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '4c8c2e55-b7b6-4a02-b981-fccc670fd9d9', url: 'https://github.com/rasitesdmr/product-service.git']])
                withMaven(maven: 'maven') {
                    sh 'mvn clean package -DskipTests'
                }

            }
        }
        stage("Docker Build Image"){
            steps{
                script{
                    withCredentials([usernameColonPassword(credentialsId: 'dockerhub', variable: 'docker')]) {
                    sh 'docker build -t rasitesdmr1486/product-service:latest .'
                    }

                }
            }

        }
        stage('Docker Push Image'){
            steps{
                script{
                    withDockerRegistry(credentialsId: 'dockerhub', toolName: 'dockerhub', url: "" ){
                        sh 'docker tag rasitesdmr1486/product-service:latest  rasitesdmr1486/product-service:latest'
                        sh 'docker push rasitesdmr1486/product-service:latest'
                    }

                }

            }
        }
        stage("docker-compose"){
            steps{
                sh 'docker-compose up -d'
            }
        }
    }
}