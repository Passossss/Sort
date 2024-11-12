import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] arquivos = {
                "src/arquivos/aleatorio_100.csv",
                "C:/Users/Gustavo Passos/Desktop/Sort/src/arquivos/aleatorio_1000.csv",
                "C:/Users/Gustavo Passos/Desktop/Sort/src/arquivos/aleatorio_10000.csv",
                "C:/Users/Gustavo Passos/Desktop/Sort/src/arquivos/crescente_100.csv",
                "C:/Users/Gustavo Passos/Desktop/Sort/src/arquivos/crescente_1000.csv",
                "C:/Users/Gustavo Passos/Desktop/Sort/src/arquivos/crescente_10000.csv",
                "C:/Users/Gustavo Passos/Desktop/Sort/src/arquivos/decrescente_100.csv",
                "C:/Users/Gustavo Passos/Desktop/Sort/src/arquivos/decrescente_1000.csv",
                "C:/Users/Gustavo Passos/Desktop/Sort/src/arquivos/decrescente_10000.csv"
        };

        for (String arquivo : arquivos) {
            System.out.println("Processando arquivo: " + arquivo);

            // Lendo o arquivo CSV
            int[] arr = readCSV(arquivo);

            // Bubble Sort
            long startTime = System.nanoTime();
            Sorts.bubbleSort(arr);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Bubble Sort tempo de execução: " + duration / 1_000_000.0 + " ms");

            // Resetando o array para a próxima ordenação
            arr = readCSV(arquivo);

            // Insertion Sort
            long startTimeInsertion = System.nanoTime();
            Sorts.insertionSort(arr);
            long endTimeInsertion = System.nanoTime();
            long durationInsertion = (endTimeInsertion - startTimeInsertion);
            System.out.println("InsertionSort tempo de execução: " + durationInsertion / 1_000_000.0 + " ms");

            // Resetando o array para a próxima ordenação
            arr = readCSV(arquivo);

            // QuickSort
            long startTimeQuick = System.nanoTime();
            Sorts.quickSort(arr, 0, arr.length - 1);
            long endTimeQuick = System.nanoTime();
            long durationQuick = (endTimeQuick - startTimeQuick);
            System.out.println("QuickSort tempo de execução: " + durationQuick / 1_000_000.0 + " ms");

            System.out.println();  // Separador entre os resultados de diferentes arquivos
        }
    }

    // Método para ler o arquivo CSV
    public static int[] readCSV(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<Integer> dataList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (String value : values) {
                dataList.add(Integer.parseInt(value.trim()));
            }
        }
        br.close();
        // Convertendo para array
        int[] data = new int[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return data;
    }
}
