package cz.czechitas.java2webapps.ukol6.controller;
import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.Optional;

@Controller
// Controller pro zobrazovani seznamu vizitek
public class VizitkaController {
    private VizitkaRepository vizitkaRepository;

@Autowired
    public VizitkaController(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository = vizitkaRepository;
    }

@InitBinder
// Prázdné textové řetězce nahradit null hodnotou
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

@GetMapping("/")
    public Object seznam() {
        //TODO načíst seznam osob
        return new ModelAndView("seznam")
        .addObject("vizitky", vizitkaRepository.findAll());
    }

@GetMapping("/nova")
    public Object nova() {
        return new ModelAndView("formular")
        .addObject("vizitka", new Vizitka());
    }

@PostMapping("/nova")
    public Object pridat(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "detail";
        }
        vizitkaRepository.save(vizitka);
        return "redirect:/";
    }

@PostMapping("/smazat")
    public String smazat(@RequestParam(value = "id") Integer id) {
        vizitkaRepository.deleteById(id);
        return "redirect:/";
    }

@GetMapping("detail/{id}")
    public Object detail(@PathVariable Integer id) {
        ModelAndView detail = new ModelAndView("vizitka");
        Optional<Vizitka> vizitkaOptional = vizitkaRepository.findById(id);
        if (vizitkaOptional.isPresent()) {
            detail.addObject("vizitka", vizitkaOptional.get());
            return detail;
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}