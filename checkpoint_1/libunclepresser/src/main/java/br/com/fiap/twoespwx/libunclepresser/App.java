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

import java.util.ArrayList;
import java.util.Arrays;


public class App 
{
    public static void main( String[] args )
    { 
        System.out.println("\n\n------------------------------------");
        System.out.println(":: Lib Uncle Otidio - Nucleotidio Counter Algorithm ::");

        int frequenciaA = 0;
        int frequenciaC = 0;
        int frequenciaT = 0;
        int frequenciaG = 0;

        String entrada = "GGAACCTTCC";
        StringBuilder output = new StringBuilder();
        String[] entradaSplitada = entrada.split("");
        int nextPos = 0;

        for (int i = 0; i <= entradaSplitada.length - 1; i++) {
            String caracter = entradaSplitada[i];
            if (i < entradaSplitada.length - 1) {
                nextPos = i + 1;
            }

            if (caracter.equals("A")) {
                frequenciaA = frequenciaA + 1;
                if (!entradaSplitada[nextPos].equals("A") || i + 1 > entradaSplitada.length - 1) {
                    output.append("A").append(frequenciaA);
                    frequenciaA = 0;
                }
            }

            if (caracter.equals("C")) {
                frequenciaC = frequenciaC + 1;
                if (!entradaSplitada[nextPos].equals("C") || i + 1 > entradaSplitada.length - 1) {
                    output.append("C").append(frequenciaC);
                    frequenciaC = 0;
                }
            }

            if (caracter.equals("T")) {
                frequenciaT = frequenciaT + 1;
                if (!entradaSplitada[nextPos].equals("T") || i + 1 > entradaSplitada.length - 1) {
                    output.append("T").append(frequenciaT);
                    frequenciaT = 0;
                }
            }

            if (caracter.equals("G")) {
                frequenciaG = frequenciaG + 1;
                if (!entradaSplitada[nextPos].equals("G") || i + 1 > entradaSplitada.length - 1) {
                    output.append("G").append(frequenciaG);
                    frequenciaG = 0;
                }
            }
        }

        System.out.println(output);
    }
}

