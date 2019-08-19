package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Updated by Sophie Grusenick on 04.07.2019
 */
public class Age_person extends AppCompatActivity {

    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>)intent.getSerializableExtra("tools");

        Spinner dropdown = findViewById(R.id.spinner_person);
        String[] items = new String[]{"","Kind", "Jugendlich", "Erwachsen"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
/*
        if(!tools.get("number_person").keySet().isEmpty()){
            if (tools.get("number_person").get("person") != null) {
                String selectedItem = tools.get("number_person").get("person");
                switch (selectedItem) {
                    case "person_1":
                        selectedItem = "1";
                        break;
                    case "person_2":
                        selectedItem = "2";
                        break;
                    case "person_3":
                        selectedItem = "3";
                        break;
                    case "person_4":
                        selectedItem = "4";
                        break;
                    case "person_5_10":
                        selectedItem = "5 - 10";
                        break;
                    case "person_10_20":
                        selectedItem = "10 - 20";
                        break;
                    case "person_20":
                        selectedItem = "mehr als 20";
                        break;
                }
                int spinnerPosition = adapter.getPosition(selectedItem);
                dropdown.setSelection(spinnerPosition);
            }
        }
*/
    }

    public void saveData(View view){
        Spinner dropdown = findViewById(R.id.spinner_person);
        String selectedItem = dropdown.getSelectedItem().toString();
        if(!selectedItem.equals("")) {
            String form ="";

            switch (selectedItem){
                case "Kind": form = "person_1";
                    break;
                case "Jugendlich": form = "person_2";
                    break;
                case "Erwachsen": form = "person_3";
                    break;
            }
         //   tools.get("age_person").put("person", form);

            Intent intent = new Intent(this, Tool_Information.class);
          //  intent.putExtra("tools", tools);
            startActivity(intent);
        } else {
            TextView text = findViewById(R.id.text_person);
            text.setText("Bitte wählen Sie ein Alter aus");
        }
    }
}
