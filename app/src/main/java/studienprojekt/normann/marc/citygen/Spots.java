package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.HashMap;
/**
 * Created by Jonas Wilczek on 05.02.2019
 */

public class Spots extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots);
        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");

        Switch switch_spotsFixedPointsForParentFunction = findViewById(getResources().getIdentifier(("switch_spotsFixedPointsForParentFunction"), "id", getPackageName()));
        Switch switch_spotsPlacesForNetworking = findViewById(getResources().getIdentifier(("switch_spotsPlacesForNetworking"), "id", getPackageName()));

        switch_spotsFixedPointsForParentFunction.setOnCheckedChangeListener(this);
        switch_spotsPlacesForNetworking.setOnCheckedChangeListener(this);

        if (!tools.get("spots").keySet().isEmpty()) {
            if (tools.get("spots").get("spotsFixedPointsForParentFunction") != null)
                switch_spotsFixedPointsForParentFunction.setChecked(true);
            if (tools.get("spots").get("spotsPlacesForNetworking") != null)
                switch_spotsPlacesForNetworking.setChecked(true);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.switch_spotsFixedPointsForParentFunction:
                if (isChecked)
                    tools.get("spots").put("fixedPointsForParentFunction", "true");
                else
                    tools.get("spots").put("fixedPointsForParentFunction", "true");
                break;
            case R.id.switch_spotsPlacesForNetworking:
                if (isChecked)
                    tools.get("spots").put("placesForNetworking", "true");
                else
                    tools.get("spots").put("placesForNetworking", "true");
                break;
        }
    }

    public void saveData(View view){
        Intent intent = new Intent(this, Tool_Information.class);
        intent.putExtra("tools", tools);
        startActivity(intent);
    }
}
