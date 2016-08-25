package CarSaleManagerSystem.Service;


import CarSaleManagerSystem.Bean.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by googo on 16/8/10.
 */

@Service
@Transactional
public class BudgetService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CarService carService;

    public JSONObject getOrderInfo(String carID){
        JSONObject orderInfo = new JSONObject();

//        Car car = carService.findCarById(carID);
//        if(car == null)
//            return  orderInfo;
//        Order order = orderService.findOrderByCar(carID);
//        Customer customer = order.getCustomer();
//        Set<Gift> gifts = order.getGiftSet();
//        Set<Insurance> insurances = order.getInsuranceSet();
//
//        float totalGiftSale = 0;
//        float totalGiftCost = 0;
//
//        for (Gift gift : gifts){
//            totalGiftSale += gift.getActualGetMoney();
//            totalGiftCost += gift.getCost();
//        }
//
//        float totalInsuranceSale = 0;
//        float totalInsuranceCost = 0;
//
//        for(Insurance insurance : insurances){
//            totalGiftSale += insurance.getActualGetMoney();
//            totalGiftCost += insurance.getCost();
//        }
//
//        orderInfo.put("carID", car.getCarID());
//        orderInfo.put("brand" , car.getGarage());
//        orderInfo.put("carBrand", car.getBrand());
//        orderInfo.put("sfx", car.getSfx());
//        orderInfo.put("carPrice", car.getPrice());
//        orderInfo.put("carDiscount", car.getDiscount());
//        orderInfo.put("carCost", car.getCost());
//        orderInfo.put("carProfit", order.getActualGetMoney() - car.getCost());
//
//        orderInfo.put("giftSale", totalGiftSale);
//        orderInfo.put("giftProfit", totalGiftSale - totalGiftCost);
//
//        orderInfo.put("insuranceSale", totalInsuranceSale);
//        orderInfo.put("insuranceProfit", totalInsuranceSale - totalInsuranceCost);
        return orderInfo;
    }

}
