pipeline {
    agent any
    environment {
        IMAGE_REGISTRY = 'docker.io/rasitesdmr1486/test-product-service'
        IMAGE_VERSION = 'v1.0'
        IMAGE_REGISTRY_CREDENTIAL = 'dockerrasit'
        DOCKER_REGISTRY_URL = ""
    }
    tools {
        // Docker CLI (docker-ce-cli) aracı tanımlanıyor
        // docker-ce-cli aracı için gerekli olan kurulumu Jenkins kurulum sayfasından yada "Jenkins > Manage Jenkins > Global Tool Configuration" altında tanımlayabilirsiniz
        docker 'docker-ce-cli'
    }
    stages {
        stage('Build') {
            // label yerine agent kullanmadık
            steps {
                // withDocker bloğu içinde docker objesi tanımlandı
                withDocker {
                    script {
                        docker.image('maven:3.9.0-adoptopenjdk-17').inside('-v $HOME/.m2:/root/.m2') {
                            sh 'mvn compile jib:dockerBuild'
                        }
                    }
                }
            }
        }

        stage('Docker Publish') {
            steps {
                    withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "${IMAGE_REGISTRY}"]) {
                        sh "docker push ${IMAGE_REGISTRY}:${IMAGE_VERSION}"
                    }
            }
        }

        stage('Deploy Docker-compose') {
             steps {
               sh "docker-compose -f /opt/test/docker-compose.yaml stop product-service"
               withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "${IMAGE_REGISTRY}"]) {
                       sh "docker-compose -f /opt/test/docker-compose.yaml pull product-service"
               }
               dir('/opt/test') {
                     sh "docker-compose up -d product-service"
               }
             }
        }
    }
}
