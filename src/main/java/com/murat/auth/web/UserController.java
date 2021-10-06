package com.murat.auth.web;


import com.murat.auth.model.Car;
import com.murat.auth.model.SalesRep;
import com.murat.auth.model.User;
import com.murat.auth.service.CarService;
import com.murat.auth.service.SalesRepService;
import com.murat.auth.service.SecurityService;
import com.murat.auth.service.UserService;
import com.murat.auth.validator.UserValidator;

import utility.CarErrorResponse;
import utility.CarNotFoundException;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
        	
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/index")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        	
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "index";
    }


    
    @Autowired
    private CarService carService;
    
    @Autowired
    private SalesRepService salesRepService;
 
    // handler methods will go here...
    @GetMapping({"/", "/welcome"})
    public ModelAndView home() {
        List<Car> listCar = carService.listAll();
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("listCar", listCar);
        System.out.println(listCar);
        return mav;
        
    }
    
    @RequestMapping({"/", "/salesRep"})
    public ModelAndView homeSal() {
        List<SalesRep> listSalesRep = salesRepService.listAll();
        ModelAndView mav = new ModelAndView("salesRep");
        mav.addObject("listSalesRep", listSalesRep);
        return mav;
    }
    
    @RequestMapping("/new")
    public String newCarForm(Map<String, Object> model) {
        Car car = new Car();
        model.put("car", car);
        return "new_car";
    }
    
    @RequestMapping("/newSal")
    public String newSalesRepForm(Map<String, Object> model) {
    	SalesRep salesRep = new SalesRep();
        model.put("salesRep", salesRep);
        return "new_salesRep";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car") Car car) {
        carService.save(car);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveSalesRep(@ModelAttribute("salesRep") SalesRep salesRep) {
    	salesRepService.add(salesRep);
        return "redirect:/";
    }
    
    @RequestMapping("/edit")
    public ModelAndView editCarForm(@RequestParam String vin) {
        ModelAndView mav = new ModelAndView("edit_car");
        Car car = carService.get(vin);
        mav.addObject("car", car);
     
        return mav;
    }
    
    @RequestMapping("/sedit")
    public ModelAndView editSalesRepForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_salesRep");
        SalesRep salesRep = salesRepService.get(id);
        mav.addObject("salesRep", salesRep);
     
        return mav;
    }
    
    @RequestMapping("/delete")
    public String deleteCarForm(@RequestParam String vin) {
        carService.delete(vin);
        return "redirect:/";       
    }
    
    @RequestMapping("/remove")
    public String deleteSalesRepForm(@RequestParam long id) {
    	salesRepService.remove(id);
        return "redirect:/";       
    }
    
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword ,Long salesId) {
        List<Car> result = carService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        
        for(Car car : result) {
        	if ( car.getMake().equals(keyword) || car.getModel().equals(keyword) || car.getColor().equals(keyword) || car.getYear().equals(keyword) ) {			
    			return mav;
    		}
        	
        	
        }
        
     
        throw new CarNotFoundException("Car not found - " + keyword);   
    }
    
    @ExceptionHandler
	public ResponseEntity<CarErrorResponse> handleException(CarNotFoundException exc) {
		
    	CarErrorResponse error = new CarErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }

	@ExceptionHandler
	public ResponseEntity<CarErrorResponse> handleException(Exception exc) {
		
		CarErrorResponse error = new CarErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}	
    
    
    @RequestMapping("/lookUp")
    public ModelAndView lookUp(@RequestParam String keyword) {
        List<SalesRep> result = salesRepService.lookUp(keyword);
        ModelAndView mav = new ModelAndView("lookUp");
        mav.addObject("result", result);
     
        return mav;    
    }
    
    @RequestMapping("/assign")
    public String assignCarForm(@RequestParam String vin, Model model) {
        model.addAttribute("car", carService.get(vin));
        List<SalesRep> listSalesRep = salesRepService.listAll();
        model.addAttribute("listSalesRep", listSalesRep);
        return "sales_reps_to_assign";       
    }
    
    @RequestMapping("/assign_rep_to_car")
    public String assignRepToCar(@RequestParam String carVin, @RequestParam long repId) {
        carService.assignSalesRep(carVin, repId);
        return "redirect:/";       
    }
    
   
}
