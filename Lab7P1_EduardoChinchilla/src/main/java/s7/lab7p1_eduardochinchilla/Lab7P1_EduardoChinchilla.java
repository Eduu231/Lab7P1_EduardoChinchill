package s7.lab7p1_eduardochinchilla;

import java.util.Scanner;
import java.util.Random;

public class Lab7P1_EduardoChinchilla {

    static Scanner read = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 3) {

            opcion = menu();

            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese las filas : ");
                    int filas = read.nextInt();
                    System.out.println("Ingrese las columnas: ");
                    int col = read.nextInt();

                    System.out.println("Ingrese la cantidad de balas para jugador 1");
                    int balas = read.nextInt();
                    System.out.println("Ingrese la cantidad de balas para jugador 2 ");
                    int balas2 = read.nextInt();
                    while (balas >= (filas * col) && balas2 >= (filas * col)) {
                        System.out.println("Cantidad de balas excesiva");
                        balas = read.nextInt();
                    }

                    System.out.println("Tablero1");
                    System.out.println("Matriz de primer jugador");
                    int[][] mjugador1 = new int[filas][col];
                    mjugador1 = llenado(filas, col, mjugador1);
                    imprimir(mjugador1);
                    while (balas != 0 && balas2 != 0) {

                        System.out.println("Ingrese el numero a disparar jugador 1: ");
                        int disparo = read.nextInt();
                        imprimir(disparo1(mjugador1, disparo));
                        System.out.println("Jugador 1 Tienes: " + balas);
                        System.out.println("Tablero2");
                        System.out.println("Matriz de segundo jugador");
//                    int[][] mjugador2 = new int[filas][col];
//                    mjugador2 = mjugador1;
                        imprimir(mjugador1);
                        System.out.println("Ingrese el numero a disparar jugador2: ");
                        int disparo2 = read.nextInt();
                        imprimir(disparo2(mjugador1, disparo2));
                        System.out.println("Jugador 2 Tienes: " + balas);

                        imprimir(mjugador1);

                        balas--;
                        suma1(mjugador1, disparo);
                        suma2(mjugador1, disparo);

                    }

                    break;
                }

                case 2: {
                    int[][] matriz = new int[5][5];
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            if (i == j ){
                                matriz[i][j]=0;
                            }else if ((i-j)==1 || (i-j)== -2 || (i-j)==3|| (i-j)==-4){
                                matriz[i][j]=-1;
                            }else{
                                matriz[i][j]=2;
                            }
                        }
                    }
//                    matriz[0][0] = 0; // tijera a papel
//                    matriz[0][1] = 2;// tijera a lizard
//                    matriz[0][2] = 3;// papel a spock
//                    matriz[0][3] = 4;// papel a piedra
//                    matriz[0][4] = 5;// piedra a tijera
//                    matriz[1][0] = 6;// piedra a lizard
//                    matriz[1][1] = 7;//lizard a papel
//                    matriz[1][2] = 8;//lizard a spock
//                    matriz[1][3] = 9;//spock a tijera
//                    matriz[1][4] = 10;// spock a piedra

                    System.out.println("Elegir opciones:");
                    System.out.println("1. Tijera");
                    System.out.println("2. papel");
                    System.out.println("3. piedra");
                    System.out.println("4. lizard");
                    System.out.println("5. spock");
                    int op = read.nextInt();
                    
                    System.out.println("La maquina");
                    int opM = 1 + rand.nextInt(5);
                    if (opM == 1) {
                        System.out.println("La maquina eligio tijera");
                    } else if (opM == 2) {
                        System.out.println("La maquina eligio papel");

                    } else if (opM == 3) {
                        System.out.println("La maquina eligio piedra");

                    } else if (opM == 4) {
                        System.out.println("La maquina eligio lizard");

                    } else if (opM == 5) {
                        System.out.println("La maquina eligio spock");

                    }

                
                    if (gano(matriz,op,opM)==0){
                        System.out.println("empate");
                    }else if(gano(matriz,op,opM)==-1){
                        System.out.println("gano la maquina");
                    }else if (gano(matriz,op,opM)==2){
                        System.out.println("gano el usuario");
                    }
                    
                    break;
                }
                case 3: {
                    System.out.println("Ha salido");
                    break;
                }
            }//fin switch
        }//fin while menu
    }//fin main

    public static int menu() {
        int op = 0;

        System.out.println("menu");
        System.out.println("1. disparar ");
        System.out.println("2. papel o tijera");
        System.out.println("3. Salir");

        op = read.nextInt();
        return op;
    }

    public static int[][] llenado(int x, int y, int [][] matriz) {
        int[][] temp = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i][j] = 1 + rand.nextInt(x * y);
                boolean f = false;
                for (int k = 0; k < matriz.length; k++) {
                    for (int l = 0; l < matriz[i].length; l++) {
                        if (matriz[k][l] == temp[i][j]){
                            f = true;
                        }
                    }
                }
            }
        }
        return temp;
    }

    public static void imprimir(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]" + " ");

            }
            System.out.println(" ");
        }

    }

    public static int[][] disparo1(int[][] matriz, int disparo) {
        int[][] temp = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (disparo == matriz[i][j]) {
                    System.out.println("Tiro acertado");
                    matriz[i][j] = 88;

                }
            }
        }
        return matriz;
    }

    public static void suma1(int[][] matriz, int disparo) {
        int acum = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (disparo == matriz[i][j]) {
                    acum += matriz[i][j];
                }
                System.out.println(acum);
            }
        }

    }

    public static void suma2(int[][] matriz, int disparo2) {
        int acum = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (disparo2 == matriz[i][j]) {
                    acum += matriz[i][j];
                }
                System.out.println(acum);
            }
        }

    }

    public static int[][] disparo2(int[][] matriz, int disparo) {
        int[][] temp = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (disparo == matriz[i][j]) {
                    System.out.println("Tiro acertado");
                    matriz[i][j] = 99;

                }
            }
        }
        return matriz;
    }
    
    public static int gano (int [][] matriz, int op, int opM){
        int acum = 0;
        
        for (int i = 0; i < matriz.length-1; i++) {
            for (int j = 0; j < matriz[i].length-1; j++) {
                if(i==op-1 && j == opM-1){
                    acum = matriz[i][j];
                }
            }
           
        }
        return acum;
    }

}
