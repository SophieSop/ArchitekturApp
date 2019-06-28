package studienprojekt.normann.marc.citygen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Marc Normann on 10.04.2018.
 * Added Prolog support and rule management on 18.01.2019
 */

public class Animation extends AppCompatActivity {

        private final String image_titles[] = {
                "Img1",
                "Img2",
                "Img3",
                "Img4",
                "Img5",
                "Img6",
                "Img7",
                "Img8",
                "Img9",
                "Img10",

        };

        private final Integer image_ids[] = {
                /*
                R.drawable.barrieren_mehrfach_abknickende_durchgaenge,
                R.drawable.barrieren_schleuse,
                R.drawable.barrieren_sichtschutz,
                R.drawable.barrieren_sperre,
                R.drawable.baustruktur_bauwagen,
                R.drawable.baustruktur_bestand,
                R.drawable.baustruktur_dorfstruktur,
                R.drawable.baustruktur_dorfstruktur_2,
                R.drawable.baustruktur_geb_teile_ziehen_um,
                R.drawable.baustruktur_horizontale_verdichtung,
                R.drawable.baustruktur_landgewinnung,
                R.drawable.baustruktur_neubau,
                R.drawable.baustruktur_substitution,
                R.drawable.baustruktur_substitution_2,
                R.drawable.baustruktur_vertikale_erweiterung,
                R.drawable.baustruktur_vertikale_erweiterung_2,
                R.drawable.infrastruktur_baum,
                R.drawable.infrastruktur_radweg,
                R.drawable.infrastruktur_strasse,
                R.drawable.infrastruktur_strasse_mittel,
                R.drawable.infrastruktur_verkehrskonzept,
                R.drawable.infrastruktur_wald,
                R.drawable.infrastruktur_wald_see,

                */
                R.drawable.universelle_raumlehren_agrarflaeche,
                R.drawable.universelle_raumlehren_hofladen,
                R.drawable.universelle_raumlehren_innenhof,
                R.drawable.universelle_raumlehren_solarpanel,
                R.drawable.universelle_raumlehren_windrad,
                R.drawable.universelle_raumlehren_belueftung_horiz_achse,

                R.drawable.interferenz_nutzungsmuster_schule,
                R.drawable.interferenz_nutzungsmuster_hotel_seminar,

                R.drawable.barrieren_sichtschutz,
                R.drawable.barrieren_mehrfach_abknickende_durchgaenge,
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_animation_new_new);

            RecyclerView recyclerView = (RecyclerView)findViewById(R.id.pics);
            recyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),5);
            recyclerView.setLayoutManager(layoutManager);

            ArrayList<Pics_Liste> createLists = prepareData();
            Pics_Adapter adapter = new Pics_Adapter(getApplicationContext(), createLists);
            recyclerView.setAdapter(adapter);


        }
        private ArrayList<Pics_Liste> prepareData(){

            ArrayList<Pics_Liste> theimage = new ArrayList<>();
            for(int i = 0; i< image_titles.length; i++){
                Pics_Liste createList = new Pics_Liste();
                createList.setImage_title(image_titles[i]);
                createList.setImage_ID(image_ids[i]);
                theimage.add(createList);
            }
            return theimage;
        }
/*
    HashMap<String, HashMap<String, String>> tools;

*/
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
/*    @Override
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
/*        } catch (Exception e) {
           Log.w("ERROR", "Error Message: ", e);
       }
        TextView Tools = (TextView)findViewById(R.id.tv_Tools);
        Tools.setText(tools.toString());

    }

    public void onClick(View v) {

        // Create a HashMap object
        HashMap<String, String> pics = new HashMap<String, String>();

        // Add keys and values
        pics.put("England", "London");
        pics.put("Germany", "Berlin");
        pics.put("Norway", "Oslo");
        pics.put("USA", "Washington DC");


        ImageView Barriers = (ImageView)findViewById(R.id.pic_barriers);


        if (tools.toString().contains("barriers")) {
            Barriers.setVisibility(View.VISIBLE);
        }
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
*/
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
            System.out.println("Person zieht in anderes Haus!");
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
/*
    public void goOn(View view){
        Intent intent = new Intent(this, Tool_Information.class);
        //disable the .putExtra if tools should be refreshed/deleted after the animation
        intent.putExtra("tools", tools);
        startActivity(intent);
    }
    */
//}

