package java1.lesson6;

import java.io.*;
import java.util.Objects;
import java.util.Random;

public class Main {

    private static final char[] arrChar = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static final int minWordLength = 2;
    private static final int maxWordLength = 12;
    private static final int minText = 100;
    private static final int maxText = 1000;
    private static final String searchFolder = "c:/java/java1";
    private static final String[] nameFiles = new String[] {
            "file_1.txt",
            "file_2.txt",
            "file_3.txt"
    };
    private static final String mergeFile = "file_merge.txt";
    private static String[] textOutputGenerated = new String[nameFiles.length];
    private static String textOutputMerge = "";
    private static final String wordSearch = textOutputGenerated.toString();
    private static boolean typeOutputCheck = false;

    // получаем случайную букву
    public static char getCharRnd() {
        Random random = new Random();
        int charSelectPos = random.nextInt(arrChar.length);
        return arrChar[charSelectPos];
    }
    // получием длину слова
    public static int gerWordLength() {
        Random random = new Random();
        return random.nextInt((maxWordLength - minWordLength) + 1) + minWordLength;
    }
    // генерируем слово
    public static String wordGenerator() {
        StringBuilder word = new StringBuilder();
        for(int i=0; i < gerWordLength(); i++) {
            word.append(getCharRnd());
        }
        word.append(" ");
        return word.toString();
    }
    // генерируем текст и пишем в файл или в память
    public static String textGenerator() {
        Random random = new Random();
        int textLength = random.nextInt((maxText - minText) + 1) + minText;
        int posWordSearch = textLength / 2;
        StringBuilder word = new StringBuilder();
        for(int i=0; i < textLength; i++) {
            // добавляем слово для поиска в тексте
            if (posWordSearch == i) {
                word.append(wordSearch).append(" ");
            }
            word.append(wordGenerator());
        }
        word.append(" ");
        return word.toString();
    }
    // вывод текста в файл или на экран
    public static void textOutput(String textGenerated, String nameFile, int number, boolean typeOutput) {
        if (typeOutput) {
            try {
                FileOutputStream fos = new FileOutputStream(nameFile);
                fos.write(textGenerated.getBytes());
                fos.flush();
                fos.close();
                System.out.printf("Записали в файл: %s\n", nameFile);
                System.out.printf("Содержимое:\n%s\n\n", readFile(nameFile));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            textOutputGenerated[number] = textGenerated; // для поиска
            System.out.printf("Возможно записать в файл: %s\n", nameFile);
            System.out.printf("Содержимое:\n%s\n\n", textGenerated);
        }
        typeOutputCheck = typeOutput;
    }
    // содержимое склеенного файла
    public static void readMergeFile() {
        if (typeOutputCheck) {
            System.out.printf("Имя файла: %s\n", mergeFile);
        } else {
            System.out.printf("Возможное имя файла: %s\n", mergeFile);
        }
        System.out.println("Содержимое:");
        if (typeOutputCheck) {
            System.out.print(readFile(mergeFile));
        } else {
            System.out.print(textOutputMerge);
        }
    }
    // читаем файл
    public static String readFile(String file_name) {
        StringBuilder str = new StringBuilder();
        try(FileInputStream fin = new FileInputStream(file_name))
        {
            int i;
            while((i = fin.read()) != -1){
                str.append((char) i);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return str.toString();
    }
    // склеиваем содержимое
    public static void mergeFiles(String[] nameFiles, String mergeFile) {
        if (typeOutputCheck) {
            try {
                for (String file : nameFiles) {
                    FileInputStream fis = new FileInputStream(file);
                    int b;
                    FileOutputStream fos = new FileOutputStream(mergeFile, true);
                    while ((b = fis.read()) != -1) {
                        fos.write((char) b);
                    }
                    fos.flush();
                    fos.close();
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        } else {
            StringBuilder text = new StringBuilder();
            for (String s : textOutputGenerated) {
                text.append(s);
            }
            textOutputMerge = text.toString();
        }
    }
    // ищем по слову
    public static void searchWord() {
        if (typeOutputCheck) {
            File folder = new File(searchFolder);
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                if (file.isFile() && file.length() > 0) {
                    if (readFile(file.getName()).contains(wordSearch)) {
                        System.out.println("Слово найдено в файле: " + file.getName());
                    }
                }
            }
        } else {
            for(int i=0; i < textOutputGenerated.length; i++) {
                if (textOutputGenerated[i].contains(wordSearch)) {
                    System.out.printf("Символы %s найдены в файле: %s\n", wordSearch, nameFiles[i]);
                }
            }
            if (textOutputMerge.contains(wordSearch)) {
                System.out.printf("Символы %s найдены в файле: %s\n", wordSearch, mergeFile);
            }
        }
    }
    // результат работы программы
    public static void main(String[] args) {
        // Генерируем и выводим текст в файл или на экран
        for(int i = 0; i < nameFiles.length; i++) {
            textOutput(textGenerator(), nameFiles[i], i,true); // текст, имя файла, номер файла, вывод: на экран или в файл
        }
        // Склеиваем содержимое файлов в новый файл/на экран
        mergeFiles(nameFiles, mergeFile);
        // Выводим содержимое склеенного файла
        readMergeFile();
        // Ищем случайный набор символов
        System.out.printf("\n\nПоиск символов %s в записанных файлах.\n\n", textOutputGenerated.toString());
        searchWord();
    }
}
