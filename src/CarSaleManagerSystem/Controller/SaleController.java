package CarSaleManagerSystem.Controller;

import CarSaleManagerSystem.Bean.*;
import CarSaleManagerSystem.Service.AdditionalProductService;
import CarSaleManagerSystem.Service.CarService;
import CarSaleManagerSystem.Service.GiftService;
import CarSaleManagerSystem.Service.InsuranceService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HFQ on 2016/8/9.
 */
@Controller
@RequestMapping(value = "/Sale")
public class SaleController {
    @Autowired
    private GiftService giftService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AdditionalProductService additionalProductService;

    /*
    * Gift controller
    * */
    @RequestMapping(value = "/createGift", method = RequestMethod.GET)
    public ModelAndView createGiftPage(){
        ModelAndView modelAndView = new ModelAndView("Sale/giftCreate");
        List<GiftType> giftTypeList = giftService.getAllGiftTypes();
        List<GiftBrand> giftBrandList = giftService.getAllGiftBrands();
        modelAndView.addObject("gift", new Gift());
        modelAndView.addObject("giftBrands",giftBrandList);
        modelAndView.addObject("types",giftTypeList);
        return modelAndView;
    }

    @RequestMapping(value = "/createGift", method = RequestMethod.POST)
    public ModelAndView createGift(@ModelAttribute Gift gift){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/listGift");
        giftService.createGift(gift);
        return modelAndView;
    }

    @RequestMapping(value = "/listGift", method = RequestMethod.GET)
    public ModelAndView listGift(){
        ModelAndView modelAndView = new ModelAndView("Sale/giftList");
        List<?> giftList = giftService.getAllGifts();
        modelAndView.addObject("gifts", giftList);
        return modelAndView;
    }

    @RequestMapping(value = "/editGift",method = RequestMethod.GET)
    public ModelAndView editGiftPage(){

        // TODO: 16/8/9
        ModelAndView modelAndView = null;
        return modelAndView;
    }

    @RequestMapping(value = "/editGift/{giftID}", method = RequestMethod.POST)
    public ModelAndView editGift(@ModelAttribute Gift gift){

        //// TODO: 16/8/9
        ModelAndView modelAndView = null;
        return modelAndView;
    }

    @RequestMapping(value = "/deleteGift/{giftID}", method = RequestMethod.GET)
    public ModelAndView removeGift(@PathVariable int giftID){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/listGift");
        Gift gift = giftService.findGiftById(giftID);
        giftService.removeGift(gift);
        return modelAndView;
    }


    @RequestMapping(value = "/createGiftType",method = RequestMethod.GET)
    public ModelAndView createGiftTypePage(){
        ModelAndView modelAndView = new ModelAndView("Sale/createGiftType");
        modelAndView.addObject("giftType",new GiftType());
        return modelAndView;
    }

    @RequestMapping(value = "/createGiftType",method = RequestMethod.POST)
    public ModelAndView createGiftType(@ModelAttribute GiftType giftType){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/createGift");
        giftService.createGiftType(giftType);
        return modelAndView;
    }

    @RequestMapping(value = "/listGiftType", method = RequestMethod.GET)
    public ModelAndView listGiftType(){
        ModelAndView modelAndView = new ModelAndView("Sale/giftTypeList");
        List<?> giftTypeList = giftService.getAllGiftTypes();
        modelAndView.addObject("giftTypes", giftTypeList);
        return modelAndView;
    }

    @RequestMapping(value = "/createGiftBrand",method = RequestMethod.GET)
    public ModelAndView createGiftBrandPage(){
        ModelAndView modelAndView = new ModelAndView("Sale/createGiftBrand");
        List<?> giftTypeList = giftService.getAllGiftTypes();
        modelAndView.addObject("giftTypes", giftTypeList);
        modelAndView.addObject("giftBrand",new GiftBrand());
        return modelAndView;
    }

    @RequestMapping(value = "/createGiftBrand",method = RequestMethod.POST)
    public ModelAndView createGiftBrand(@ModelAttribute GiftBrand giftBrand){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/createGift");
        giftService.createGiftBrand(giftBrand);
        return modelAndView;
    }

    @RequestMapping(value = "/listGiftBrand", method = RequestMethod.GET)
    public ModelAndView listGiftBrand(){
        ModelAndView modelAndView = new ModelAndView("Sale/giftBrandList");
        List<?> giftBrandList = giftService.getAllGiftBrands();
        modelAndView.addObject("giftBrands", giftBrandList);
        return modelAndView;
    }


