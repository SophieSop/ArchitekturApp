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
 * Created by Jonas Wilczek on 06.02.2019
 */

public class Infrastructure extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infrastructure);
        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");

        Switch switch_infrastructureCars = findViewById(R.id.switch_infrastructureCars);
        Switch switch_infrastructureCentralSupplyLocation = findViewById(R.id.switch_infrastructureCentralSupplyLocation);
        Switch switch_infrastructureLivingCloseToNature = findViewById(R.id.switch_infrastructureLivingCloseToNature);
        Switch switch_infrastructureOnlyPedestrians = findViewById(R.id.switch_infrastructureOnlyPedestrians);
        Switch switch_infrastructureOptimizedTrafficNetwork = findViewById(R.id.switch_infrastructureOptimizedTrafficNetwork);
        Switch switch_infrastructureRecreation = findViewById(R.id.switch_infrastructureRecreation);
        Switch switch_infrastructureSaveResources = findViewById(R.id.switch_infrastructureSaveResources);
        Switch switch_infrastructureTrafficConcept = findViewById(R.id.switch_infrastructureTrafficConcept);

        switch_infrastructureCars.setOnCheckedChangeListener(this);
        switch_infrastructureCentralSupplyLocation.setOnCheckedChangeListener(this);
        switch_infrastructureLivingCloseToNature.setOnCheckedChangeListener(this);
        switch_infrastructureOnlyPedestrians.setOnCheckedChangeListener(this);
        switch_infrastructureOptimizedTrafficNetwork.setOnCheckedChangeListener(this);
        switch_infrastructureRecreation.setOnCheckedChangeListener(this);
        switch_infrastructureSaveResources.setOnCheckedChangeListener(this);
        switch_infrastructureTrafficConcept.setOnCheckedChangeListener(this);

        if (!tools.get("infrastructure").keySet().isEmpty()) {
            if ( tools.get("infrastructure").get("infrastructureCars") != null)
                switch_infrastructureCars.setChecked(true);
            if ( tools.get("infrastructure").get("infrastructureNoCars") != null)
                switch_infrastructureCars.setChecked(false);
            if ( tools.get("infrastructure").get("infrastructureCentralSupplyLocation") != null)
                switch_infrastructureCentralSupplyLocation.setChecked(true);
            if ( tools.get("infrastructure").get("infrastructureLivingCloseToNature") != null)
                switch_infrastructureLivingCloseToNature.setChecked(true);
            if ( tools.get("infrastructure").get("infrastructureOnlyPedestrians") != null)
                switch_infrastructureOnlyPedestrians.setChecked(true);
            if ( tools.get("infrastructure").get("infrastructureOptimizedTrafficNetwork") != null)
                switch_infrastructureOptimizedTrafficNetwork.setChecked(true);
            if ( tools.get("infrastructure").get("infrastructureRecreation") != null)
                switch_infrastructureRecreation.setChecked(true);
            if ( tools.get("infrastructure").get("infrastructureSaveResources") != null)
                switch_infrastructureSaveResources.setChecked(true);
            if ( tools.get("infrastructure").get("infrastructureTrafficConcept") != null)
                switch_infrastructureTrafficConcept.setChecked(true);
            SeekBar seekBar_trafficDensity = findViewById(R.id.seekBar_trafficDensity);
            String trafficDensity = tools.get("infrastructure").get("trafficDensity");
            int trafficDensityValue = 0;
            switch (trafficDensity){
                case "trafficDensityLow":
                    trafficDensityValue = 25; break;
                case "trafficDensityMedium":
                    trafficDensityValue = 50; break;
                case "trafficDensityHigh":
                    trafficDensityValue = 75; break;
            }
            seekBar_trafficDensity.setProgress(trafficDensityValue);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()){
            case R.id.switch_infrastructureCars:
                if(isChecked) {
                    tools.get("infrastructure").put("infrastructureCars", "true");
                    tools.get("infrastructure").put("infrastructureNoCars", null);
                }
                else {
                    tools.get("infrastructure").put("infrastructureNoCars", "true");
                    tools.get("infrastructure").put("infrastructureCars", null);
                }
                break;
            case R.id.switch_infrastructureCentralSupplyLocation:
                if(isChecked)
                    tools.get("infrastructure").put("infrastructureCentralSupplyLocation", "true");
                else
                    tools.get("infrastructure").put("infrastructureCentralSupplyLocation", null);
                break;
            case R.id.switch_infrastructureLivingCloseToNature:
                if(isChecked)
                    tools.get("infrastructure").put("infrastructureLivingCloseToNature", "true");
                else
                    tools.get("infrastructure").put("infrastructureLivingCloseToNature", null);
                break;
            case R.id.switch_infrastructureOnlyPedestrians:
                if(isChecked)
                    tools.get("infrastructure").put("infrastructureOnlyPedestrians", "true");
                else
                    tools.get("infrastructure").put("infrastructureOnlyPedestrians", null);
                break;
            case R.id.switch_infrastructureOptimizedTrafficNetwork:
                if(isChecked)
                    tools.get("infrastructure").put("infrastructureOptimizedTrafficNetwork", "true");
                else
                    tools.get("infrastructure").put("infrastructureOptimizedTrafficNetwork", null);
                break;
            case R.id.switch_infrastructureRecreation:
                if(isChecked)
                    tools.get("infrastructure").put("infrastructureRecreation", "true");
                else
                    tools.get("infrastructure").put("infrastructureRecreation", null);
                break;
                case R.id.switch_infrastructureSaveResources:
                if(isChecked)
                    tools.get("infrastructure").put("infrastructureSaveResources", "true");
                else
                    tools.get("infrastructure").put("infrastructureSaveResources", null);
                break;
            case R.id.switch_infrastructureTrafficConcept:
                if(isChecked)
                    tools.get("infrastructure").put("infrastructureTrafficConcept", "true");
                else
                    tools.get("infrastructure").put("infrastructureTrafficConcept", null);
                break;
        }
    }

    public void saveData(View view){
        SeekBar seekBar_trafficDensity = findViewById(R.id.seekBar_trafficDensity);
        String trafficDensity ="";
        if ( seekBar_trafficDensity.getProgress() <= 25)
            trafficDensity = "trafficDensityLow";
        else if (seekBar_trafficDensity.getProgress() >= 75)
            trafficDensity = "trafficDensityHigh";
        else
            trafficDensity = "trafficDensityMedium";

        tools.get("infrastructure").put(trafficDensity, "true");

        Intent intent = new Intent(this, Tool_Information.class);
        intent.putExtra("tools", tools);
        startActivity(intent);

    }
}
