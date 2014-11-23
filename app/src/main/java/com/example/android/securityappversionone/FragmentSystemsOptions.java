package com.example.android.securityappversionone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Eric on 11/19/2014.
 */
public class FragmentSystemsOptions extends FragmentMenu {

    Button addButton;
    TextView projectText,systemText;
    EditText projectEdit,systemEdit;
    SQLiteDatabaseAdapter helper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_systems_options,container,false);
        projectEdit = (EditText) view.findViewById(R.id.editText2);
        projectText = (TextView) view.findViewById(R.id.textView2);
        systemEdit = (EditText) view.findViewById(R.id.editText);
        projectText = (TextView) view.findViewById(R.id.textView);
        addButton = (Button) view.findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser(view);
            }
        });

        helper = new SQLiteDatabaseAdapter(getActivity());
        return view;
    }

    public void addUser(View view){
        String projectName = projectEdit.getText().toString();
        String system = systemEdit.getText().toString();
        long id = helper.insertData(projectName,system);
        if(id<0){
            Toast.makeText(getActivity(),"Insert not successful",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getActivity(),"!!!!Successful!!!!",Toast.LENGTH_LONG).show();
        }
    }


}
