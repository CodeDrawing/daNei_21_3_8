package top.zwzx.supermarket_001.controller;

import top.zwzx.supermarket_001.pojo.Provider;
import top.zwzx.supermarket_001.service.ProviderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/pro")
public class ProviderController {
    @Autowired
    ProviderServices providerServices;

//    @RequestMapping("/getprovider")
//    public ModelAndView getAllProvider(@RequestParam(name="currentPageNo",defaultValue = "1") int currentPageNo,
//                                 @RequestParam(name="size",defaultValue = "5") int size ){
//        ArrayList<Provider> providers= providerServices.getProviderByNo(currentPageNo,size);
//        PageUtill pageUtill=new PageUtill();
//        pageUtill.setCode("200");
//        pageUtill.setId(201);
//        pageUtill.setMsg("恭喜你发送成功");
//        pageUtill.setData(providers);
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("provider");
//        modelAndView.addObject("providerList",pageUtill);
//
////        model.addAttribute("providerList",providers);
//        return modelAndView;
//    }
    @RequestMapping("/getprovider")
    public String  getAllProvider(Model model,@RequestParam(name="currentPageNo",defaultValue = "1") int currentPageNo,
                                 @RequestParam(name="size",defaultValue = "5") int size ){
        ArrayList<Provider> providers= providerServices.getProviderByNo(currentPageNo,size);
        model.addAttribute("providerList",providers);
        return "pro/provider";
    }

    @RequestMapping("/selectProvider")
    public String selectProvider(Model model, HttpServletRequest request,@RequestParam(name="currentPageNo",defaultValue = "1") int currentPageNo,
                                 @RequestParam(name="size",defaultValue = "5") int size ){
        String name=request.getParameter("queryname");
        System.out.println(name);
        System.out.println(name.equals(""));
//        if(name.equals("")){
//            ArrayList<Provider> providers=providerServices.getProviderByNo(currentPageNo,size);
//            model.addAttribute("providerList",providers);
//        }else{
        ArrayList<Provider> providers=providerServices.getProviderByName(name);
        System.out.println(providers);
        model.addAttribute("providerList",providers);
//        }
        return "pro/provider";
    }
    @RequestMapping("/addProviderpage")
    public String AddProviderPage(){
        return "pro/addProviderPage";
    }

    @RequestMapping("/AddProvider")
    public String addProvider(Provider provider){
        Date date=new Date();
        String nowdate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//获取时间
        provider.setCreatedBy(1);
        provider.setCreationDate(nowdate);

        System.out.println(provider);
        providerServices.AddProvider(provider);
        return "redirect:/pro/getprovider";
    }
    @RequestMapping("/deleteProvider")
    public String deleteProvider(HttpServletRequest request){
        int id=Integer.valueOf(request.getParameter("providerid"));
        providerServices.deleteProvider(id);
        return "redirect:/pro/getprovider";
    }
    @RequestMapping("/updateProviderPage")
    public String updateProviderPage(HttpServletRequest request,Model model){
        int id=Integer.valueOf(request.getParameter("providerid"));
        ArrayList<Provider> providers= providerServices.getProviderById(id);
        model.addAttribute("providerlist",providers);
        return "pro/updateProviderpage";
    }
    @RequestMapping("/updateProvider")
    public String updateProvider(Provider provider,Model model){
        Date date=new Date();
        String nowdate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        provider.setModifyBy(1);
        provider.setModifyDate(nowdate);
        providerServices.updateProvider(provider);
        return "redirect:/pro/getprovider";
    }
    @RequestMapping("/checkProvider")
    public String checkProvider(HttpServletRequest request,Model model){
        int id=Integer.parseInt(request.getParameter("providerid"));
        ArrayList<Provider> providers= providerServices.getProviderById(id);
        model.addAttribute("providerlist",providers);
        return "pro/checkprovider";
    }
}
