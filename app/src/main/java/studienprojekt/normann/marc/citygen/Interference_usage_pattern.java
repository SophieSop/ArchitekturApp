package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.HashMap;

/**
 * Created by Jonas Wilczek on 06.02.2019
 */

public class Interference_usage_pattern extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interference_usage_pattern);
        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");
        Switch switch_interferenceUsagePatternAgriculturalArea = findViewById(R.id.switch_interferenceUsagePatternAgriculturalArea);
        Switch switch_interferenceUsagePatternBusiness = findViewById(R.id.switch_interferenceUsagePatternBusiness);
        Switch switch_interferenceUsagePatternCommonRoom = findViewById(R.id.switch_interferenceUsagePatternCommonRoom);
        Switch switch_interferenceUsagePatternCulture = findViewById(R.id.switch_interferenceUsagePatternCulture);
        Switch switch_interferenceUsagePatternGastronomy = findViewById(R.id.switch_interferenceUsagePatternGastronomy);
        Switch switch_interferenceUsagePatternHotel = findViewById(R.id.switch_interferenceUsagePatternHotel);
        Switch switch_interferenceUsagePatternLiving = findViewById(R.id.switch_interferenceUsagePatternLiving);     
        Switch switch_interferenceUsagePatternSeparationOfFunctions = findViewById(R.id.switch_interferenceUsagePatternSeparationOfFunctions);
        Switch switch_interferenceUsagePatternTechnology = findViewById(R.id.switch_interferenceUsagePatternTechnology);
        
        switch_interferenceUsagePatternAgriculturalArea.setOnCheckedChangeListener(this);
        switch_interferenceUsagePatternBusiness.setOnCheckedChangeListener(this);
        switch_interferenceUsagePatternCommonRoom.setOnCheckedChangeListener(this);
        switch_interferenceUsagePatternCulture.setOnCheckedChangeListener(this);
        switch_interferenceUsagePatternGastronomy.setOnCheckedChangeListener(this);
        switch_interferenceUsagePatternHotel.setOnCheckedChangeListener(this);
        switch_interferenceUsagePatternLiving.setOnCheckedChangeListener(this);
        switch_interferenceUsagePatternSeparationOfFunctions.setOnCheckedChangeListener(this);
        switch_interferenceUsagePatternTechnology.setOnCheckedChangeListener(this);

        if (!tools.get("interference_usage_pattern").keySet().isEmpty()) {
            if (tools.get("interference_usage_pattern").get("interferenceUsagePatternSeparationOfFunctions") != null) {
                switch_interferenceUsagePatternSeparationOfFunctions.setChecked(true);
                if (tools.get("interference_usage_pattern").get("interferenceUsagePatternAgriculturalArea") != null)
                    switch_interferenceUsagePatternAgriculturalArea.setChecked(true);
                if (tools.get("interference_usage_pattern").get("interferenceUsagePatternBusiness") != null)
                    switch_interferenceUsagePatternBusiness.setChecked(true);
                if (tools.get("interference_usage_pattern").get("interferenceUsagePatternCommonRoom") != null)
                    switch_interferenceUsagePatternCommonRoom.setChecked(true);
                if (tools.get("interference_usage_pattern").get("interferenceUsagePatternCulture") != null)
                    switch_interferenceUsagePatternCulture.setChecked(true);
                if (tools.get("interference_usage_pattern").get("interferenceUsagePatternGastronomy") != null)
                    switch_interferenceUsagePatternGastronomy.setChecked(true);
                if (tools.get("interference_usage_pattern").get("interferenceUsagePatternHotel") != null)
                    switch_interferenceUsagePatternHotel.setChecked(true);
                if (tools.get("interference_usage_pattern").get("interferenceUsagePatternLiving") != null)
                    switch_interferenceUsagePatternLiving.setChecked(true);
                if (tools.get("interference_usage_pattern").get("interferenceUsagePatternTechnology") != null)
                    switch_interferenceUsagePatternTechnology.setChecked(true);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.switch_interferenceUsagePatternAgriculturalArea:
                if (isChecked)
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternAgriculturalArea", "true");
                else 
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternAgriculturalArea", null);                
                break;
            case R.id.switch_interferenceUsagePatternBusiness:
                if (isChecked)
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternBusiness", "true");
                else
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternBusiness", null);
                break;
            case R.id.switch_interferenceUsagePatternCommonRoom:
                if (isChecked)
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternCommonRoom", "true");
                else
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternCommonRoom", null);
                break;
            case R.id.switch_interferenceUsagePatternCulture:
                if (isChecked)
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternCulture", "true");
                else
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternCulture", null);
                break;
            case R.id.switch_interferenceUsagePatternGastronomy:
                if (isChecked)
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternGastronomy", "true");
                else
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternGastronomy", null);
                break;
            case R.id.switch_interferenceUsagePatternHotel:
                if (isChecked)
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternHotel", "true");
                else
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternHotel", null);
                break;
            case R.id.switch_interferenceUsagePatternLiving:
                if (isChecked)
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternLiving", "true");
                else
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternLiving", null);
                break;
            case R.id.switch_interferenceUsagePatternSeparationOfFunctions:
                Switch switch_interferenceUsagePatternAgriculturalArea = findViewById(R.id.switch_interferenceUsagePatternAgriculturalArea);
                Switch switch_interferenceUsagePatternBusiness = findViewById(R.id.switch_interferenceUsagePatternBusiness);
                Switch switch_interferenceUsagePatternCommonRoom = findViewById(R.id.switch_interferenceUsagePatternCommonRoom);
                Switch switch_interferenceUsagePatternCulture = findViewById(R.id.switch_interferenceUsagePatternCulture);
                Switch switch_interferenceUsagePatternGastronomy = findViewById(R.id.switch_interferenceUsagePatternGastronomy);
                Switch switch_interferenceUsagePatternHotel = findViewById(R.id.switch_interferenceUsagePatternHotel);
                Switch switch_interferenceUsagePatternLiving = findViewById(R.id.switch_interferenceUsagePatternLiving);
                Switch switch_interferenceUsagePatternTechnology = findViewById(R.id.switch_interferenceUsagePatternTechnology);
                if (isChecked) {
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternSeparationOfFunctions", "true");
                    switch_interferenceUsagePatternAgriculturalArea.setVisibility(View.VISIBLE);
                    switch_interferenceUsagePatternBusiness.setVisibility(View.VISIBLE);
                    switch_interferenceUsagePatternCommonRoom.setVisibility(View.VISIBLE);
                    switch_interferenceUsagePatternCulture.setVisibility(View.VISIBLE);
                    switch_interferenceUsagePatternGastronomy.setVisibility(View.VISIBLE);
                    switch_interferenceUsagePatternHotel.setVisibility(View.VISIBLE);
                    switch_interferenceUsagePatternLiving.setVisibility(View.VISIBLE);
                    switch_interferenceUsagePatternTechnology.setVisibility(View.VISIBLE);
                }
                else {
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternSeparationOfFunctions", null);
                    switch_interferenceUsagePatternAgriculturalArea.setVisibility(View.GONE);
                    switch_interferenceUsagePatternBusiness.setVisibility(View.GONE);
                    switch_interferenceUsagePatternCommonRoom.setVisibility(View.GONE);
                    switch_interferenceUsagePatternCulture.setVisibility(View.GONE);
                    switch_interferenceUsagePatternGastronomy.setVisibility(View.GONE);
                    switch_interferenceUsagePatternHotel.setVisibility(View.GONE);
                    switch_interferenceUsagePatternLiving.setVisibility(View.GONE);
                    switch_interferenceUsagePatternTechnology.setVisibility(View.GONE);

                    switch_interferenceUsagePatternAgriculturalArea.setChecked(false);
                    switch_interferenceUsagePatternBusiness.setChecked(false);
                    switch_interferenceUsagePatternCommonRoom.setChecked(false);
                    switch_interferenceUsagePatternCulture.setChecked(false);
                    switch_interferenceUsagePatternGastronomy.setChecked(false);
                    switch_interferenceUsagePatternHotel.setChecked(false);
                    switch_interferenceUsagePatternLiving.setChecked(false);
                    switch_interferenceUsagePatternTechnology.setChecked(false);
                }
                break;
            case R.id.switch_interferenceUsagePatternTechnology:
                if (isChecked)
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternTechnology", "true");
                else
                    tools.get("interference_usage_pattern").put("interferenceUsagePatternTechnology", null);
                break;
        }
    }

    public void saveData(View view){
        Intent intent = new Intent(this, Tool_Information.class);
        intent.putExtra("tools", tools);
        startActivity(intent);
    }
}