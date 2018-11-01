package com.knight.demo.StringUtils;

import org.apache.commons.lang3.StringUtils;

public class SplitTest {

    public static void main(String[] args) {

        String str = "BankResponse(tranReqNo=null, outerTranNo=null, outerTranDate=null, respCode=NOTPAY, respDesc=订单未支付, tranStatus=D, tranAmt=0, authorizationCode=null, realRtn=false, respSrvIp=null, respMsg=null, respCoding=null, balance=null, ourTransNo=null, isRevokeOrRefund=null, aliPayResModel=null, weChatRespModel=WeChatResponseModel(appid=wx2421b1c4370ec43b, subAppid=null, mchId=1900008751, subMchId=247063304, deviceInfo=null, nonceStr=Pww9osIcxX8kUjhMdJe0uY26qvN4BmtE, openId=null, subOpenId=null, tradeType=null, bankType=null, feeType=null, totalFee=0, cashFeeType=null, cashFee=0, settlementTotalFee=0, couponFee=0, transactionId=null, outTradeNo=20181101130000040000001001153456, attach=null, timeEnd=null, promotionId=null, name=null, scope=null, type=null, amount=null, activityId=null, wxpayContribute=null, merchantContribute=null, otherContribute=null, goodsId=null, goodsIemark=null, discountAmount=null, quantity=null, price=null, returnCode=null, returnMsg=null, resultCode=null, errCode=null, errCodeDes=null, tradeState=null, tradeStateDesc=null, recall=null, outRefundNo=null, refundId=null, refundFee=0, settlementRefundFee=0, cashRefundFee=0, couponRefundFee=0, refundChannel=null, refundStatus=null, refundAccount=null, refundRecvAccout=null, refundSuccessTime=null, refundCreateTime=null, prepayId=null, codeUrl=null, dataAppId=null, dataTimeStamp=null, dataNonceStr=null, dataPackage=null, dataSignType=null, dataPaySign=null, partnerId=null, wcPrepayId=null)";

        String[] arg = StringUtils.split(str,",");

        for (String s : arg){
            if(StringUtils.contains(s,"respCode=")){
                String a = StringUtils.split(s,"=")[1];
                System.out.println(a);
            }
        }
    }
}
