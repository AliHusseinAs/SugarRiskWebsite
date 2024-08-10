package com.SugarRisk.website.SugarRisk.ControllerLayer;

import com.SugarRisk.website.SugarRisk.ModelLayer.UserDataModel;
import com.SugarRisk.website.SugarRisk.ServiceLayer.ServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private ServiceInt serviceInt;

    public Controller(ServiceInt serviceInt) {
        this.serviceInt = serviceInt;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/send/data")
    public ResponseEntity<String> addData(@RequestBody UserDataModel userDataModel){
        serviceInt.addData(userDataModel);
        return new ResponseEntity<>("Data Added", HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping("/delete/data/{id}")
    public ResponseEntity<String> removeData(@PathVariable Long id){
        serviceInt.removeData(id);
        return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/name/{id}")
    public ResponseEntity<String> getName(@PathVariable Long id){
        String res = serviceInt.getName(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/surname/{id}")
    public ResponseEntity<String> getSurname(@PathVariable Long id){
        String res = serviceInt.getSurname(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/age/{id}")
    public ResponseEntity<Integer> getAge(@PathVariable Long id){
        Integer res = serviceInt.getAge(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/sex/{id}")
    public ResponseEntity<String> getSex(@PathVariable Long id){
        String res = serviceInt.getSex(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/bodyMass/{id}")
    public ResponseEntity<Float> getBodyMass(@PathVariable Long id){
        Float res = serviceInt.getBodyMass(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/activity/{id}")
    public ResponseEntity<String> getActivity(@PathVariable Long id){
        String res = serviceInt.getActivity(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/waist/{id}")
    public ResponseEntity<Float> getWaist(@PathVariable Long id){
        Float res = serviceInt.getWaist(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/antiHyper/{id}")
    public ResponseEntity<String> getAntihyber(@PathVariable Long id){
        String res = serviceInt.getAntiHyperTensive(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/bloodGlucose/{id}")
    public ResponseEntity<String> getBloodGlucose(@PathVariable Long id){
        String res = serviceInt.getBloodGlucose(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/relative/{id}")
    public ResponseEntity<Integer> getRelative(@PathVariable Long id){
        Integer res = serviceInt.getRelativeDiabetes(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/eating/{id}")
    public ResponseEntity<Integer> getEating(@PathVariable Long id){
        Integer res = serviceInt.getEating(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/get/score/{id}")
    public ResponseEntity<Float> getScore(@PathVariable Long id){
        Float res = serviceInt.getScore(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
