pipeline {
    agent any 
    stages {
        stage ('pull'){
            steps {
                git branch: 'main', url: 'https://github.com/Aamantamboli/Project-backend.git'
            }
        }
        stage ('build'){
            steps {
                sh 'mvn clean package'
            }
        }
        stage ('deploy'){
            steps {
                sh '''
                    docker build -t aamantamboli/project-backend:latest .
                    docker push aamantamboli/project-backend:latest
                    docker aamantamboli/project-backend:latest
                    kubectl apply -f ./yaml/
                '''
            }
        }
    }
}