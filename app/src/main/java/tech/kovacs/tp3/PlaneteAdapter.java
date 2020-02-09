package tech.kovacs.tp3;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

class PlaneteAdapter extends BaseAdapter {

    private MainActivity mainActivity;
    private Data dt;

    // number
    private int nbChecked;


    public PlaneteAdapter(MainActivity ma, Data d) {
        this.dt = d;
        this.mainActivity = ma;
        nbChecked=0;
    }


    @Override
    public int getCount() {
        return dt.getPlanetes().size();
    }

    @Override
    public Object getItem(int arg0) {
        return dt.getPlanetes().get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }
        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);
        nomPlanete.setText(dt.getPlanetes().get(position));
        //  installer l'adaptateur pour la liste déroulante (spinner)
        String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(mainActivity, android.R.layout.simple_spinner_item, taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox) compoundButton.findViewById(R.id.checkbox);
                Button button = mainActivity.findViewById(R.id.valider);
                if(checkBox.isChecked()) nbChecked++;
                else nbChecked--;
                if(nbChecked>= dt.getPlanetes().size()) {
                    button.setEnabled(true);
                }else if(button.isEnabled()==true) button.setEnabled(false);

                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();
            }
        });


        return itemView;
    }
}