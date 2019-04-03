package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.HashMap;

/**
 * Created by Jonas Wilczek on 07.02.2019
 */

public class Universal_space_concept extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universal_space_concept);
        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");
        Switch switch_universal_space_conceptAutarky = findViewById(R.id.switch_universal_space_conceptAutarky);
        Switch switch_universal_space_conceptBuildingsWithCenter = findViewById(R.id.switch_universal_space_conceptBuildingsWithCenter);
        Switch switch_universal_space_conceptHolisticWayOfLife = findViewById(R.id.switch_universal_space_conceptHolisticWayOfLife);
        Switch switch_universal_space_conceptHorizontalAxis = findViewById(R.id.switch_universal_space_conceptHorizontalAxis);
        Switch switch_universal_space_conceptInsideOutsideRelation = findViewById(R.id.switch_universal_space_conceptInsideOutsideRelation);
        Switch switch_universal_space_conceptLightAxis = findViewById(R.id.switch_universal_space_conceptLightAxis);
        Switch switch_universal_space_conceptRenewableEnergies = findViewById(R.id.switch_universal_space_conceptRenewableEnergies);
        Switch switch_universal_space_conceptSustainableLife = findViewById(R.id.switch_universal_space_conceptSustainableLife);
        Switch switch_universal_space_conceptVeganism = findViewById(R.id.switch_universal_space_conceptVeganism);
        Switch switch_universal_space_conceptVentilation = findViewById(R.id.switch_universal_space_conceptVentilation);
        Switch switch_universal_space_conceptVerticalAxis = findViewById(R.id.switch_universal_space_conceptVerticalAxis);
        Switch switch_universal_space_conceptWorkOnSite = findViewById(R.id.switch_universal_space_conceptWorkOnSite);
        
        switch_universal_space_conceptAutarky.setOnCheckedChangeListener(this);
        switch_universal_space_conceptBuildingsWithCenter.setOnCheckedChangeListener(this);
        switch_universal_space_conceptHolisticWayOfLife.setOnCheckedChangeListener(this);
        switch_universal_space_conceptHorizontalAxis.setOnCheckedChangeListener(this);
        switch_universal_space_conceptInsideOutsideRelation.setOnCheckedChangeListener(this);
        switch_universal_space_conceptLightAxis.setOnCheckedChangeListener(this);
        switch_universal_space_conceptRenewableEnergies.setOnCheckedChangeListener(this);
        switch_universal_space_conceptSustainableLife.setOnCheckedChangeListener(this);
        switch_universal_space_conceptVeganism.setOnCheckedChangeListener(this);
        switch_universal_space_conceptVentilation.setOnCheckedChangeListener(this);
        switch_universal_space_conceptVerticalAxis.setOnCheckedChangeListener(this);
        switch_universal_space_conceptWorkOnSite.setOnCheckedChangeListener(this);

        if (!tools.get("universal_space_concept").keySet().isEmpty()) {
            if (tools.get("universal_space_concept").get("autarky") != null)
                switch_universal_space_conceptAutarky.setChecked(true);
            if (tools.get("universal_space_concept").get("buildingsWithCenter") != null)
                switch_universal_space_conceptBuildingsWithCenter.setChecked(true);
            if (tools.get("universal_space_concept").get("horizontalAxis") != null)
                switch_universal_space_conceptHorizontalAxis.setChecked(true);
            if (tools.get("universal_space_concept").get("holisticWayOfLife") != null)
                switch_universal_space_conceptHolisticWayOfLife.setChecked(true);
            if (tools.get("universal_space_concept").get("insideOutsideRelation") != null)
                switch_universal_space_conceptInsideOutsideRelation.setChecked(true);
            if (tools.get("universal_space_concept").get("lightAxis") != null)
                switch_universal_space_conceptLightAxis.setChecked(true);
            if (tools.get("universal_space_concept").get("renewableEnergies") != null)
                switch_universal_space_conceptRenewableEnergies.setChecked(true);
            if (tools.get("universal_space_concept").get("sustainableLife") != null)
                switch_universal_space_conceptSustainableLife.setChecked(true);
            if (tools.get("universal_space_concept").get("veganism") != null)
                switch_universal_space_conceptVeganism.setChecked(true);
            if (tools.get("universal_space_concept").get("ventilation") != null)
                switch_universal_space_conceptVentilation.setChecked(true);
            if (tools.get("universal_space_concept").get("verticalAxis") != null)
                switch_universal_space_conceptVerticalAxis.setChecked(true);
            if (tools.get("universal_space_concept").get("workOnSite") != null)
                switch_universal_space_conceptWorkOnSite.setChecked(true);
        }
    }
    
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()){
            case R.id.switch_universal_space_conceptAutarky:
                if(isChecked)
                    tools.get("universal_space_concept").put("autarky", "true");
                else
                    tools.get("universal_space_concept").put("autarky", null);
                break;
            case R.id.switch_universal_space_conceptBuildingsWithCenter:
                if(isChecked)
                    tools.get("universal_space_concept").put("buildingsWithCenter", "true");
                else
                    tools.get("universal_space_concept").put("buildingsWithCenter", null);
                break;
            case R.id.switch_universal_space_conceptHolisticWayOfLife:
                if (isChecked)
                    tools.get("universal_space_concept").put("holisticWayOfLife", "true");
                else
                    tools.get("universal_space_concept").put("holisticWayOfLife", null);
                break;
            case R.id.switch_universal_space_conceptHorizontalAxis:
                if (isChecked)
                    tools.get("universal_space_concept").put("horizontalAxis", "true");
                else
                    tools.get("universal_space_concept").put("horizontalAxis", null);
                break;
            case R.id.switch_universal_space_conceptInsideOutsideRelation:
                if (isChecked)
                    tools.get("universal_space_concept").put("insideOutsideRelation", "true");
                else
                    tools.get("universal_space_concept").put("insideOutsideRelation", null);
                break;
            case R.id.switch_universal_space_conceptLightAxis:
                if (isChecked)
                    tools.get("universal_space_concept").put("lightAxis", "true");
                else
                    tools.get("universal_space_concept").put("lightAxis", null);
                break;
            case R.id.switch_universal_space_conceptRenewableEnergies:
                if (isChecked)
                    tools.get("universal_space_concept").put("renewableEnergies", "true");
                else
                    tools.get("universal_space_concept").put("renewableEnergies", null);
                break;
            case R.id.switch_universal_space_conceptSustainableLife:
                if (isChecked)
                    tools.get("universal_space_concept").put("sustainableLife", "true");
                else
                    tools.get("universal_space_concept").put("sustainableLife", null);
                break;
            case R.id.switch_universal_space_conceptVeganism:
                if (isChecked)
                    tools.get("universal_space_concept").put("veganism", "true");
                else
                    tools.get("universal_space_concept").put("veganism", null);
                break;
            case R.id.switch_universal_space_conceptVentilation:
                if (isChecked)
                    tools.get("universal_space_concept").put("ventilation", "true");
                else
                    tools.get("universal_space_concept").put("ventilation", null);
                break;
            case R.id.switch_universal_space_conceptVerticalAxis:
                if (isChecked)
                    tools.get("universal_space_concept").put("verticalAxis", "true");
                else
                    tools.get("universal_space_concept").put("verticalAxis", null);
                break;
            case R.id.switch_universal_space_conceptWorkOnSite:
                if (isChecked)
                    tools.get("universal_space_concept").put("workOnSite", "true");
                else
                    tools.get("universal_space_concept").put("workOnSite", null);
                break;
        }
    }

    public void saveData(View view){
        Intent intent = new Intent(this, Tool_Information.class);
        intent.putExtra("tools", tools);
        startActivity(intent);
    }
}