#!/bin/bash
USER=$1
PASSWORD=$2
DATA_NAME=$3
service mysqld start &>> /tmp/text.txt

cd /backup/data/logical

gunzip $DATA_NAME

FILENAME=${DATA_NAME:0:23}

mysql -u$USER -p$PASSWORD < $FILENAME

rm -rf $FILENAME