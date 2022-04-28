package com.example.task14;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class RESTController {
    ArrayList<Patient> patientArrayList = new ArrayList<>();
    ArrayList<Doctor> doctorArrayList = new ArrayList<>();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ResponseEntity sendHTML() {
        return ResponseEntity.ok("<html><h1>Header</h1></html>");
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public ResponseEntity getPatient() {
        return ResponseEntity.ok(this.patientArrayList);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public ResponseEntity postPatient(@Valid @RequestBody Patient patient) {
        System.out.println(patient);
        this.patientArrayList.add(patient);
        return ResponseEntity.ok("Patient successfully added, current length: " + this.patientArrayList.size());
    }

    @RequestMapping(value = "/patient", method = RequestMethod.DELETE)
    public ResponseEntity deletePatient(@RequestBody String name) {
        for (Patient item : this.patientArrayList) {
            if (item.getFirstName().equals(name)) {
                this.patientArrayList.remove(item);
                return ResponseEntity.ok("Item with name " + name + " was deleted");
            }
        }
        return ResponseEntity.ok("This name does not exist");
    }

    @RequestMapping(value = "/doctor", method = RequestMethod.GET)
    public ResponseEntity getDoctor() {
        return ResponseEntity.ok(this.doctorArrayList);
    }

    @RequestMapping(value = "/doctor", method = RequestMethod.POST)
    public ResponseEntity postDoctor(@Valid @RequestBody Doctor doctor) {
        System.out.println(doctor);
        this.doctorArrayList.add(doctor);
        return ResponseEntity.ok("Patient successfully added, current length: " + this.doctorArrayList.size());
    }

    @RequestMapping(value = "/doctor", method = RequestMethod.DELETE)
    public ResponseEntity deleteDoctor(@RequestBody String name) {
        for (Doctor item : this.doctorArrayList) {
            if (item.getFirstName().equals(name)) {
                this.doctorArrayList.remove(item);
                return ResponseEntity.ok("Item with name " + name + " was deleted");
            }
        }
        return ResponseEntity.ok("This name does not exist");
    }
}
