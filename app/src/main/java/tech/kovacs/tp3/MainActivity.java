package tech.kovacs.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    Button valider;
    PlaneteAdapter adapter;

    Data dt;

    public void popUp(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listView);
        valider = (Button) findViewById(R.id.valider);
        valider.setOnClickListener(validerOnClickListener);
        valider.setEnabled(false);
        dt = new Data();
        adapter = new PlaneteAdapter(this, dt);
        listview.setAdapter(adapter);

    }


    View.OnClickListener validerOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // do something
            if(verifTailles()){
                popUp("ok");
            }else popUp("fail.");

        }
    };



    public boolean verifTailles(){

        // for some reason it's impossible to do a foreach with a listView, so back to the good old for
        //for(View va : listview)


        for(int i =0;i<listview.getCount();++i){

            if(Integer.parseInt(((Spinner) (listview.getChildAt(i)).findViewById(R.id.spinner)).getSelectedItem().toString()) !=(dt.getTaille(dt.getPlanete(i))))
            {

                //popUp("i : " + i + " " + dt.getTaille(dt.getPlanete(i)) + " comp " + ((Spinner) (listview.getChildAt(i)).findViewById(R.id.spinner)).getSelectedItem().toString());
               return false;
            }
        }
        return true;
    }







}