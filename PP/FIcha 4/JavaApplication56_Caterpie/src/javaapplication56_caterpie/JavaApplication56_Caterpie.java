/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication56_caterpie;

/**
 *
 * @author Luís Pereira
 */
public class JavaApplication56_Caterpie {

    public static void ex2() {

    }

    public static void main(String[] args) {
        //exercicio 2
        User user1 = new User();
        user1.id[0] = 'A';
        user1.id[1] = 'B';
        user1.id[2] = 'C';
        user1.name = new char[]{'B', 'r', 'u', 'n', 'o'};
        user1.email = new char[]{'b', 'm', 'o', '@', 'e', 's', 't', 'g', 'f', '.', 'i', 'p', 'p', '.', 'p', 't'};

        //exercicio 3
        System.out.println("----- User 1 ------");
        System.out.print("ID: ");
        System.out.println(user1.id);
        System.out.print("Nome: ");
        System.out.println(user1.name);
        System.out.print("E-mail: ");
        System.out.println(user1.email);
        //exercicio 4
        User user2 = new User();
        user2.id = new char[]{'L', 'U', 'I'};
        user2.name = new char[]{'L', 'u', 'i', 's'};
        user2.email = new char[]{'8', '1', '6', '0', '1', '8', '2', '@', 'e', 's', 't', 'g', '.', 'i', 'p', 'p', '.', 'p', 't'};

        System.out.println("----- User 2 ------");
        System.out.print("ID: ");
        System.out.println(user2.id);
        System.out.print("Nome: ");
        System.out.println(user2.name);
        System.out.print("E-mail: ");
        System.out.println(user2.email);
    }

}
