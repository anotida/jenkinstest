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
        stage("Docker build") {
            steps {
                sh 'docker build -t localhost:5000/jenkinstest .'
            }
        }
        stage("Docker push") {
            steps {
                sh 'docker push localhost:5000/jenkinstest'
            }
        }
        stage("Deploy to testing") {
            steps {
                sh 'docker run -d --rm -p 8765:8080 --name jenkinstest localhost:5000/jenkinstest'
            }
        }

        stage("Acceptance Test") {
            steps {
                sleep 60
                sh 'chmod a+x acceptance_test.sh',
                sh './acceptance_test.sh'
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