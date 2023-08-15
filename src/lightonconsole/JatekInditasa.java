package lightonconsole;

import java.util.Scanner;

public class JatekInditasa {

    private static final Scanner sc = new Scanner(System.in, "latin1");
    private final Lampak lampak;
    private int osszKor, korokSzama, ennyiLepes, osszLepes;
    private boolean stopJatek, joValasz;

    public JatekInditasa() {
        this.lampak = new Lampak();
        osszKor = 0;
        osszLepes = 0;
        stopJatek = false;

        //szabályok
        lampak.szabalyok();
        enterGomb();
        leir("<====================================>");
        //főprogram
        while (!stopJatek) {
            korokSzama = 25;
            ennyiLepes = 0;
            joValasz = true;
            lampak.kiir();
            leir(" Lepeseid: " + korokSzama);
            while (!lampak.amigVanNulla() && korokSzama >= 1) {
                beolvasas();
                korokSzama--;
                ennyiLepes++;
                lampak.kiir();
                leir(" Lepeseid: " + korokSzama);
                leir("<====================================>");
            }
            osszLepes += ennyiLepes;
            vegEredmeny();
            ujraIndit();
        }
        leir("O-------O------O------O-------O------O------O-------O");
        leir("\tEnnyiszer inditottad ujra a jatekot: " + osszKor);
        leir("\tEnnyi lepest tettel a jatekban osszesen: " + osszLepes);
        leir("O-------O------O------O-------O------O------O-------O");

    }

    private void ujraIndit() {
        String dontes;
        while (joValasz) {
            System.out.print("Szeretnel uj jatekot kezdeni? (I/N) vagy (i/n): ");
            dontes = sc.next();
            if (null == dontes) {
                leir("Nem jo valszt adtal meg, probald ujra!");
                joValasz = true;
            } else {
                switch (dontes) {
                    case "I", "i" -> {
                        stopJatek = false;
                        joValasz = false;
                        osszKor++;
                    }
                    case "N", "n" -> {
                        stopJatek = true;
                        joValasz = false;
                    }
                    default -> {
                        leir("Nem jo valaszt adtal meg, probald ujra!");
                        joValasz = true;
                    }
                }
            }
        }
    }

    private void vegEredmeny() {
        if (!lampak.getAmigNulla() && korokSzama >= 1) {
            leir("Gratulalok, sikerult minden lampat lekapcsolnod!");
            leir("Ennyi lepest tettel: " + ennyiLepes);
        } else {
            leir("Sajnalom, nem sikerult lekapcsolnod a lampakat, vesztettel.");
        }
    }

    private void enterGomb() {
        String input = " ";
        while (!input.isEmpty()) {
            input = sc.nextLine();
        }
    }

    private void beolvasas() {

        //Sor megadása és ellenőrzése
        System.out.print(" Adja meg a lampak sorat(1-3): ");
        boolean sorIgaz = false;
        int sor = 0;
        while (!sorIgaz) {
            if (sc.hasNextInt()) { // Ellenőrzi, hogy a bemenet szám-e
                sor = sc.nextInt();
                if (sor > 3 || sor < 1) {
                    leir("Erteken kivuli szamot adott meg.");
                    System.out.print("Adja meg a lampak sorat(1-3): ");
                } else {
                    sorIgaz = true;
                }
            } else {
                System.out.print("Betut adott meg, adja meg a lampak sorat(1-3):");
                sc.next(); // Beolvasza és eldobja a nem szám karaktertartalmú bemenetet
            }
        }

        //Oszlop megadása és ellenőrzése
        System.out.print(" Adja meg a lampak oszlopat(1-3): ");
        int oszlop = 0;
        boolean oszlopIgaz = false;
        while (!oszlopIgaz) {
            if (sc.hasNextInt()) { // Ellenőrzi, hogy a bemenet szám-e
                oszlop = sc.nextInt();
                if (oszlop > 3 || oszlop < 1) {
                    leir("Erteken kivuli szamot adott meg.");
                    System.out.print("Adja meg a lampak oszlopat(1-3): ");
                } else {
                    oszlopIgaz = true;
                }
            } else {
                System.out.print("Betut adott meg, adja meg a lampak oszlopat(1-3):");
                sc.next(); // Beolvasza és eldobja a nem szám karaktertartalmú bemenetet
            }
        }

        megforditLampa(sor - 1, oszlop - 1);
        szomszedosLampakMegforditasa(sor - 1, oszlop - 1);
    }

    //A kiválasztott kordinátának a szomszédjait is nézi és úgy változtatt
    //rajtuk.
    private void megforditLampa(int sor, int oszlop) {
        lampak.setLampakErtek(sor, oszlop, !lampak.getLampak()[sor][oszlop]);
    }

    private void szomszedosLampakMegforditasa(int sor, int oszlop) {
        if (sor - 1 >= 0) {
            megforditLampa(sor - 1, oszlop);
        }
        if (sor + 1 < lampak.getLampak().length) {
            megforditLampa(sor + 1, oszlop);
        }
        if (oszlop - 1 >= 0) {
            megforditLampa(sor, oszlop - 1);
        }
        if (oszlop + 1 < lampak.getLampak()[0].length) {
            megforditLampa(sor, oszlop + 1);
        }

    }

    //A kiirtás leegyszerűsítése
    private void leir(String str) {
        System.out.println(str);
    }

    //getterek és setterek
    public void setOsszKor(int osszKor) {
        this.osszKor = osszKor;
    }

    public void setKorokSzama(int korokSzama) {
        this.korokSzama = korokSzama;
    }

    public void setEnnyiLepes(int ennyiLepes) {
        this.ennyiLepes = ennyiLepes;
    }

    public void setOsszLepes(int osszLepes) {
        this.osszLepes = osszLepes;
    }

    public void setStopJatek(boolean stopJatek) {
        this.stopJatek = stopJatek;
    }

    public void setJoValasz(boolean joValasz) {
        this.joValasz = joValasz;
    }

    public static Scanner getSc() {
        return sc;
    }

    public Lampak getLampak() {
        return lampak;
    }

    public int getOsszKor() {
        return osszKor;
    }

    public int getKorokSzama() {
        return korokSzama;
    }

    public int getEnnyiLepes() {
        return ennyiLepes;
    }

    public int getOsszLepes() {
        return osszLepes;
    }

    public boolean isStopJatek() {
        return stopJatek;
    }

    public boolean isJoValasz() {
        return joValasz;
    }
}
