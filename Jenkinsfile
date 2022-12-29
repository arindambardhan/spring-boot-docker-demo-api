pipeline {
    agent any
    stages {
        stage("Clean Up"){
            steps {
                deleteDir()
            }
        }
        stage("Clone Repo"){
            steps {
                sh "git clone https://github.com/arindambardhan/spring-boot-docker-demo-api.git"
            }
        }
        stage("Build"){
            steps {
                dir("spring-boot-docker-demo-api") {
                    gradle build
                }
            }
        }
    }
}