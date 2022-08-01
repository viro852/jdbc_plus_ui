pipeline {
    agent any
    tools {
        maven 'MavenLocal'
    }
    environment {
        DB_CREDS = credentials("MySQLDB")
    }
    stages {
        stage("Git checkout") {
            steps {
                git branch: 'main', credentialsId: 'github_creds', url: 'https://github.com/viro852/jdbc_plus_ui.git'
            }
        }
        stage('Code Build') {
            steps {
                script {
                    if ("${system}" == "Original") {
                        echo "User has chosen system: ['${system}']"
                    }
                    if ("${system}" == "Clone") {
                        echo "User has chosen system: ['${system}']"
                    }
                }
                bat "mvn clean test -Dgroups=${type} -Ddb.login=${DB_CREDS_USR} -Ddb.password=${DB_CREDS_PSW}"
            }
        }
        stage('Post actions') {
            steps{
                cleanWs()
            }
        }
    }
}