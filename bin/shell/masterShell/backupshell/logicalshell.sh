#!/bin/bash
#
BACKUP_DIR=/backup/data/logical
DATE=$(date +"%F_%T")

cd $BACKUP_DIR

/usr/local/mysql/bin/mysqlpump -u$1 -p$2 --single-transaction --add-drop-database --add-drop-table --exclude-databases=information_schema,mysql,performance_schema,sys --set-gtid-purged=OFF | gzip > $BACKUP_DIR/$DATE.sql.gz

SIZE=$(ls -sh $BACKUP_DIR/$DATE.sql.gz | awk '{print $1}')
TYPE="logical"
STRATEGY="instance"
HOST="192.168.25.133"
BACKUP_NAME=$DATE.sql.gz
current=`date "+%Y-%m-%d %H:%M:%S"`     #获取当前时间，例：2015-03-11 12:33:41       
timeStamp=`date -d "$current" +%s`      #将current转换为时间戳，精确到秒
currentTimeStamp=$((timeStamp*1000+`date "+%N"`/1000000)) #将current转换为时间戳，精确到毫秒

curl http://192.168.1.103:8080/backup/backupinsert\?type\=$TYPE\&size\=$SIZE\&strategy\=$STRATEGY\&time\=$currentTimeStamp\&host\=192.168.25.133\&backupName\=$BACKUP_NAME  >>/dev/null