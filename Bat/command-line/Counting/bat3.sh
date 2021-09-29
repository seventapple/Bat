#!/bin/sh 
#remeber encode set UNIX
EXEC_DIR=$(cd `dirname $0`;pwd)
JAVA_HOME=/home/wang/java/jre1.8.0_301

CLASS_PATH=$CLASS_PATH:$EXEC_DIR/lib/bat3.jar
CLASS_PATH=$CLASS_PATH:$EXEC_DIR/lib/commons-daemon-1.2.0.jar

$JAVA_HOME/bin/java -classpath ${CLASS_PATH} com.bat.Counting "$@"