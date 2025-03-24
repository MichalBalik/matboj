// importy potrebných knižnic pre spravne fungovanie programu
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class Metody {
    
    
    
    private int riadkyA;
    private int stlpceA;
    private int riadkyB;
    private int stlpceB;
   
   


    public Metody() {
        this.riadkyA = 0;
        this.stlpceA = 0;
        this.riadkyB =  0;
        this.stlpceB = 0;
    }    

    
    

    
    
    /**
     * Metoda sčitanie služi na sčitanie dvoch matic rovnakého typu, čiže podmienka najprv overi či matice majú rovnaky počet stlpcov a riadkov
     * a nasladne vykona sčitanie matic
     *
     * @param matice A parameter
     * @param matice2 A parameter
     */
    public  void scitanie(int [] []pole, int [][] pole2 )throws FileNotFoundException, IOException {


        int[][] scitanie = new int[100][100];
        
        System.out.println("\n---Sčítanie matice A+B=---");
        if (this.riadkyA == this.riadkyA && this.stlpceA == this.stlpceB) {
            for (int i = 0;i < this.riadkyA;i++) {
                for (int j = 0;j < this.stlpceB;j++) {
                    if (scitanie[i][j] >= 0) {
                        scitanie[i][j] = pole[i][j] + pole2[i][j];
                        System.out.print(" ");
                        System.out.printf("%4d", scitanie[i][j]);
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Matice niesu rovnakeho typu, ciže riadky a stlpce sa nezhoduju");
        } 
        this.moznost();

    }
    
    
    
    
    /**
     * Metoda odčitanie  služi na odčitanie dvoch matic rovnakého typu, čiže podmienka najprv overi či matice majú rovnaky počet stlpcov a riadkov
     * a nasladne vykona odčitanie  matic. Pri odčítaní matíc sa vypíšu 2 výsledky a to odčítanie matíc A -B, a odčítanie matíc B-A
     *
     * @param matice A parameter
     * @param matice2 A parameter
     */
    public  void odcitanie(int [] [] matice, int [][] matice2)throws FileNotFoundException, IOException {
        

        int[][] odcitanie = new int[100][100];
        int[][] odcitanie2 = new int[100][100];
        System.out.println("\n---Odčítanie matice A-B=---");
        if (this.riadkyA == this.riadkyB && this.stlpceB == this.stlpceB) {
            for (int i = 0;i < this.riadkyA;i++) {
                for (int j = 0;j < this.stlpceB;j++) {
                    if (odcitanie[i][j] >= 0) {
                        odcitanie[i][j] = matice[i][j] - matice2[i][j];
                        System.out.print(" ");
                        System.out.printf("%4d", odcitanie[i][j]); 
                    }
                }
                System.out.println();
            }
        }
        System.out.println("\n---Odčítanie matice B-A=---");
        if (this.riadkyA == this.riadkyB && this.stlpceA == this.stlpceB) {
            for (int i = 0; i < this.riadkyB; i++) {
                for (int j = 0; j < this.stlpceA; j++) {
                    if (odcitanie2[i][j] >= 0) {
                        odcitanie2[i][j] = matice2[i][j] - matice[i][j];
                        System.out.print(" ");
                        System.out.printf("%4d", odcitanie2[i][j]); 
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Matice niesu rovnakeho typu, čiže riadky a stlpce sa nezhodujú");

        }
        this.moznost();
    }
    
        
    
    
    /**
     * Metoda vypisMatice vypíše zadane matice do terminálu
     *
     * @param matice A parameter
     * @param matice2 A parameter
     */
    public  void  vypisMatice(int[][] matice, int [][]matice2) {
        System.out.println("\n---Vypis matice A=---");
        for (int a = 0; a < matice.length; a++) {
            System.out.println(Arrays.toString(matice[a]));
        }
        System.out.println("\n---Vypis matice B=---");
        for (int b = 0; b < matice2.length; b++) {
            System.out.println(Arrays.toString(matice2[b]));
        }
        
        this.riadkyA = matice.length;
        this.stlpceA = matice[0].length;
        this.riadkyB = matice2.length;
        this.stlpceB = matice2[0].length;
    }
    
    
    
    
    /**
     * Metoda násobenie dvoch matíc vykoná násobenie matice A a matice B za predpokladu, že je možne vynásobiť matice, to znamená, 
     * že podmienka kontroluje či sa počet riadkov matice A rovná počtu stĺpcov matice B
     *
     * @param matice A parameter
     * @param matice2 A parameter
     */
    public  void nasobenie(int[][] matice, int[][] matice2)throws FileNotFoundException, IOException { 
        
        //int riadkyA = matice.length; //zistenie riadkov matice A
        //int stlpceA = matice[0].length; // zistenie stlpcov matice A, ktore su rovnake ako riadky matice B
        //int riadkyB = matice2.length;
        //int stlpceB = matice2[0].length; //zistenie a uloženie počtu stlpcov maticeB
        
        int[][] nasobenie = new int[this.riadkyA][this.stlpceB];
        if (this.stlpceA == this.riadkyB) {
            System.out.println("\n---Násobenie matice AxB=---");
            for (int i = 0; i < this.riadkyA; i++) {
                for (int j = 0; j < this.stlpceB; j++) {
                    for (int k = 0; k < this.stlpceA; k++) {
                        nasobenie[i][j] = nasobenie[i][j] + matice[i][k] * matice2[k][j];
                    }

                    System.out.printf("%4d", nasobenie[i][j]); // formatovanie matice pre výpis
                }
                System.out.println();
            }
     
        } else {
            System.out.println("Nesprávne zadana matica");
        }
        this.moznost();
    }
   
    
        
    /**
     * Metoda determinant vracia hodnotu determinantu pre zadane matice 
     *
     * @param matice A parameter
     * @return The return value
     */
    public  int determinant(int [][] matice) {
        int det = 0;

        
        //int riadkyA = matice.length; //zistenie riadkov matice A
        //int stlpceA = matice[0].length; // zistenie stlpcov matice A, ktore su rovnake ako riadky matice B
        //int riadkyB = matice2.length;
        //int stlpceB = matice2[0].length; //zistenie a uloženie počtu stlpcov maticeB

        if (this.riadkyA == 1) {
            det = matice[0][0];
            return det;
        }

        if (this.riadkyA == 2) {
            det = matice[0][0] * matice[1][1] - matice[0][1] * matice[1][0];
            return det;
        }

        for (int i = 0;i < this.stlpceB;i++) {
            int[][] pomocna = new int [matice.length - 1][matice[0].length - 1];
            for (int j = 1;j < matice.length; j++) {
                for (int k = 0;k < this.stlpceA; k++) {
                    if (k < i) {
                        pomocna[j - 1][k] = matice[j][k];
                    } else 
                        if (k > i) {
                            pomocna[j - 1][k - 1] = matice[j][k];
                        }
                }
            }
            det += matice[0][i] * Math.pow(-1, (int)i) * this.determinant(pomocna);

        }
        return det;

    }
    
    
   
    /**
     * Metoda transponovaná spraví transponovane matice A a B  zámenou riadkov za stĺpce
     *
     * @param matice A parameter
     * @param matice2 A parameter
     */
    public  void transponovana(int [][] matice, int[][] matice2)throws FileNotFoundException, IOException {
        int[][] transpose = new int[100][100];
        int[][] transpose2 = new int[100][100];

        System.out.println("\n---Transponovanie matice A a B=---");
        System.out.println("\nMatica A transponovana:");  
        for (int i = 0;i < this.stlpceB; i++) {
            for (int j = 0;j < this.riadkyA;j++) {
                System.out.printf("%4d", matice[j][i]);
            }
            System.out.print("\n");

        }

        System.out.println("\nMatica B transponovana:");  
        for (int i = 0;i < this.stlpceB;i++) {
            for (int j = 0;j < this.riadkyB; j++) {         
                System.out.printf("%4d", matice2[j][i]);

            }
            System.out.print("\n");

        }
        this.moznost();
    }
    

    /**
     * Metoda možnosť slúži  na rozhodnutie ci sa program ma zopakovať alebo sa nemá zopakovať čiže vypnúť. 
     *
     */
    public  void moznost()throws FileNotFoundException, IOException {
        String []args = null;
        int skuska = 0;
        String  pokracovanie;
        Scanner skener = new Scanner(System.in);
        System.out.println("------------------------");
        System.out.println("Zopakovať program?");
        System.out.println("Vyber moznost Ano[1] , Nie[0]");
        do {

            pokracovanie = skener.nextLine();

            if (pokracovanie.isEmpty()) { 
                skuska = 2;
                System.out.println("Zadaj to znovu,lebo si zadal medzeru"); 
            } else
                if ((pokracovanie.charAt(0) > '1') || (pokracovanie.charAt(0) < '0')) { 
                    skuska = 2;
                } else { 
                    skuska = 1; 
                }
            
        } while(skuska == 2);
        
        int operacia = Integer.parseInt(pokracovanie);

        if (operacia == 1) {
         
            Program.main(args);
        } else {
            System.exit(0); 
        }
    }
    
   
   
    
    /**
     * Metoda gaus slúži na vypočítanie matice gaustovským spôsobom 
     *
     * @param matice A parameter
     * @return gaus
     */
    public  double[][] gaus(int[][] matice) {
        double[][] gaus = new double[matice.length][matice[0].length];

        
        for (int r = 0; r < gaus.length; ++r) {
            for (int c = 0; c < gaus[r].length; ++c) {
                gaus[r][c] = matice[r][c];
            }
        }

        for (int p = 0; p < gaus.length; ++p) {
            
            double pv = gaus[p][p];
            if (pv != 0) {
                double pvInv = 1.0 / pv;
                for (int i = 0; i < gaus[p].length; ++i) {
                    gaus[p][i] *= pvInv;
                }
            }

            
            
            for (int r = 0; r < gaus.length; ++r) {
                if (r != p) {
                    double f = gaus[r][p];
                    for (int i = 0; i < gaus[r].length; ++i) {
                        gaus[r][i] -= f * gaus[p][i];
                    }
                }
            }
        }

        return gaus;
    }
    
    
    /**
     * Metoda hodnost1 slúži na výpočet hodnosti zadaných matíc, čiže počet nenulových riadkov matíc
     *
     * @param matice A parameter
     * @param matice2 A parameter
     */
    public  void hodnost1(int[][] matice, int[][] matice2) {
        double[][] hodn = this.gaus(matice);
        boolean nula = false;
        int hodnost = this.riadkyA;
        int pocetnul = 0;

        for (int i = 0; i < matice.length; i++) {
            
            for (int j = 0; j < matice[0].length; j++) {

                if (hodn[i][j] == 0) {
                    pocetnul++;
                }

            }

            //if (pocetnul == matice[0].length) {
             //   hodnost--;
            //}

        }
        System.out.println("");
        System.out.println("Hodnosť matice A je: \n" + "H= " + hodnost);
        
        
        double[][] hodno = this.gaus(matice2);
        boolean nulaa = false;
        int hodnost2 = matice2.length;
        int pocetnul2;
        pocetnul2 = 0;
        for (int i = 0; i < matice2.length; i++) {
            
            for (int j = 0; j < matice2[0].length; j++) {

                if (hodno[i][j] == 0) {
                    pocetnul2++;
                }

            }

            if (pocetnul == matice2[0].length) {
                hodnost2--;
            }

        }
        System.out.println("");
        System.out.println("Hodnosť matice B je: \n" + "H= " + hodnost2);
    }
   
    
    //metóda pre výpís determinantu 
    /**
     * Metoda vypisdet slúži na vypísanie determinantu matíc
     *
     * @param matice A parameter
     * @param matice2 A parameter
     */
    public  void vypisdet(int[][] matice, int[][] matice2)throws FileNotFoundException, IOException {

        
        if (this.riadkyA == this.stlpceA) {
            System.out.println("Determinant matice A=" + this.determinant(matice)); 
        } else {
            System.out.println("Matica A nieje rovnakeho typu, determinant nieje mozne určiť");
        }
        if (this.riadkyB == this.stlpceB) {
            System.out.println("Determinant matice B=" + this.determinant(matice2));
        } else {
            System.out.println("Matica B nieje rovnakeho typu, determinant nieje mozne určiť");
        }

        
        this.moznost();
    }
    
    
    
     //metóda pre výpočet Inverznej matice
    /**
     * Metoda inverzná slúži na vypočítanie inverzných matíc k zadaným maticiam
     *
     * @param matice A parameter
     */
    public  void inverzna(int[][] matice)throws FileNotFoundException, IOException {

        double[][] a = new double[this.riadkyA][this.stlpceA];
        int n = a.length;
        if (this.riadkyA == this.stlpceA) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    a[i][j] = matice[i][j];
                }
            }
            double[][] d = this.invert(a);
        
        
            for (int i = 0; i < n; ++i) {
          
                for (int j = 0; j < n; ++j) {
                    if (d[i][j] > 0) {
                        System.out.print(" ");
                        System.out.printf(" %1$2.2f", d[i][j]);
                    }
                }
                    
                System.out.println();
        
        
            }
        }   else {
            System.out.println("Matica nieje adekvátna tj štvorcová");
        }
        this.moznost();
    }

    
    /**
     * Metoda invert služi na transformaciu matice do horného trojuholnika
     *
     * @param a A parameter
     * @return The return value
     */
    public  double[][] invert(double[][] a) {
        int n = a.length;
        double[][] x = new double[n][n];
        double[][] b = new double[n][n];
        int[] index = new int[n];
        for (int i = 0; i < n; ++i) { 
            b[i][i] = 1;
        }

        // Transformácia matice do horného trojuholníka
        this.gaussian(a, index);

    
        // Aktualizácia matice B [i][j] s uložením koeficientom
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int  k = 0; k < n; ++k) {
                    b[index[j]][k]
                        -= a[index[j]][i] * b[index[i]][k];
                }
            }
        }
            

        // Vykonanie spätnej substitúcie
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= a[index[j]][k] * x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }


    /**
     * Metoda gaussian služi na vypočet pomocou gausovej eliminačnej metody
     *
     * @param a A parameter
     * @param index A parameter
     */
    public  void gaussian(double[][] a,
    int []index) {
        int n = index.length;
        double[] c = new double[n];

        // Inicializácia indexu
        for (int i = 0; i < n; ++i) { 
            index[i] = i;
        }

        // Nájde prepočítane faktory pre každý riadok
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) { 
                    c1 = c0; 
                }
            }
            c[i] = c1;
        }

        // Nájde vedúci prvok pre každý stlpec
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Výmena riadkov podľa vedúceho prvku
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];

                // Načítanie vodiaceho prvku do diagonály
                a[index[i]][j] = pj;

                // Uprava dalších prvkov
                for (int l = j + 1; l < n; ++l) {
                    a[index[i]][l] -= pj * a[index[j]][l];
                }
            }

        }
    
    }
}
