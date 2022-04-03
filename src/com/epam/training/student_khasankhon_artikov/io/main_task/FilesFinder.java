package com.epam.training.student_khasankhon_artikov.io.main_task;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesFinder {
    static Writer writer = null;
    static BufferedReader reader = null;

    public static void main(String[] args) throws IOException {

        File dir = new File(args[0]);
        if (dir.isDirectory()) {
            writer = new FileWriter("out.txt");
            writer.write(dir.getName() + "\n");
            printFiles(dir, "");
            writer.close();
        } else {
            reader = new BufferedReader(new FileReader(dir.getName()));
            readFiles();
            reader.close();

        }

    }

    static void printFiles(File dir, String subFolder) throws IOException {
        File[] files = sortedFiles(dir.listFiles());
        for (File item : files) {
            if (item.isDirectory()) {
                writer.write(subFolder+"|" + "\n");
                writer.write(subFolder + "|---" + item.getName() + "\n");
                if (item == files[files.length - 1]) {
                    printFiles(item, subFolder + "    ");
                } else {
                    printFiles(item, subFolder + "|   ");
                }
            } else {
                if (hasSubFolder(files)) {
                    writer.write(subFolder + "|   " + item.getName() + "\n");
                } else {
                    writer.write(subFolder + "    " + item.getName() + "\n");
                }
            }
        }
    }

    static File[] sortedFiles(File[] files) {
        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return 1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return -1;
            } else {
                return f1.compareTo(f2);
            }
        });
        return files;
    }

    static boolean hasSubFolder(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    static void readFiles() throws IOException {

        Pattern pattern = Pattern.compile("[^\\s^\\|].*");
        String folder = null;
        Matcher matcher = null;
        ArrayList<Integer> files = new ArrayList<>();
        Map<String, ArrayList<Integer>> allFiles = new HashMap<String, ArrayList<Integer>>();
        String line = reader.readLine();
        folder = line;
        line = reader.readLine();
        while (line != null) {
            if (!line.contains("---")){
                matcher = pattern.matcher(line);
                if (matcher.find()){
                    files.add(matcher.group().length());
                }
            } else {
                if (!files.isEmpty()){
                    allFiles.put(folder, (ArrayList<Integer>) files.clone());
                } else {
                    allFiles.put(folder, new ArrayList<>());
                }
                folder = line;
                files.clear();
            }
            line = reader.readLine();
        }
        if (!files.isEmpty()) allFiles.put(folder, (ArrayList<Integer>) files.clone());

        int sumFiles = 0;
        int sumLengthOfFiles = 0;
        System.out.println("Numbers of folders: " + allFiles.size());
        for(ArrayList<Integer> filesList: allFiles.values()){
            sumFiles += filesList.size();
            sumLengthOfFiles += filesList.stream().mapToInt(value -> value).sum();
        }
        System.out.println("Numbers of all files: " + sumFiles);
        System.out.printf("Average number of files per folder: %6.1f \n", (double) sumFiles / allFiles.size());
        System.out.printf("Average filename length: %6.1f", (double) sumLengthOfFiles / sumFiles);
    }
}
