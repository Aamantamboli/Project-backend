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
                    docker build . -t aamantamboli/projectbackend:latest 
                    docker push aamantamboli/projectbackend:latest
                    docker rmi aamantamboli/projectbackend:latest
                    kubectl apply -f ./yaml/
                '''
            }
        }
    }
}
