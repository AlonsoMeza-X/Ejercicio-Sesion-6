package service;

import model.Persona;
import util.ScannerSingleton;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PersonaService {
    private final Scanner sc;

    public PersonaService() {
        this.sc = ScannerSingleton.getInstance();
    }

    public void inicio() {
        List<Persona> per = new ArrayList<>();
        datosIniciales(per);
        menu(per);
    }

    private void datosIniciales(List<Persona> per) {
        Persona persona1 = new Persona("MikeXD", "@M0-214");
        Persona persona2 = new Persona("MayaXD", "$M9-215");
        per.add(persona1);
        per.add(persona2);

    }

    private void menu(List<Persona> per) {
        System.out.println("Le saludos cordialmente, porfavor ingrese su Usuario y Contraseña");
        System.out.println();
        verificacion(per);
    }

    private void verificacion(List<Persona> per) {
        String usuario, clave;
        boolean cerrarC = true;

        try {
            while (cerrarC) {
                System.out.println("Usuario");
                usuario = sc.nextLine();
                System.out.println("Contraseña");
                clave = sc.nextLine();
                System.out.println();
                for (Persona persona : per) {
                    if (usuario.equals(persona.getUsuario()) && clave.equals(persona.getClave())) {
                        System.out.println("Bienvenido/a " + persona.getUsuario());
                        cerrarC = false;
                        break;
                    }
                }

                if (cerrarC) {
                    System.out.println("Datos incorrectos, porfavor ingresar los datos nuevamente");
                }
            }
            menu();
        } catch (IllegalArgumentException e) {
            System.out.println("Porfavor ingresar texto, no numero");
            sc.next();
            verificacion(per);
        }
    }

    private void menu() {
        int option, n, nn;
        do {
            System.out.println("¿Qué es lo que desea relizar?");
            System.out.println("""
                    1. Cacular la raíz Cuadrada de un número.
                    2. Ver el valor de Pi.
                    3.Calcular la potencia de un número.
                    4. Salir.""");
            option = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (option) {
                case 1:
                    System.out.println("Ingrese un numero");
                    n = sc.nextInt();
                    System.out.println(raiz(n));
                    break;
                case 2:
                    pi();
                    break;
                case 3:
                    System.out.println("Ingrese un numero");
                    n = sc.nextInt();
                    System.out.println("Ingrese un segundo numero");
                    nn = sc.nextInt();
                    potencia(n, nn);
                    break;
                case 4:
                    System.out.println("Gracias por visitarnos");
                    ScannerSingleton.closeInstance();
                    break;
                default:
                    System.out.println("Porfavor ingresar un número del 1 al 4");
            }
        } while (option != 4);
    }

    public float raiz(int n1) {
          float resultado = 0;
        try {

            System.out.println();
            if (n1 < 0) {
                n1 *= -1;
            }
            resultado = (float) Math.sqrt(n1); //(float), convierte el resultado en float es debido a que resultado da un valor doble.
        } catch (
                InputMismatchException e) { // Entrada no coincide con el tipo de datos esperado (por ejemplo, ingresar texto cuando se espera un número).
            System.out.println("Porfavor ingresar numero, no texto");
            sc.nextLine();
            raiz(n1);
        }
        return resultado;
    }

    public double pi() {
        double pi = Math.PI;
        System.out.println("El valor de Pi es: " + pi);
        System.out.println();
        return pi;
    }

    public double potencia(int base, int exponente) {
        double resultado = 0;
        try {
            resultado = Math.pow(base, exponente);
            System.out.println("El número " + base + " elevado a la potencia de " + exponente + " es: " + resultado);
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Porfavor ingresar un numero, no un texto");
            sc.nextLine();
            potencia(base, exponente);
        }
        return resultado;
    }
}
