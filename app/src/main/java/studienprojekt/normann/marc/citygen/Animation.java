package studienprojekt.normann.marc.citygen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Marc Normann on 10.04.2018.
 * Added Prolog support and rule management on 18.01.2019
 */

public class Animation extends AppCompatActivity {

    HashMap<String, HashMap<String, String>> tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_new);

       try {
            Intent intent = getIntent();
            Context context = getApplicationContext();
            tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");
        } catch (Exception e) {
           Log.w("ERROR", "Error Message: ", e);
       }
        TextView Tools = (TextView)findViewById(R.id.tv_Tools);
        Tools.setText(tools.toString());

    }

        public void onClick(View v) {
            ImageView Barriers = (ImageView)findViewById(R.id.pic_barriers);
            ImageView Universal_Space_Concept = (ImageView)findViewById(R.id.pic_universal_space_concept);
            ImageView Spots = (ImageView)findViewById(R.id.pic_spots);
            ImageView Modul = (ImageView)findViewById(R.id.pic_modul);
            ImageView Building_Structure = (ImageView)findViewById(R.id.pic_building_structure);
            ImageView Placeholder = (ImageView)findViewById(R.id.pic_placeholder);
            ImageView Survival_Logic = (ImageView)findViewById(R.id.pic_survival_logic);
            ImageView Infrastructure = (ImageView)findViewById(R.id.pic_infrastructure);
            ImageView Interference_Usage_Pattern = (ImageView)findViewById(R.id.pic_interference_usage_pattern);

            if (tools.toString().contains("barriers")) {
                Barriers.setVisibility(View.VISIBLE);
            }
            if (tools.toString().contains("universal_space_concept")) {
                Universal_Space_Concept.setVisibility(View.VISIBLE);
            }
            if (tools.toString().contains("spots")) {
                Spots.setVisibility(View.VISIBLE);
            }
            if (tools.toString().contains("modul")) {
                Modul.setVisibility(View.VISIBLE);
            }
            if (tools.toString().contains("building_structure")) {
                Building_Structure.setVisibility(View.VISIBLE);
            }
            if (tools.toString().contains("placeholder")) {
                Placeholder.setVisibility(View.VISIBLE);
            }
            if (tools.toString().contains("survival_logic")) {
                Survival_Logic.setVisibility(View.VISIBLE);
            }
            if (tools.toString().contains("infrastructure")) {
                Infrastructure.setVisibility(View.VISIBLE);
            }
            if (tools.toString().contains("interference_usage_pattern")) {
                Interference_Usage_Pattern.setVisibility(View.VISIBLE);
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

    }

    public void goOn(View view){
        Intent intent = new Intent(this, Tool_Information.class);
        //disable the .putExtra if tools should be refreshed/deleted after the animation
        intent.putExtra("tools", tools);
        startActivity(intent);
    }
}

