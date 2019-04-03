package studienprojekt.normann.marc.citygen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import java.util.HashMap;

/**
 * Updated by Jonas Wilczek on 06.02.2019
 */

public class Survival_logic extends AppCompatActivity {

    HashMap<String, HashMap<String, String>> tools = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survival_logic);

        Intent intent = getIntent();
        tools = (HashMap<String, HashMap<String, String>>)intent.getSerializableExtra("tools");

        if(!tools.get("survival_logic").keySet().isEmpty()){
            RatingBar rbSafety = findViewById(R.id.rating_safety);
            float rating = Float.parseFloat(tools.get("survival_logic").get("safety"));
            rbSafety.setRating(rating);
            RatingBar rbOrientation = findViewById(R.id.rating_orientation);
            rating = Float.parseFloat(tools.get("survival_logic").get("orientation"));
            rbOrientation.setRating(rating);
        }
    }

    public void onGo(View view){
        RatingBar rbSafety = findViewById(R.id.rating_safety);
        float ratingSafety = rbSafety.getRating();
        tools.get("survival_logic").put("safety", String.valueOf(ratingSafety));
        RatingBar rbOrientation = findViewById(R.id.rating_orientation);
        float ratingOrientation = rbOrientation.getRating();
        tools.get("survival_logic").put("orientation", String.valueOf(ratingOrientation));

        Intent intent = new Intent(this, Tool_Information.class);
        intent.putExtra("tools", tools);
        startActivity(intent);
    }
}
