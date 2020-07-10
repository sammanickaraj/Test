pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                echo 'Running build automation'
                sh '/bin/mvn clean package'
                // 
            }
        }
    }
}
