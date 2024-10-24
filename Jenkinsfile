node{
   stage('SCM checkout'){
     git 'https://github.com/LordAjinkya/LoginPage-web-automation'
   }
   stage('compile-package'){
    def mvnHome = tool name: 'maven-3', type: 'maven'
      sh "${mvnHome}/bin/mvn package"
   }
   stage('Email Notification'){
      mail bcc: '', body: '''Hello
      Welcome to my jenkins
      Regards''', cc: '', from: '', replyTo: '', subject: 'jenkins job', to: 'ajinkyanarale007@gmail.com'
   }
}
