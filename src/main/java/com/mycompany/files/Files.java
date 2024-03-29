package com.mycompany.files;

import java.io.*;
import java.util.*;



public class Files {

    public ArrayList <String> reader(File file){
        BufferedReader reader;
        ArrayList <String> list = new ArrayList <>();
        try {
           
            reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String line = reader.readLine();
            while (line != null){
                line = new StringBuilder(line).reverse().toString();
                list.add(line);
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
    public void save (File fileTask, ArrayList<String> list) {
        BufferedWriter writer;

        try {
            File file = new File(fileTask.getAbsoluteFile().getParent() + "/answer.txt");
           
            writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));

            for (String line : list) {
                writer.write(line + "\n");
            }

            writer.close();
        } catch (Exception ex) {
            System.out.println("Возникла ошибка при записи файла");
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Antonenko Darya RIBO-04-22 Var:2");
        Files files = new Files();
        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите путь к файлу");
        File file = new File (scanner.nextLine());
        ArrayList <String> list = files.reader(file);
        files.save(file, list);
    }
}


