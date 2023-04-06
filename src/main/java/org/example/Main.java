package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.launch(args);
        String string = "z6h2fh";
        String fileName = args[0];

        //Optional<String> line = Files.lines(Paths.get(fileName)).findFirst();
        //System.out.println(line.get());
        //System.out.println(packaged(line.get()));
        //input(args, string);
        //unpacking(line.get());
        //System.out.println(line.get());
    }
    private static void input(String[] args, String str) {
        try (FileWriter writer = new FileWriter(args[0], false)) {
            writer.write(str);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static String packaged(String string){
        StringBuilder now = new StringBuilder();
        int count = 1;
        char symbol = string.charAt(0);
        int ans = 1;
        for(int i = 1; i < string.length(); i++){
            if (string.charAt(i) == symbol) count ++;
            else if (count == 1) now.append(symbol);
            else {
                now.append(count);
                now.append(symbol);
                count = 1;
            }
            symbol = string.charAt(i);
            if (ans == string.length() - 1) {
                if (count > 1) {
                    now.append(count);
                    now.append(string.charAt(i));
                }
                else now.append(string.charAt(i));
            }
            ans ++;
        }
        return now.toString();
    }
    public static String unpacking(String string){
        String now = "";
        int count = 1;
        for (int i = 0; i < string.length(); i++){
            int c =string.charAt(i);
            if (c > 47 && c < 58){
                count *= c - 48;
            }
            else{
                for (int j = 0; j < count; j++){
                    now += string.charAt(i);
                }
                count = 1;
            }
        }
        return now;
    }
    public void solve(String inputFile, Boolean unpack, Boolean pack, String outputFile) throws IOException {
        String text = "";
        File input = new File(inputFile);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        String line = bufferedReader.readLine();
        while (line != null){
            text += line;
            line = bufferedReader.readLine();
        }
        String answer;
        if (pack){
            answer = packaged(text);

        }
        else answer = unpacking(text);
        File output = new File(outputFile);
        output.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));
        bufferedWriter.write(answer);
        bufferedWriter.close();
        bufferedReader.close();
    }
}