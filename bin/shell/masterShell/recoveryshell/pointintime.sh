#!/bin/bash

USER=$1
PASSWORD=$2
STOP_DATE=$3
DATA_NAME=$4

cd /backup/data/physical

innobackupex --apply-log /backup/data/physical/tmp &>> /tmp/test.txt

service mysqld stop &>> /tmp/test.txt

rm -rf /data/mysql/data/* &>> /tmp/test.txt

innobackupex --copy-back /backup/data/physical/tmp &>> /tmp/test.txt

chown -R mysql:mysql /data/mysql/data/ &>> /tmp/test.txt

killall mysqld &>> /tmp/test.txt

service mysqld start &>> /tmp/test.txt

POS=$(awk '{print $2}'   /backup/data/physical/tmp/xtrabackup_binlog_info)
BEGIN_LOG=$(cat /backup/data/physical/tmp/xtrabackup_binlog_info | sed  -n "1p" | awk '{print $1}')
TMP="/mysql/logs/$BEGIN_LOG"
BINLOG=$TMP
for binfile in `ls /mysql/logs/master-bin.0* |sort`; do
       # echo $binfile
        if [ $binfile \> $TMP ]
        then
                BINLOG="$BINLOG $binfile"
        fi

  done
#echo $BINLOG
#echo $BEGIN_LOG
#echo $TMP
#echo $POS

mysqlbinlog $BINLOG --skip-gtids=true --start-position=$POS --stop-datetime="$STOP_DATE" | mysql -u$USER -p$PASSWORD

rm -rf /backup/data/physical/tmp/*