package CarSaleManagerSystem.Bean;

/**
 * Created by HFQ on 2016/8/30.
 */
public class CarProfit {
    private float carCost;
    private float carPrice;
    private float carDiscount;

    /**
     * 毛利1
     */
    private float carProfit1;
    private float carPayBack;

    /**
     * 毛利2
     */
    private float carProfit2;
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

    private float valueChainIncome; //��ֵ������
    private float valueChainProfit; //��ֵ������
    private float carDynamicProfit; //�䶯ë�� number = 1ʱΪ ����
    private float carDynamicFee; //�䶯����
    private float carBoundProfit;//�߼�����

    public CarProfit() {
        this.carCost = 0;
        this.carPrice = 0;
        this.carDiscount = 0;

        /**
         * 毛利1
         */
        this.carProfit1 = 0;
        this.carPayBack = 0;

        /**
         * 毛利2
         */
        this.carProfit2 = 0;
        this.number = 0;

        this.exchangeCost = 0;
        this.exchangePrice = 0;
        this.exchangeProfit = 0;
        this.exchangeSaturate = 0;

        this.giftCost = 0;
        this.giftPrice = 0;
        this.giftProfit = 0;
        this.giftSaturate = 0;

        this.insuranceCost = 0;
        this.insurancePrice = 0;
        this.insuranceProfit = 0;
        this.insuranceSaturate = 0;

        this.financeCost = 0;
        this.financePrice = 0;
        this.financeProfit = 0;
        this.financeSaturate = 0;

        this.serviceCost = 0;
        this.servicePrice = 0;
        this.serviceProfit = 0;
        this.serviceSaturate = 0;

        this.rebookInsuranceCost = 0;
        this.rebookInsurancePrice = 0;
        this.rebookInsuranceProfit = 0;
        this.rebookInsuranceSaturate = 0;

        this.vipCost = 0;
        this.vipPrice = 0;
        this.vipProfit = 0;
        this.vipSaturate = 0;

        this.renderCost = 0;
        this.renderPrice = 0;
        this.renderProfit = 0;
        this.renderSaturate = 0;

        this.valueChainIncome = 0; //��ֵ������
        this.valueChainProfit = 0; //��ֵ������
        this.carDynamicProfit = 0; //�䶯ë�� number = 1ʱΪ ����
        this.carDynamicFee = 0; //�䶯����
        this.carBoundProfit = 0;//�߼�����
    }

    public CarProfit(SalesPlan salesPlan) {
        this.number = salesPlan.getNumber();
        this.carCost = salesPlan.getCarCost() * this.number;
        this.carPrice = salesPlan.getCarPrice()* this.number;
        this.carDiscount = salesPlan.getCarDiscount()* this.number;
        this.carPayBack = salesPlan.getCarPayback()* this.number;
        this.carProfit1 = this.carPrice - this.carCost - this.carDiscount;
        this.carProfit2 = this.carProfit1 + this.carPayBack;

        this.exchangeCost = salesPlan.getExchangeCost()* this.number;
        this.exchangePrice = salesPlan.getExchangePrice()* this.number;
        this.exchangeProfit = this.exchangePrice - this.exchangeCost;
        this.exchangeSaturate = salesPlan.getExchangeSaturate();
        this.exchangeCost *= this.exchangeSaturate;
        this.exchangePrice *= this.exchangeSaturate;
        this.exchangeProfit *= this.exchangeSaturate;

        this.giftCost = salesPlan.getGiftCost()* this.number;
        this.giftPrice = salesPlan.getGiftPrice()* this.number;
        this.giftProfit = this.giftPrice - this.giftCost;
        this.giftSaturate = salesPlan.getGiftSaturate();
        this.giftCost *= this.giftSaturate;
        this.giftPrice *= this.giftSaturate;
        this.giftProfit *= this.giftSaturate;

        this.insuranceCost = salesPlan.getInsuranceCost()* this.number;
        this.insurancePrice = salesPlan.getInsurancePrice()* this.number;
        this.insuranceProfit = this.insurancePrice - this.insuranceCost;
        this.insuranceSaturate = salesPlan.getInsuranceSaturate();
        this.insuranceCost *= this.insuranceSaturate;
        this.insurancePrice *= this.insuranceSaturate;
        this.insuranceProfit *= this.insuranceSaturate;

        this.financeCost = salesPlan.getFinanceCost()* this.number;
        this.financePrice = salesPlan.getFinancePrice()* this.number;
        this.financeProfit = this.financePrice - this.financeCost;
        this.financeSaturate = salesPlan.getFinanceSaturate();
        this.financeCost *= this.financeSaturate;
        this.financePrice *= this.financeSaturate;
        this.financeProfit *= this.financeSaturate;

        this.serviceCost = salesPlan.getServiceCost()* this.number;
        this.servicePrice = salesPlan.getServicePrice()* this.number;
        this.serviceProfit = this.servicePrice - this.serviceCost;
        this.serviceSaturate = salesPlan.getServiceSaturate();
        this.serviceCost *= this.serviceSaturate;
        this.servicePrice *= this.serviceSaturate;
        this.serviceProfit *= this.serviceSaturate;

        this.rebookInsuranceCost = salesPlan.getRebookInsuranceCost()* this.number;
        this.rebookInsurancePrice = salesPlan.getRebookInsurancePrice()* this.number;
        this.rebookInsuranceProfit = this.rebookInsurancePrice - this.rebookInsuranceCost;
        this.rebookInsuranceSaturate = salesPlan.getRebookInsuranceSaturate();
        this.rebookInsuranceCost *= this.rebookInsuranceSaturate;
        this.rebookInsurancePrice *= this.rebookInsuranceSaturate;
        this.rebookInsuranceProfit *= this.rebookInsuranceSaturate;

        this.vipCost = salesPlan.getVipCost()* this.number;
        this.vipPrice = salesPlan.getVipPrice()* this.number;
        this.vipProfit = this.vipPrice - this.vipCost;
        this.vipSaturate = salesPlan.getVipSaturate();
        this.vipCost *= this.vipSaturate;
        this.vipPrice *= this.vipSaturate;
        this.vipProfit *= this.vipSaturate;

        this.renderCost = salesPlan.getRenderCost()* this.number;
        this.renderPrice = salesPlan.getRenderPrice()* this.number;
        this.renderProfit = this.renderPrice - this.renderCost;
        this.renderSaturate = salesPlan.getRenderSaturate();
        this.renderCost *= this.renderSaturate;
        this.renderPrice *= this.renderSaturate;
        this.renderProfit *= this.renderSaturate;

        this.valueChainIncome = this.exchangePrice +
                this.giftPrice + this.insurancePrice +
                this.servicePrice + this.financePrice +
                this.vipPrice + this.rebookInsurancePrice +
                this.renderPrice;

        this.valueChainProfit = this.exchangeProfit +
                this.giftProfit + this.insuranceProfit +
                this.serviceProfit + this.financeProfit +
                this.vipProfit + this.rebookInsuranceProfit +
                this.renderProfit;

        this.carDynamicProfit = (this.carProfit2 + this.valueChainProfit) * (1-0.17f*1.12f);
        this.carDynamicFee = this.carCost * (0.05f + 30 * 0.0002f);
        this.carBoundProfit = this.carDynamicProfit - this.carDynamicFee;
    }

