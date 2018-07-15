package com.example.demo.controllers;

import com.example.demo.entities.Flight;
import com.example.demo.entities.User;
import com.example.demo.repos.FlightRepository;
import com.example.demo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping("/showReg")
    public ModelAndView chatWindow(){
        return new ModelAndView("registerUser");
    }


    // Take User instance as input parameter
    // save it
    // return another page
    // Once the form in registerUser is submitted
    // it calls this function since we map it here(<form action = "registerUser">)
    @RequestMapping(value = "loginForm", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user")User user, @RequestParam String confirmPassword, ModelMap modelMap) {
        if (user.getPassword().equals(confirmPassword)){
            try {
                userRepository.save(user);
            } catch (Exception e) {
                modelMap.addAttribute("msg","something went wrong!");
                return new ModelAndView("registerUser");
            }
            return new ModelAndView("login/login");
        } else {
            modelMap.addAttribute("msg","Passwords dont match!");
            return new ModelAndView("registerUser");
        }

    }


    // Find by email, compare
    // (<form action = "login">)
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
        try {
            User user = userRepository.findByEmail(email);
            if (password.equals(user.getPassword())) {
                // Everything is fine
                return new ModelAndView("findFlights");
            } else {
                // Wrong password
                modelMap.addAttribute("msg","Wrong password");
                return new ModelAndView("login/login");
            }
        } catch (Exception e) {
            // Invalid email
            modelMap.addAttribute("msg","Invalid email");
            return new ModelAndView("login/login");
        }
    }

    // Value == Function
    // viewName == Page
    @RequestMapping(value = "findFlights", method = RequestMethod.POST)
    public ModelAndView findFlights(@RequestParam String from,
                                    @RequestParam String to,
                                    @RequestParam String date,
                                    ModelMap modelMap) throws ParseException {
        System.out.println("abcde");

        Date departDate = new SimpleDateFormat("MM-dd-yyyy").parse(date);
        List<Flight> flights = flightRepository.findFlights(from, to, departDate);
        modelMap.addAttribute("flights", flights);
        return new ModelAndView("showFlights");
    }



}
