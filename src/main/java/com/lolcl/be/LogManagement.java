package com.lolcl.be;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LogManagement {
    public static void read(String[] args) {

        File file = new File("example.txt");
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch(Exception e){}

    }

    public static void write(Object o) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss", Locale.getDefault());
        String date = sdf.format(cal.getTime());
        String out = "[" + date + "] " + o;
        System.out.println(out);

        String filePath = "log/" + date + ".txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))){
            bw.append(out);
            bw.newLine();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
