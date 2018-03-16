node {
  git url: 'git@github.com:jpuli/pqvp.git'
  /* def mvnHome = tool 'M3.5.2' */
  try {
    def gitCommit = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
    def shortCommit = gitCommit.take(6)
    stage('Image Build') {
      sh "docker build -t pqvp:${shortCommit} ."
    }
    stage('Test') {
      sh "docker run --rm -v $WORKSPACE:/pqvp pqvp:${shortCommit} mvn -B test"
      /* sh "${mvnHome}/bin/mvn -B test" */
    }
    stage('Deploy') {
      sh "docker save -o pqvp-${shortCommit}.img pqvp:${shortCommit}"
      sh "scp pqvp-${shortCommit}.img ec2-user@ec2-54-245-38-51.us-west-2.compute.amazonaws.com:~/."
      sh "rm pqvp-${shortCommit}.img"
      sh "ssh ec2-user@ec2-54-245-38-51.us-west-2.compute.amazonaws.com docker load -i pqvp-${shortCommit}.img"
      sh "ssh ec2-user@ec2-54-245-38-51.us-west-2.compute.amazonaws.com rm pqvp-${shortCommit}.img"
      sh "ssh ec2-user@ec2-54-245-38-51.us-west-2.compute.amazonaws.com docker stop pqvp || true"
      sh "ssh ec2-user@ec2-54-245-38-51.us-west-2.compute.amazonaws.com docker run --rm -d -p 80:8080 --name pqvp pqvp:${shortCommit} java -jar target/pqvp-0.0.1-SNAPSHOT.jar"
    }
  } finally {
    stage('Reports') {
      step([$class: 'JUnitResultArchiver', testResults: '**/surefire-reports/*.xml'])
    }
    stage('Clean-Up') {
      sh "docker ps -qa | xargs docker rm || true"
      sh "docker images -q | xargs docker rmi || true"
      sh "ssh ec2-user@ec2-54-245-38-51.us-west-2.compute.amazonaws.com docker ps -qa | xargs docker rm || true"
      sh "ssh ec2-user@ec2-54-245-38-51.us-west-2.compute.amazonaws.com docker images -q | xargs docker rmi || true"
    }
  }
}
