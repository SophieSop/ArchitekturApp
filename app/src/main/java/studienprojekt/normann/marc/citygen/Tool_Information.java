package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * Updated by Jonas Wilczek on 08.02.2019
 */

public class Tool_Information extends AppCompatActivity {

    HashMap<String, HashMap<String, String>> tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool__information);

        try {
            Intent intent = getIntent();
            tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");
        } catch (Exception e){
            e.printStackTrace();
        }

        if (tools == null){
            tools = new HashMap<>();
        } else {
            setCheckbox(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            Intent intent = null;
            switch (item.getItemId()) {
                /* at the moment not implemented
                case R.id.menu_pg:
                    Toast.makeText(this, "Projektgruppe ausgewählt", Toast.LENGTH_SHORT)
                            .show();
                    intent = new Intent(this, Project_groups.class);
                    break;
                case R.id.menu_help:
                    Toast.makeText(this, "Hilfe ausgewählt", Toast.LENGTH_SHORT)
                            .show();
                    break;
                */case R.id.menu_restartSession:
                    setCheckbox(false);
                    tools.clear();
                    intent.putExtra("tools", tools);
                    Toast.makeText(this, "Die Session wurde zurückgesetzt", Toast.LENGTH_SHORT)
                            .show();
                    break;
            }
            intent.putExtra("tools", tools);
            startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void popUp_info(View view){

        String line, btnId, information="";

        btnId = getName(view);

        try {
            InputStream is = getResources().openRawResource(getResources().getIdentifier(btnId,"raw", getPackageName()));
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            while((line = br.readLine()) != null){
                information += line + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
            information=" ";
        }

        Intent intent = new Intent(this, Info_window.class);
        intent.putExtra("info", information);
        startActivity(intent);
    }

    public void selectTool(View view){
        String btnId = getName(view);
        if(tools.keySet().contains(btnId)){
            tools.remove(btnId);
        } else {
            tools.put(btnId, new HashMap<String, String>());
        }
    }

    public void goOn(View view){
        if(tools.isEmpty()){
            String information = "Kein Tool ausgewählt";
            Intent intent = new Intent(this, Info_window.class);
            intent.putExtra("info", information);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, Animation.class);
            intent.putExtra("tools", tools);
            startActivity(intent);
        }
    }

    public void setUpTool(View view){
        try {
            String btnId = getName(view);
            Intent intent = null;
            switch (btnId){
                case "person":
                    intent = new Intent(this, Number_person.class); break;
                case "barriers":
                    intent = new Intent(this, Barriers.class); break;
                case "building_structure":
                    intent = new Intent(this, Building_structure.class); break;
                case "dynamics_of_user_group":
                    intent = new Intent(this, Dynamics_of_user_group.class); break;
                case "infrastructure":
                    intent = new Intent(this, Infrastructure.class); break;
                case "interference_usage_pattern":
                    intent = new Intent(this, Interference_usage_pattern.class); break;
                case "modul":
                    intent = new Intent(this, Modul.class); break;
                case "placeholder":
                    intent = new Intent(this, Placeholder.class); break;
                case "spots":
                    intent = new Intent(this, Spots.class); break;
                case "survival_logic":
                    intent = new Intent(this, Survival_logic.class); break;
                case "universal_space_concept":
                        intent = new Intent(this, Universal_space_concept.class); break;
            }
            if(tools.keySet().isEmpty() || !tools.keySet().contains(btnId)){
                tools.put(btnId, new HashMap<String, String>());
                btnId = "checkBox_" + btnId;
                CheckBox cb = findViewById(getResources().getIdentifier(btnId,"id", getPackageName()));
                cb.setChecked(true);
            }
            intent.putExtra("tools", tools);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCheckbox(boolean isChecked){
        for(String tool : tools.keySet()){
            CheckBox cb = findViewById(getResources().getIdentifier(("checkBox_"+tool),"id", getPackageName()));
            cb.setChecked(isChecked);
        }
    }

    private String getName(View view){
        String test = view.getResources().getResourceName(view.getId());
        String[] splittedValues = test.split("/");
        String btnId = splittedValues[1];
        if(btnId.startsWith("info")){
            btnId = btnId.substring(5);
        }
        if(btnId.startsWith("btn")){
            btnId = btnId.substring(4);
        }
        if (btnId.startsWith("checkBox")) {
            btnId = btnId.substring(9);
        }
        return btnId;
    }
}