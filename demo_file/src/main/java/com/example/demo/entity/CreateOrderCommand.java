package com.example.demo.entity;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

public class CreateOrderCommand {
	 	@NotNull
	    private Integer orderType;
	    @NotNull
	    private Long amount;
	    private String accountCode;
	    private String clientAppName;
	    private Integer paymentType;
	    private Integer validationType;
	    private Map<String, String> paymentParams;
	    private Long refundOrderId;
	    private Integer settlementType;
	    private Long splitRuleId;
	    //private List<SplitSpec> splitSpecs;
	    private Long expirationMillis;
	    private String summary;
	    private Long payeeUserId;
	    private Long payerUserId;
	    private String frontUrl;
	    @NotNull
	    private String backUrl;
	    private String extendInfo;
	    private String goodsName;
	    private String goodsDescription;
	    private String industryCode;
	    private String industryName;
	    private Integer sourceType;
	    @NotNull
	    private String bizOrderNum;
	    private String orderRemark1;
	    private String orderRemark2;
	    private String orderRemark3;
	    private String orderRemark4;
	    private String orderRemark5;
	    
	    
	    
	    
	    public CreateOrderCommand() {
			// TODO Auto-generated constructor stub
		}
		public Integer getOrderType() {
			return orderType;
		}
		public void setOrderType(Integer orderType) {
			this.orderType = orderType;
		}
		public Long getAmount() {
			return amount;
		}
		public void setAmount(Long amount) {
			this.amount = amount;
		}
		public String getAccountCode() {
			return accountCode;
		}
		public void setAccountCode(String accountCode) {
			this.accountCode = accountCode;
		}
		public String getClientAppName() {
			return clientAppName;
		}
		public void setClientAppName(String clientAppName) {
			this.clientAppName = clientAppName;
		}
		public Integer getPaymentType() {
			return paymentType;
		}
		public void setPaymentType(Integer paymentType) {
			this.paymentType = paymentType;
		}
		public Integer getValidationType() {
			return validationType;
		}
		public void setValidationType(Integer validationType) {
			this.validationType = validationType;
		}
		public Map<String, String> getPaymentParams() {
			return paymentParams;
		}
		public void setPaymentParams(Map<String, String> paymentParams) {
			this.paymentParams = paymentParams;
		}
		public Long getRefundOrderId() {
			return refundOrderId;
		}
		public void setRefundOrderId(Long refundOrderId) {
			this.refundOrderId = refundOrderId;
		}
		public Integer getSettlementType() {
			return settlementType;
		}
		public void setSettlementType(Integer settlementType) {
			this.settlementType = settlementType;
		}
		public Long getSplitRuleId() {
			return splitRuleId;
		}
		public void setSplitRuleId(Long splitRuleId) {
			this.splitRuleId = splitRuleId;
		}
		public Long getExpirationMillis() {
			return expirationMillis;
		}
		public void setExpirationMillis(Long expirationMillis) {
			this.expirationMillis = expirationMillis;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public Long getPayeeUserId() {
			return payeeUserId;
		}
		public void setPayeeUserId(Long payeeUserId) {
			this.payeeUserId = payeeUserId;
		}
		public Long getPayerUserId() {
			return payerUserId;
		}
		public void setPayerUserId(Long payerUserId) {
			this.payerUserId = payerUserId;
		}
		public String getFrontUrl() {
			return frontUrl;
		}
		public void setFrontUrl(String frontUrl) {
			this.frontUrl = frontUrl;
		}
		public String getBackUrl() {
			return backUrl;
		}
		public void setBackUrl(String backUrl) {
			this.backUrl = backUrl;
		}
		public String getExtendInfo() {
			return extendInfo;
		}
		public void setExtendInfo(String extendInfo) {
			this.extendInfo = extendInfo;
		}
		public String getGoodsName() {
			return goodsName;
		}
		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		public String getGoodsDescription() {
			return goodsDescription;
		}
		public void setGoodsDescription(String goodsDescription) {
			this.goodsDescription = goodsDescription;
		}
		public String getIndustryCode() {
			return industryCode;
		}
		public void setIndustryCode(String industryCode) {
			this.industryCode = industryCode;
		}
		public String getIndustryName() {
			return industryName;
		}
		public void setIndustryName(String industryName) {
			this.industryName = industryName;
		}
		public Integer getSourceType() {
			return sourceType;
		}
		public void setSourceType(Integer sourceType) {
			this.sourceType = sourceType;
		}
		public String getBizOrderNum() {
			return bizOrderNum;
		}
		public void setBizOrderNum(String bizOrderNum) {
			this.bizOrderNum = bizOrderNum;
		}
		public String getOrderRemark1() {
			return orderRemark1;
		}
		public void setOrderRemark1(String orderRemark1) {
			this.orderRemark1 = orderRemark1;
		}
		public String getOrderRemark2() {
			return orderRemark2;
		}
		public void setOrderRemark2(String orderRemark2) {
			this.orderRemark2 = orderRemark2;
		}
		public String getOrderRemark3() {
			return orderRemark3;
		}
		public void setOrderRemark3(String orderRemark3) {
			this.orderRemark3 = orderRemark3;
		}
		public String getOrderRemark4() {
			return orderRemark4;
		}
		public void setOrderRemark4(String orderRemark4) {
			this.orderRemark4 = orderRemark4;
		}
		public String getOrderRemark5() {
			return orderRemark5;
		}
		public void setOrderRemark5(String orderRemark5) {
			this.orderRemark5 = orderRemark5;
		}
		public Integer getCommitFlag() {
			return commitFlag;
		}
		public void setCommitFlag(Integer commitFlag) {
			this.commitFlag = commitFlag;
		}
		private Integer commitFlag;
}
