package com.example.kanbara.neverforget;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class PropertyFragment extends Fragment {
    public static Fragment newInstance(Context context) {
        PropertyFragment f = new PropertyFragment();
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_property,null);
        return  root;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("property", Context.MODE_PRIVATE);
        String carNumber = prefs.getString("carNumber", "");
        String phoneNumber = prefs.getString("phoneNumber", "");
        EditText edText1 = (EditText) getView().findViewById(R.id.editText1);
        edText1.setText(carNumber);

        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);
        edText2.setText(phoneNumber);
    }

    @Override
    public void onPause() {
        super.onPause();
        EditText edText1 = (EditText) getView().findViewById(R.id.editText1);
        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);

        String carNumber = edText1.getText().toString();
        String phoneNumber = edText2.getText().toString();

        // 保存
        SharedPreferences prefs = this.getActivity().getSharedPreferences("property", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("carNumber",carNumber);
        editor.putString("phoneNumber", phoneNumber);
        //editor.commit();
        editor.apply();     // commitの非同期
    }

}

