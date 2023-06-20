package lightonconsole;

public class LightOnConsole {

     public static void main(String[] args) {
        foProgram();
    }

    private static void foProgram() {
        kapcsolasokMegjelenese();
    }

    private static void kapcsolasokMegjelenese() {
         //Lampak lampak = new Lampak();
         Kapcsolasok K = new Kapcsolasok();
         K.beolvasas();

    }
    
    

}
