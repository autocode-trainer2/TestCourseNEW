# ta_training-java

# framework (Hardcore)
type command to run test:\
mvn -Dbrowser=chrome -Denvironment=qa -Dsurefire.suiteXmlFiles=/src/test/resources/testng-smoke.xml clean test

PARAMETRIES

Dbrowser:  chrome | yandex | edge

Denvironment: qa | dev

Dsurefire.suiteXmlFiles: src/test/resources/testng-smoke.xml | testng-all.xml