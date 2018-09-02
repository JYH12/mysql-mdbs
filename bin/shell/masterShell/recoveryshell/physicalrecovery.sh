#!/bin/bash
USER=$1
PASSWORD=$2
DATA_NAME=$3
service mysqld start &>> /tmp/text.txt

cd /backup/data/logical

mysql -u$USER -p$PASSWORD < $DATA_NAME