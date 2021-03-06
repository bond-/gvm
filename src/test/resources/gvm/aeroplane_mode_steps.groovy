package gvm

import static cucumber.runtime.groovy.EN.*

Given(~'^the internet is not reachable$') {->
    bash = new BashEnv(baseDir, [GVM_DIR: gvmDirEnv, GVM_SERVICE: "http://localhost:0"])
    bash.start()
    bash.execute("source $binDir/gvm-init.sh")
}


And(~'^the internet is reachable$') {->
    bash = new BashEnv(baseDir, [GVM_DIR: gvmDirEnv, GVM_SERVICE: serviceUrlEnv])
    bash.start()
    bash.execute("source $binDir/gvm-init.sh")
}