package main.java;

public class ejerciciosArreglos {

    public static void main (String [] args){
        int [] horas = new int [5];
        horas [2] = 34;
        horas [3]= 29;
        horas [4] = 14;
        for (int pos = 0; pos<horas.length;pos++){
            System.out.println("Posición "+pos+" --> "+ horas [pos]);
        }

        String [] dias = new String [7];
        dias [0] = "Domingo";
        dias [1] = "Lunes";
        dias [2] = "Martes";
        dias [3] = "Miercoles";
        dias [4] = "Jueves";
        dias [5] = "Viernes";
        dias [6] = "Sábado";

        for (int i = 0; i < dias.length; i++){
            System.out.println("Día de la semana "+dias[i]);
        }



    }
