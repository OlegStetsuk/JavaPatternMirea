package com.example.task15.services;

import com.example.task15.entities.Dog;
import com.example.task15.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    final static String PATH = "src/task22Data";

    @Autowired
    private DogServiceImpl dogService;

    @Autowired
    private PatientServiceImpl patientService;

    @Scheduled(cron = "0 0,30 * * * *")
    public void doScheduledTask() throws IOException {
        File dir = new File(PATH);
        if(dir.exists()) {
            deleteDir(dir);
        }

        if(!dir.exists()) {
            dir.mkdirs();
        }

        new File(dir.getAbsolutePath() + "/dog.txt").createNewFile();
        new File(dir.getAbsolutePath() + "/patient.txt").createNewFile();
        FileWriter dogWriter = new FileWriter(dir.getAbsolutePath() + "/dog.txt");
        FileWriter userWriter = new FileWriter(dir.getAbsolutePath() + "/patient.txt");
        String dogData = "";
        String userData = "";
        try {
            List<Dog> dogs = dogService.getFilteredDogs("breed").get();
            dogData = dogs.stream().map(i -> "dog( " + i.getName() + ", " + i.getBreed() + " );").collect(Collectors.joining("\n"));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        try {
            List<Patient> users = patientService.getPatients().get();;
            userData = users.stream().map(i -> "patient( " + i.getFirstName() + ", " + i.getLastName() + " );").collect(Collectors.joining("\n"));

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        dogWriter.write(dogData);
        userWriter.write(userData);
        dogWriter.close();
        userWriter.close();
    }

    private static void deleteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                if (!Files.isSymbolicLink(f.toPath())) {
                    deleteDir(f);
                }
            }
        }
        file.delete();
    }
}
