# lein-deploy-prepared

A Leiningen plugin for deploying already built jar to remote repository.

In deploy stage of CI process a jar prepared in build stage can be used for deployment. There is no need to rebuild the project.

## Usage

Put `[lein-deploy-prepared "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your `:user`
profile.

    $ lein deploy-prepared [repository]

Plugin expects *pom.xml* in *project root* folder and *jar file* in *target* folder. This can be achieved by running `$ lein do uberjar, pom`. Lein *deploy* task is then used to push files to repository. Repository provided as parameter to *deploy-prepared* task is used or, if none provided, either a "snapshots" or "releases" repository is selected based on the project version.

## License

Copyright © 2018 doubleelbow

Distributed under the Eclipse Public License either version 1.0.
