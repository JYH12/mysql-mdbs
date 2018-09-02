#!/bin/bash
USER=$1
HOST=$2
LOCAL_USER=$3
LOCAL_PSW=$4
REPL_USER=$5
REPL_PSW=$6
scp -r $USER@$HOST:/backup/data/logical/openslave.sql /backup/data/
service mysqld start &>> /tmp/test.txt

/usr/local/mysql/bin/mysql -u$LOCAL_USER -p$LOCAL_PSW << EOF 2>/tmp/test.txt
stop slave;
reset slave all;
reset master;
source /backup/data/openslave.sql;
change MASTER to MASTER_HOST='$HOST',MASTER_USER='$REPL_USER',MASTER_PASSWORD='$REPL_PSW',MASTER_PORT=3306,MASTER_AUTO_POSITION=1;
start slave;
exit;
EOF