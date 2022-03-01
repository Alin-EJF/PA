package com.company;
import java.util.ArrayList;
import java.util.LinkedList;



public class Homework {
    static int p;

    public static void main(String[] args) {

        long begin = System.nanoTime();  //timpul de executie

        if (args.length < 3) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }

        int n = Integer.parseInt(args[0]);
        p = Integer.parseInt(args[1]);

        Homework app = new Homework();

        char[] alfabet = new char[args.length - 2];


        for (int i = 2; i < args.length; i++) {
            alfabet[i - 2] = args[i].charAt(0);
        }

        String[] words = app.generate(n, alfabet);

        for (String x : words)
            System.out.println(x);

        boolean[][] matrix = new boolean[n][n];



        ArrayList<LinkedList> Neighbours= new ArrayList<LinkedList>();


        for (int i = 0; i < n; i++) {
            LinkedList<String> lista= new LinkedList<String>();
            lista.add(words[i]);
            for (int j = 0; j < n; j++) {  //compara fiecare cuvant cu restul cuvintelor

                for (int x = 0; x < p; x++)
                    for (int y = 0; y < p; y++) //compara fiecare caracter cu restul caracterelor
                        if (Character.compare(words[i].charAt(x), words[j].charAt(y)) == 0) {
                            matrix[i][j] = true;
                            lista.add(words[j]);
                            x = p;            //Nu mai controleaza restul literelor daca gaseste un echivalent
                            break;
                        }
                       else
                        {matrix[i][j] = false;}



            }
            Neighbours.add(lista);
        }

        /*         AFISAREA VECINILOR
        for (LinkedList s : Neighbours) {
            System.out.print(s.getFirst() + "  vecinii : ");
            for (Object neighbour : s) {
                if (neighbour != s.getFirst()) {
                    if (neighbour == s.getLast()) {
                        System.out.println(neighbour + " ;");
                    } else {
                        System.out.print(neighbour + ", ");
                    }
                }
            }
        }
        */

        long end = System.nanoTime();
        long time = end-begin;
        System.out.println();
        System.out.println("Elapsed Time: "+time);  //afisam timpul de executie
    }


        public String[] generate(int n, char[] alphabet) {
            String[] words = new String[n];

            int ret=p;  //tine minte valoarea initiala al lui p

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                while (p>0) {
                    int pos = (int) ((Math.random() * (alphabet.length - 0)) + 0);
                    if (pos < 0)
                        break;
                    sb.append(alphabet[pos]);
                    p--;
                }
                words[i] = sb.toString();

                p=ret;
            }
            return words;
        }


}