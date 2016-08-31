package CarSaleManagerSystem.Bean;

/**
 * Created by HFQ on 2016/8/29.
 */
public class ValueChain {
    private float number;
    private float exchangeCost;
    private float exchangePrice;
    private float exchangeProfit;
    private float exchangeSaturate;

    private float giftCost;
    private float giftPrice;
    private float giftProfit;
    private float giftSaturate;

    private float insuranceCost;
    private float insurancePrice;
    private float insuranceProfit;
    private float insuranceSaturate;

    private float financeCost;
    private float financePrice;
    private float financeProfit;
    private float financeSaturate;

    private float serviceCost;
    private float servicePrice;
    private float serviceProfit;
    private float serviceSaturate;

    private float rebookInsuranceCost;
    private float rebookInsurancePrice;
    private float rebookInsuranceProfit;
    private float rebookInsuranceSaturate;

    private float vipCost;
    private float vipPrice;
    private float vipProfit;
    private float vipSaturate;

    private float renderCost;
    private float renderPrice;
    private float renderProfit;
    private float renderSaturate;

    public ValueChain() {
        number = 0;
    }

    public ValueChain(SalesPlan salesPlan) {
        this.exchangeCost = salesPlan.getExchangeCost();
        this.exchangePrice = salesPlan.getExchangePrice();
        this.exchangeProfit = this.exchangePrice - this.exchangeCost;
        this.exchangeSaturate = salesPlan.getExchangeSaturate();
        this.number = salesPlan.getNumber();

        this.giftCost = salesPlan.getGiftCost();
        this.giftPrice = salesPlan.getGiftPrice();
        this.giftProfit = this.giftPrice - this.giftCost;
        this.giftSaturate = salesPlan.getGiftSaturate();

        this.insuranceCost = salesPlan.getInsuranceCost();
        this.insurancePrice = salesPlan.getInsurancePrice();
        this.insuranceProfit = this.insurancePrice - this.insuranceCost;
        this.insuranceSaturate = salesPlan.getInsuranceSaturate();

        this.financeCost = salesPlan.getFinanceCost();
        this.financePrice = salesPlan.getFinancePrice();
        this.financeProfit = this.financePrice - this.financeCost;
        this.financeSaturate = salesPlan.getFinanceSaturate();

        this.serviceCost = salesPlan.getServiceCost();
        this.servicePrice = salesPlan.getServicePrice();
        this.serviceProfit = this.servicePrice - this.serviceCost;
        this.serviceSaturate = salesPlan.getServiceSaturate();

        this.rebookInsuranceCost = salesPlan.getRebookInsuranceCost();
        this.rebookInsurancePrice = salesPlan.getRebookInsurancePrice();
        this.rebookInsuranceProfit = this.rebookInsurancePrice - this.rebookInsuranceCost;
        this.rebookInsuranceSaturate = salesPlan.getRebookInsuranceSaturate();

        this.vipCost = salesPlan.getVipCost();
        this.vipPrice = salesPlan.getVipPrice();
        this.vipProfit = this.vipPrice - this.vipCost;
        this.vipSaturate = salesPlan.getVipSaturate();

        this.renderCost = salesPlan.getRenderCost();
        this.renderPrice = salesPlan.getRenderPrice();
        this.renderProfit = this.renderPrice - this.renderCost;
        this.renderSaturate = salesPlan.getRenderSaturate();
    }

    public void dataAdd(ValueChain valueChain){
        this.number += valueChain.number;
        this.exchangeCost += valueChain.exchangeCost;
        this.exchangePrice += valueChain.exchangePrice;
        this.exchangeProfit += valueChain.exchangeProfit;

        this.giftCost += valueChain.giftCost;
        this.giftPrice += valueChain.giftPrice;
        this.giftProfit += valueChain.giftProfit;

        this.insuranceCost += valueChain.insuranceCost;
        this.insurancePrice += valueChain.insurancePrice;
        this.insuranceProfit += valueChain.insuranceProfit;

        this.financeCost += valueChain.financeCost;
        this.financePrice += valueChain.financePrice;
        this.financeProfit += valueChain.financeProfit;

        this.serviceCost += valueChain.serviceCost;
        this.servicePrice += valueChain.servicePrice;
        this.serviceProfit += valueChain.serviceProfit;

        this.rebookInsuranceCost += valueChain.rebookInsuranceCost;
        this.rebookInsurancePrice += valueChain.rebookInsurancePrice;
        this.rebookInsuranceProfit += valueChain.rebookInsuranceProfit;

        this.vipCost += valueChain.vipCost;
        this.vipPrice += valueChain.vipPrice;
        this.vipProfit += valueChain.vipProfit;

        this.renderCost += valueChain.renderCost;
        this.renderPrice += valueChain.renderPrice;
        this.renderProfit += valueChain.renderProfit;
    }

    public float getExchangeCost() {
        return exchangeCost;
    }

