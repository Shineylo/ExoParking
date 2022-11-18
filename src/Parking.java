import java.util.HashMap;

public class Parking<V> {
    private int nbrPlace;
    private HashMap<Integer,V> batiment = new HashMap<Integer,V>();
    private static final int nbrPlaceMaxEtage = 20;
    private static final int nbrPlaceMax = 26 * nbrPlaceMaxEtage;


    public String ajouterVehicule(V vehicule){
        for (int i = 0; i<this.nbrPlaceMax;i++){
            if(!batiment.containsKey(i)){
                batiment.put(i,vehicule);
                return convPlace(i);
            }
        }
        throw new parkingPleinException();
    }

    public V retirerVehicule(String place){
        int etage = place.charAt(0)-'A';
        V vehicule = batiment.get(etage*nbrPlaceMaxEtage + Integer.parseInt(place.substring(1)));
        batiment.remove(etage*nbrPlaceMaxEtage + Integer.parseInt(place.substring(1)));
        return vehicule;
    }

    public V getVehicul(String place){
        int etage = place.charAt(0)-'A';
        V vehicule = batiment.get(etage*nbrPlaceMaxEtage + Integer.parseInt(place.substring(1)));
        return vehicule;
    }

    private String convPlace(int numPlace){
        char lettreEtage = (char) (numPlace/nbrPlaceMaxEtage + 'A');
        String nom ="";
        nom += lettreEtage;
        nom += numPlace%nbrPlaceMaxEtage;
        return nom;
    }

}
