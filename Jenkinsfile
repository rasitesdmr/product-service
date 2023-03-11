pipeline {
    agent any
    environment {
        IMAGE_REGISTRY = 'docker.io/rasitesdmr1486/test-product-service'
        IMAGE_VERSION = 'v1.0'
        IMAGE_REGISTRY_CREDENTIAL = 'dockerrasit'
        DOCKER_REGISTRY_URL = ""
    }
    stages {
        stage('Build') {
           agent {
             docker {
               image 'maven:3.8.3-adoptopenjdk-17'
               args '-v $HOME/.m2:/root/.m2'
               reuseNode true
             }
           }
           steps {
             sh """
                mvn compile jib:dockerBuild
                 """
           }
        }

        stage('Docker Publish') {
            steps {
                    withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "https://hub.docker.com"]) {
                        sh "docker push ${IMAGE_REGISTRY}:${IMAGE_VERSION}"
                    }
            }
        }

        stage('Deploy Docker-compose') {
             steps {
               sh "docker-compose -f /opt/test/docker-compose.yaml stop product-service"
               withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "https://hub.docker.com"]) {
                       sh "docker-compose -f /opt/test/docker-compose.yaml pull product-service"
               }
               dir('/opt/test') {
                     sh "docker-compose up -d product-service"
               }
             }
        }
    }
}