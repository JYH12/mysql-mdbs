#!/bin/bash
#
BACKUP_DIR=/backup/data/physical
DATE=$(date +"%F_%T")

innobackupex --user=$1 --password=$2 --stream=tar /backup | gzip > $BACKUP_DIR/$DATE.tar.gz

SIZE=$(ls -sh $BACKUP_DIR/$DATE.tar.gz | awk '{print $1}')
TYPE="physical"
STRATEGY="instance"
HOST="192.168.25.133"
BACKUP_NAME=$DATE.tar.gz
current=`date "+%Y-%m-%d %H:%M:%S"`     #获取当前时间，例：2015-03-11 12:33:41       
timeStamp=`date -d "$current" +%s`      #将current转换为时间戳，精确到秒
currentTimeStamp=$((timeStamp*1000+`date "+%N"`/1000000)) #将current转换为时间戳，精确到毫秒
            
curl http://192.168.1.103:8080/backup/backupinsert\?type\=$TYPE\&size\=$SIZE\&strategy\=$STRATEGY\&time\=$currentTimeStamp\&host\=192.168.25.133\&backupName\=$BACKUP_NAME