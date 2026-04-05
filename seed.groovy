def services = ['service-a', 'service-b', 'service-c']

services.each { svc ->
    pipelineJob("${svc}-pipeline") {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url("https://github.com/Kishore-SCM/${svc}.git")
                            credentials('github')
                        }
                        branch("*/main")
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
    }
}
