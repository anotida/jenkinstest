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
