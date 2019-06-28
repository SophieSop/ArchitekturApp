package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Updated by Jonas Wilczek on 11.02.2019
 */
public class Person extends AppCompatActivity {

    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>)intent.getSerializableExtra("tools");

        Spinner dropdown = findViewById(R.id.spinner_person);
        String[] items = new String[]{"","1", "2", "3", "4", "5 - 10", "10 - 20", "mehr als 20"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
/*
        if(!tools.get("anzahl").keySet().isEmpty()){
            if (tools.get("anzahl").get("person") != null) {
                String selectedItem = tools.get("anzahl").get("person");
                switch (selectedItem) {
                    case "1":
                        selectedItem = "1";
                        break;
                    case "2":
                        selectedItem = "2";
                        break;
                    case "3":
                        selectedItem = "3";
                        break;
                    case "4":
                        selectedItem = "4";
                        break;
                    case "5 - 10":
                        selectedItem = "5 - 10";
                        break;
                    case "10 - 20":
                        selectedItem = "10 - 20";
                        break;
                    case "mehr als 20":
                        selectedItem = "mehr als 20";
                        break;
                }
                int spinnerPosition = adapter.getPosition(selectedItem);
                dropdown.setSelection(spinnerPosition);
            }
        } */
    }

    public void saveData(View view){
        Spinner dropdown = findViewById(R.id.spinner_person);
        String selectedItem = dropdown.getSelectedItem().toString();
        if(!selectedItem.equals("")) {
            String form ="";

            switch (selectedItem){
                case "1": form = "1";
                    break;
                case "2": form = "2";
                    break;
                case "3": form = "3";
                    break;
                case "4": form = "4";
                    break;
                case "5 - 10": form = "5 - 10";
                    break;
                case "10 - 20": form = "10 - 20";
                    break;
                case "mehr als 20": form = "mehr als 20";
                    break;
            }
            tools.get("anzahl").put("person", form);

            Intent intent = new Intent(this, Tool_Information.class);
            intent.putExtra("tools", tools);
            startActivity(intent);
        } else {
            TextView text = findViewById(R.id.text_person);
            text.setText("Bitte wählen Sie eine Personenanzahl aus");
        }
    }
}
