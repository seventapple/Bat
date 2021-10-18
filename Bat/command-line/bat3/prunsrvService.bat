@echo off
set EXEC_DIR=%cd%
set LIB=%EXEC_DIR%\lib

set CLASSPATH=%LIB%\bat3.jar;%LIB%\commons-daemon-1.2.0.jar
set INSTALL_PATH=%EXEC_DIR%\prunsrv.exe
set JVM=E:\Java\jre1.8.0_25\bin\server\jvm.dll
set SERVER_NAME=WANG
set DISPLAY_SERVICE_NAME=WANG Test Service
set JvmMs=256
set JvmMx=1024

if "%1" == "-INSTALL" goto install
if "%1" == "-UNINSTALL" goto nuinstall

:install
echo install
"%EXEC_DIR%\prunsrv.exe" //IS//%SERVER_NAME% --DisplayName="%DISPLAY_SERVICE_NAME%" --Description="%DISPLAY_SERVICE_NAME%" --Install=%INSTALL_PATH% --Startup=auto --Jvm="%JVM%" --StartMode=jvm --StopMode=jvm --Classpath="%CLASSPATH%" --StartClass=com.bat.Bat3Launcher --StartMethod=startService --StopClass=com.bat.Bat3Launcher --StopMethod=stopService --JvmMs=%JvmMs% --JvmMx=%JvmMx%
sc config %SERVER_NAME% obj=LocalSystem
goto end



:nuinstall
echo nuinstall
"%EXEC_DIR%\prunsrv.exe" //DS//%SERVER_NAME%
goto end

rem "%JAVA_EXE%" -classpath %CLASSPATH% com.bat.Counting %*


:end