    public void dataAdd(CarProfit carProfit){
        this.carCost += carProfit.carCost;
        this.carPrice += carProfit.carPrice;
        this.carDiscount += carProfit.carDiscount;
        this.carPayBack += carProfit.carPayBack;
        this.carProfit1 += carProfit.carProfit1;
        this.carProfit2 += carProfit.carProfit2;
        this.valueChainIncome += carProfit.valueChainIncome;
        this.valueChainProfit += carProfit.valueChainProfit;
        this.carDynamicProfit += carProfit.carDynamicProfit;
        this.carDynamicFee += carProfit.carDynamicFee;
        this.carBoundProfit += carProfit.carBoundProfit;
        this.number += carProfit.number;

        this.exchangeCost += carProfit.exchangeCost;
        this.exchangePrice += carProfit.exchangePrice;
        this.exchangeProfit += carProfit.exchangeProfit;

        this.giftCost += carProfit.giftCost;
        this.giftPrice += carProfit.giftPrice;
        this.giftProfit += carProfit.giftProfit;

        this.insuranceCost += carProfit.insuranceCost;
        this.insurancePrice += carProfit.insurancePrice;
        this.insuranceProfit += carProfit.insuranceProfit;

        this.financeCost += carProfit.financeCost;
        this.financePrice += carProfit.financePrice;
        this.financeProfit += carProfit.financeProfit;

        this.serviceCost += carProfit.serviceCost;
        this.servicePrice += carProfit.servicePrice;
        this.serviceProfit += carProfit.serviceProfit;

        this.rebookInsuranceCost += carProfit.rebookInsuranceCost;
        this.rebookInsurancePrice += carProfit.rebookInsurancePrice;
        this.rebookInsuranceProfit += carProfit.rebookInsuranceProfit;

        this.vipCost += carProfit.vipCost;
        this.vipPrice += carProfit.vipPrice;
        this.vipProfit += carProfit.vipProfit;

        this.renderCost += carProfit.renderCost;
        this.renderPrice += carProfit.renderPrice;
        this.renderProfit += carProfit.renderProfit;
    }

    public float getCarProfit2() {
        return carProfit2;
    }

    public void setCarProfit2(float carProfit2) {
        this.carProfit2 = carProfit2;
    }

    public float getValueChainIncome() {
        return valueChainIncome;
    }

    public void setValueChainIncome(float valueChainIncome) {
        this.valueChainIncome = valueChainIncome;
    }

    public float getValueChainProfit() {
        return valueChainProfit;
    }

    public void setValueChainProfit(float valueChainProfit) {
        this.valueChainProfit = valueChainProfit;
    }

    public float getCarDynamicProfit() {
        return carDynamicProfit;
    }

    public void setCarDynamicProfit(float carDynamicProfit) {
        this.carDynamicProfit = carDynamicProfit;
    }

    public float getCarDynamicFee() {
        return carDynamicFee;
    }

    public void setCarDynamicFee(float carDynamicFee) {
        this.carDynamicFee = carDynamicFee;
    }

    public float getCarBoundProfit() {
        return carBoundProfit;
    }

    public void setCarBoundProfit(float carBoundProfit) {
        this.carBoundProfit = carBoundProfit;
    }

    public float getCarCost() {
        return carCost;
    }

    public void setCarCost(float carCost) {
        this.carCost = carCost;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(float carPrice) {
        this.carPrice = carPrice;
    }

    public float getCarDiscount() {
        return carDiscount;
    }

    public void setCarDiscount(float carDiscount) {
        this.carDiscount = carDiscount;
    }

    public float getCarProfit1() {
        return carProfit1;
    }

    public void setCarProfit1(float carProfit1) {
        this.carProfit1 = carProfit1;
    }

    public float getCarPayBack() {
        return carPayBack;
    }

    public void setCarPayBack(float carPayBack) {
        this.carPayBack = carPayBack;
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
