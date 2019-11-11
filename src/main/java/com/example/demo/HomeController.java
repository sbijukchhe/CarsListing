package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    CarRepository carRepository;

   /* @Autowired
    CloudinaryConfig cloudc;*/

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("categories", categoriesRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());
        return "index";
    }

    @GetMapping("/addcategories")
    public String categoriesForm(Model model){
        model.addAttribute("categories", new Categories());
        return "categoriesform";
    }

    @PostMapping("/process_categories")
    public String processCategoriesForm(@Valid Categories categories, BindingResult result){
        if (result.hasErrors()){
            return "categoriesform";
        }
        categoriesRepository.save(categories);

        return "redirect:/categorieslist";
    }

    @RequestMapping("/categorieslist")
    public String categoriesList(Model model){
        model.addAttribute("categories", categoriesRepository.findAll());
        return "categorieslist";
    }

    @GetMapping("/addcar")
    public String carForm(Model model){
        model.addAttribute("categories", categoriesRepository.findAll());
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/process_car")
    public String processCarForm(@Valid Car car, BindingResult result){
        if (result.hasErrors()){
            return "carform";
        }
        carRepository.save(car);

        return "redirect:/carlist";
    }

    @RequestMapping("/carlist")
    public String carList(Model model){
        model.addAttribute("cars", carRepository.findAll());
        return "carlist";
    }

    @RequestMapping("/detail/{id}")
    public String showCategories(@PathVariable("id") long id, Model model){
        model.addAttribute("categories", categoriesRepository.findById(id).get());
        return "showcategories";
    }

    @RequestMapping("/update/{id}")
    public String updateCategories(@PathVariable("id") long id, Model model){
        model.addAttribute("categories", categoriesRepository.findById(id).get());
        return "categoriesform";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCategories(@PathVariable("id") long id){
        categoriesRepository.deleteById(id);
//        return "index";
        return "redirect:/";
    }

    @RequestMapping("/detail_car/{id}")
    public String showCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "showcar";
    }

    @RequestMapping("/update_car/{id}")
    public String updateCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        model.addAttribute("categories",categoriesRepository.findAll());
        return "carform";
    }

    @RequestMapping("/delete_car/{id}")
    public String deleteCar(@PathVariable("id") long id){
        carRepository.deleteById(id);
//        return "index";
        return "redirect:/";
    }


   /* @PostMapping("/addcar")
    public String processCar(@ModelAttribute Car car, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "redirect:/addcar";
        }
        try {
            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            car.setHeadshot(uploadResult.get("url").toString());
            carRepository.save(car);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/addcar";
        }
        return "carlist";
    }*/
}
