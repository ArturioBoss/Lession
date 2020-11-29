package com.chat.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Log {
    private BufferedWriter bw;
    private BufferedReader br;

    public Log() {

    }

    private File File(){
        File file = new File("src/com/chat/log/logChat.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
                return file;
            } catch (IOException e) {
                throw new RuntimeException("SWW ошибка создания файла", e);
            }
        }
        return file;
    }

    public void doFileRead(int count){
        try {
            br = new BufferedReader(
                    new FileReader(File())
            );
            List<String> stringsTemp = new ArrayList<>();
            br.lines().forEach(stringsTemp::add);
            int a = stringsTemp.size()-count;
            if (a<count) a=0;
            for (int i = a; i < stringsTemp.size() ; i++) {
                System.out.println(stringsTemp.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doFileWrite(String message){
        try {
            bw = new BufferedWriter(
                    new FileWriter(File(), true)
            );
            bw.newLine();
            bw.write(
                    String.format(
                            "%s: Сообщение: "+message,
                            new Date()
                    )
            );
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
