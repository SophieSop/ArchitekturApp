package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;

import java.util.HashMap;

/**
 * Created by Jonas Wilczek on 11.02.2019
 */

public class Building_structure extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_structure);

        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>)intent.getSerializableExtra("tools");        
           
        Switch switch_horizontalDensity = findViewById(R.id.switch_horizontalDensity);
        Switch switch_building = findViewById(R.id.switch_building);
        Switch switch_courtyard = findViewById(R.id.switch_courtyard);
        Switch switch_horizontalExtension = findViewById(R.id.switch_horizontalExtension);
        Switch switch_otherPlace = findViewById(R.id.switch_otherPlace);
        Switch switch_cultivation = findViewById(R.id.switch_cultivation);
        Switch switch_verticalExtension = findViewById(R.id.switch_verticalExtension);
        Switch switch_newPlace = findViewById(R.id.switch_newPlace);
        Switch switch_substitution = findViewById(R.id.switch_substitution);
        Switch switch_moveBuilding = findViewById(R.id.switch_moveBuilding);

        switch_horizontalDensity.setOnCheckedChangeListener(this);
        switch_building.setOnCheckedChangeListener(this);
        switch_courtyard.setOnCheckedChangeListener(this);
        switch_horizontalExtension.setOnCheckedChangeListener(this);
        switch_otherPlace.setOnCheckedChangeListener(this);
        switch_cultivation.setOnCheckedChangeListener(this);
        switch_verticalExtension.setOnCheckedChangeListener(this);
        switch_newPlace.setOnCheckedChangeListener(this);
        switch_substitution.setOnCheckedChangeListener(this);
        switch_moveBuilding.setOnCheckedChangeListener(this);



        if(!tools.get("building_structure").keySet().isEmpty()){
            SeekBar bar = findViewById(R.id.seekBar_density);
            String density = tools.get("building_structure").get("density");
            int densityValue = 0;
            switch (density){
                case "densityLow":
                    densityValue = 25; break;
                case "densityMedium":
                    densityValue = 50; break;
                case "densityHigh":
                    densityValue = 75; break;
            }
            bar.setProgress(densityValue);

            if (tools.get("building_structure").get("horizontalDensity") != null) {
                switch_horizontalDensity.setChecked(true);
                switch_building.setVisibility(View.VISIBLE);
                switch_courtyard.setVisibility(View.VISIBLE);
                if (tools.get("building_structure").get("horizontalDensity_building") != null)
                    switch_building.setChecked(true);
                if (tools.get("building_structure").get("horizontalDensity_courtyard") != null)
                    switch_courtyard.setChecked(true);
            }
            if (tools.get("building_structure").get("horizontalExtension") != null) {
                switch_horizontalExtension.setChecked(true);
                switch_otherPlace.setVisibility(View.VISIBLE);
                switch_cultivation.setVisibility(View.VISIBLE);
                if (tools.get("building_structure").get("horizontalExtension_otherPlace") != null)
                    switch_otherPlace.setChecked(true);
                if (tools.get("building_structure").get("horizontalExtension_cultivation") != null)
                    switch_cultivation.setChecked(true);
            }
            if (tools.get("building_structure").get("verticalExtension") != null)
                switch_verticalExtension.setChecked(true);
            if (tools.get("building_structure").get("newPlace") != null)
                switch_newPlace.setChecked(true);
            if (tools.get("building_structure").get("substitution") != null)
                switch_substitution.setChecked(true);
            if (tools.get("building_structure").get("moveBuilding") != null)
                switch_moveBuilding.setChecked(true);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.switch_horizontalDensity:
                Switch switch_building = findViewById(R.id.switch_building);
                Switch switch_courtyard = findViewById(R.id.switch_courtyard);
                if (isChecked) {
                    tools.get("building_structure").put("horizontalDensity", "true");
                    switch_building.setVisibility(View.VISIBLE);
                    switch_courtyard.setVisibility(View.VISIBLE);
                }
                else {
                    tools.get("building_structure").put("horizontalDensity", null);
                    switch_building.setVisibility(View.GONE);
                    switch_courtyard.setVisibility(View.GONE);
                    switch_building.setChecked(false);
                    switch_courtyard.setChecked(false);
                }
                break;
            case R.id.switch_building:
                if (isChecked)
                    tools.get("building_structure").put("horizontalDensity_building", "true");
                else
                    tools.get("building_structure").put("horizontalDensity_building", null);
                break;
            case R.id.switch_courtyard:
                if (isChecked)
                    tools.get("building_structure").put("horizontalDensity_courtyard", "true");
                else
                    tools.get("building_structure").put("horizontalDensity_courtyard", null);
                break;
            case R.id.switch_horizontalExtension:
                Switch switch_otherPlace = findViewById(R.id.switch_otherPlace);
                Switch switch_cultivation = findViewById(R.id.switch_cultivation);
                if (isChecked) {
                    tools.get("building_structure").put("horizontalExtension", "true");
                    switch_otherPlace.setVisibility(View.VISIBLE);
                    switch_cultivation.setVisibility(View.VISIBLE);
                }
                else {
                    tools.get("building_structure").put("horizontalExtension", null);
                    switch_otherPlace.setVisibility(View.GONE);
                    switch_cultivation.setVisibility(View.GONE);
                    switch_otherPlace.setChecked(false);
                    switch_cultivation.setChecked(false);
                }
                break;
            case R.id.switch_otherPlace:
                if (isChecked)
                    tools.get("building_structure").put("horizontalExtension_otherPlace", "true");
                else
                    tools.get("building_structure").put("horizontalExtension_otherPlace", null);
                break;
            case R.id.switch_cultivation:
                if (isChecked)
                    tools.get("building_structure").put("horizontalExtension_cultivation", "true");
                else
                    tools.get("building_structure").put("horizontalExtension_cultivation", null);
                break;
            case R.id.switch_verticalExtension:
                if (isChecked)
                    tools.get("building_structure").put("verticalExtension", "true");
                else
                    tools.get("building_structure").put("verticalExtension", null);
                break;
            case R.id.switch_newPlace:
                if (isChecked)
                    tools.get("building_structure").put("newPlace", "true");
                else
                    tools.get("building_structure").put("newPlace", null);
                break;
            case R.id.switch_substitution:
                if (isChecked)
                    tools.get("building_structure").put("substitution", "true");
                else
                    tools.get("building_structure").put("substitution", null);
                break;
            case R.id.switch_moveBuilding:
                if (isChecked)
                    tools.get("building_structure").put("moveBuilding", "true");
                else
                    tools.get("building_structure").put("moveBuilding", null);
                break;
        }
    }

    public void saveData(View view){
        SeekBar bar = findViewById(R.id.seekBar_density);

        String density ="";
        if ( bar.getProgress() <= 25)
            density = "densityLow";
        else if (bar.getProgress() >= 75)
            density = "densityHigh";
        else
            density = "densityMedium";

        tools.get("building_structure").put("density", density);

        Intent intent = new Intent(this, Tool_Information.class);
        intent.putExtra("tools", tools);
        startActivity(intent);
    }
}
