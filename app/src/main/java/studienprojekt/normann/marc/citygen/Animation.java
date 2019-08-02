package studienprojekt.normann.marc.citygen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marc Normann on 10.04.2018.
 * Added Prolog support and rule management on 18.01.2019
 * Pics added by Sophie Grusenick on 16.07.2019
 */

public class Animation extends AppCompatActivity {

    HashMap<String, HashMap<String, String>> tools;

    /*
    private int count;
    HashMap<String, HashMap<String, String>> tools;
    HashMap<String, HashMap<String, Boolean>> solutions =new HashMap<>();
    String dataDirPath;
    Integer[] tViewIDs = {
            R.id.A1, R.id.A2, R.id.A3, R.id.A4, R.id.A5,
            R.id.B1, R.id.B2, R.id.B3, R.id.B4, R.id.B5,
            R.id.C1, R.id.C2, R.id.C3, R.id.C4, R.id.C5,
            R.id.D1, R.id.D2, R.id.D3, R.id.D4, R.id.D5,
            R.id.E1, R.id.E2, R.id.E3, R.id.E4, R.id.E5,
            R.id.F1, R.id.F2, R.id.F3, R.id.F4, R.id.F5,
            R.id.G1, R.id.G2, R.id.G3, R.id.G4, R.id.G5,
            R.id.H1, R.id.H2, R.id.H3, R.id.H4, R.id.H5,
            R.id.I1, R.id.I2, R.id.I3, R.id.I4, R.id.I5,
            R.id.J1, R.id.J2, R.id.J3, R.id.J4, R.id.J5,
    };
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_new);

       try {
            Intent intent = getIntent();
            Context context = getApplicationContext();
            tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");
            /*
            PackageManager pm = context.getPackageManager();
            dataDirPath = getPackageName();
            PackageInfo p = pm.getPackageInfo(dataDirPath, 0);
            dataDirPath = p.applicationInfo.dataDir;
            Log.d("INFO","DataDir: "+dataDirPath);
             */
        } catch (Exception e) {
           Log.w("ERROR", "Error Message: ", e);
       }

    }

        public void onClick(View v) {

            AnalyticsTool at = new AnalyticsTool(this.getBaseContext());
            HashMap<String, Boolean> prologSolutions = at.analyse(tools);
            StringBuilder sb = new StringBuilder();
            for(String rule: prologSolutions.keySet()){
                sb.append(rule);
                sb.append("  ");
            }

            RecyclerView recyclerView = (RecyclerView)findViewById(R.id.pics);
            recyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),5);
            recyclerView.setLayoutManager(layoutManager);

            ArrayList<Pics_Liste> createLists = prepareData();
            Pics_Adapter adapter = new Pics_Adapter(getApplicationContext(), createLists);
            recyclerView.setAdapter(adapter);

        }

        private ArrayList<Pics_Liste> prepareData(){


            AnalyticsTool at = new AnalyticsTool(this.getBaseContext());
            HashMap<String, Boolean> prologSolutions = at.analyse(tools);
            StringBuilder sb = new StringBuilder();
            for(String rule: prologSolutions.keySet()){
                sb.append(rule);
                sb.append("  ");
            }

            HashMap<String, Integer> map = new HashMap<String, Integer>();
            //Barriers
            map.put("barriersVisualCover(ng1).",R.drawable.barrieren_sichtschutz);
            map.put("barriersKinkingPassage(ng1).",R.drawable.barrieren_mehrfach_abknickende_durchgaenge);
            //Building Structure
            map.put("trailer(ng1).",R.drawable.baustruktur_bauwagen);
            map.put("useStock(ng1).",R.drawable.baustruktur_bestand);
            //Dynamic of user group
            map.put("userGroupFlexibility(ng1).",R.drawable.dynamik_der_nutzergruppe_vernetzung);
            //map.put("privateRoom(ng1).","");
            //Infrastructure
            map.put("infrastructureStreets(ng1).",R.drawable.infrastruktur_strasse);
            map.put("infrastructurePaths(ng1).",R.drawable.infrastruktur_weg);
            map.put("infrastructureBicyclePath(ng1).",R.drawable.infrastruktur_radweg);
            map.put("infrastructureWoodsAndSees(ng1).",R.drawable.infrastruktur_wald_see);
            //map.put("infrastructureBroadStreet(ng1).","");
            map.put("infrastructureAverageRoad(ng1).",R.drawable.infrastruktur_strasse_mittel);
            //map.put("infrastructureSmallRoads(ng1).","");
            //map.put("infrastructureWaterSupplyLocation(ng1).","");
            //map.put("infrastructurePowerSupplyLocation(ng1).","");
            map.put("infrastructureTrafficNetwork(ng1).",R.drawable.infrastruktur_verkehrskonzept);
            //Interference usage pattern
            map.put("interferenceUsagePatternSeparationLiving(ng1).",R.drawable.interferenz_nutzungsmuster_wohneinheit);
            map.put("interferenceUsagePatternSeparationBusiness(ng1).",R.drawable.interferenz_nutzungsmuster_atelier);
            //Spots
            map.put("spots(ng1).",R.drawable.spots_landmarks_sammelplatz);
            //Universal space concept
            map.put("universalSpaceConceptNoAnimalFarming(ng1).",R.drawable.universelle_raumlehren_agrarflaeche);
            map.put("universalSpaceConceptFreeSchool(ng1).",R.drawable.interferenz_nutzungsmuster_schule);
            map.put("universalSpaceConceptSeminarCenter(ng1).",R.drawable.interferenz_nutzungsmuster_hotel_seminar);
            map.put("universalSpaceConceptFarmShop(ng1).",R.drawable.universelle_raumlehren_hofladen);
            map.put("universalSpaceConceptWindmill(ng1).",R.drawable.universelle_raumlehren_windrad);
            map.put("universalSpaceConceptPhotovoltaicModule(ng1).",R.drawable.universelle_raumlehren_solarpanel);
            map.put("universalSpaceConceptCourtyard(ng1).",R.drawable.universelle_raumlehren_innenhof);
            map.put("universalSpaceConceptStaircase(ng1).",R.drawable.universelle_raumlehren_feng_shui);
            map.put("universalSpaceConceptSpine(ng1).",R.drawable.universelle_raumlehren_belueftung_horiz_achse);

            List<Integer> list = new ArrayList<Integer>();
            // die zutreffenden Regeln werden mit dem Hash (in dem sich die Bilder befinden) verglichen
            // alle Symbole, bei der die Regel zutrifft, werden in ein Array geschrieben
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (sb.toString().contains(entry.getKey())) {
                    list.add(entry.getValue());
                }
            }
            ArrayList<Pics_Liste> theimage = new ArrayList<>();
            for(int i = 0; i< list.toArray().length; i++){
                Pics_Liste createList = new Pics_Liste();
                createList.setImage_ID(list.get(i));
                theimage.add(createList);
            }
            return theimage;
        }

    public void createAlternative(View view){
        //Prolog Questions

        AnalyticsTool at = new AnalyticsTool(this.getBaseContext());
        HashMap<String, Boolean> prologSolutions = at.analyse(tools);
        String information="";
        StringBuilder sb = new StringBuilder();
        sb.append("Regeln die zutreffen: \n");
        for(String rule: prologSolutions.keySet()){
            sb.append(rule);
            sb.append(" → ");
            sb.append("true");
            sb.append(" \n ");
        }
        sb.append(" \n ausgewählte Variablen: \n");
        information = sb.toString();
        Intent intent = new Intent(this, Info_window.class);
        intent.putExtra("info", information);
        intent.putExtra("tools", tools);



        startActivity(intent);

        /*
         * Only to test the prolog integration.

        at.setNewPrologTheory(  "cats(katze).\n" +
                                "cats(katze2).\n" +
                                "allergy(person,cats)."
                             );

        at.setNewPrologTheory("compression(ng1). \n"+ "buildingUsable(ng1). \n" + "annex(ng1). \n" +"extension(ng1). \n"+"notMaxDensity(ng1).");
        at.setNewPrologTheory("emptySpace(ng1).\n userGroupFlexible(ng1).\n newBuilding(ng1).\n "+
        "networking(ng1).\n lowDensity(ng1).\n villageStructure(ng1).");
        //at.setNewPrologTheory("networkingRegional(ng1). \n" +"networkingHigh(ng1).");
        //boolean move = at.getPrologAnswer("move(person1,person2).");
        boolean move = at.getPrologAnswer("move(person,katze).");
        boolean density = at.getPrologAnswer("lowDensity(ng1).");

        boolean useStock = at.getPrologAnswer("useStock(ng1).");
        boolean trailer = at.getPrologAnswer("trailer(ng1).");

        solutions.put("move",new HashMap<String, Boolean>());
        //List<Boolean> solutions = new ArrayList<>();

        if (!move) {
            System.out.println("Niemand muss ausziehen!");
            solutions.get("move").put("move(person,katze).",false);
        }
        if (move){
            move = at.getPrologAnswer("moveIntoGarden(katze).");
            System.out.println("Katze zieht in Garten");
            solutions.get("move").put("moveIntoGarden(katze).",true);
        }
        if (move){
            move = at.getPrologAnswer("moveIntoHouse(person).");
            System.out.println("Number_person zieht in anderes Haus!");
            solutions.get("move").put("moveIntoHouse(person).",true);
        }
        */

    }

    /*
    public void nextAlternative(View view){
        HashMap<String, TextView> textViewMap = findTextViews();
        if(count == 1) {
            textViewMap.get("H4").setBackgroundColor(ContextCompat.getColor(this.getBaseContext(), R.color.red));
            textViewMap.get("H3").setBackgroundColor(ContextCompat.getColor(this.getBaseContext(), android.R.color.transparent));
            textViewMap.get("H2").setBackgroundColor(ContextCompat.getColor(this.getBaseContext(), R.color.dark_orange));
        }
        else
            Toast.makeText(this, "Keine weitere Alternative", Toast.LENGTH_SHORT).show();
    }

    public HashMap<String, TextView> findTextViews(){
        HashMap<String, TextView> textViewMap = new HashMap<String, TextView>();
        for(int i = 0; i<10;i++){
            String tmpKey;
            int tmpID;
            switch (i){
                case 0: tmpKey = "A";
                    tmpID = 0;
                    break;
                case 1: tmpKey = "B";
                    tmpID = 5;
                    break;
                case 2: tmpKey = "C";
                    tmpID = 10;
                    break;
                case 3: tmpKey = "D";
                    tmpID = 15;
                    break;
                case 4: tmpKey = "E";
                    tmpID = 20;
                    break;
                case 5: tmpKey = "F";
                    tmpID = 25;
                    break;
                case 6: tmpKey = "G";
                    tmpID = 30;
                    break;
                case 7: tmpKey = "H";
                    tmpID = 35;
                    break;
                case 8: tmpKey = "I";
                    tmpID = 40;
                    break;
                case 9: tmpKey = "J";
                    tmpID = 45;
                    break;
                default: tmpKey = "A";
                    tmpID = 0;
                    break;
            }
            for(int j = 0 ; j<5 ; j++) {
                String key = tmpKey + (j+1);
                int id = tViewIDs[tmpID + j];
                textViewMap.put(key, (TextView) findViewById(id));
            }
        }
        return textViewMap;
    }

     */

    public void goOn(View view){
        Intent intent = new Intent(this, Tool_Information.class);
        //disable the .putExtra if tools should be refreshed/deleted after the animation
        intent.putExtra("tools", tools);
        startActivity(intent);
    }

}

