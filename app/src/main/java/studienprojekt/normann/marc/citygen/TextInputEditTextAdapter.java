package studienprojekt.normann.marc.citygen;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Jonas on 21.01.2019.
 */

public class TextInputEditTextAdapter extends BaseAdapter {
    public Context context;
    private final String[] textInputLayoutHints;

    TextInputEditTextAdapter(Context context, String[] textInputLayoutHints){
        this.context = context;
        this.textInputLayoutHints = textInputLayoutHints;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if (convertView == null){
            gridView = new View(context);
            // get layout
            gridView = inflater.inflate(R.layout.activity_project_groups, null);
            // set hint value
            TextInputEditText txtInputEditTxt =  gridView.findViewById(R.id.gv_groups);
            txtInputEditTxt.setHint(textInputLayoutHints[position]);
        } else{
            gridView = (View) convertView;
        }
        return gridView;
    }
    @Override
    public int getCount() {
        //return textInputLayoutHints.length;
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