    @RequestMapping(value = "/getGiftType")
    public @ResponseBody
    Map<String,Object> getGiftType(HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        List<GiftType> giftTypes = giftService.getAllGiftTypes();

        for(int j = 0; j < giftTypes.size(); j ++){
           map.put(String.valueOf(j), giftTypes.get(j).getType());
        }
       return map;
    }


//    @RequestMapping(value = "/selectGiftName")
//    public @ResponseBody
//    Map<String,Object> getGiftName(HttpServletRequest request) throws IOException {
//        Map<String,Object> map = new HashMap<String,Object>();
//
//        String type = request.getParameter("type");
//        List<Gift> giftList = giftService.findGiftByType(type);
//        //System.out.println(type);
//        for(int j = 0; j < giftList.size(); j ++){
//            if(giftList.get(j).getValid().equals("Y")) {
//                if(giftList.get(j).getOrderID() == null) {
//                    map.put(String.valueOf(j), giftList.get(j).getName());
//                }
//            }
//        }
//        return map;
//    }
    @RequestMapping(value = "/selectGiftBrand")
    public @ResponseBody
    Map<String,Object> getGiftBrand(HttpServletRequest request) throws IOException{
        Map<String, Object> map = new HashMap<>();

        String type = request.getParameter("type");
        List<GiftBrand> giftBrands = giftService.getAllGiftBrands();

        for(int j = 0; j < giftBrands.size(); j++){
            if(giftBrands.get(j).getValid().equals("Y")){
                if(giftBrands.get(j).getType().equals(type)){
                    map.put(String.valueOf(j), giftBrands.get(j).getGiftBrand());
                }
            }
        }

        return map;
    }

    /*
    * insurance controller
    *
    */
    @RequestMapping(value = "/createInsurance", method = RequestMethod.GET)
    public ModelAndView createInsurancePage(){
        ModelAndView modelAndView = new ModelAndView("Sale/insuranceCreate");
        List<InsuranceType> insuranceTypeList = insuranceService.getAllInsuranceType();
        modelAndView.addObject("insurance", new Insurance());
        modelAndView.addObject("types",insuranceTypeList);
        return modelAndView;
    }

    @RequestMapping(value = "/createInsurance", method = RequestMethod.POST)
    public ModelAndView createInsurance(@ModelAttribute Insurance insurance){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/listInsurance");
        insuranceService.createInsurance(insurance);
        return modelAndView;
    }

    @RequestMapping(value = "/listInsurance", method = RequestMethod.GET)
    public ModelAndView listInsurance(){
        ModelAndView modelAndView = new ModelAndView("Sale/insuranceList");
        List<?> insuranceList = insuranceService.getAllInsurance();
        modelAndView.addObject("insurances", insuranceList);
        return modelAndView;
    }

    @RequestMapping(value = "/editInsurance",method = RequestMethod.GET)
    public ModelAndView editInsurancePage(){

        // TODO: 16/8/9
        ModelAndView modelAndView = null;
        return modelAndView;
    }

    @RequestMapping(value = "/editInsurance/{insuranceID}", method = RequestMethod.POST)
    public ModelAndView editInsurance(@ModelAttribute Insurance insurance){

        //// TODO: 16/8/9
        ModelAndView modelAndView = null;
        return modelAndView;
    }

    @RequestMapping(value = "/deleteInsurance/{insuranceID}", method = RequestMethod.GET)
    public ModelAndView removeInsurance(@PathVariable int insuranceID){
        ModelAndView modelAndView = new ModelAndView("redirect: /Sale/insuranceList");
        Insurance insurance = insuranceService.findInsuranceById(insuranceID);
        insuranceService.removeInsurance(insurance);
        return modelAndView;
    }


    @RequestMapping(value = "/createInsuranceType",method = RequestMethod.GET)
    public ModelAndView createInsuranceTypePage(){
        ModelAndView modelAndView = new ModelAndView("Sale/createInsuranceType");
        modelAndView.addObject("insuranceType",new InsuranceType());
        return modelAndView;
    }

    @RequestMapping(value = "/createInsuranceType",method = RequestMethod.POST)
    public ModelAndView createInsuranceType(@ModelAttribute InsuranceType insuranceType){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/createInsurance");
        insuranceService.createInsuranceType(insuranceType);
        return modelAndView;
    }

    @RequestMapping(value = "/listInsuranceType", method = RequestMethod.GET)
    public ModelAndView listInsuranceType(){
        ModelAndView modelAndView = new ModelAndView("Sale/insuranceTypeList");
        List<?> insuranceTypes = insuranceService.getAllInsuranceType();
        modelAndView.addObject("insuranceTypes",insuranceTypes);
        return modelAndView;
    }

    @RequestMapping(value = "/getInsuranceType")
    public @ResponseBody
    Map<String,Object> getInsuranceType(HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        List<InsuranceType> insuranceTypes = insuranceService.getAllInsuranceType();


        for(int j = 0; j < insuranceTypes.size(); j ++){
            map.put(String.valueOf(j), insuranceTypes.get(j).getType());
        }
        return map;
    }


    @RequestMapping(value = "/selectInsuranceName")
    public @ResponseBody
    Map<String,Object> getInsuranceName(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        String type = request.getParameter("type");
        List<Insurance> insuranceList = insuranceService.findInsuranceByType(type);
        //System.out.println(type);
        for(int j = 0; j < insuranceList.size(); j ++){
            if(insuranceList.get(j).getValid().equals("Y")) {
                if(insuranceList.get(j).getOrderID() == null) {
                    map.put(String.valueOf(j), insuranceList.get(j).getName());
                }
            }
        }
        return map;
    }


