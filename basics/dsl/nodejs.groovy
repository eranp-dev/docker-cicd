job('NodeJS Docker example') {
    scm {
        git('git://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
  
    steps {
        dockerBuildAndPublish {
            repositoryName(eranp/jenkins-repo)
            tag('${GIT_REVISION,length=9}')
            registryCredentials('2a1f5ff8-b15d-4c4a-a0fe-f763cd47ae16')
            forcePull(false)
            forceTag(false)
            createFingerprints(true)
            skipDecorate()
            
        }
    }
}

