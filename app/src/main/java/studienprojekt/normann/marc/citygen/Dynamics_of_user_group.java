package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jonas on 28.01.2019.
 */

public class Dynamics_of_user_group extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamics_of_user_group);
        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");
        Spinner spUserGroupNetworking = findViewById(R.id.spinner_userGroupNetworking);
        Switch switch_userGroupFlexibility = findViewById(getResources().getIdentifier(("switch_userGroupFlexibility"), "id", getPackageName()));
        Switch switch_userGroupProcessOrientated = findViewById(R.id.switch_userGroupProcessOrientated);
        switch_userGroupFlexibility.setOnCheckedChangeListener(this);
        switch_userGroupProcessOrientated.setOnCheckedChangeListener(this);

        if (!tools.get("dynamics_of_user_group").keySet().isEmpty()) {
            SeekBar bar = findViewById(R.id.seekBar_networking);
            String networking = tools.get("dynamics_of_user_group").get("networking");
            int networkingValue=0;
            switch (networking){
                case "networkingLow":
                    networkingValue = 25; break;
                case "networkingMedium":
                    networkingValue = 50; break;
                case "networkingHigh":
                    networkingValue = 75; break;
            }
            bar.setProgress(networkingValue);
            
            if (tools.get("dynamics_of_user_group").get("userGroupFlexibility") != null)
                switch_userGroupFlexibility.setChecked(true);
            if (tools.get("dynamics_of_user_group").get("userGroupProcessOrientated") != null)
                switch_userGroupProcessOrientated.setChecked(true);
            if (!tools.get("dynamics_of_user_group").get("userGroupNetworking").isEmpty()) {
                if (tools.get("dynamics_of_user_group").get("userGroupNetworking").equals("international"))
                    spUserGroupNetworking.setSelection(1);
                else
                    spUserGroupNetworking.setSelection(0);
            }
        }
        List<String> spArrLst = new ArrayList<String>();
        spArrLst.add("keine Vernetzung");
        spArrLst.add("mit eigener Nutzergruppe");
        spArrLst.add("Umgebung/regional");
        spArrLst.add("international");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spArrLst);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUserGroupNetworking.setAdapter(adapter);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()){
            case R.id.switch_userGroupFlexibility:
                if(isChecked)
                    tools.get("dynamics_of_user_group").put("userGroupFlexibility", "true");
                else
                    tools.get("dynamics_of_user_group").put("userGroupFlexibility", null);
                break;
            case R.id.switch_userGroupProcessOrientated:
                if(isChecked)
                    tools.get("dynamics_of_user_group").put("userGroupProcessOrientated", "true");
                else
                    tools.get("dynamics_of_user_group").put("userGroupProcessOrientated", null);
                break;
        }
    }

    public void saveData(View view){
        Spinner sp_userGroupNetworking = findViewById(R.id.spinner_userGroupNetworking);
        SeekBar sb_networking = findViewById(R.id.seekBar_networking);

        //tools.get("dynamics_of_user_group").put("networking", String.valueOf(sb_networking.getProgress()));
        String networking="";
        float networkingValue = sb_networking.getProgress();
        if (networkingValue  <= 25)
            networking = "networkingLow";
        else if (networkingValue >= 75)
            networking = "networkingHigh";
        else
            networking = "networkingMedium";
        tools.get("dynamics_of_user_group").put("networking", networking);

        switch (String.valueOf(sp_userGroupNetworking.getSelectedItem())){
            case "keine Vernetzung":
                tools.get("dynamics_of_user_group").put("userGroupNetworking", "networkingNo");
                break;
            case "mit eigener Nutzergruppe":
                tools.get("dynamics_of_user_group").put("userGroupNetworking", "networkingOwnUserGroup");
                break;
            case "Umgebung/regional":
                tools.get("dynamics_of_user_group").put("userGroupNetworking", "networkingRegional");
                break;
            case "international":
                tools.get("dynamics_of_user_group").put("userGroupNetworking", "networkingInternational");
                break;
            default:
                break;
        }

        Intent intent = new Intent(this, Tool_Information.class);
        intent.putExtra("tools", tools);
        startActivity(intent);

    }
}
