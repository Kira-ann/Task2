package org.example;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    private String lines;
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.launch(args);
    }
    private String packaged(){
        StringBuilder now = new StringBuilder();
        int count = 1;
        char symbol = lines.charAt(0);
        int ans = 1;
        for(int i = 1; i < lines.length(); i++){
            if (lines.charAt(i) == symbol) count ++;
            else if (count == 1) now.append(symbol);
            else {
                now.append(count);
                now.append(symbol);
                count = 1;
            }
            symbol = lines.charAt(i);
            if (ans == lines.length() - 1) {
                if (count > 1) {
                    now.append(count);
                    now.append(lines.charAt(i));
                }
                else now.append(lines.charAt(i));
            }
            ans ++;
        }
        return now.toString();
    }
    private String unpacking(){
        StringBuilder now = new StringBuilder();
        int count = 0;

        for (int i = 0; i < lines.length(); i++){
            String a = String.valueOf(lines.charAt(i));
            if (Pattern.matches("\\d",a)){
                if (count != 0) count *= 10;
                count += Byte.parseByte(a);
            }
            else{
                for (int j = 0; j < count; j++){
                    now.append(lines.charAt(i));
                }
                count = 0;
            }
        }
        return now.toString();
    }
    public void solve(Boolean unpack, Boolean pack, String outputFile) throws IOException {
        String answer;
        if (pack){
            answer = packaged();
        }
        else answer = unpacking();
        File output = new File(outputFile);
        output.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));
        bufferedWriter.write(answer);
        bufferedWriter.close();
    }
    public Main(String inputFile) throws IOException {
        String text = "";
        File input = new File(inputFile);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        String line = bufferedReader.readLine();
        while (line != null){
            text += line;
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        this.lines = text;
    }
}