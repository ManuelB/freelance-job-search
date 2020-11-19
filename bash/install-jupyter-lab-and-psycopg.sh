sudo yum install -y python3
sudo pip3 install jupyterlab
sudo pip3 install notebook
sudo yum install -y postgresql-devel.x86_64 
sudo yum install -y gcc
sudo yum install -y python3-devel
sudo pip3 install psycopg2
sudo pip3 install sqlalchemy
sudo pip3 install pandas
sudo pip3 install seaborn
sudo pip3 install matplotlib
sudo pip3 install trafilatura
sudo yum install -y gcc-c++
sudo yum install -y compat-gcc-48-c++
sudo pip3 install spacy_cld
sudo python3 -m spacy download xx_ent_wiki_sm
python3 -m spacy download en
python3 -m spacy download xx_ent_wiki_sm
# start lab with: jupyter-lab --ip 0.0.0.0
# This will run on port 8080
mkdir -p ~/.config/systemd/user
wget "https://gist.github.com/r-darwish/42042b204aa562b3a8f742056b771079/raw/0ecf28461b26d32b13c97de786d1096a2459d6de/jupyter.service" -O ~/.config/systemd/user/jupyterlab.service
vi ~/.config/systemd/user/jupyterlab.service   # edit
#[Unit]
#Description=Jupyter Notebook
#
#[Service]
#User=ec2-user
#Group=ec2-user
#Type=simple
#ExecStart=/usr/local/bin/jupyter-lab --ip 0.0.0.0
#WorkingDirectory=/home/ec2-user
#
#[Install]
#WantedBy=default.target
sudo mv ~/.config/systemd/user/jupyterlab.service /etc/systemd/system/jupyter.service
sudo systemctl enable jupyter.service
sudo systemctl daemon-reload
sudo systemctl restart jupyter.service
# list all services
sudo systemctl --type=service --all
# list log messages of jupyter server including access token
sudo journalctl -u jupyter

