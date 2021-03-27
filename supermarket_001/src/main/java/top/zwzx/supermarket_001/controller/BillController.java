package top.zwzx.supermarket_001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zwzx.supermarket_001.pojo.Bill;
import top.zwzx.supermarket_001.service.IBillService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: CodeDrawing
 * @Date: 2021/3/27 8:25
 * @Package: top.zwzx.supermarket_001.controller
 * 功能：
 * 细节：
 * 注意：
 */
@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    public IBillService iBillService;
    @RequestMapping("/getAllBill")
    @CrossOrigin
    @ResponseBody
    public Map getAllBill(){
        HashMap<String, Object> map = new HashMap<>();
        List<Bill> allBill = iBillService.getAllBill();
        map.put("code",0) ;
        map.put("msg","");
    map.put("data",allBill);

        return map;
    }
    @RequestMapping("/showBill")
    public String showBill(){
        return "showBill";
    }
}
