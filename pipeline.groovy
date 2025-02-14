pipeline {
    agent any 
    stages {
        stage ('pull'){
            steps {
                git branch: 'dev', url: 'https://github.com/mayurmwagh/CDEC-B21-Backend.git'
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
                    docker build . -t mayurwagh/cdec-b21-backend:latest 
                    docker push mayurwagh/cdec-b21-backend:latest
                    docker rmi mayurwagh/cdec-b21-backend:latest
                    kubectl apply -f ./yaml/
                '''
            }
        }
    }
}