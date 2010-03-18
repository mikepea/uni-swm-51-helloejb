echo "Deploying helloejb.ear:" &&
java -jar $ORACLE_HOME/j2ee/home/admin.jar ormi://127.0.0.1 oc4jadmin wobble -deploy -file lib/helloejb.ear -deploymentName helloejb &&
echo "Binding helloejb:" &&
java -jar $ORACLE_HOME/j2ee/home/admin.jar ormi://127.0.0.1 oc4jadmin wobble -bindWebApp helloejb helloejb-web default-web-site /helloejb &&
echo "Success!" || ( echo "FAILED!" && exit 1 )
