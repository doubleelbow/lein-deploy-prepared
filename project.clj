(defproject com.doubleelbow/lein-deploy-prepared "0.1.0-SNAPSHOT"
  :description "Deploy prepared jar file"
  :url "https://github.com/doubleelbow/lein-deploy-prepared"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:name "git" :url "https://github.com/doubleelbow/lein-deploy-prepared"}
  :eval-in-leiningen true
  :repositories [["snapshots" {:url "https://repo.clojars.org"
                               :username :env/clojars_user
                               :password :env/clojars_pass}]
                 ["releases" {:url "https://repo.clojars.org"
                              :username :env/clojars_user
                              :password :env/clojars_pass}]])
