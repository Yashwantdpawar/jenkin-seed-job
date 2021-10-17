def description(job){
    job.with{
        description("Job used for testing ds")
    }
}

def jobDefinition(job)  {
    job.with {
        definition {
            cpsScm {
                lightweight(true)
                scm {
                    git {
                        remote {
                            url('https://github.com/mhasif0786/jenkin-seed-job.git')
                            branch('master')
                        }
                    }
                }
                scriptPath('backend/newtest/main')
            }
        }
    }
}

def jobProperties(job){
    job.with {
        properties{
            disableConcurrentBuilds()
            buildDiscarder{
                strategy {
                    logRotator {
                        daysToKeepStr('')
                        numToKeepStr('10')
                        artifactDaysToKeepStr('')
                        artifactNumToKeepStr('')
                    }
                }
            }
        }
    }
}
job = pipelineJob("DSL-Tutorial-1-Test/newtest")
description(job)
jobDefinition(job)
jobProperties(job)
