package top.zwzx.supermarket_001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.zwzx.supermarket_001.pojo.Bill;
import top.zwzx.supermarket_001.service.IBillService;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
    public Map getAllBill(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit")Integer limit){
        HashMap<String, Object> map = new HashMap<>();
        List<Bill> allBill = iBillService.getAllBill(page,limit);
        Integer countForBill = iBillService.getCountForBill();
        map.put("count",countForBill);
        map.put("code",0) ;
        map.put("msg","");
    map.put("data",allBill);

        return map;
    }

    @RequestMapping("/showBill")
    public String showBill(){
        return "showBill";
    }

    @RequestMapping("/toAddBill")
    public String toAddBill(){
        return "addBill";
    }
    @RequestMapping("/addBill")
    public String addBill(Bill bill, Model model, HttpSession httpSession){
        List<Bill> billByBillCode = iBillService.getBillByBillCode(bill.getBillCode());
        if(billByBillCode.size()!=0){
            model.addAttribute("msg","订单号重复");
            return "addBill";
        }
        bill.setCreatedBy((Integer) httpSession.getAttribute("id"));
        bill.setCreationDate(new Date());
        iBillService.addBill(bill);
        return "redirect:/bill/showBill";
    }
    @RequestMapping("/deleteBillById/{id}")
    @ResponseBody
    @CrossOrigin
    public void deleteBillById(@PathVariable("id")Integer id){
        iBillService.deleteBillById(id);
    }



    @RequestMapping("/toUpdateBill/{id}")
    public String updateBill(@PathVariable("id") Integer id,Model model){
        Bill bill = iBillService.getBillById(id);
        model.addAttribute("bill",bill);
        return "/updateBill";
    }
    @RequestMapping("/updateBill")
    public String updateBill(Bill bill){
        iBillService.updateBill(bill);
        return "redirect:/bill/showBill";
    }
}
