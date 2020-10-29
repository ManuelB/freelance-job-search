#!/bin/bash
# ssh -i ~/.ssh/aws_rsa ec2-user@ec2-18-192-6-32.eu-central-1.compute.amazonaws.com
# https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/amazon-linux-install.html
sudo yum install -y java-11-amazon-corretto-headless
sudo yum install -y git
sudo wget https://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven
sudo alternatives --set java /usr/lib/jvm/java-11-amazon-corretto.x86_64/bin/java
sudo alternatives --set javac /usr/lib/jvm/java-11-amazon-corretto.x86_64/bin/javac
wget http://download.jboss.org/wildfly/20.0.1.Final/wildfly-20.0.1.Final.zip
sudo unzip wildfly-20.0.1.Final.zip -d /opt/
sudo ln -s /opt/wildfly-20.0.1.Final /opt/wildfly
sudo cp /opt/wildfly/docs/contrib/scripts/init.d/wildfly.conf /etc/default/wildfly
sudo cp /opt/wildfly/docs/contrib/scripts/init.d/wildfly-init-redhat.sh /etc/init.d/wildfly
sudo perl -pi -w -e 's/# JBOSS_USER=wildfly/JBOSS_USER=root/g' /etc/default/wildfly
sudo perl -pi -w -e 's/# JBOSS_OPTS="--admin-only -b 127.0.0.1"/JBOSS_OPTS="-b 0.0.0.0 -Djboss.http.port=80 -Djboss.https.port=443"/g' /etc/default/wildfly
sudo perl -pi -w -e 's/# JBOSS_CONFIG=standalone.xml/JBOSS_CONFIG=standalone-full.xml/g' /etc/default/wildfly
sudo /opt/wildfly/bin/jboss-cli.sh
# https://developer.jboss.org/people/fjuma/blog/2018/08/31/obtaining-certificates-from-lets-encrypt-using-the-wildfly-cli
# /subsystem=elytron/key-store=serverKS:add(path=application.keystore, relative-to=jboss.server.config.dir, credential-reference={clear-text=password}, type=JKS)
# /subsystem=elytron/key-store=accountsKS:add(path=accounts.keystore.jks,relative-to=jboss.server.config.dir,credential-reference={clear-text=password},type=JKS)
# /subsystem=elytron/certificate-authority-account=myLetsEncryptAccount:add(alias=letsEncrypt,key-store=accountsKS,contact-urls=[mailto:webmaster@incetergy.de])
# /subsystem=elytron/key-store=serverKS:obtain-certificate(alias=server,domain-names=[bot.incentergy.de],certificate-authority-account=myLetsEncryptAccount,agree-to-terms-of-service)
sudo service wildfly start
git clone https://github.com/ManuelB/freelance-project-search.git
cd freelance-project-search
git submodule init
git submodule update
echo "export JAVA_HOME=$(dirname $(dirname $(readlink $(readlink $(which javac)))))" >> ~/.bashrc
wget https://bintray.com/sobolevn/rpm/rpm -O bintray-sobolevn-rpm.repo
sudo mv bintray-sobolevn-rpm.repo /etc/yum.repos.d/
sudo yum install git-secret
mvn install
sudo amazon-linux-extras install postgresql11
sudo yum -y install postgresql-server
sudo service postgresql initdb
sudo /sbin/chkconfig --levels 235 postgresql on
# Change thw following lines in /var/lib/pgsql/data/pg_hba.conf
#
# host    all             all             127.0.0.1/32            ident
# host    all             all             ::1/128                 ident
#
# TO:
#
# host    all             all             127.0.0.1/32            md5
# host    all             all             ::1/128                 md5
sudo service postgresql start
sudo su postgres
psql -c "CREATE DATABASE freelancesearch;"
psql -c "CREATE USER freelancesearch WITH PASSWORD 'changeme';"
psql -c "GRANT ALL PRIVILEGES ON DATABASE freelancesearch TO freelancesearch;"
exit
sudo su
cd /tmp
wget https://repo1.maven.org/maven2/org/postgresql/postgresql/42.2.18/postgresql-42.2.18.jar
/opt/wildfly/bin/jboss-cli.sh --connect controller=127.0.0.1
module add --name=org.postgresql --resources=/tmp/postgresql-42.2.18.jar --dependencies=javax.api,javax.transaction.api
/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgresql",driver-class-name=org.postgresql.Driver)
data-source remove --name=ExampleDS
data-source add --jndi-name=java:jboss/datasources/ExampleDS --name=ExampleDS --connection-url=jdbc:postgresql://localhost:5432/freelancesearch --driver-name=postgres --user-name=freelancesearch --password=changeme
reload
find . -name "*.war" | sudo args cp -t /opt/wildfly/standalone/deployments/
