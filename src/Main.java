public class Main {
    public static void main(String[] args) {
        Parking<Voiture> liva = new Parking<Voiture>();
        Voiture bryan = new Voiture("Bryan","Penetrator");
        try{
            System.out.println(liva.ajouterVehicule(bryan));
            Vehicule remove = liva.retirerVehicule("A0");
        }
        catch (RuntimeException ex){
            System.out.println( ex.getMessage() );
        }
    }
}