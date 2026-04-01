pipeline{
    agent any 
    stages{
        stage('Code-pull'){
            steps{
                git branch: 'main', url: 'https://github.com/Devops-Sanket/Flight-Reservation-Application'
            }
        }
        stage('Build'){
            steps{
                sh''' 
                    cd frontend
                    npm install
                    npm run build
                '''
            }
        }
        stage('Deploy'){
            steps{
                sh '''
                    cd frontend
                    aws s3 sync dist/ s3://cbz-frontend-project-bux/
                '''    
            }
        }
    }
}
