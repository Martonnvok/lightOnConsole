package lightonconsole;

import java.util.Scanner;

public class Kapcsolasok {

    private static final Scanner sc = new Scanner(System.in);
    private final Lampak lampak;
    private int id;

    public Kapcsolasok() {
        this.lampak = new Lampak();
    }

    public void ertekValtoztatasok() {
        while (!lampak.amigVanNulla()) {
            beolvasas();
            szomszedokKeresese(this.id);
            lampak.kiir();
        }
    }

    public void beolvasas() {
        int[] sorokK = lampak.getSorokK();
        int[] oszlopK = lampak.getOszlopK();

        System.out.print("Kérem adja meg a következő koordináták oszlopát {1-" + sorokK[0] + "}: ");
        int bekerO = sc.nextInt();
        int oszlop = bekerO - 1;

        System.out.print("Kérem adja meg a következő koordináták sorát {1-" + oszlopK[0] + "}: ");
        int bekerS = sc.nextInt();
        int sor = bekerS - 1;

        System.out.println("A bekért koordináták a következők: sor = " + (sor + 1) + ", oszlop = " + (oszlop + 1));

        lampak.modositElemet(sor, oszlop);
    }

    public void szomszedokKeresese(int szam) {
        int felsoSor = szam > 2 ? szam - 3 : -1;
        int alsoSor = szam < 6 ? szam + 3 : -1;
        int bal = szam % 3 != 0 ? szam - 1 : -1;
        int jobb = szam % 3 != 2 ? szam + 1 : -1;
        int[] szomszedok = { felsoSor, alsoSor, bal, jobb, szam };
        int[][] lampakDb = lampak.getLampakDb();
        for (int i = 0; i < lampakDb.length; i++) {
            for (int j = 0; j < lampakDb[i].length; j++) {
                if (lampakDb[i][j] == 1) {
                    lampak.setLampakValue(i, j, false, szomszedok);
                } else {
                    lampak.setLampakValue(i, j, true, szomszedok);
                }
            }
        }
    }

    public void korok() {
        int korokSzama = 0;
        while (!lampak.amigVanNulla()) {
            korokSzama++;
            ertekValtoztatasok();
        }
        System.out.println("A játék " + korokSzama + " kör után véget ért. Minden lámpa kialszott.");
    }
}