@echo off
set EXEC_DIR=%cd%
set LIB=%EXEC_DIR%\lib\

set CLASSPATH=%LIB%bat3.jar
set CLASSPATH=%CLASSPATH%;%LIB%\commons-daemon-1.2.0.jar

set JAVA_EXE=E:\Java\jre1.8.0_25\bin\java.exe

"%JAVA_EXE%" -classpath %CLASSPATH% com.bat.Counting %*