    /*
    *AdditionalProduct
     */

    @RequestMapping(value = "/createAdditionalProduct", method = RequestMethod.GET)
    public ModelAndView createAdditionalProductPage(){
        ModelAndView modelAndView = new ModelAndView("Sale/additionalProductCreate");
        List<AdditionalProductType> additionalProductTypes = additionalProductService.getAllAdditionalProductType();
        modelAndView.addObject("additionalProduct", new AdditionalProduct());
        modelAndView.addObject("types",additionalProductTypes);
        return modelAndView;
    }

    @RequestMapping(value = "/createAdditionalProduct", method = RequestMethod.POST)
    public ModelAndView createAdditionalProduct(@ModelAttribute AdditionalProduct additionalProduct){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/listAdditionalProduct");
        System.out.println(additionalProduct.getName() + "name");
        additionalProductService.createAdditionalProduct(additionalProduct);
        return modelAndView;
    }

    @RequestMapping(value = "/listAdditionalProduct", method = RequestMethod.GET)
    public ModelAndView listAdditionalProduct(){
        ModelAndView modelAndView = new ModelAndView("Sale/additionalProductList");
        List<?> additionalProductList = additionalProductService.getAllAdditionalProducts();
        modelAndView.addObject("AdditionalProducts", additionalProductList);
        return modelAndView;
    }


    @RequestMapping(value = "/editAdditionalProduct",method = RequestMethod.GET)
    public ModelAndView editAdditionalProductPage(){

        // TODO: 16/8/14
        ModelAndView modelAndView = null;
        return modelAndView;
    }

    @RequestMapping(value = "/editAdditionalProduct/{additionalProductID}", method = RequestMethod.POST)
    public ModelAndView editGift(@ModelAttribute AdditionalProduct additionalProduct){

        //// TODO: 16/8/14
        ModelAndView modelAndView = null;
        return modelAndView;
    }

    @RequestMapping(value = "/deleteAdditionalProduct/{additionalProductID}", method = RequestMethod.GET)
    public ModelAndView removeAdditionalProduct(@PathVariable int additionalProductID){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/listAdditionalProduct");
        AdditionalProduct additionalProduct = additionalProductService.findAdditionalProductById(additionalProductID);
        additionalProductService.removeAdditionalProduct(additionalProduct);
        return modelAndView;
    }


    @RequestMapping(value = "/createAdditionalProductType",method = RequestMethod.GET)
    public ModelAndView createAdditionalProductTypePage(){
        ModelAndView modelAndView = new ModelAndView("Sale/createAdditionalProductType");
        modelAndView.addObject("AdditionalProductType",new AdditionalProductType());
        return modelAndView;
    }

    @RequestMapping(value = "/createAdditionalProductType",method = RequestMethod.POST)
    public ModelAndView createAdditionalProductType(@ModelAttribute AdditionalProductType additionalProductType){
        ModelAndView modelAndView = new ModelAndView("redirect:/Sale/createAdditionalProduct");
        //System.out.println(additionalProductType.getType() + "type");
        additionalProductService.createAdditionalProductType(additionalProductType);
        return modelAndView;
    }

    @RequestMapping(value = "/listAdditionalProductType", method = RequestMethod.GET)
    public ModelAndView listAdditionalProductType(){
        ModelAndView modelAndView = new ModelAndView("Sale/additionalProductTypeList");
        List<?> additionalProductTypeList = additionalProductService.getAllAdditionalProductType();
        modelAndView.addObject("additionalProductTypes", additionalProductTypeList);
        return modelAndView;
    }



    @RequestMapping(value = "giftTypeExists")
    public @ResponseBody
    Map<String, Object> giftTypeExists(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        String type = request.getParameter("type");

        if(!giftService.giftTypeExist(type)){
            map.put("message","false");
        }else {
            map.put("message","true");
        }
        return map;
    }


    @RequestMapping(value = "giftBrandExists")
    public @ResponseBody
    Map<String, Object> giftBrandExists(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        String brand = request.getParameter("giftBrand");
        String type = request.getParameter("giftType");
        if(!giftService.giftBrandExist(type,brand)){
            map.put("message","false");
        }else {
            map.put("message","true");
        }
        return map;
    }

    public SaleController() {
    }

    @RequestMapping(value = "/insuranceExists")
    public @ResponseBody
    Map<String, Object> insuranceExists(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        String type = request.getParameter("type");
        if(!insuranceService.insuranceTypeExist(type)){
            map.put("message","false");
        }else {
            map.put("message","true");
        }
        return map;
    }


    @RequestMapping(value = "/additionalProductTypeExists")
    public @ResponseBody
    Map<String, Object> additionalProductExists(HttpServletRequest request) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        String type = request.getParameter("type");

        System.out.println(type);
        if(!additionalProductService.additionalProductTypeExist(type)){
//            System.out.println("hahaha");
            map.put("message","false");
        }else {
//            System.out.println("yaoyaoqiekenao");
            map.put("message","true");
        }
        return map;
    }
}
