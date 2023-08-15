package lightonconsole;

import java.util.Random;

public class Lampak {

    //Itt adjuk meg a privát adattagok értékét, amiket a későbbiekben felhasználok
    private int[] sorokK; //sorok kórdinátái
    private int[] oszlopK; //oszlopok kórdinátái
    private boolean[][] lampak; //a táblával arányos igaz/hamis értékek
    private int[][] lampakDb; // a tábla mérete pl 3x3-as az 9 elem
    private boolean amigNulla; //addig lesz tur/false az érték míg nem lesz mindegyik lámpa leoldva

    public Lampak() {
        this.lampak = new boolean[3][3];
        this.lampakDb = new int[3][3];
        this.sorokK = new int[]{1, 2, 3};
        this.oszlopK = new int[]{1, 2, 3};
        this.amigNulla = false;

        randomLampak();
    }

    //kiiratás, megjelenítés
    public void kiir() {
        leir("\t     LightOn");
        int szam = 1;

        leir("\t  +---+---+---+");
        for (int[] lampakDb1 : lampakDb) {
            System.out.print("\t" + szam + " | ");
            szam++;
            for (int j = 0; j < lampakDb1.length; j++) {
                System.out.print(lampakDb1[j] + " | ");
            }
            leir(" ");
            leir("\t  +---+---+---+");
        }
        leir("\t    1   2   3");
    }

    //A játék címe és leírása
    public void szabalyok() {
        leir("O---------O---------O");
        leir(" Szabalyok:");
        leir("O---------O---------O");
        leir("-A jatekban kizarolag 1 es 3 kozotti szamokat szabad megadni.");
        leir("-A jatekot felhasznalonak atirni tilos.");
        leir("-Ha hibat vell felfedezni, azt jelezze a szoftver fejlesztojenek.");
        leir("<========================================================================================================================>");
        leir("O------O------O");
        leir("  LightOn:");
        leir("O------O------O");
        leir("-A jatekban 0 es 1-es szamok szerepelnek. Fel van kapcsolva(1), le van kapcsolva(0).");
        leir("-A jatek addig megy amig le nem lesz kapcsolva az osszes lampa(0) vagy el nem fogynak a lepesek.");
        leir("-A lampakat a sorok(1-3) es oszlopok(1-3) megadasaval lehet kivalasztani es modositani.");
        leir("VIGYAZZ! a kivalasztott lampa koruli ertekek is ugyan ugy valtozni fognak, mint a kivalasztott lampa(jobb, bal, fel, le).");
        leir("\t Jo jatekot kivanok!");
        leir("<========================================================================================================================>");
        leir("");
        leir("\t --Nyomja meg az ENTERT a jatek inditasahoz--");
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

    }

    //A cserélt lámpákat rakja el
    public void modositottElemek(int sor, int oszlop) {
        boolean jelenlegiErtek = lampak[sor][oszlop];
        setLampakErtek(sor, oszlop, !jelenlegiErtek);
    }

    //Egy ciklus amí addig fog menni míg a benne lévő érték nem lesz igaz
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

    //A kiirtás leegyszerűsítése
    public void leir(String str) {
        System.out.println(str);
    }

    //Getterek és Setterek
    public int[][] getLampakDb() {
        return lampakDb;
    }

    public void setLampakDb(int[][] lampakDb) {
        this.lampakDb = lampakDb;
    }

    public boolean getAmigNulla() {
        return amigNulla;
    }

    public void getAmigNulla(boolean randomized) {
        amigNulla = randomized;
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

    public void setLampak(boolean[][] lampak) {
        this.lampak = lampak;
    }

    public boolean[][] getLampak() {
        return lampak;
    }

    public void setLampakErtek(int sor, int oszlop, boolean ertek) {
        this.lampak[sor][oszlop] = ertek;
        this.lampakDb[sor][oszlop] = ertek ? 1 : 0;
    }

}
