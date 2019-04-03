package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jonas on 18.01.2019.
 */

public class Project_groups extends AppCompatActivity {

    HashMap<String, HashMap<String, String>> tools = new HashMap<>();
    private int numberOfPgs = 1 ;

    public int getNumberOfPgs() {
        return numberOfPgs;
    }

    public void setNumberOfPgs(int numberOfPgs) {
        this.numberOfPgs = numberOfPgs;
    }

    String[] txtInputEditTextHints;

    public String[] getTxtInputEditTextHints() {
        return txtInputEditTextHints;
    }

    public void setTxtInputEditTextHints(String[] txtInputEditTextHints) {
        this.txtInputEditTextHints = txtInputEditTextHints;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_groups);
        Spinner spNumberOfGroups = findViewById(R.id.spinner_number_of_groups);

        Intent intent = getIntent();
        if (tools == null) {
            tools = new HashMap<>();
        } else {
            tools = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("tools");
        }


        try {
            if (!tools.get("projectgroups").keySet().isEmpty()) {
                spNumberOfGroups.setSelection(Integer.parseInt(tools.get("projectgroups").get("number")));
                GridView gvGroups = findViewById(R.id.gv_groups);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> spArrLst = new ArrayList<String>();
        for (int i = 1; i < 11; i++)
            spArrLst.add("true" + i);
        spArrLst.add(">10");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spArrLst);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNumberOfGroups.setAdapter(adapter);

        GridView gvGroups = findViewById(R.id.gv_groups);
        List<String> gvArrLst = new ArrayList<String>();
        List<TextInputEditText> gvTxtInputEditTxt= new ArrayList<>();

        gvArrLst.add("1. Item");
        gvArrLst.add("2. Item");

        spNumberOfGroups.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                numberOfPgs = 10;
                txtInputEditTextHints = new String[numberOfPgs];

                for(int i = 1; i<=5;i++){
                    txtInputEditTextHints[i] = "Projektgruppe "+i+":";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        //txtInputEditTextHints = new String[10];

        TextInputEditTextAdapter txtInputEditTxtAdapter = new TextInputEditTextAdapter(this.getBaseContext(),txtInputEditTextHints);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                gvArrLst );

        //gvGroups.setAdapter(txtInputEditTxtAdapter);
        gvGroups.setAdapter(arrayAdapter);


    }

    public void refreshGridView(){
        //gvGroups.invalidateViews();
        //gvGroups.invalidate();
    }



    public void onGo(View view){
        Intent intent = new Intent(this, Tool_Information.class);
        intent.putExtra("tools", tools);
        startActivity(intent);
    }




}
