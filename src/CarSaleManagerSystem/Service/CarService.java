package CarSaleManagerSystem.Service;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.DAO.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by HFQ on 2016/8/7.
 */
@Service
@Transactional
public class CarService {
    @Autowired
    private CarDAO carDAO;

    @Autowired
    private GarageDAO garageDAO;

    @Autowired
    private CarBrandDAO carBrandDAO;

    @Autowired
    private ColorDAO colorDAO;

    @Autowired
    private SFXDAO sfxdao;

    @Autowired
    private CarTypeDAO carTypeDAO;

    @Autowired
    private StockStatusDAO stockStatusDAO;
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private AdditionalProductDAO additionalProductDAO;

    @Autowired
    private GiftDAO giftDAO;

    @Autowired
    private InsuranceDAO insuranceDAO;

    @Autowired
    private CarPlanDAO carPlanDAO;

    @Autowired
    private SalesPlanDAO salesPlanDAO;

    public void createCar(Car car) {
        if (carExist(car.getCarID())) {
            return;
        }
        if(stockStatusDAO.getStockStatusByID(car.getStockStatus()) == null){
            StockStatus stockStatus = new StockStatus();
            stockStatus.setState(car.getStockStatus());
            stockStatus.setValid("Y");
            stockStatusDAO.createStockStatus(stockStatus);
        }
        if(car.getPlanID() != -1){
            CarPlan carPlan = carPlanDAO.getCarPlanByID(car.getPlanID());
            if(carPlan != null) {
                int old_plan = carPlan.getNumber();
                if (old_plan > 0) {
                    carPlan.setNumber(old_plan - 1);
                    carPlanDAO.updateCarPlan(carPlan);
                }
            }
        }
        CarType carType = getCarTypeByID(new CarTypeID(car.getGarage(), car.getBrand(), car.getSfx(), car.getColor()));
        car.setValid("Y");
        car.setCost(carType.getCost());
        car.setDiscount(carType.getDiscount());
        car.setPrice(carType.getPrice());
        int stock = carType.getStock();
        int request_number = carType.getRequestNumber();
        carType.setStock(stock + 1);
        if (request_number > 0) {
            request_number--;
        }
        carType.setRequestNumber(request_number);
        carTypeDAO.updateCarType(carType);
        if (carDAO.findCarById(car.getCarID()) != null) {
            carDAO.updateCar(car);
            return;
        }
        carDAO.createCar(car);
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    public void removeCar(Car car) {
        if (carExist(car.getCarID())) {
            car.setValid("N");
            carDAO.updateCar(car);
        }
//        carDAO.removeCar(car);
    }

    public void updateCar(Car car) {
        if(stockStatusDAO.getStockStatusByID(car.getStockStatus()) == null){
            StockStatus stockStatus = new StockStatus();
            stockStatus.setState(car.getStockStatus());
            stockStatus.setValid("Y");
            stockStatusDAO.createStockStatus(stockStatus);
        }
        carDAO.updateCar(car);
    }

    public void removeUpdate(Car oldCar, Car newCar){
        System.out.println("!!!!!!!!");
        carDAO.removeCar(oldCar);
        carDAO.createCar(newCar);
        System.out.println("!!!!!!!!");
    }
    public Car findCarById(String carID) {
//        Car car = carDAO.findCarById(carID);
        if (carExist(carID))
            return carDAO.findCarById(carID);
        return null;
    }

    public boolean carExist(String carID) {
        Car car = carDAO.findCarById(carID);
        if (car == null || car.getValid().equals("N")) {
            return false;
        }
        return true;
    }

    public void createGarage(Garage garage) {
        if (garageExist(garage.getBrand())) {
            return;
        }
        if (garageDAO.findGarageByBrand(garage.getBrand()) != null) {
            garage.setValid("Y");
            garageDAO.updateGarage(garage);
            return;
        }
        garage.setValid("Y");
        garageDAO.createGarage(garage);
    }

    public List<Garage> getAllGarages() {
        return garageDAO.getAllGarages();
    }

    public void createCarBrand(CarBrand carBrand) {
        if (brandExist(carBrand.getGarage(), carBrand.getBrand())) {
            return;
        }
        List<CarBrand> carBrandList = getCarBrandsByGarage(carBrand.getGarage());
        if (carBrandList != null) {
            for (int i = 0; i < carBrandList.size(); i++) {
                if (carBrandList.get(i).equals(carBrand)) {
                    carBrand.setValid("Y");
                    carBrandDAO.updateCarBrand(carBrand);
                    return;
                }
            }
        }
        carBrand.setValid("Y");
        carBrandDAO.createCarBrand(carBrand);
    }

    public List<CarBrand> getAllCarBrands() {
        return carBrandDAO.getAllCarBrands();
    }

    public void createColor(CarColor carColor) {
        if (colorExist(carColor.getColor())) {
            return;
        }
        if (colorDAO.getColorByID(carColor.getColor()) != null) {
            carColor.setValid("Y");
            colorDAO.updateColor(carColor);
            return;
        }
        carColor.setValid("Y");
        colorDAO.createColor(carColor);
    }

    public List<CarColor> getAllColors() {
        return colorDAO.getAllColors();
    }

    public void createStockStatus(StockStatus stockStatus) {
        if (stockStatusExist(stockStatus.getState())) {
            return;
        }
        if (stockStatusDAO.getStockStatusByID(stockStatus.getState()) != null) {
            stockStatus.setValid("Y");
            stockStatusDAO.updateStockStatus(stockStatus);
            return;
        }
        stockStatus.setValid("Y");
        stockStatusDAO.createStockStatus(stockStatus);
    }

    public List<StockStatus> getAllStockStatus() {
        return stockStatusDAO.getAllStockStatus();
    }

    public void createCarSFX(CarSFX carSFX) {
        if (sfxExist(carSFX.getSfx())) {
            return;
        }
        if (sfxdao.findCarSFXById(carSFX.getSfx()) != null) {
            carSFX.setValid("Y");
            sfxdao.updateCarSFX(carSFX);
            return;
        }
        carSFX.setValid("Y");
        sfxdao.createCarSFX(carSFX);
    }

    public List<CarSFX> getAllCarSFX() {
        return sfxdao.getAllCarSFXs();
    }

    public void createCarType(CarType carType) {
        CarTypeID carTypeID = new CarTypeID(carType.getGarage(), carType.getBrand(), carType.getCarSfx(), carType.getCarColor());
        if (carTypeExist(carTypeID)) {
            return;
        }
        if (getCarTypeByID(carTypeID) != null) {
            carType.setValid("Y");
            carTypeDAO.updateCarType(carType);
            return;
        }
        carType.setValid("Y");
        carTypeDAO.createCarType(carType);
    }

    public List<CarType> getAllCarType() {
        return carTypeDAO.getAllCarType();
    }

    public List<CarType> getValidCarType() {

        List<CarType> carTypeList = carTypeDAO.getAllCarType();

        if(carTypeList == null){
            return null;
        }

        List<CarType> result = new ArrayList<>();

        for(int i = 0; i < carTypeList.size(); i ++){
            if(carTypeList.get(i).getValid().equals("Y")){
                result.add(carTypeList.get(i));
            }
        }

        return result;
    }

    public void removeCarType(CarType carType) {
        CarTypeID carTypeID = new CarTypeID(carType.getGarage(), carType.getBrand(), carType.getCarSfx(), carType.getCarColor());
        if (carTypeExist(carTypeID)) {
            carType = getCarTypeByID(carTypeID);
            carType.setValid("N");
            carTypeDAO.updateCarType(carType);
        }
//        carTypeDAO.removeCarType(carType);
    }

    public void updateCarType(CarType carType) {
        carTypeDAO.updateCarType(carType);
    }

    public List<CarType> findCarTypeByGarageBrand(String garageBrand) {
        return carTypeDAO.findCarTypeByGarageBrand(garageBrand);
    }

    public List<CarType> findCarTypeByBrand(String brand) {
        return carTypeDAO.findCarTypeByBrand(brand);
    }

    public List<CarType> findCarTypeBySFX(String SFX) {
        return carTypeDAO.findCarTypeBySFX(SFX);
    }

    public List<CarType> findCarTypeByColor(String color) {
        return carTypeDAO.findCarTypeByColor(color);
    }

    public List<CarType> GarageBrandFilter(List<CarType> carTypeList, String garage) {
        if (garage == null) {
            return carTypeList;
        }
        List<CarType> result = new ArrayList<>();
        if (carTypeList == null) {
            return null;
        }
        for (int i = 0; i < carTypeList.size(); i++) {
            if (carTypeList.get(i).getGarage().equals(garage)) {
                result.add(carTypeList.get(i));
            }
        }
        return result;
    }

    public List<CarType> BrandFilter(List<CarType> carTypeList, String carBrand) {
        if (carBrand == null) {
            return carTypeList;
        }
        List<CarType> result = new ArrayList<>();
        if (carTypeList == null) {
            return null;
        }
        for (int i = 0; i < carTypeList.size(); i++) {
            if (carTypeList.get(i).getBrand().equals(carBrand)) {
                result.add(carTypeList.get(i));
            }
        }
        return result;
    }

    public List<CarType> SFXFilter(List<CarType> carTypeList, String sfx) {
        if (sfx == null) {
            return carTypeList;
        }
        List<CarType> result = new ArrayList<>();
        if (carTypeList == null) {
            return null;
        }
        for (int i = 0; i < carTypeList.size(); i++) {
            if (carTypeList.get(i).getCarSfx().equals(sfx)) {
                result.add(carTypeList.get(i));
            }
        }
        return result;
    }

    public List<CarType> ColorFilter(List<CarType> carTypeList, String carColor) {
        if (carColor == null) {
            return carTypeList;
        }
        List<CarType> result = new ArrayList<>();
        if (carTypeList == null) {
            return null;
        }
        for (int i = 0; i < carTypeList.size(); i++) {
            if (carTypeList.get(i).getCarColor().equals(carColor)) {
                result.add(carTypeList.get(i));
            }
        }
        return result;
    }

    public CarType getCarTypeByID(CarTypeID carTypeID) {
        List<CarType> carTypeList = getAllCarType();
        carTypeList = GarageBrandFilter(carTypeList, carTypeID.getGarage());
        carTypeList = BrandFilter(carTypeList, carTypeID.getBrand());
        carTypeList = ColorFilter(carTypeList, carTypeID.getColor());
        carTypeList = SFXFilter(carTypeList, carTypeID.getSfx());
        if (carTypeList == null || carTypeList.size() == 0) {
            return null;
        }
        return carTypeList.get(0);
    }

    public List<Car> CarGarageBrandFilter(List<Car> cars, String garage) {
        if (garage == null) {
            return cars;
        }
        List<Car> result = new ArrayList<>();
        if (cars == null) {
            return null;
        }
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getGarage().equals(garage)) {
                result.add(cars.get(i));
            }
        }
        return result;
    }

    public List<Car> CarBrandFilter(List<Car> cars, String brand) {
        if (brand == null) {
            return cars;
        }
        List<Car> result = new ArrayList<>();
        if (cars == null) {
            return null;
        }
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getBrand().equals(brand)) {
                result.add(cars.get(i));
            }
        }
        return result;
    }

    public List<Car> CarColorFilter(List<Car> cars, String color) {
        if (color == null) {
            return cars;
        }
        List<Car> result = new ArrayList<>();
        if (cars == null) {
            return null;
        }
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getColor().equals(color)) {
                result.add(cars.get(i));
            }
        }
        return result;
    }



    public List<Car> CarSFXFilter(List<Car> cars, String SFX) {
        if (SFX == null) {
            return cars;
        }
        List<Car> result = new ArrayList<>();
        if (cars == null) {
            return null;
        }
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getSfx().equals(SFX)) {
                result.add(cars.get(i));
            }
        }
        return result;
    }

    public List<Car> carStatusFilter(List<Car> cars, String status){
       if(status == null){
           return null;
       }

       if(cars == null){
           return null;
       }
       List<Car> result = new ArrayList<>();

        for(int i = 0; i < cars.size(); i ++){
            if(cars.get(i).getStockStatus().equals(status)){
                result.add(cars.get(i));
            }
        }


        return result;
    }
    public List<Car> findCarByCarType(CarTypeID carTypeID) {
        List<Car> result = getAllCars();
        result = CarGarageBrandFilter(result, carTypeID.getGarage());
        result = CarBrandFilter(result, carTypeID.getBrand());
        result = CarColorFilter(result, carTypeID.getColor());
        result = CarSFXFilter(result, carTypeID.getSfx());
        if (result != null && result.size() > 0) {
            return result;
        }
        return null;
    }

    public int getCarAge(String carID) {
        Car car = findCarById(carID);
        if (car == null) {
            return -1;
        }
        Date purchaseDay = car.getPurchasedTime();
        Calendar calendar = Calendar.getInstance();
        Date today = new Date();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            purchaseDay = sdf.parse(sdf.format(purchaseDay));
            today = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
        calendar.setTime(purchaseDay);
        long time1 = calendar.getTimeInMillis();
        calendar.setTime(today);
        long time2 = calendar.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public Map<Car, Integer> getCarAgeList() {
        List<Car> cars = getAllCars();
        if (cars == null) {
            return null;
        }
        Map<Car, Integer> result = new HashMap<>();
        int age;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getValid().equals("Y")) {
                age = getCarAge(cars.get(i).getCarID());
                result.put(cars.get(i), age);
            }
        }
        return result;
    }


    public Map<Car, Integer> getCarAgeListByCarType(CarTypeID carTypeID) {
        List<Car> cars = findCarByCarType(carTypeID);
        if (cars == null) {
            return null;
        }
        Map<Car, Integer> result = new HashMap<>();
        int age;
        for (int i = 0; i < cars.size(); i++) {
            age = getCarAge(cars.get(i).getCarID());
            result.put(cars.get(i), age);
        }
        return result;
    }

    public Map<Car, CarPlan> getCarBookedList(){
        List<Car> carList = getAllCars();

        List<Car> cars = carStatusFilter(carList, "订车");

        if(cars == null){
            return null;
        }

        Map<Car,CarPlan> result = new HashMap<>();

        for(int i = 0; i < cars.size(); i ++){
            CarPlan carPlan = carPlanDAO.getCarPlanByID(cars.get(i).getPlanID());

            result.put(cars.get(i), carPlan);
        }

        return result;
    }

    public Map<Car, CarPlan> getCarOnWayList(){
        List<Car> carList = carDAO.getAllCars();

        List<Car> cars = carStatusFilter(carList,"在途");

        if(cars == null){
            return null;
        }
        int age;
        CarPlan carPlan;
        Map<Car,CarPlan> result = new HashMap<>();
        for(int i = 0; i < cars.size(); i ++){

            age = getCarAge(cars.get(i).getCarID());
            carPlan = carPlanDAO.getCarPlanByID(cars.get(i).getPlanID());
            result.put(cars.get(i), carPlan);
        }
        return result;
    }

    public Map<Car, CarPlan> getCarInGarage(){
        List<Car> carList = carDAO.getAllCars();

        List<Car> cars = carStatusFilter(carList,"在库");

        if(cars == null){
            return null;
        }

        int age;
        CarPlan carPlan;
        Map<Car,CarPlan> result = new HashMap<>();
        for(int i = 0; i < cars.size(); i ++){

            age = getCarAge(cars.get(i).getCarID());
            carPlan = carPlanDAO.getCarPlanByID(cars.get(i).getPlanID());
            result.put(cars.get(i), carPlan);
        }
        return result;

    }

    public Map<Car, CarPlan> getCarOutOfGarage(){
        List<Car> carList = carDAO.getAllCars();

        List<Car> cars = carStatusFilter(carList,"出库");

        if(cars == null){
            return null;
        }

        int age;
        CarPlan carPlan;
        Map<Car,CarPlan> result = new HashMap<>();
        for(int i = 0; i < cars.size(); i ++){

            age = getCarAge(cars.get(i).getCarID());
            carPlan = carPlanDAO.getCarPlanByID(cars.get(i).getPlanID());
            result.put(cars.get(i), carPlan);
        }
        return result;
    }

    public Map<Car, CarPlan> getCarByStatus(String status){
        List<Car> carList = carDAO.getAllCars();

        List<Car> cars = carStatusFilter(carList,status);

        if(cars == null){
            return null;
        }

        int age;
        CarPlan carPlan;
        Map<Car,CarPlan> result = new HashMap<>();
        for(int i = 0; i < cars.size(); i ++){

            age = getCarAge(cars.get(i).getCarID());
            carPlan = carPlanDAO.getCarPlanByID(cars.get(i).getPlanID());
            result.put(cars.get(i), carPlan);
        }
        return result;
    }
    public List<CarBrand> getCarBrandsByGarage(String garage) {
        List<CarBrand> carBrandList = carBrandDAO.getAllCarBrands();
        List<CarBrand> result = new ArrayList<>();
        if (garage == null) {
            return carBrandList;
        }
        if (carBrandList == null || carBrandList.size() == 0) {
            return null;
        }
        for (int i = 0; i < carBrandList.size(); i++) {
            if (carBrandList.get(i).getGarage().equals(garage)) {
                result.add(carBrandList.get(i));
            }
        }
        return result;
    }

    public List<CarSFX> getCarSFXByBrand(String garage, String brand){
        List<CarSFX> carSFXList = sfxdao.getAllCarSFXs();
        List<CarSFX> result = new ArrayList<>();

        if(garage == null || brand == null){
            return carSFXList;
        }

        for(int i = 0; i < carSFXList.size(); i++){
            if(carSFXList.get(i).getGarage().equals(garage) && carSFXList.get(i).getBrand().equals(brand)){
                result.add(carSFXList.get(i));
            }
        }

        return result;
    }
    public boolean garageExist(String brand) {
        Garage garage = garageDAO.findGarageByBrand(brand);
        if (garage == null || garage.getValid().equals('N')) {
            return false;
        }
        return true;
    }

    public boolean brandExist(String garage, String brand) {
        if (!garageExist(garage)) {
            return false;
        }
        List<CarBrand> carBrandList = getCarBrandsByGarage(garage);
        if (carBrandList == null) {
            return false;
        }
        for (int i = 0; i < carBrandList.size(); i++) {
            if (carBrandList.get(i).getBrand().equals(brand) && carBrandList.get(i).getValid().equals("Y")) {
                return true;
            }
        }
        return false;
    }

    public boolean colorExist(String color) {
        CarColor carColor = colorDAO.getColorByID(color);
        if (carColor == null || carColor.getValid().equals("N")) {
            return false;
        }
        return true;
    }

    public boolean sfxExist(String sfx) {
        CarSFX carSFX = sfxdao.findCarSFXById(sfx);
        if (carSFX == null || carSFX.getValid().equals("N")) {
            return false;
        }
        return true;
    }

    public boolean carTypeExist(CarTypeID carTypeID) {
        CarType carType = getCarTypeByID(carTypeID);
        if (carType == null || carType.getValid().equals("N")) {
            return false;
        }
        return true;
    }

    public boolean stockStatusExist(String stock) {
        StockStatus stockStatus = stockStatusDAO.getStockStatusByID(stock);
        if (stockStatus == null || stockStatus.getValid().equals("N")) {
            return false;
        }
        return true;
    }

    /*
    *营销公式部分
    *
    *
     */

    public Order getOrderByCarID(String carID) {
        List<Order> orders = orderDAO.getAllOrders();
        if (orders == null) return null;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCarID().equals(carID)) {
                return orders.get(i);
            }
        }
        return null;
    }

    private static final float INTEREST_RATE = 0.05f;

    /**
     * 单车可变经营费用公式＝进货成本*库存天数*可变费率（5%）
     *
     * @param carID        车架号
     * @param interestRate 可变费率
     * @return 单车可变经营费用
     */
    public float carDynamicFee(String carID, float interestRate) {
        Car car = carDAO.findCarById(carID);
        if (car == null) {
            return 0;
        }
        return car.getCost() * getCarAge(carID) * interestRate;
    }

    /**
     * 单车亏损预警公式＝整车计划销售毛利+整车计划销售特返利－可变经营费用
     *
     * @param carID 车架号
     * @return 单车亏损预警
     */
    public float carWarning(String carID) {
        Car car = carDAO.findCarById(carID);
        if (car == null) {
            return 0;
        }
        float orderProfit = car.getPrice() - car.getCost();
        float payback = car.getPayback();
        float dynamicFee = carDynamicFee(carID, INTEREST_RATE);
        return orderProfit + payback - dynamicFee;
    }

    /**
     * 水平事业收入毛利公式＝二手车+精品+保险+金融+延保+会员+租赁
     * 若此车没卖 返回0
     *
     * @param carID 车架号
     * @return 水平事业收入毛利
     */
    public float additionalProfit(String carID) {
        /** to be implemented*/
        Order order = getOrderByCarID(carID);
        if (order == null) {
            return 0;
        }

        List<AdditionalProduct> additionalProducts = additionalProductDAO.findAdditionalProductByOrderId(order.getOrderID());
        List<Gift> gifts = giftDAO.findGiftByOrderId(order.getOrderID());
        List<Insurance> insurances = insuranceDAO.findInsuranceByOrderId(order.getOrderID());
        float total = 0;
        for(AdditionalProduct additionalProduct : additionalProducts){
            total += (additionalProduct.getActualGetMoney() - additionalProduct.getCost());
        }

        for(Gift gift : gifts){
            total += gift.getActualGetMoney()- gift.getCost();
        }

        for(Insurance insurance : insurances){
            total += insurance.getActualGetMoney() - insurance.getCost();
        }

        return total;
    }

    public float additionalIncome(String carID) {
        /** to be implemented*/
        Order order = getOrderByCarID(carID);
        if (order == null) {
            return 0;
        }

        List<AdditionalProduct> additionalProducts = additionalProductDAO.findAdditionalProductByOrderId(order.getOrderID());
        List<Gift> gifts = giftDAO.findGiftByOrderId(order.getOrderID());
        List<Insurance> insurances = insuranceDAO.findInsuranceByOrderId(order.getOrderID());
        float total = 0;
        for(AdditionalProduct additionalProduct : additionalProducts){
            total += (additionalProduct.getActualGetMoney());
        }

        for(Gift gift : gifts){
            total += gift.getActualGetMoney();
        }

        for(Insurance insurance : insurances){
            total += insurance.getActualGetMoney();
        }

        return total;
    }
    /**
     * 综合利润公式＝整车毛利+返利+水平事业毛利－可变经营费用
     * 若此车没卖 返回0
     *
     * @param carID 车架号
     * @return 综合利润公式
     */
    public float carTotalProfit(String carID) {
        /**
         *  通过carID 找 orderID -- 得改数据库给车加上orderID -- 或者遍历orderList
         */
        Car car = carDAO.findCarById(carID);
        if (car == null) {
            return 0;
        }
        Order order = getOrderByCarID(carID);
        if (order == null) {
            return 0;
        }

        float carProfit = order.getActualGetMoney() - car.getCost();
        float additionalProfit = additionalProfit(carID);
        float payback = car.getPayback();
        float dynamicFee = carDynamicFee(carID, INTEREST_RATE);

        return carProfit + payback + additionalProfit - dynamicFee;
    }


    /**
     * 还剩几天亏损
     * 单车亏损预警公式＝整车计划销售毛利+整车计划销售特返利－可变经营费用
     * =整车计划销售毛利+整车计划销售特返利 - 进货成本*库存天数*可变费率（5%）
     * <p>
     * 总寿命 = （整车计划销售毛利+整车计划销售特返利）/ （进货成本*可变费率）
     * 剩余寿命 = 总寿命 - 当前寿命
     *
     * @param carID 车架号
     * @return -1 —— 车不存在
     * 0 -- 已经亏损
     * 正整数 —— 还剩几天亏损
     */
    public int remainingProfitDay(String carID) {
        Car car = carDAO.findCarById(carID);
        if (car == null) {
            return -1;
        }
        float orderProfit = car.getPrice() - car.getCost();
        float payback = car.getPayback();
        float carCost = car.getCost();
        int carAge = (int) ((orderProfit - payback) / (carCost * INTEREST_RATE));
        if (carAge < getCarAge(carID)) {
            return 0;
        }
        return carAge - getCarAge(carID);
    }

    public void createCarPlan(CarPlan carPlan){
        carPlanDAO.createCarPlan(carPlan);
    }

    public List<CarPlan> getAllCarPlans(){
        return carPlanDAO.getAllCarPlan();
    }

    public CarPlan getCarPlanByID(int planID){
        return carPlanDAO.getCarPlanByID(planID);
    }


    /**
     * 辅助函数 判断是否同一个月
     * @param date1 date1
     * @param date2 date2
     * @return 是否同一个月
     */
    private boolean isSameMonth(Date date1,Date date2){
        if(date1 == null || date2 == null){
            return false;
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);
        int month1 = calendar1.get(Calendar.MONTH);
        int month2 = calendar2.get(Calendar.MONTH);
//        System.out.println(year1);
//        System.out.println(year2);
        return year1 == year2 && month1 == month2;
    }

    /**
     * 辅助函数 判断是否同一个日
     * @param date1 date1
     * @param date2 date2
     * @return 是否同一个日
     */
    private boolean isSameDay(Date date1,Date date2){
        if(date1 == null || date2 == null){
            return false;
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);
        int month1 = calendar1.get(Calendar.MONTH);
        int month2 = calendar2.get(Calendar.MONTH);
        int day1 = calendar1.get(Calendar.DAY_OF_MONTH);
        int day2 = calendar2.get(Calendar.DAY_OF_MONTH);
        return year1 == year2 && month1 == month2 && day1 == day2;
    }

    public Date setDate(int year, int month, int day){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = year + "-" + month + "-" + day;
            Date result = sdf.parse(sdf.format(date));
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 辅助函数 获得一个月有多少天
     * @param date 某个月
     * @return 这个月有多少天
     */
    public int dayOfMonth(Date date){
        if(date == null){
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int result = 0;
        int[] monthDay ={31,28,31,30,31,30,31,31,30,31,30,31};
        if(month >= 0 && month < 12){
            result = monthDay[month];
        }
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            if(result == 28){
                result = 29;
            }
        }
        return result;
    }

    /**
     * 返回所有的车的计划
     * @return 所有车的计划
     */
    public List<CarPlan> getAllCarPlan(){
        return carPlanDAO.getAllCarPlan();
    }

    /**
     * 某个月计划要卖的车的数量
     * @param date 某个月
     * @return 这个月要卖的车的数量
     */
    public int getCarPlanNumberByMonth(Date date){
        List<CarPlan> carPlans = carPlanDAO.getAllCarPlan();
        int result = 0;
        if(carPlans == null || date == null){
            return result;
        }
        for(int i = 0;i < carPlans.size();i++){
            if(isSameMonth(carPlans.get(i).getOutGarageTime(),date)){
                result += carPlans.get(i).getNumber();
            }
        }
        return result;
    }

    /**
     * 某个月的计划销售额
     * @param date 某个月
     * @return 这个月的计划销售额
     */
    public float getCarPlanTotalPriceByMonth(Date date){
        List<CarPlan> carPlans = carPlanDAO.getAllCarPlan();
        float result = 0;
        if(carPlans == null || date == null){
            return result;
        }
        for(int i = 0;i < carPlans.size();i++){
            if(isSameMonth(carPlans.get(i).getOutGarageTime(),date)){
                result += carPlans.get(i).getDefaultPrice();
            }
        }
        return result;
    }

    /**
     * 某个月的计划销售车辆的平均成本
     * @param date 某个月
     * @return 这个月的计划销售车辆的平均成本
     */
    public float averageBuyCarCostByMonth(Date date){
        List<CarPlan> carPlans = carPlanDAO.getAllCarPlan();
        float result = 0;
        int number = 0;
        CarType carType;
        CarTypeID carTypeID;
        CarPlan carPlan;
        if(carPlans == null || date == null){
            return result;
        }
        for(int i = 0;i < carPlans.size();i++){
            carPlan = carPlans.get(i);
            if(isSameMonth(carPlan.getOutGarageTime(), date)){
                carTypeID = new CarTypeID(carPlan.getGarage(),carPlan.getBrand(),carPlan.getCarSfx(),carPlan.getCarColor());
                carType = getCarTypeByID(carTypeID);
                result += carType.getCost();
                number++;
            }
        }
        if(number != 0){
            result /= number;
        }
        return result;
    }

    /**
     * 某个月平均每天的计划销售数
     * @param date 这个月
     * @return 这个月平均每天的计划销售数
     */
    public float carPlanNumberPerDay(Date date){
        int total = getCarPlanNumberByMonth(date);
        return total / dayOfMonth(date);
    }

    /**
     * 某个月平均每天的计划销售额
     * @param date 这个月
     * @return 这个月平均每天的计划销售额
     */
    public float carPlanTotalPricePerDay(Date date){
        float total = getCarPlanTotalPriceByMonth(date);
        return total / dayOfMonth(date);
    }

    /**
     * 某月销售的汽车
     * @param date 某一月
     * @return 这一月卖的汽车
     */
    public List<Order> getCarSoldByMonth(Date date){
        List<Order> orderList = orderDAO.getAllOrders();
        List<Order> result = new ArrayList<>();

        for(Order order : orderList){
            if(isSameMonth(order.getActual_pay_time(), date)){
                result.add(order);
            }
        }

        return result;
    }


    /**
     * 月度全车型销售利润*/
    public HashMap<String,HashMap<String, CarProfit>> getCarTypeSoldByMonth(int year, int month) throws IOException{
        try {
            Date dt = new Date(year - 1900, month,1);

            List<Order> orderList = getCarSoldByMonth(dt);
            if(orderList == null){
                return null;
            }

            HashMap<String,HashMap<String, CarProfit>> result = new HashMap<>();
            CarProfit carProfit = new CarProfit();
            for(int i = 0; i <orderList.size(); i ++){
                carProfit.setValueChainIncome(0);
                carProfit.setValueChainProfit(0);
                Car car = carDAO.findCarById(orderList.get(i).getCarID());
                List<Gift> gifts = giftDAO.findGiftByOrderId(orderList.get(i).getOrderID());
                List<Insurance> insurances = insuranceDAO.findInsuranceByOrderId(orderList.get(i).getOrderID());
                List<AdditionalProduct> additionalProducts = additionalProductDAO.findAdditionalProductByOrderId(orderList.get(i).getOrderID());


                carProfit.setCarCost(car.getCost());
                carProfit.setCarPayBack(car.getPayback());
                carProfit.setCarPrice(orderList.get(i).getActualGetMoney());
                carProfit.setCarProfit1(orderList.get(i).getActualGetMoney() - car.getCost());
                carProfit.setCarProfit2(carProfit.getCarProfit1() + car.getPayback());

                float get = 0;
                float earn = 0;

                for(Gift gift : gifts){
                    get += gift.getActualGetMoney();
                    earn += (get - gift.getCost());
                }

                carProfit.setGiftPrice(get);
                carProfit.setGiftProfit(earn);
                carProfit.setValueChainIncome(carProfit.getValueChainProfit() + get);
                carProfit.setValueChainProfit(carProfit.getValueChainProfit() + earn);
                get = 0;
                earn = 0;

                for(Insurance insurance : insurances){
                    get += insurance.getActualGetMoney();
                    earn += (get - insurance.getCost());
                }

                carProfit.setInsurancePrice(get);
                carProfit.setInsuranceProfit(earn);
                carProfit.setValueChainIncome(carProfit.getValueChainProfit() + get);
                carProfit.setValueChainProfit(carProfit.getValueChainProfit() + earn);
                get = 0;
                earn = 0;

                List<AdditionalProduct> finance = additionalProductDAO.additionalProductTypeFilter(additionalProducts,"金融");
                for(AdditionalProduct add : finance){
                    get += add.getActualGetMoney();
                    earn += (get - add.getCost());
                }
                carProfit.setFinancePrice(get);
                carProfit.setFinanceProfit(earn);
                carProfit.setValueChainIncome(carProfit.getValueChainProfit() + get);
                carProfit.setValueChainProfit(carProfit.getValueChainProfit() + earn);
                get = 0;
                earn = 0;

                List<AdditionalProduct> secondHand = additionalProductDAO.additionalProductTypeFilter(additionalProducts,"二手车");
                for(AdditionalProduct add : secondHand){
                    get += add.getActualGetMoney();
                    earn += (get - add.getCost());
                }
                carProfit.setExchangePrice(get);
                carProfit.setExchangeProfit(earn);
                carProfit.setValueChainIncome(carProfit.getValueChainProfit() + get);
                carProfit.setValueChainProfit(carProfit.getValueChainProfit() + earn);
                get = 0;
                earn = 0;


                List<AdditionalProduct> service = additionalProductDAO.additionalProductTypeFilter(additionalProducts,"服务费");
                for(AdditionalProduct add : service){
                    get += add.getActualGetMoney();
                    earn += (get - add.getCost());
                }
                carProfit.setServicePrice(get);
                carProfit.setExchangeProfit(earn);
                carProfit.setValueChainIncome(carProfit.getValueChainProfit() + get);
                carProfit.setValueChainProfit(carProfit.getValueChainProfit() + earn);
                get = 0;
                earn = 0;

                List<AdditionalProduct> VIP = additionalProductDAO.additionalProductTypeFilter(additionalProducts,"VIP");
                for(AdditionalProduct add : VIP){
                    get += add.getActualGetMoney();
                    earn += (get - add.getCost());
                }
                carProfit.setVipPrice(get);
                carProfit.setVipProfit(earn);
                carProfit.setValueChainIncome(carProfit.getValueChainProfit() + get);
                carProfit.setValueChainProfit(carProfit.getValueChainProfit() + earn);
                get = 0;
                earn = 0;

                List<AdditionalProduct> rent = additionalProductDAO.additionalProductTypeFilter(additionalProducts,"租赁");
                for(AdditionalProduct add : rent){
                    get += add.getActualGetMoney();
                    earn += (get - add.getCost());
                }
                carProfit.setRenderPrice(get);
                carProfit.setRenderProfit(earn);
                carProfit.setValueChainIncome(carProfit.getValueChainProfit() + get);
                carProfit.setValueChainProfit(carProfit.getValueChainProfit() + earn);
                get = 0;
                earn = 0;

                List<AdditionalProduct> reBook = additionalProductDAO.additionalProductTypeFilter(additionalProducts,"延保");
                for(AdditionalProduct add : reBook){
                    get += add.getActualGetMoney();
                    earn += (get - add.getCost());
                }
                carProfit.setRebookInsurancePrice(get);
                carProfit.setRebookInsuranceProfit(earn);
                carProfit.setValueChainIncome(carProfit.getValueChainProfit() + get);
                carProfit.setValueChainProfit(carProfit.getValueChainProfit() + earn);

                carProfit.setNumber(1);
                carProfit.setCarDynamicProfit((carProfit.getCarProfit2() + carProfit.getValueChainProfit()) *
                        (1-0.17f*1.12f));
                carProfit.setCarDynamicFee(carProfit.getCarCost() * (0.05f + 30 * 0.0002f));
                carProfit.setCarBoundProfit(carProfit.getCarDynamicProfit() - carProfit.getCarDynamicFee());

                if(!result.containsKey(car.getBrand())){
                    HashMap<String, CarProfit> sfx= new HashMap<>();
                    sfx.put(car.getSfx(), carProfit);
                    result.put(car.getBrand(), sfx);
                }else{
                    if(result.get(car.getBrand()).containsKey(car.getSfx())){
                        CarProfit tmp = result.get(car.getBrand()).get(car.getSfx());
                        tmp.dataAdd(carProfit);
                        result.get(car.getBrand()).replace(car.getSfx(),tmp);
                    }else {
                        result.get(car.getBrand()).put(car.getSfx(), carProfit);
                    }
                }
            }

            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 某天销售的汽车
     * @param date 某一天
     * @return 这天卖的汽车
     */

    public List<Order> getCarSoldByDay(Date date){
        List<Order> orderList = getCarSoldByMonth(date);

        List<Order> result = new ArrayList<>();

        for(Order order : orderList){
            if(isSameDay(order.getActual_pay_time(), date)){
                result.add(order);
            }
        }

        return result;
    }

    /**
     * 某月购入的汽车
     * @param date 本月
     * @return 这月买入的汽车
     */
    public List<Car> getCarPurchasedByMonth(Date date){
        List<Car> carList = carDAO.getAllCars();
        carList = carStatusFilter(carList, "在库");
        List<Car> result = new ArrayList<>();

        for(Car car : carList){
            if(isSameMonth(car.getPurchasedTime(),date)){
                result.add(car);
            }
        }
        return result;
    }


    /**
     * 某天买入的汽车
     * @param date 某一天
     * @return 这天买入的汽车
     */
    public List<Car> getCarPurchasedByDay(Date date){
        List<Car> carList = getCarPurchasedByMonth(date);
        List<Car> result = new ArrayList<>();

        for(Car car : carList){
            if(isSameDay(car.getPurchasedTime(), date)){
                result.add(car);
            }
        }
        return result;
    }


    /**
     * 某月每天销售汽车辆及销售金额
     * @param date 某一天
     * @return 这天卖的汽车数量及收入
     */
    public Map<Integer, Float> carSoldPerDay(String date){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date month;
            month = sdf.parse(sdf.format(date));
            Date day;
            List<Order> orders;
            Map<Integer, Float> result = new HashMap<>();

            for(int i = 0; i < dayOfMonth(month); i ++){
                day = new Date(month.getYear(),month.getMonth(), i+1);
                orders = getCarSoldByDay(day);
                float money = 0;
                for(int j =0; j< orders.size(); j++){
                    money += carTotalProfit(orders.get(i).getCarID());
                }
                result.put(orders.size(), money);
                money = 0;
            }

            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 某月每天买入汽车辆及销售金额
     * @param date 某一天
     * @return 这天买入的汽车数量及支出
     */
    public Map<Integer, Float> carPurchasedPerDay(String date){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date month;
            month = sdf.parse(sdf.format(date));
            Date day;
            List<Car> cars;
            Map<Integer, Float> result = new HashMap<>();

            for(int i = 0; i < dayOfMonth(month); i ++){
                day = new Date(month.getYear(),month.getMonth(), i+1);
                cars = getCarPurchasedByDay(day);
                float money = 0;
                for(int j =0; j< cars.size(); j++){
                    money += cars.get(i).getCost();
                }
                result.put(cars.size(), money);
                money = 0;

            }

            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 未来某月每天计划销售汽车辆及销售金额
     * @param date 某一天
     * @return 未来这天计划卖的汽车数量及收入
     */
    public Map<Float, Float> getCarPlanByMonth(String date){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date month;
            month = sdf.parse(sdf.format(date));

            Map<Float, Float> plan = new HashMap<>();

            float planPerDay = carPlanNumberPerDay(month);
            float money = carPlanTotalPricePerDay(month);
            int days = dayOfMonth(month);

            for (int i = 0; i < days; i++) {
                plan.put(planPerDay,money);
            }
            return plan;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


//    private boolean carTypeEqual(String garage1, String brand1, String garage2, String brand2){
//        return (garage1.equals(garage2) && brand1.equals(brand2));
//    }


    /**
     * 某月计划销售的汽车
     * @param date 某一月
     * @return 这一月计划卖的汽车
     */

    public List<CarPlan> getCarPlanMonthly(Date date){
        List<CarPlan> carPlanList = carPlanDAO.getAllCarPlan();

        if(carPlanList == null){
            return null;
        }
        List<CarPlan> result = new ArrayList<>();

        for(int i = 0; i < carPlanList.size(); i ++){
            if(isSameMonth(carPlanList.get(i).getSubmitTime(), date)){
                result.add(carPlanList.get(i));
            }
        }

        return result;
    }


    public List<CarPlan> carPlanGarageFilter(List<CarPlan> carPlanList, String garage){
        List<CarPlan> result = new ArrayList<>();


        for(int i = 0; i< carPlanList.size(); i ++){
            if(carPlanList.get(i).getGarage().equals(garage)){
                result.add(carPlanList.get(i));
            }
        }

        return result;
    }
    /**
     * 某列表中某品牌的所有汽车
     * @param carPlanList 某列表
     * @param brand 某品牌
     * @return 某列表中某品牌的所有汽车
     */
    public List<CarPlan> carPlanBrandFilter(List<CarPlan> carPlanList, String brand){
        List<CarPlan> result = new ArrayList<>();

        for(int i = 0; i< carPlanList.size(); i ++){
            if(carPlanList.get(i).getBrand().equals(brand)){
                result.add(carPlanList.get(i));
            }
        }

        return result;
    }

    public void createSalesPlan(SalesPlan salesPlan){
        salesPlanDAO.createSalesPlan(salesPlan);
    }
    public List<SalesPlan> getAllSalesPlans(){
        return salesPlanDAO.getAllSalesPlans();
    }

    public void removeSalesPlan(SalesPlan salesPlan){
        salesPlanDAO.removeSalesPlan(salesPlan);
    }

    public void updateSalesPlan(SalesPlan salesPlan){
        salesPlanDAO.updateSalesPlan(salesPlan);
    }

    public SalesPlan findSalesPlanById(int salesPlanId){
        return salesPlanDAO.findSalesPlanById(salesPlanId);
    }

    public List<SalesPlan> getSalesPlanByMonth(Date date){
        List<SalesPlan> salesPlanList = salesPlanDAO.getAllSalesPlans();

        if(salesPlanList == null){
            return null;
        }

        List<SalesPlan> result = new ArrayList<>();

        for(int i = 0; i < salesPlanList.size(); i ++){
           // System.out.println(salesPlanList.get(i).getPlanTime().toString());
            if(isSameMonth(salesPlanList.get(i).getPlanTime(), date)){
                System.out.println(i);
                result.add(salesPlanList.get(i));
            }
        }
        System.out.println(result.size());
        return result;
    }
    /**
     * 返回某一年按map<Brand, Map<sfx, month[12]>> 存储的计划车销量
     * 第一层Map的key是Brand 第二层Map的key是SFX value 是一个存了12个月车销量的数组
     * @param year 某一年
     * @return result
     */
    public HashMap<String,HashMap<String,Integer[]>> carPlanNumberByYear(int year){
        HashMap<String,HashMap<String,Integer[]>> result = new HashMap<>();
        List<SalesPlan> salesPlans = salesPlanDAO.getAllSalesPlans();
        if(salesPlans == null) return null;
        Calendar calendar = Calendar.getInstance();
        SalesPlan salesPlan;
        String brand;
        String sfx;
        int number;
        int month;
        for(int i = 0;i < salesPlans.size();i++){
            salesPlan = salesPlans.get(i);
            calendar.setTime(salesPlan.getPlanTime());
            if(calendar.get(Calendar.YEAR) != year)
                continue;
            brand = salesPlan.getBrand();
            sfx = salesPlan.getSfx();
            month = calendar.get(Calendar.MONTH);
            number = salesPlan.getNumber();
            if(!result.containsKey(brand)){
                Integer Month[] = new Integer[12];
                for(int index = 0;index < 12;index++){
                    Month[index] = 0;
                }
                Month[month] = number;
                HashMap<String ,Integer[]> sfx_month_map = new HashMap<>();
                sfx_month_map.put(sfx,Month);
                result.put(brand,sfx_month_map);
            }else{
                if(!result.get(brand).containsKey(sfx)){
                    Integer Month[] = new Integer[12];
                    for(int index = 0;index < 12;index++){
                        Month[index] = 0;
                    }
                    Month[month] = number;
                    result.get(brand).put(sfx, Month);
                }else{
                    result.get(brand).get(sfx)[month] += number;
                }
            }
        }
        return result;
    }

    /**
     * 返回某一年按map<Brand, Map<sfx, month[12]>> 存储的计划价值链的预算（必须保证plan的年月唯一）
     * @param year 某年
     * @return result
     */
    public HashMap<String,HashMap<String,ValueChain[]>> valueChainPlanByYearMonth(int year){
        HashMap<String,HashMap<String,ValueChain[]>> result = new HashMap<>();
        List<SalesPlan> salesPlans = salesPlanDAO.getAllSalesPlans();
        if(salesPlans == null) return null;
        Calendar calendar = Calendar.getInstance();
        SalesPlan salesPlan;
        String brand;
        String sfx;
        ValueChain valueChain;
        int month;
        for(int i = 0;i < salesPlans.size();i++){
            salesPlan = salesPlans.get(i);
            calendar.setTime(salesPlan.getPlanTime());
            if(calendar.get(Calendar.YEAR) != year)
                continue;
            brand = salesPlan.getBrand();
            sfx = salesPlan.getSfx();
            month = calendar.get(Calendar.MONTH);
            valueChain = new ValueChain(salesPlan);
            if(!result.containsKey(brand)){
                ValueChain Month[] = new ValueChain[12];
                for(int index = 0;index < 12;index++){
                    Month[index] = new ValueChain();
                }
                Month[month] = valueChain;
                HashMap<String ,ValueChain[]> sfx_month_map = new HashMap<>();
                sfx_month_map.put(sfx,Month);
                result.put(brand,sfx_month_map);
            }else{
                if(!result.get(brand).containsKey(sfx)){
                    ValueChain Month[] = new ValueChain[12];
                    for(int index = 0;index < 12;index++){
                        Month[index] = new ValueChain();
                    }
                    Month[month] = valueChain;
                    result.get(brand).put(sfx, Month);
                }else{
                    result.get(brand).get(sfx)[month] = valueChain;
                }
            }
        }
        return result;
    }

    /**
     * 返回某一年按map<Brand, Map<sfx, total>> 存储的计划价值链的预算（必须保证plan的年月唯一）
     * @param year 某年
     * @return result
     */
    public HashMap<String,HashMap<String,ValueChain>> valueChainPlanByYear(int year){
        HashMap<String,HashMap<String,ValueChain[]>> map = valueChainPlanByYearMonth(year);
        HashMap<String,HashMap<String,ValueChain>> result = new HashMap<>();
        String brand;
        String sfx;
        ValueChain[] valueChains;
        Iterator iterator = map.entrySet().iterator();
        HashMap<String,ValueChain[]> innerMap;
        ValueChain total;
        while (iterator.hasNext()){
            Map.Entry<String,HashMap<String,ValueChain[]>> entry = (Map.Entry)iterator.next();
            brand = entry.getKey();
            innerMap = entry.getValue();
            Iterator innerIterator = innerMap.entrySet().iterator();
            result.put(brand,new HashMap<String, ValueChain>());
            while (innerIterator.hasNext()){
                Map.Entry<String,ValueChain[]> innerEntry = (Map.Entry)innerIterator.next();
                sfx = innerEntry.getKey();
                valueChains = innerEntry.getValue();
                total = new ValueChain();
                for(int i = 0;i < 12;i++){
                    total.dataAdd(valueChains[i]);
                }
                result.get(brand).put(sfx,total);
            }
        }
        return result;
    }

    /**
     * 返回某一年按map<Brand, Map<sfx, month[12]>> 存储的计划利润预算（必须保证plan的年月唯一）
     * @param year 某年
     * @return result
     */
    public HashMap<String,HashMap<String,CarProfit[]>> carProfitPlanByYearMonth(int year){
        HashMap<String,HashMap<String,CarProfit[]>> result = new HashMap<>();
        List<SalesPlan> salesPlans = salesPlanDAO.getAllSalesPlans();
        if(salesPlans == null) return null;
        Calendar calendar = Calendar.getInstance();
        SalesPlan salesPlan;
        String brand;
        String sfx;
        CarProfit carProfit;
        int month;
        for(int i = 0;i < salesPlans.size();i++){
            salesPlan = salesPlans.get(i);
            calendar.setTime(salesPlan.getPlanTime());
            if(calendar.get(Calendar.YEAR) != year)
                continue;
            brand = salesPlan.getBrand();
            sfx = salesPlan.getSfx();
            month = calendar.get(Calendar.MONTH);
            carProfit = new CarProfit(salesPlan);
            if(!result.containsKey(brand)){
                CarProfit Month[] = new CarProfit[12];
                for(int index = 0;index < 12;index++){
                    Month[index] = new CarProfit();
                }
                Month[month] = carProfit;
                HashMap<String ,CarProfit[]> sfx_month_map = new HashMap<>();
                sfx_month_map.put(sfx,Month);
                result.put(brand,sfx_month_map);
            }else{
                if(!result.get(brand).containsKey(sfx)){
                    CarProfit Month[] = new CarProfit[12];
                    for(int index = 0;index < 12;index++){
                        Month[index] = new CarProfit();
                    }
                    Month[month] = carProfit;
                    result.get(brand).put(sfx, Month);
                }else{
                    result.get(brand).get(sfx)[month] = carProfit;
                }
            }
        }
        return result;
    }

    /**
     * 返回某一年按map<Brand, Map<sfx, total>> 存储的计划价值链的预算（必须保证plan的年月唯一）
     * 即年度利润预算的那张表
     * @param year 某年
     * @return result
     */
    public HashMap<String,HashMap<String,CarProfit>> carProfitPlanByYear(int year){
        HashMap<String,HashMap<String,CarProfit[]>> map = carProfitPlanByYearMonth(year);
        HashMap<String,HashMap<String,CarProfit>> result = new HashMap<>();
        String brand;
        String sfx;
        CarProfit[] carProfits;
        Iterator iterator = map.entrySet().iterator();
        HashMap<String,CarProfit[]> innerMap;
        CarProfit total;
        while (iterator.hasNext()){
            Map.Entry<String,HashMap<String,CarProfit[]>> entry = (Map.Entry)iterator.next();
            brand = entry.getKey();
            innerMap = entry.getValue();
            Iterator innerIterator = innerMap.entrySet().iterator();
            result.put(brand,new HashMap<String, CarProfit>());
            while (innerIterator.hasNext()){
                Map.Entry<String,CarProfit[]> innerEntry = (Map.Entry)innerIterator.next();
                sfx = innerEntry.getKey();
                carProfits = innerEntry.getValue();
                total = new CarProfit();
                for(int i = 0;i < 12;i++){
                    total.dataAdd(carProfits[i]);
                }
                result.get(brand).put(sfx,total);
            }
        }
        return result;
    }

    /**
     *
     * 返回某一月按map<Brand, Map<sfx, total>> 存储的计划价值链的预算（必须保证plan的年月唯一）
     * 即月度利润预算的那张表
     * @param year 年
     * @param month 月
     * @return result
     */
    public HashMap<String,HashMap<String,CarProfit>> carProfitPlanByMonth(int year,int month){
        HashMap<String,HashMap<String,CarProfit[]>> map = carProfitPlanByYearMonth(year);
        HashMap<String,HashMap<String,CarProfit>> result = new HashMap<>();
        String brand;
        String sfx;
        CarProfit[] carProfits;
        Iterator iterator = map.entrySet().iterator();
        HashMap<String,CarProfit[]> innerMap;
        CarProfit total;
        while (iterator.hasNext()){
            Map.Entry<String,HashMap<String,CarProfit[]>> entry = (Map.Entry)iterator.next();
            brand = entry.getKey();
            innerMap = entry.getValue();
            Iterator innerIterator = innerMap.entrySet().iterator();
            result.put(brand,new HashMap<String, CarProfit>());
            while (innerIterator.hasNext()){
                Map.Entry<String,CarProfit[]> innerEntry = (Map.Entry)innerIterator.next();
                sfx = innerEntry.getKey();
                carProfits = innerEntry.getValue();
                total = new CarProfit();

                total.dataAdd(carProfits[month]);
                result.get(brand).put(sfx,total);
            }
        }
        return result;
    }

    /**
     * 单车利润预算*/

    public HashMap<String, HashMap<String,CarProfit>> singleCarTypeProfitByMonth(int year, int month){
        try {
//            String dateLine = "-";
//            if(month < 10){
//                dateLine = "-0";
//            }
//            String date = year + dateLine + month + "-01";
            //System.out.println(date);

            Date dt = new Date(year - 1900,month,1);
           // System.out.println(date.toString());
            List<SalesPlan> planList = getSalesPlanByMonth(dt);
            if(planList == null){
                return null;
            }
            HashMap<String, HashMap<String,CarProfit>> result = new HashMap<>();
            for(int i = 0; i < planList.size(); i ++){
                if(!result.containsKey(planList.get(i).getBrand())){
                    HashMap<String, CarProfit> sfx = new HashMap<>();
                    sfx.put(planList.get(i).getSfx(), new CarProfit(planList.get(i)));
                    result.put(planList.get(i).getBrand(), sfx);
                }else{
                    result.get(planList.get(i).getBrand()).put(planList.get(i).getSfx(),new CarProfit(planList.get(i)));
                }
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}