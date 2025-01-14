package com.example.task12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Application {

//    @Value("${from}")
    String fromName = "from.txt";

//    @Value("${to}")
    String toName = "to.txt";

    public String getPath(String fileName) {
        return "src/main/java/com/example/task12/" + fileName;
    }

    @PostConstruct
    public void init() throws IOException, NoSuchAlgorithmException {
        String filename = getPath(fromName);
        File f = new File(filename);
        String hash = "";
        if(f.exists() && !f.isDirectory()) {
            String content = new String(Files.readAllBytes(Paths.get(filename)));
            System.out.println(content);
            byte[] bytesOfMessage = content.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theMD5digest = md.digest(bytesOfMessage);
            StringBuffer sb = new StringBuffer();
            for (byte b : theMD5digest) {
                sb.append(Integer.toHexString((int) (b & 0xff)));
            }
            hash = sb.toString();
        } else {
            hash = "null";
        }
        System.out.println("write " + hash);
        FileWriter writer = new FileWriter(getPath(toName));
        writer.write(hash);
        writer.close();
    }

    @PreDestroy
    public void stop() {
        File file = new File(getPath(fromName));
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }
}
