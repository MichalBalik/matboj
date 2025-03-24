import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Random;


public class Menu {
    
    private int riadkyA;
    private int stlpceA;
    private int riadkyB;
    private int stlpceB;
    private String skuska;
    private int pokracovanie;
    private Metody metody;        
    private int [][] pole;
    private int [][] pole2;
    private  Random generator; 

    public Menu() {
        
        this.riadkyA = 0;
        this.stlpceA = 0;
        this.riadkyB = 0;
        this.stlpceB = 0;
        this.skuska = null;
        this.pokracovanie = 0;
        this.metody = new Metody();
        this.generator = new Random();
        

    }
    
    /**
     * Metoda menu sluzi na zadavanie inforamacii do systemu a hlavnu algoritmizaciu programu
     *
     */
    public void menu()throws FileNotFoundException, IOException  {
        // Scanner skener = new Scanner (System.in);

        Scanner skener = new Scanner(System.in);


        System.out.println("\f-----------------------Vitaj v programe MatBoj-----------------------");
        System.out.println("MatBoj je skratka pre program Maticovy boj ");
        System.out.println("Tento program je skvelym pomocnikom pre opereacie s maticami");
        System.out.println("Medzi zakldane funkcie programu patri + , -, *, / matic");
        System.out.println("Medzi pokročile funkcie patri: Zistenie determinantu,\ntransponovanie matic, inverzia matic a hodnoť matic");
        System.out.println("-----------------------------------------------------------------------");
        
        
        System.out.println("Zadajte udaje pre maticu A");
       
        //Zadanie velkosti matic aj s overenim na ciselnu hodnotu
        do {
            do {
                System.out.print("Zadajte pocet riadkov matice A :");
                this.skuska = skener.nextLine();

                if (((this.skuska.length() > 1) || (this.skuska.length () < 1)) && this.pokracovanie != 2) {

                    System.out.println("Chybne zadany udaj, zadajte ho znovu lebo ste zadali medzeru");
                    this.pokracovanie = 2;
                }

                if ((this.skuska.isEmpty())) {
                    this.pokracovanie = 2;
                    System.out.println("Chybne zadany udaj, zadajte ho znovu lebo ste zadali medzeru");
                } else {

                    if (( this.skuska.charAt (0) > '9' ) || ( this.skuska.charAt(0) < '0' )) {
                        this.pokracovanie = 2;
                    } else {
                        this.pokracovanie = 1;
                    }
                }

                if (this.skuska.length() > 1) {
                    if ((this.skuska.charAt(1) > '9') || (this.skuska.charAt(1) < '0')) {
                        this.pokracovanie = 2;
                    } else {
                        this.pokracovanie = 1; 
                    }
                }
            } while(this.pokracovanie == 2);
            this.riadkyA = Integer.parseInt(this.skuska); //prekonvertovanie Stringu na Integer
        } while(this.riadkyA > 100);

        //zadanie poctu stlpcov s overením len pre numericku hodnotu 
        do {
            do {
                System.out.print("Zadaj počet stlpcov matice A :");
                this.skuska = skener.nextLine();
                if ((this.skuska.isEmpty())) {
                    this.pokracovanie = 2;
                    System.out.println("Chybne zadany udaj, zadajte ho znovu lebo ste zadali medzeru");
                } 
                
                if ((this.skuska.charAt(0) > '9') || (this.skuska.charAt(0) < '0')) {
                    this.pokracovanie = 2; 
                } else {
                    this.pokracovanie = 1; 
                }
            } while(this.pokracovanie == 2);
            this.stlpceB = Integer.parseInt(this.skuska);
        } while(this.stlpceB > 100);

        System.out.print("Zadaj udaje pre maticu B=\n");
        this.pole = new int[this.riadkyA][this.stlpceB];

        //zadanie poctu riadkov s overením len pre numericku hodnotu 
        do {
            do {
                System.out.print("Zadaj počet riadkov matice B :");
                this.skuska = skener.nextLine();
                if ((this.skuska.isEmpty())) {
                    this.pokracovanie = 2;
                    System.out.println("Zadaj to znovu,lebo si zadal medzeru");
                } else
                    if ((this.skuska.charAt(0) > '9') || (this.skuska.charAt(0) < '0')) {
                        this.pokracovanie = 2;
                    } else {
                        this.pokracovanie = 1;
                    }
            } while(this.pokracovanie == 2);
            this.riadkyB = Integer.parseInt(this.skuska);
        } while(this.riadkyB > 100);

        //zadanie poctu stlpcov s overením len pre numericku hodnotu 
        do {
            do {
                System.out.print("Zadaj počet stlpcov matice B :");
                this.skuska = skener.nextLine();
                if ((this.skuska.isEmpty())) {
                    this.pokracovanie = 2;
                    System.out.println("Zadaj to znovu,lebo si zadal medzeru");
                } else 
                    if ((this.skuska.charAt(0) > '9') || (this.skuska.charAt(0) < '0')) {
                        this.pokracovanie = 2;
                    } else {
                        this.pokracovanie = 1;
                    }
            } while(this.pokracovanie == 2);
            this.stlpceB = Integer.parseInt(this.skuska);
        } while(this.stlpceB > 100);

        this.pole2 = new int[this.riadkyB][this.stlpceB]; //deklaracia poľa

        //metody.nahodenieudajov (riadkyA, stlpceA, riadkyB, stlpceB);
        do {
            System.out.println("\nAku metodu načitania chceš? [1]Generovanie,[2]Z klávesnice");
            this.skuska = skener.nextLine();  
            
            if ((this.skuska.isEmpty())) {
                this.pokracovanie = 2;
                System.out.println("Zadaj to znovu,lebo si zadal medzeru");
            } else
                if ((this.skuska.charAt(0) > '3') || (this.skuska.charAt(0) < '1')) {
                    this.pokracovanie = 2;
                } else { 
                    this.pokracovanie = 1;
                }
        } while(this.pokracovanie == 2);
        
        
        int metoda = Integer.parseInt(this.skuska);
        
        switch(metoda) {
            case 1: //Generovacia prvkov v matici A
                for ( this.riadkyA = 0; this.riadkyA < this.pole.length; this.riadkyA++) {        // cyklus pre “riadky”
                    for (this.stlpceB = 0; this.stlpceB < this.pole[this.riadkyA].length ; this.stlpceB++) {   // cyklus pre “stĺpce”
                        this.pole[this.riadkyA][this.stlpceB] = this.generator.nextInt(10);  // vygenerovanie náhod. čísla 
                    }
                }   
                
                //Generovacia prvkov v matici B
                for (this.riadkyB = 0; this.riadkyB < this.pole2.length; this.riadkyB++) {        // cyklus pre “riadky”
                    for (this.stlpceB = 0; this.stlpceB < this.pole2[this.riadkyB].length; this.stlpceB++) {   // cyklus pre “stĺpce”
                        this.pole2[this.riadkyB][this.stlpceB] = this.generator.nextInt(10);  // vygenerovanie náhod. čísla 
                    }   
                }
                break;
            case 2: // nacitavanie hodnôt z klávesnice pre maticu A
                System.out.println("Zadaj hodnoty matice A[][]: ");
                for ( this.riadkyA = 0; this.riadkyA < this.pole.length; this.riadkyA++) {        // cyklus pre “riadky”
                    for ( this.stlpceB = 0; this.stlpceB < this.pole[this.riadkyA].length ; this.stlpceB++) {   // cyklus pre “stĺpce”
                        System.out.print("Zadaj pole[" + this.riadkyA + "," + this.stlpceB + "]: ");
                        this.pole[this.riadkyA][this.stlpceB] = skener.nextInt();  // zadanie z klavesnice
                    }
                }   
                
                // nacitavanie hodnôt z klávesnice pre maticu B
                System.out.println("Zadaj hodnoty matice B[][]: ");
                for (this.riadkyB = 0; this.riadkyB < this.pole2.length; this.riadkyB++) {        // cyklus pre “riadky”
                    for (this.stlpceB = 0; this.stlpceB < this.pole2[this.riadkyB].length; this.stlpceB++) {   // cyklus pre “stĺpce”
                        System.out.print("Zadaj pole[" + this.riadkyB + "," + this.stlpceB + "]: ");
                        this.pole2[this.riadkyB][this.stlpceB] = skener.nextInt();  // zadanie z klavesnice
                    }
                }
                break;

            
            
            default: 
                System.out.println("Takuto funkciu neovládam");
                this.metody.moznost();
                break;
        }

        this.metody.vypisMatice(this.pole, this.pole2);
        System.out.println("------------------------");
        System.out.println("Aku operaciu s maticami chceš vykonať?");
        System.out.println("Scitanie - Stlac 1");
        System.out.println("Odcitanie - Stlac 2");
        System.out.println("Nasobenie - Stlac 3");
        System.out.println("Determinant - Stlac 4");
        System.out.println("Transponovana - Stlac 5");
        System.out.println("Inverzna - Stlac 6");
        System.out.println("Hodnost - Stlac 7");
        System.out.println("------------------------");

        //Zadanie operacie z klávesnice + ošetrenie vstupu len pre numericku hodnotu
        do {
            System.out.println("Zadaj operáciu:");
            this.skuska = skener.nextLine();
            if ((this.skuska.isEmpty())) {
                this.pokracovanie = 2;
                System.out.println("Zadaj to znovu,lebo si zadal medzeru"); 
            } else 
                if ((this.skuska.charAt(0) > '7') || (this.skuska.charAt(0) < '1')) {
                    this.pokracovanie = 2; 
                }    else  { 
                    this.pokracovanie = 1; 
                } 
            
         
            
        } while(this.pokracovanie == 2);
        int operacia = Integer.parseInt(this.skuska);

        //switch pre menu s možními operaciami
        switch(operacia) {
            case 1:
                
                this.metody.scitanie(this.pole, this.pole2);
              
                break;
            case 2:
                this.metody.odcitanie(this.pole, this.pole2);
                break;
            case 3:
                this.metody.nasobenie(this.pole, this.pole2);
                break;
            case 4:
                this.metody.vypisdet(this.pole, this.pole2);
                break;
            case 5:
                this.metody.transponovana(this.pole, this.pole2);
                break;
            case 6:
                this.metody.inverzna(this.pole);
                break;
            case 7:
                this.metody.hodnost1(this.pole, this.pole2);
                break;
            default: 
                this.metody.moznost();
                break;
        }

    }
}

