package tech.kovacs.tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data {

    private ArrayList<String> planetes;
    private HashMap taillePlanetes;

    public int getTaille(String planeteName){return (int) taillePlanetes.get(planeteName);}

    public ArrayList<String> getPlanetes() {
        return planetes;
    }
    public String getPlanete(int i ){return planetes.get(i);}

    public void setPlanetes(ArrayList<String> planetes) {
        this.planetes = planetes;
    }

    // The usage of the Map standalone would have been better than using the map and the arrayList
    private void installePlanetes() {
        planetes = new ArrayList<String>();
        planetes.add("Mercure");
        taillePlanetes.put("Mercure",4900);
        planetes.add("Venus");
        taillePlanetes.put("Venus",12000);
        planetes.add("Terre");
        taillePlanetes.put("Terre", 12800);
        planetes.add("Mars");
        taillePlanetes.put("Mars", 6800);
        planetes.add("Jupiter");
        taillePlanetes.put("Jupiter",144000);
        planetes.add("Saturne");
        taillePlanetes.put("Saturne",120000);
        planetes.add("Uranus");
        taillePlanetes.put("Uranus",52000);
        planetes.add("Neptune");
        taillePlanetes.put("Neptune",50000);
        planetes.add("Pluton");
        taillePlanetes.put("Pluton",2300);
    }



    public Data(){
        taillePlanetes = new HashMap();
        installePlanetes();

    }




}
