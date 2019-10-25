/* 
 * Copyright 2019 Javier Monterde - javier.monterde.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Javier Monterde - javier.monterde.alum@iescamp.es
 */
public class Main {

    public static final Calendar CAL = Calendar.getInstance();
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Variables
        int horaUser, minUser, segUser, tiempoUser;

        int horaActual = CAL.get(Calendar.HOUR_OF_DAY);
        int minActual = CAL.get(Calendar.MINUTE);
        int segActual = CAL.get(Calendar.SECOND);
        int tiempoActual;

        int diferenciaSeg, diferenciaMin, diferenciaHoras;

        //Bloque principal
        try {
            //Pedimos la hora
            System.out.print("Hora inicio.....: ");
            horaUser = SCN.nextInt();
            SCN.nextLine();

            //Pedimos el minuto
            System.out.print("Minuto inicio...: ");
            minUser = SCN.nextInt();
            SCN.nextLine();

            //Pedimos el segundo
            System.out.print("Segundo inicio..: ");
            segUser = SCN.nextInt();
            SCN.nextLine();

            //Pasamos el tiempo a segundos
            tiempoUser = horaUser * 3600 + minUser * 60 + segUser;

            //Calculamos el tiempo actual
            tiempoActual = horaActual * 3600 + minActual * 60 + segActual;

            // Calculamos la diferencia, en segundos
            diferenciaSeg = tiempoActual - tiempoUser;

            //Obtenemos el número de horas
            diferenciaHoras = diferenciaSeg / 3600;

            //Ahora, el de minutos
            diferenciaMin = diferenciaSeg % 3600 / 60;

            //Y, por último, calculamos el número de segundos restantes
            diferenciaSeg = diferenciaSeg
                    - (diferenciaHoras * 3600 + diferenciaMin * 60);

            //Salidas
            System.out.printf("Hora actual.....: %02d:%02d:%02d%n",
                    horaActual, minActual, segActual);
            System.out.printf("Hora inicio.....: %02d:%02d:%02d%n",
                    horaUser, minUser, segUser);
            System.out.printf("Tiempo de clase.: %02d:%02d:%02d%n",
                    diferenciaHoras, diferenciaMin, diferenciaSeg);
        } catch (Exception e) {
            System.out.println("ERROR: Parámetro no válido");
        }
    }
}
