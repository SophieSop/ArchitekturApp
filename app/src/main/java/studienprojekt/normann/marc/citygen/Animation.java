package studienprojekt.normann.marc.citygen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Marc Normann on 10.04.2018.
 * Added Prolog support and rule management on 18.01.2019
 */

public class Animation extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
       try {
            Intent intent = getIntent();
            Context context = getApplicationContext();
            tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");
            PackageManager pm = context.getPackageManager();
            dataDirPath = getPackageName();
            PackageInfo p = pm.getPackageInfo(dataDirPath, 0);
            dataDirPath = p.applicationInfo.dataDir;
            Log.d("INFO","DataDir: "+dataDirPath);
        } catch (Exception e){
           Log.w("ERROR", "Error Message: ", e);
        }
    }



    public void createAlternative(View view){
        HashMap<String, TextView> textViewMap = findTextViews();

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
            System.out.println("Person zieht in anderes Haus!");
            solutions.get("move").put("moveIntoHouse(person).",true);
        }
        */
    }

    public void nextAlternative(View view){
        HashMap<String, TextView> textViewMap = findTextViews();
        count +=1;
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

    public void goOn(View view){
        Intent intent = new Intent(this, Tool_Information.class);
        //disable the .putExtra if tools should be refreshed/deleted after the animation
        intent.putExtra("tools", tools);
        startActivity(intent);
    }
}

