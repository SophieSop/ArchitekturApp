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

public class Barriers extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barriers);
        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");

        Switch switch_barriersNoVisualInsights = findViewById(R.id.switch_barriersNoVisualInsights);
        Switch switch_barriersInhibitionThreshold = findViewById(R.id.switch_barriersInhibitionThreshold);
        switch_barriersNoVisualInsights.setOnCheckedChangeListener(this);
        switch_barriersInhibitionThreshold.setOnCheckedChangeListener(this);

        if (!tools.get("barriers").keySet().isEmpty()) {
            if (tools.get("barriers").get("barriersNoVisualInsights") != null)
                switch_barriersNoVisualInsights.setChecked(true);
            if (tools.get("barriers").get("barriersInhibitionThreshold") != null)
                switch_barriersInhibitionThreshold.setChecked(true);
            SeekBar seekBar_privacy = findViewById(R.id.seekBar_privacy);
            String privacy = tools.get("barriers").get("privacy");
            int privacyValue = 0;
            switch (privacy){
                case "privacyLow":
                    privacyValue = 25; break;
                case "privacyMedium":
                    privacyValue = 50; break;
                case "privacyHigh":
                    privacyValue = 75; break;
            }
            seekBar_privacy.setProgress(privacyValue);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()){
            case R.id.switch_barriersNoVisualInsights:
                if(isChecked)
                    tools.get("barriers").put("barriersNoVisualInsights", "true");
                else
                    tools.get("barriers").put("barriersNoVisualInsights", null);
                break;
            case R.id.switch_barriersInhibitionThreshold:
                if(isChecked)
                    tools.get("barriers").put("barriersInhibitionThreshold", "true");
                else
                    tools.get("barriers").put("barriersInhibitionThreshold", null);
                break;
        }
    }

    public void saveData(View view){
        SeekBar seekBar_privacy = findViewById(R.id.seekBar_privacy);
        String privacy ="";
        int privacyValue = seekBar_privacy.getProgress();
        if ( privacyValue <= 25)
            privacy = "privacyLow";
        else if (privacyValue >= 75)
            privacy = "privacyHigh";
        else
            privacy = "privacyMedium";

        tools.get("barriers").put("privacy", privacy);

        Intent intent = new Intent(this, Tool_Information.class);
        intent.putExtra("tools", tools);
        startActivity(intent);

    }
}
