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
git clone https://github.com/ManuelB/scopevisio-chatbot.git
cd scopevisio-chatbot 
git submodule init
git submodule update
echo "export JAVA_HOME=$(dirname $(dirname $(readlink $(readlink $(which javac)))))" >> ~/.bashrc
wget https://bintray.com/sobolevn/rpm/rpm -O bintray-sobolevn-rpm.repo
sudo mv bintray-sobolevn-rpm.repo /etc/yum.repos.d/
sudo yum install git-secret
mvn install
find . -name "*.war" | sudo args cp -t /opt/wildfly/standalone/deployments/
