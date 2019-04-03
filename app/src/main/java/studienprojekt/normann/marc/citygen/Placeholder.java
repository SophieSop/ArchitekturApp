package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.HashMap;

/**
 * Updated by Jonas Wilczek on 08.02.2019
 */

public class Placeholder extends AppCompatActivity {

    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>)intent.getSerializableExtra("tools");
        if(!tools.get("placeholder").keySet().isEmpty()){
            for(String tool: tools.get("placeholder").keySet()){
                Switch name = findViewById(getResources().getIdentifier(("switch_"+tool),"id", getPackageName()));
                name.setChecked(true);
            }
        }
    }

    public void select (View view){
        String switchId = getName(view);
        if(tools.get("placeholder").keySet().contains(switchId)){
            tools.get("placeholder").remove(switchId);
        } else {
            tools.get("placeholder").put(switchId,"true");
        }
    }

    public void onGo(View view) {
        Intent intent = new Intent(this, Tool_Information.class);
        intent.putExtra("tools", tools);
        startActivity(intent);
    }

    private String getName(View view){
        String test = view.getResources().getResourceName(view.getId());
        String[] splittedValues = test.split("/");
        String btnId = splittedValues[1];
        btnId = btnId.substring(7);
        return btnId;
    }
}