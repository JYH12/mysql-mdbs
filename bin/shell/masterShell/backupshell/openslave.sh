#!/bin/bash
#
BACKUP_DIR=/backup/data/logical

/usr/local/mysql/bin/mysqlpump -u$1 -p$2 --single-transaction --add-drop-database --add-drop-table --exclude-databases=information_schema,mysql,performance_schema,sys --set-gtid-purged=on > $BACKUP_DIR/openslave.sql