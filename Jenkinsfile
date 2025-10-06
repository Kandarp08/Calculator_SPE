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

        stage("Check Docker version")
        {
            steps
            {
                echo "Checking docker version..."
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
                    docker.build("kandarp53/calculator_spe:latest")
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
                        docker.image("kandarp53/calculator_spe:latest").push()
                    }
                }
            }
        }

        stage("Deploy using Ansible")
        {
            steps
            {
                ansiblePlaybook(
                    installation: "Ansible",
                    inventory: "inventory.ini",
                    playbook: "playbook.yml",
                )
            }
        }
    }
}