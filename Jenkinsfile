pipeline {
    agent any
    stages {
        stage("Compile") {
            steps {
                sh './mvnw compile'
            }
        }
        stage("Testing") {
            steps {
                sh './mvnw test'
            }
        }
        stage("Package") {
            steps {
                sh './mvnw package'
            }
        }
        stage("Initialize") {
            def dockerHome = tool 'myDocker',
            env.PATH = "${dockerHome}/bin:${env.PATH}"
        }
        stage("Docker build") {
            steps {
                sh 'docker build -t localhost:5000/jenkinstest'
            }
        }
        stage("Docker push") {
            steps {
                sh 'docker push localhost:5000/jenkinstest'
            }
        }
    }
    post {
        always {
            mail to: 'amaditsha@gmail.com',
            subject: "Completed Pipeline: ${currentBuild.fullDisplayName}",
            body: "Your build completed, please check: ${env.BUILD_URL}"
        }
    }

    triggers {
        pollSCM('*/5 * * * *')
    }
}