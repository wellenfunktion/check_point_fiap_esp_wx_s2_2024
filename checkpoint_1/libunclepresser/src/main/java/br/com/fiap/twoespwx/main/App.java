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

package br.com.fiap.twoespwx.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        System.out.println("\n\n------------------------------------");
        System.out.println(":: Lib Uncle Otidio - Nucleotidio Counter Algorithm ::");
        System.out.println("\n\n------------------------------------");

        // Caminho do arquivo de entrada.
        String inputPath = "check_point_fiap_esp_wx_s2_2024\\checkpoint_1\\libunclepresser\\inputs\\input.txt";
        String outputPath = "check_point_fiap_esp_wx_s2_2024\\checkpoint_1\\libunclepresser\\outputs\\output.TXT";
        String result = nucleotidioSequenceProcesser(inputPath); 
       
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(result);
            System.out.println("Resultado gravado com sucesso em: " + outputPath);
        } catch (IOException e) {
        System.err.println("Erro ao escrever no arquivo de saída: " + e.getMessage());
        }
    }
    
    // Processa a sequencia de nucleotideos.
    public static String nucleotidioSequenceProcesser(String filePath) {
        StringBuilder output = new StringBuilder(); // Cria um StringBuilder para armazenar a sequencia comprimida.
        
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



