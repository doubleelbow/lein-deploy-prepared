(ns leiningen.deploy-prepared
  "Deploy already built jar and pom to remote repository."
  (:require [leiningen.deploy :as deploy]
            [leiningen.pom :as pom]
            [leiningen.core.main :as main]))

(defn deploy-prepared
  "Find prepared jar and pom files and deploy them to remote repository
  with the help of lein deploy task."
  ([project]
   (deploy-prepared project (if (pom/snapshot? project)
                              "snapshots"
                              "releases")))
  ([project repository]
   (let [identifier (str (:group project) "/" (:name project))
         version (:version project)
         jar (str "target/" (:name project) "-" (:version project) ".jar")]
     (main/info "Deploying" jar "to" repository)
     (deploy/deploy project repository identifier version jar "pom.xml"))))
