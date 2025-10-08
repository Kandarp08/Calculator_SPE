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
                sh "ansible-playbook -i inventory.ini playbook.yml"
            }
        }
    }

    post
    {
        always
        {
            def jobName = env.JOB_NAME
            def buildNumber = env.BUILD_NUMBER
            def pipelineStatus = currentBuild.result ?: "UNKNOWN"

            echo "Cleaning workspace..."
            cleanWs()

            emailext(
                subject: "${jobName} - Build ${buildNumber}",
                body: "Calculator project pipeline status: ${pipelineStatus.toUpperCase()}",
                to: "Dave.Kandarp@iiitb.ac.in",
                from: "davekandarp2004@gmail.com",
            )
        }
    }
}