package lightonconsole;

import java.util.Random;

public class Lampak {
    //Itt adjuk meg a privát adattagok értékét, amiket a későbbiekben felhasználok
    private int[] sorokK;
    private int[] oszlopK;
    private boolean[][] lampak;
    private int[][] lampakDb;
    private boolean amigNulla;

    public Lampak() {
        this.lampak = new boolean[3][3];
        this.lampakDb = new int[3][3];
        this.sorokK = new int[]{1, 2, 3};
        this.oszlopK = new int[]{1, 2, 3};
        this.amigNulla = false;
        this.oszlopK = new int[3]; // Új sor

        randomLampak();
    }

    //Getterek és Setterek
    public int[][] getLampakDb() {
        return lampakDb;
    }

    public boolean isIsRandomized() {
        return amigNulla;
    }

    public boolean isRandomized() {
        return amigNulla;
    }

    public void setRandomized(boolean randomized) {
        amigNulla = randomized;
    }

    public void setLampakDb(int[][] lampakDb) {
        this.lampakDb = lampakDb;
    }

    public int[] getSorokK() {
        return sorokK;
    }

    public void setSorokK(int[] sorokK) {
        this.sorokK = sorokK;
    }

    public int[] getOszlopK() {
        return oszlopK;
    }

    public void setOszlopK(int[] oszlopK) {
        this.oszlopK = oszlopK;
    }

    public boolean[][] getLampak() {
        return lampak;
    }

    public void setLampakValue(int sor, int oszlop, boolean ertek) {
        this.lampak[sor][oszlop] = ertek;
        this.lampakDb[sor][oszlop] = ertek ? 1 : 0;
         //kiir();
    }
    
    public void setLampakValue(int sor, int oszlop, boolean ertek, int szomszedok []) {
        this.lampak[sor][oszlop] = ertek;
        this.lampakDb[sor][oszlop] = ertek ? 1 : 0;
         //kiir();
    }

    //kiiratás, megjelenítés
    void kiir() {
        System.out.println("  1   2   3");
        System.out.println("+---+---+---+");
        for (int i = 0; i < lampakDb.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < lampakDb[i].length; j++) {
                System.out.print(lampakDb[i][j] + " | ");
            }
            System.out.println();
            System.out.println("+---+---+---+");
        }
        System.out.println("  1   2   3\n");
    }

    //Random lámpák fel/le kapcsolása kezdő értékben
    private void randomLampak() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.lampak[i][j] = random.nextBoolean();
                this.lampakDb[i][j] = this.lampak[i][j] ? 1 : 0;
            }
        }

        kiir();
    }

    public void modositElemet(int sor, int oszlop) {
        boolean jelenlegiErtek = lampak[sor][oszlop];
        setLampakValue(sor, oszlop, !jelenlegiErtek);
    }

    public boolean amigVanNulla() {
        for (boolean[] lampak1 : lampak) {
            for (int j = 0; j < lampak1.length; j++) {
                if (lampak1[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
