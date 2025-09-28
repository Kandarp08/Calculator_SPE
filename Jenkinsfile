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
                echo "Test execution completed."
            }
        }

        stage("Check Docker")
        {
            steps
            {
                echo "Checking docker and docker compose versions..."
                sh '''
                docker version
                docker compose version
                '''
                echo "Check completed."
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
    }
}