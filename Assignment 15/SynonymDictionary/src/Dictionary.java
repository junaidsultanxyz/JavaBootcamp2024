import javax.swing.*;
import java.io.*;
import java.util.*;


public class Dictionary {
    private static HashMap<String, String> dictionaryList = new HashMap<>();


    public void setDictionaryList (HashMap<String, String> data){
        dictionaryList = data;
    }

    public HashMap<String, String> getDictionaryList(){
        return dictionaryList;
    }

    public void newWord (String word, String synonyms){

        for (String s : dictionaryList.keySet()){
            if (word.equalsIgnoreCase(s)){
                int confirm = JOptionPane.showConfirmDialog(null, "Word already exist, want to change synonyms?");
                if (confirm == 0){
                    dictionaryList.put(s, synonyms);
                    return;
                }
                else return;
            }
        }

        dictionaryList.put(word,synonyms);
        JOptionPane.showMessageDialog(null, "New word added !");
    }

    public HashMap<String, String> searchWord (String word){
        HashMap<String, String> data = new HashMap<>();

        for (String s : dictionaryList.keySet()){
            if (s.toLowerCase().contains(word.toLowerCase()) || dictionaryList.get(s).toLowerCase().contains(word)){
                data.put(s, dictionaryList.get(s));
            }
        }

        return data;
    }

    public boolean deleteWord (String word){
        if (dictionaryList.containsKey(word)){

            int confirm = JOptionPane.showConfirmDialog(null, "Confirm want to delete the word?");
            if (confirm == 0){
                dictionaryList.remove(word);
                return true;
            }
            else {
                return false;
            }

        }
        else {
            return false;
        }
    }

    public HashMap<String, String> LoadDataFromFile(String fileName){
        HashMap<String, String> hashMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split("=", 2);

                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];

                    hashMap.put(key, value);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return hashMap;
    }

    public void SaveDataToFile(HashMap<String, String> hashMap, String fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            hashMap.forEach((key, value) -> {
                try {
                    writer.write(key + "=" + value);
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}