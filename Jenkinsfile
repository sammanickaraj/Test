pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                echo 'Building the application...'
                echo "Printing branch ${env.BRANCH_NAME}"
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
