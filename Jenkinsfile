pipeline
{
    agent any

    stages
    {
        stage("Run Tests")
        {
            steps
            {
                echo "Testing Calculator..."
                sh "mvn test"
            }
        }

        stage("Check Docker")
        {
            steps
            {
                echo "Checking docker and docker compose versions..."
                sh '''
                docker version
                '''
            }
        }

        stage("Build Docker image")
        {
            steps
            {
                echo "Building Docker image..."
                script
                {
                    docker.build("calculator_spe:latest")
                }
            }
        }

        stage("Login to Dockerhub")
        {
            steps
            {
                echo "Logging in to Dockerhub..."
                script
                {
                    docker.withRegistry("https://index.docker.io/v1/", "dockerhub-credentials") {
                        // Docker registry login happens here
                    }
                }
            }
        }

        stage("Push Docker image to Registry")
        {
            steps
            {
                echo "Pushing Docker image to Dockerhub..."
                script
                {
                    docker.withRegistry("https://index.docker.io/v1/", "dockerhub-credentials") {
                        docker.image("calculator_spe:latest").push()
                    }
                }
            }
        }
    }
}