    public void setExchangeCost(float exchangeCost) {
        this.exchangeCost = exchangeCost;
    }

    public float getExchangePrice() {
        return exchangePrice;
    }

    public void setExchangePrice(float exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    public float getExchangeProfit() {
        return exchangeProfit;
    }

    public void setExchangeProfit(float exchangeProfit) {
        this.exchangeProfit = exchangeProfit;
    }

    public float getExchangeSaturate() {
        return exchangeSaturate;
    }

    public void setExchangeSaturate(float exchangeSaturate) {
        this.exchangeSaturate = exchangeSaturate;
    }

    public float getGiftCost() {
        return giftCost;
    }

    public void setGiftCost(float giftCost) {
        this.giftCost = giftCost;
    }

    public float getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(float giftPrice) {
        this.giftPrice = giftPrice;
    }

    public float getGiftProfit() {
        return giftProfit;
    }

    public void setGiftProfit(float giftProfit) {
        this.giftProfit = giftProfit;
    }

    public float getGiftSaturate() {
        return giftSaturate;
    }

    public void setGiftSaturate(float giftSaturate) {
        this.giftSaturate = giftSaturate;
    }

    public float getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(float insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public float getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(float insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public float getInsuranceProfit() {
        return insuranceProfit;
    }

    public void setInsuranceProfit(float insuranceProfit) {
        this.insuranceProfit = insuranceProfit;
    }

    public float getInsuranceSaturate() {
        return insuranceSaturate;
    }

    public void setInsuranceSaturate(float insuranceSaturate) {
        this.insuranceSaturate = insuranceSaturate;
    }

    public float getFinanceCost() {
        return financeCost;
    }

    public void setFinanceCost(float financeCost) {
        this.financeCost = financeCost;
    }

    public float getFinancePrice() {
        return financePrice;
    }

    public void setFinancePrice(float financePrice) {
        this.financePrice = financePrice;
    }

    public float getFinanceProfit() {
        return financeProfit;
    }

    public void setFinanceProfit(float financeProfit) {
        this.financeProfit = financeProfit;
    }

    public float getFinanceSaturate() {
        return financeSaturate;
    }

    public void setFinanceSaturate(float financeSaturate) {
        this.financeSaturate = financeSaturate;
    }

    public float getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(float serviceCost) {
        this.serviceCost = serviceCost;
    }

    public float getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(float servicePrice) {
        this.servicePrice = servicePrice;
    }

    public float getServiceProfit() {
        return serviceProfit;
    }

    public void setServiceProfit(float serviceProfit) {
        this.serviceProfit = serviceProfit;
    }

    public float getServiceSaturate() {
        return serviceSaturate;
    }

    public void setServiceSaturate(float serviceSaturate) {
        this.serviceSaturate = serviceSaturate;
    }

    public float getRebookInsuranceCost() {
        return rebookInsuranceCost;
    }

    public void setRebookInsuranceCost(float rebookInsuranceCost) {
        this.rebookInsuranceCost = rebookInsuranceCost;
    }

    public float getRebookInsurancePrice() {
        return rebookInsurancePrice;
    }

    public void setRebookInsurancePrice(float rebookInsurancePrice) {
        this.rebookInsurancePrice = rebookInsurancePrice;
    }

    public float getRebookInsuranceProfit() {
        return rebookInsuranceProfit;
    }

    public void setRebookInsuranceProfit(float rebookInsuranceProfit) {
        this.rebookInsuranceProfit = rebookInsuranceProfit;
    }

    public float getRebookInsuranceSaturate() {
        return rebookInsuranceSaturate;
    }

    public void setRebookInsuranceSaturate(float rebookInsuranceSaturate) {
        this.rebookInsuranceSaturate = rebookInsuranceSaturate;
    }

    public float getVipCost() {
        return vipCost;
    }

    public void setVipCost(float vipCost) {
        this.vipCost = vipCost;
    }

    public float getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(float vipPrice) {
        this.vipPrice = vipPrice;
    }

    public float getVipProfit() {
        return vipProfit;
    }

    public void setVipProfit(float vipProfit) {
        this.vipProfit = vipProfit;
    }

    public float getVipSaturate() {
        return vipSaturate;
    }

    public void setVipSaturate(float vipSaturate) {
        this.vipSaturate = vipSaturate;
    }

    public float getRenderCost() {
        return renderCost;
    }

    public void setRenderCost(float renderCost) {
        this.renderCost = renderCost;
    }

    public float getRenderPrice() {
        return renderPrice;
    }

    public void setRenderPrice(float renderPrice) {
        this.renderPrice = renderPrice;
    }

    public float getRenderProfit() {
        return renderProfit;
    }

    public void setRenderProfit(float renderProfit) {
        this.renderProfit = renderProfit;
    }

    public float getRenderSaturate() {
        return renderSaturate;
    }

    public void setRenderSaturate(float renderSaturate) {
        this.renderSaturate = renderSaturate;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }
}
