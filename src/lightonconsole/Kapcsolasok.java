package lightonconsole;

import java.util.Scanner;

public class Kapcsolasok {
    private static final Scanner sc = new Scanner(System.in);
    private final Lampak lampak;

    //Itt példányosítom a Lampa osztályomat, a Lampa osztály adattagjait 
    //használom fel hogy változtatni tudjam a lámpák értékeit
    public Kapcsolasok() {
        this.lampak = new Lampak();
    }

    public void ertekValtoztatasok() {
        while (!lampak.amigVanNulla()) {
//            beolvasas();
            csere();
        }
    }

    public void beolvasas() {
        int[] sorokK = lampak.getSorokK();
        int[] oszlopK = lampak.getOszlopK();

        System.out.print("Kérem adja meg a következő koordináták oszloát {1-" + sorokK[0] + "}: ");
        int bekerS = sc.nextInt();
        int sor = bekerS - 1;

        System.out.print("Kérem adja meg a következő koordináták sorát {1-" + oszlopK[0] + "}: ");
        int bekerO = sc.nextInt();
        int oszlop = bekerO - 1;

        System.out.println("A bekért koordináták a következők: sor = " + (sor + 1) + ", oszlop = " + (oszlop + 1));

        lampak.modositElemet(sor, oszlop);
    }

    public void csere() {
        int[][] lampakDb = lampak.getLampakDb();
        for (int i = 0; i < lampakDb.length; i++) {
            for (int j = 0; j < lampakDb[i].length; j++) {
                if (lampakDb[i][j] == 1) {
                    lampak.setLampakValue(i, j, false);
                } else {
                    lampak.setLampakValue(i, j, true);
                }
            }
        }
        lampak.kiir();
    }

    public void korok() {
        int korokSzama = 0;
        while (!lampak.amigVanNulla()) {
            korokSzama++;
            ertekValtoztatasok();
        }
        System.out.println("A játék " + korokSzama + " kör után véget ért. Minden lámpa kialszott.");
    }
    
    
    
    
    
    //szomszédok Keresése metódus:
//        const szomszedFelsoSor = id > 5 ? id : id + 3;
//        const szomszedAlsoSor = id < 3 ? id : id - 3;;
//        const szomszedBal = id % 3 == 0 ? id : id - 1;;
//        const szomszedJobb = id % 3 == 2 ? id : id + 1;
//        const szomszedek = [szomszedFelsoSor, szomszedAlsoSor, szomszedBal, szomszedJobb, id];
//        console.log(szomszedek)
//        for (const szomszed of szomszedek) {
//            if (szomszed !== null) {
//                if (this.#allapotLista[szomszed] === 1) {
//                    this.#allapotLista[szomszed] = 0;
//                } else {
//                    this.#allapotLista[szomszed] = 1;
//                }
//            }
//        }
}

