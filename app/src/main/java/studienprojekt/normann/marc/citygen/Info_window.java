package studienprojekt.normann.marc.citygen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Marc Normann on 17.02.2018.
 */

public class Info_window extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        HashMap<String, HashMap<String, String>> tools = (HashMap<String, HashMap<String, String>>)intent.getSerializableExtra("tools");
        String test = "";
        if(!(intent.getStringExtra("info") == null)) {
            test = intent.getStringExtra("info");
        }

        setContentView(R.layout.tool_information_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .6));

        try {
            if (tools.size() != 0) {
                for (String key : tools.keySet()) {
                    test += key + ":\n";
                    for (String subkey : tools.get(key).keySet()) {
                        test += subkey + ": " + tools.get(key).get(subkey) + "\n";
                    }
                    test += "\n";
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            //test += "\n\n" + tools.isEmpty();
        }

        TextView tv = findViewById(R.id.informationText);
        if(!test.isEmpty()) {
            tv.setText(test);
        } else if(tools.keySet().isEmpty()) {
            tv.setText("Es wurde kein Tool ausgewählt");
        } else {
            tv.setText("Es ist ein Fehler beim laden des Infotextes aufgetreten. Bitte versuchen Sie es erneut.");
        }
    }
}
