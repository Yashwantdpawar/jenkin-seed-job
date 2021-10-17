def description(job){
    job.with{
        description("Job used for creating jenkins backup")
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
                scriptPath('backend/jenkins_backup/main')
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
job = pipelineJob("DSL-Tutorial-1-Test/jenkins_backup")
description(job)
jobDefinition(job)
jobProperties(job)
