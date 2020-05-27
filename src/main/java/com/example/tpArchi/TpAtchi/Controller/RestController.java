package com.example.tpArchi.TpAtchi.Controller;


import com.example.tpArchi.TpAtchi.Model.Garantie;
import com.example.tpArchi.TpAtchi.accessingdatamysql.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path="/api")
public class RestController {
    @Autowired
    private DataRepository dataRepository;

    @GetMapping(path = "/garanties")
    public @ResponseBody Iterable<Garantie> getAllGaranties(){
        return dataRepository.findAll();
    }

    @GetMapping(path = "/garantie/{id}")
    public @ResponseBody
    Optional<Garantie> getGarantie(@PathVariable Integer id){
        return dataRepository.findById(id);
    }

    @PostMapping(path = "/garantie")
    public @ResponseBody Garantie addNewGarantie(@RequestParam String Nom,@RequestParam Integer prix, @RequestParam String Description){
        Garantie g = new Garantie();
        g.setNom(Nom);
        g.setMontant(prix);
        g.setDescription(Description);
        dataRepository.save(g);
        return g;
    }
    @DeleteMapping(path = "/garantie/{id}")
    public @ResponseBody String deleteGarantie(@PathVariable Integer id){
        dataRepository.deleteById(id);
        return "deleted";
    }
    @PutMapping(path = "garantie/{id}")
    public @ResponseBody Garantie editGarantie(@PathVariable Integer id,@RequestParam(required = false, defaultValue = "") String Nom,@RequestParam(required = false,defaultValue = "-1") Integer Prix,@RequestParam(required = false,defaultValue = "") String Description){
        Optional<Garantie> t = dataRepository.findById(id);
        Garantie tmp = t.get();
        if(!Nom.equals("")){
            tmp.setNom(Nom);
        }
        if(!Description.equals("")){
            tmp.setDescription(Description);
        }
        if(!Prix.equals(-1) && Prix >= 0){
            tmp.setMontant(Prix);
        }
        dataRepository.save(tmp);
        return tmp;
    }
}
