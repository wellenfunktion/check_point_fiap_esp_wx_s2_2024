/* 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Grupo: Batata Doce
 * Autores: 
 *      - Enzo Vasconcelos de Oliveira Santos - RM550702
 *      - Felipe Hideki Iwasa - RM98323
 */

package br.com.fiap.twoespwx.libunclepresser;

// public class App 
// {
//     public static void main( String[] args )
//     { 
//         System.out.println("\n\n------------------------------------");
//         System.out.println(":: Lib Uncle Otidio - Nucleotidio Counter Algorithm ::");

//         int frequenciaA = 0;
//         int frequenciaC = 0;
//         int frequenciaT = 0;
//         int frequenciaG = 0;

//         String entrada = "GGAACCTTCC";
//         StringBuilder output = new StringBuilder();
//         String[] entradaSplitada = entrada.split("");
//         int nextPos = 0;

//         for (int i = 0; i <= entradaSplitada.length - 1; i++) {
//             String caracter = entradaSplitada[i];
//             if (i < entradaSplitada.length - 1) {
//                 nextPos = i + 1;
//             }

//             if (caracter.equals("A")) {
//                 frequenciaA = frequenciaA + 1;
//                 if (!entradaSplitada[nextPos].equals("A") || i + 1 > entradaSplitada.length - 1) {
//                     output.append("A").append(frequenciaA);
//                     frequenciaA = 0;
//                 }
//             }

//             if (caracter.equals("C")) {
//                 frequenciaC = frequenciaC + 1;
//                 if (!entradaSplitada[nextPos].equals("C") || i + 1 > entradaSplitada.length - 1) {
//                     output.append("C").append(frequenciaC);
//                     frequenciaC = 0;
//                 }
//             }

//             if (caracter.equals("T")) {
//                 frequenciaT = frequenciaT + 1;
//                 if (!entradaSplitada[nextPos].equals("T") || i + 1 > entradaSplitada.length - 1) {
//                     output.append("T").append(frequenciaT);
//                     frequenciaT = 0;
//                 }
//             }

//             if (caracter.equals("G")) {
//                 frequenciaG = frequenciaG + 1;
//                 if (!entradaSplitada[nextPos].equals("G") || i + 1 > entradaSplitada.length - 1) {
//                     output.append("G").append(frequenciaG);
//                     frequenciaG = 0;
//                 }
//             }
//         }

//         System.out.println(output);
//     }
// }


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        System.out.println("\n\n------------------------------------");
        System.out.println(":: Lib Uncle Otidio - Nucleotidio Counter Algorithm ::");
        System.out.println("\n\n------------------------------------");

        // Caminho do arquivo de entrada.
        String filePath = "caminho/para/o/arquivo/de/entrada.txt";
        String result = nucleotidioSequenceProcesser(filePath); 
        System.out.println(result);
    }

    // Processa a sequencia de nucleotideos.
    public static String nucleotidioSequenceProcesser(String filePath) {
        StringBuilder output = new StringBuilder(); // Cria um StringBuilder para armazenar a sequencia compr.
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { // Cria um BufferedReader para ler o arquivo.
            String line; // Cria uma variável para armazenar a linha atual.
            while ((line = reader.readLine()) != null) { // Enquanto a linha não é nula, appendamos ao "output" o resultado da função sequenceCompressor.
                output.append(sequenceCompressor(line));
            }
        } // Error handling para erros de IO.
        catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return "";
        }
        
        return output.toString(); // Retorna a sequencia comprimida e convertida para String.
    }

    // Comprime a sequencia de nucleotideos.
    private static String sequenceCompressor(String sequence) {
        StringBuilder compressed = new StringBuilder(); // Cria um StringBuilder para armazenar a sequencia comprimida.
        char currentChar = '\0'; // Inicializa o char atual como nulo.
        int count = 0; // Inicializa o contador como 0.

        for (int i = 0; i < sequence.length(); i++) { // Para cada caracter na sequencia,
            char nucleotideo = sequence.charAt(i); // Obtemos o caracter atual.
            
            if (nucleotideo == currentChar) { // Se o caracter atual é igual ao caracter anterior, incrementamos o contador.
                count++;
            } else { // Caso contrário, adicionamos o caracter anterior e o contador à sequencia comprimida, e resetamos o contador.
                if (count > 0) {
                    compressed.append(currentChar).append(count);
                }
                currentChar = nucleotideo; // Atualizamos o caracter atual.
                count = 1; // Resetamos o contador.
            }
        }

        if (count > 0) { // Se o contador é maior que 0, adicionamos o caracter atual e o contador à sequencia comprimida.
            compressed.append(currentChar).append(count);
        }

        return compressed.toString(); // Retorna a sequencia comprimida e convertida para String.
    }
}

