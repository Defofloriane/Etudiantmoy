import java.text.BreakIterator;
import java.util.Date;
import java.util.Scanner;

public class Etudiant {
    private String matricule;
    private String nom;
    private char genre;
    private Date dateDeNaissance;
   public double moyenne;



    public Etudiant(String matricule, String nom, char genre,double moyenne) {
        this.matricule = matricule;
        this.nom = nom;
        this.genre = genre;
        this.dateDeNaissance = dateDeNaissance;
        this.moyenne=moyenne;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
    public  String afficher(){
        return "Etudiant{" +
                "matricule='" + this.matricule + '\'' +
                ", nom='" + this.nom + '\'' +
                ", genre=" + this.genre +
                ", dateDeNaissance=" + this.dateDeNaissance +
                ", moyenne=" + this.moyenne +
                '}';
    }
    public double bonifier(double bonus){
        return moyenne +=bonus;
    }
    public int calculerage(int age){
        age= new Date().getYear()-dateDeNaissance.getYear();
        return age;
    }
    public void sortirprog(){

    }
    public static void chargement()
    {
        Scanner saisie = new Scanner(System.in);
        System.out.println("entrer l effectif ");
        int effectif = saisie.nextInt();
        Etudiant[] etudiant = new Etudiant[effectif];
       // double note[] = new double[effectif];

        //enregistement des n etudiants dans un tableau

        for (int i = 0; i < effectif; i++) {

            saisie.nextLine();
            System.out.println("entrer les informations sur de L etudiant N" + (i + 1) + " matricule/nom/genre/moyenne ");
            etudiant[i] = new Etudiant(saisie.next(), saisie.next(), saisie.next().charAt(0),saisie.nextDouble());
            Scanner cl=new Scanner(System.in);
            //System.out.println("confirmer sa moyenne");

           // note[i] = cl.nextDouble();
//            if (note[i]!= cl.nextDouble()){
//                System.out.println("reveriez la moyenne de l etudiant");
//            }




        }
        for (int i = 0; i < effectif; i++) {
            System.out.println( etudiant[i].afficher());
        }

        char rep;
        System.out.println("   **************MEMU****************");
     //   do {
        System.out.println("1-Afficher les etudiants par ordre de merite");
        System.out.println("2-Afficher les informations sur le premier etudiants ");
        System.out.println("3-Afficher les informations sur le dernier etudiants ");
        System.out.println("4-Reinitialiser la liste de la classe");
        System.out.println("5-Sortir du programme");
        System.out.println("   ***********************************");
        Scanner clavier=new Scanner(System.in);
        System.out.println(" entrer votre choix");
        int choix= clavier.nextInt();
        double maxnote=0;
        double maxnoten=0;
        String premier="";
        String dernier="";

        double max=0;
            switch (choix){
                case 1:
                    System.out.println("les informations Des etudiants par ordre de merite");
                    for (int i = 0; i <etudiant.length; i++) {
                       maxnote=etudiant[i].moyenne;
                       for (int j=i+1;j< etudiant.length;j++){
                           if (etudiant[j].moyenne>etudiant[i].moyenne){
                               double tmp =etudiant[i].moyenne;
                               etudiant[i].moyenne=etudiant[j].moyenne;
                               etudiant[j].moyenne=tmp;

                           }
                       }

                       // System.out.println(max);
                   System.out.println(etudiant[i].afficher());

                    }

                    break;
                case 2:
                        int i;
                        for ( i = 0; i < effectif; i++) {
                            if (maxnote<etudiant[i].moyenne){
                                maxnote=etudiant[i].moyenne;
                                premier=etudiant[i].afficher();
                            }
                        }
                        System.out.println("les informations sur le premier etudiants");
                        System.out.println( premier);
                        //System.out.println( etudiant[i].afficher());
                    break;
                case 3:
//                    for (int k = 0; k <etudiant.length; k++) {
//                        maxnoten=etudiant[k].moyenne;
//                        for (int l=k+1;l< etudiant.length;l++){
//                            if (etudiant[l].moyenne < etudiant[l].moyenne){
//                                double tmp =etudiant[k].moyenne;
//                                etudiant[k].moyenne=etudiant[l].moyenne;
//                                etudiant[l].moyenne=tmp;
//
//                            }
//                        }
//
//                        // System.out.println(max);
//                        System.out.println(etudiant[k].afficher());

//                    }


                    break;
                case 4:
                    System.out.println("Reinitialiser la liste de la classe");
                    Scanner text = new Scanner(System.in);
                    System.out.println("entrer le nouvel  effectif  de la classe  ");
                    int neweffectif = saisie.nextInt();
                    Etudiant[] newetudiant = new Etudiant[neweffectif];
                    double notes[] = new double[effectif];

                    //enregistement des n etudiants dans un tableau

                    for (int j = 0; j < effectif; j++) {

                        saisie.nextLine();
                        System.out.println("entrer les informations sur de L etudiant N" + (j+ 1) + " matricule/nom/genre/moyenne ");
                        newetudiant[j] = new Etudiant(saisie.next(), saisie.next(), saisie.next().charAt(0),saisie.nextDouble());
                        Scanner cla=new Scanner(System.in);
                        System.out.println("confirmer sa moyenne");

                        etudiant[j].moyenne = cla.nextDouble();
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("votre choix n est pas inscrit sur le menu");
            }
//        System.out.println("voulez vous reacceder au menu O/N");
//            saisie.nextLine();
//        rep =saisie.nextLine().toUpperCase().charAt(0);
//
//        }while (rep != 'N');

    }

//  public static void MeriteEtudiant(){
////        for (int i = 0; i < effectif; i++) {
////            System.out.println( etudiant[i].afficher());
////        }
//       System.out.println("MeriteEtudiant");
//   }
//    public static void InfoFirstEtudiant(){
//        System.out.println("InfoFirstEtudiant");
//    }
//    public static void InfoEndEtudiant(){
//        System.out.println("InfoEndEtudiant");
//    }
//    public static void ReinitialiserListe(){
//        System.out.println("ReinitialiserListe");
//    }
//    public static void Sortiprog(){
//        System.out.println("Sortir du programme");
//    }


//
//    public static void Menu(){
//        System.out.println("   **************MEMU****************");
//        System.out.println("1-Afficher les etudiants par ordre de merite");
//        System.out.println("2-Afficher les informations sur le premier etudiants ");
//        System.out.println("3-Afficher les informations sur le dernier etudiants ");
//        System.out.println("4-Reinitialiser la liste de la classe");
//        System.out.println("5-Sortir du programme");
//        System.out.println("   ***********************************");
//        Scanner clavier=new Scanner(System.in);
//        System.out.println(" entrer votre choix");
//        int choix= clavier.nextInt();
//        switch (choix){
//            case 1:MeriteEtudiant();
//                break;
//            case 2:InfoFirstEtudiant();
//                break;
//            case 3:InfoEndEtudiant();
//                break;
//            case 4: ReinitialiserListe();
//                break;
//            case 5:Sortiprog();
//                break;
//            default:
//                System.out.println("votre choix n est pas inscrit sur le menu");
//        }
//    }
}
