echo [$0] ===== START =====

RETVAL=0

PRODUCT_DIR=/home/wang/test/bat3

BATNAME=bat3Service

if [ -a "$PRODUCT_DIR/$BATNAME" ];then
echo [$0] ===== STOP BAT SERVICE=====
$PRODUCT_DIR/$BATNAME stop
RETVAL=$(($RETVAL+$?))
fi

echo [$0] ===== FINISH [$1] =====
exit $RETVAL