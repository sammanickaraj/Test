pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                echo 'Building the application...'
                echo "Printing branch ${env.GIT_BRANCH}"
            }
        }
        stage("Test") {
            steps {
                echo 'Testing the application...'
            }
        }
        stage("Deploy") {
            steps {
                echo 'Deploying the application...'
            }

        }
    }

}
