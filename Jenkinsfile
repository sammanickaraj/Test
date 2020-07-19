pipeline {
    agent any
    environment {
     BRANCH_NAME = "${GIT_BRANCH.split("/")[1]}"
  }
    stages {
        stage("Build") {
            steps {
                when {
                    expression {
                        BRANCH_NAME == 'dev'
                    }
                }
                echo 'Building the application...'
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
