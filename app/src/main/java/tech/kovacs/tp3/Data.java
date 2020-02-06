package tech.kovacs.tp3;

import java.util.ArrayList;

public class Data {

    private ArrayList<String> planetes;

    public ArrayList<String> getPlanetes() {
        return planetes;
    }

    public void setPlanetes(ArrayList<String> planetes) {
        this.planetes = planetes;
    }

    private void installePlanetes() {
        planetes = new ArrayList<String>();
        planetes.add("Mercure");
        planetes.add("Venus");
        planetes.add("Terre");
        planetes.add("Mars");
        planetes.add("Jupiter");
        planetes.add("Saturne");
        planetes.add("Uranus");
        planetes.add("Neptune");
        planetes.add("Pluton");
    }



    public Data(){

        installePlanetes();
    }




}
