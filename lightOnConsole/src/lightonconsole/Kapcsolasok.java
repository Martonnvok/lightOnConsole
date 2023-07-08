package lightonconsole;

import java.util.Scanner;

public class Kapcsolasok {

    private static final Scanner sc = new Scanner(System.in, "latin1");
    private final Lampak lampak;

    public Kapcsolasok() {
        this.lampak = new Lampak();
    }

    public void jatekInditasa() {
        int osszKor = 0;
        int korokSzama = 25;
        int ennyiLepes = 0;
        boolean stopJatek = false;
        String dontes;

        lampak.szabalyok();
        enterGomb();
        lampak.kiir();
        leir(" Lepeseid: " + korokSzama);
        leir("<====================================>");
        while (!stopJatek) {
            korokSzama = 1;
            while (!lampak.amigVanNulla() && korokSzama >= 1) {
                beolvasas();
                korokSzama--;
                ennyiLepes++;
                lampak.kiir();
                leir(" Lepeseid: " + korokSzama);
                leir("<====================================>");
            }

            if (!lampak.getAmigNulla() && korokSzama >= 1) {
                leir("Gratulalok, sikerult minden lampat lekapcsolnod!");
                leir("Ennyi lepest tettel: " + ennyiLepes);
            } else {
                leir("Sajnalom, nem sikerult lekapcsolnod a lampakat, vesztettel.");
            }
            
            System.out.print("Szeretnel uj jatekot kezdeni? (I/N) vagy (i/n): ");
            dontes=sc.next();
            if ("I".equals(dontes) || "i".equals(dontes)) {
                stopJatek = false;
                osszKor++;
            }
            else if("N".equals(dontes) || "n".equals(dontes)){
                stopJatek = true;
            }    
        }
        leir("O-------O------O------O-------O------O------O-------O");
        leir("\tEnnyiszer inditottad ujra a jatekot: "+osszKor);
        leir("O-------O------O------O-------O------O------O-------O");

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
        int sor = sc.nextInt();

        while (sor > 3 || sor < 1) {
            leir(" Vagy tul nagy szamot adott meg, vagy meg tul kicsit.");
            System.out.print(" Adja meg a lampak sorat(1-3): ");
            sor = sc.nextInt();
        }

        //Oszlop megadása és ellenőrzése
        System.out.print(" Adja meg a lampak oszlopat(1-3): ");
        int oszlop = sc.nextInt();

        while (oszlop > 3 || oszlop < 1) {
            leir(" Vagy tul nagy szamot adott meg, vagy meg tul kicsit.");
            System.out.print(" Adja meg a lampak oszlopat(1-3): ");
            oszlop = sc.nextInt();
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
}
