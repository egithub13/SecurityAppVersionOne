package com.example.android.securityappversionone;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Eric on 11/19/2014.
 */
public class FragmentLogin extends Fragment implements CompoundButton.OnCheckedChangeListener {

    TextView login,username,passWord;
    EditText eUserName,ePassword;
    Button buttonLogin;
    CheckBox mCheckBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        login = (TextView) view.findViewById(R.id.textViewLogin);
        username = (TextView) view.findViewById(R.id.editTextUserName);
        mCheckBox = (CheckBox) view.findViewById(R.id.checkBox);
        passWord = (TextView) view.findViewById(R.id.textViewPassword);
        eUserName = (EditText) view.findViewById(R.id.editTextUserName);
        ePassword = (EditText) view.findViewById(R.id.editTextPassword);
        buttonLogin = (Button) view.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(eUserName.getText().toString().equalsIgnoreCase("ehayes") &&
                        ePassword.getText().toString().matches("1234"))
                {
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();

                    Fragment fragment = new FragmentSystemsOptions();

                    transaction.replace(R.id.container,fragment);
                    transaction.addToBackStack(null);

                    transaction.commit();

                }
                else
                {
                    Toast.makeText(getActivity(),"INCORRECT!!!!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked)
                {
                    ePassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else
                {
                    ePassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });


        return view;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
