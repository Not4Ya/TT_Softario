package org.example.Services;

import org.example.Interfaces.IReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HtmlReader implements IReader {

    @Override
    public Map<String, String> read(String filePath) {
        Map<String, String> map = new HashMap<>();
        StringBuilder resultStringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String url = null;
            while ((line = br.readLine()) != null) {
                if (line.contains("https")){
                    url = line.substring(2);
                    continue;
                }
                if (line.isEmpty() && !resultStringBuilder.isEmpty()){
                    // Это условие нужно, чтобы не создавались пары, состоящие только из ключей
                    map.put(url, resultStringBuilder.toString());
                    resultStringBuilder.delete(0, resultStringBuilder.length());
                    continue;
                }
                resultStringBuilder.append(line).append("\n");
            }
            map.put(url, resultStringBuilder.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return map;
    }
}
