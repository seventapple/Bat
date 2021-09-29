echo [$0] ===== START =====

RETVAL=0

PRODUCT_DIR=/home/wang/test/bat3

BATNAME=bat3Service

#多分支判定可启动多个服务
if [ -a "$PRODUCT_DIR/$BATNAME" ];
then
echo [$0] ===== START BAT SERVICE=====
$PRODUCT_DIR/$BATNAME start
fi

echo [$0] ===== FINISH [$1] =====
exit $RETVAL