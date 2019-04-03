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
public class Modul extends AppCompatActivity {

    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul);

        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>)intent.getSerializableExtra("tools");

        Spinner dropdown = findViewById(R.id.spinner_shape);
        String[] items = new String[]{"","Kreis", "Rechteck", "Dreieck", "Quadrat"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        if(!tools.get("modul").keySet().isEmpty()){
            if (tools.get("modul").get("shape") != null) {
                String selectedItem = tools.get("modul").get("shape");
                switch (selectedItem) {
                    case "formTriangle":
                        selectedItem = "Dreieck";
                        break;
                    case "formRectangle":
                        selectedItem = "Rechteck";
                        break;
                    case "formSquare":
                        selectedItem = "Quadrat";
                        break;
                    case "formCircle":
                        selectedItem = "Kreis";
                        break;
                }
                int spinnerPosition = adapter.getPosition(selectedItem);
                dropdown.setSelection(spinnerPosition);
            }
        }
    }

    public void saveData(View view){
        Spinner dropdown = findViewById(R.id.spinner_shape);
        String selectedItem = dropdown.getSelectedItem().toString();
        if(!selectedItem.equals("")) {
            String form ="";

            switch (selectedItem){
                case "Dreieck": form = "formTriangle";
                break;
                case "Rechteck": form = "formRectangle";
                    break;
                case "Quadrat": form = "formSquare";
                    break;
                case "Kreis": form = "formCircle";
                    break;
            }
            tools.get("modul").put("shape", form);

            Intent intent = new Intent(this, Tool_Information.class);
            intent.putExtra("tools", tools);
            startActivity(intent);
        } else {
            TextView text = findViewById(R.id.text_modul);
            text.setText("Bitte wählen Sie eine Form aus");
        }
    }
}
