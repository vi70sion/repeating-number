import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

//        Užduotis 1: Daugiausiai kartų pasikartojantis skaičius
//        Parašykite programą, kuri nuskaito sveikųjų skaičių sąrašą ir išveda skaičių, kuris sąraše pasikartoja
//        daugiausiai kartų. Jei tokių skaičių yra keli, išvesti pirmąjį. Sąlygos pavyzdys:
//        Įvedus sąrašą [1, 2, 2, 3, 3, 3, 4, 4, 4, 4], išvestis turėtų būti 4. Masyvą nuskaitome iš failo.

        String filePath = "C:/JavaTest/kartojimas_07-25/skaiciai.csv";
        int mostFrequentNumber = mostFrequentNumber(filePath);
        System.out.println("Daugiausiai kartų pasikartojantis skaičius yra: " + mostFrequentNumber);

    }

    private static int mostFrequentNumber(String filePath) {
        BufferedReader reader;
        Map<Integer, Integer> numberMap = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split(",");
                for (String number : numbers) {
                    int num = Integer.parseInt(number.trim());
                    numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Failo skaitymo klaida: " + e.getMessage());
            System.exit(0);
        }
        int mostFrequentNumber = 0;
        int freqCount = 0;
        for (Map.Entry<Integer, Integer> entry : numberMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > freqCount) {
                mostFrequentNumber = number;
                freqCount = frequency;
            }
        }
        return mostFrequentNumber;
    }


}