node {
  git url: 'git@github.com:jpuli/pqvp.git'
  def mvnHome = tool 'M3.5.2'
  try {
    stage('Image Build') {
      sh "docker build -t pqvp ."
    }
    stage('Test') {
      sh "docker run --rm -v $WORKSPACE:/pqvp pqvp mvn test"
      /* sh "${mvnHome}/bin/mvn -B test" */
    }
  } finally {
    stage('Reports') {
      step([$class: 'JUnitResultArchiver', testResults: '**/surefire-reports/*.xml'])
    }
  }
}
