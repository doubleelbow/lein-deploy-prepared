(ns leiningen.deploy-prepared-test
  (:require [leiningen.deploy-prepared :as sut]
            [clojure.test :as t]
            [leiningen.deploy :as deploy]))

(defn mocked-deploy
  [project repository identifier version jar pom]
  {:project project
   :repository repository
   :identifier identifier
   :version version
   :jar jar
   :pom pom})

(t/deftest deploy-called-with-correct-values
  (let [project {:group "com.example"
                 :name "example"
                 :version "1.0.0"}
        repository "remote-repo"
        expected-params {:project project
                         :repository repository
                         :identifier "com.example/example"
                         :version "1.0.0"
                         :jar "target/example-1.0.0.jar"
                         :pom "pom.xml"}]
    (with-redefs-fn {#'deploy/deploy mocked-deploy}
      #(t/is (= expected-params (sut/deploy-prepared project repository))))))
