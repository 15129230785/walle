#!/bin/bash
#cd `pwd`;cd ..
export SERVER_HOME="/dianyi"

SERVER_LOG_DIR=$SERVER_HOME/log

#file
SERVER_ERROR_FILE=$SERVER_LOG_DIR/error.out
SERVER_PID_FILE=$SERVER_LOG_DIR/server.pid

###启动
function func_start(){

    MAINCLASS=com.yuyue.schedulers.Scheduler
    LIB=$SERVER_HOME/schedulers/lib
    for jar in $LIB/*
        do
            CLASSPATH=$CLASSPATH:$jar
    done
    CLASSPATH=$CLASSPATH:$SERVER_HOME/schedulers/conf

    #echo $CLASSPATH
    #Djava.ext.dirs=%CLASSPATH%
    JAVA_OPS="-Xmx1024m -Xms1024m -Djava.net.preferIPv4Stack=true -server -cp $CLASSPATH"

    nohup java $JAVA_OPS  $MAINCLASS >/dev/null 2>$SERVER_ERROR_FILE &
    echo $! > $SERVER_PID_FILE
}

###停止
function func_stop(){
     [ ! -f $SERVER_PID_FILE ] && exit
     kill `cat $SERVER_PID_FILE`
     rm -f $SERVER_PID_FILE
}

function func_help()
{
    echo "    Usage: $0 [start|stop]"
}


if [ "$1" = 'start' ] ; then
    func_start
elif [ "$1" = 'stop' ] ; then
    func_stop
else
    func_help
fi
