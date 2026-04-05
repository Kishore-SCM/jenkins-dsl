def services = ['service-a', 'service-b', 'service-c']

services.each { svc ->
    pipelineJob("${svc}-pipeline") {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url("https://github.com/<your>/${svc}.git")
                        }
                        branch("*/main")
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
    }
}
