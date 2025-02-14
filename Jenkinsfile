pipeline {
    agent any 
    stages {
        stage ('pull'){
            steps {
                git branch: 'dev', url: 'https://github.com/Aamantamboli/Project-backend.git'
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
                    docker build . -t aamantamboli/projecct-backend:latest 
                    docker push aamantamboli/projecct-backend:latest
                    docker aamantamboli/projecct-backend:latest
                    kubectl apply -f ./yaml/
                '''
            }
        }
    }
}