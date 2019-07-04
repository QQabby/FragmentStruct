package com.demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class NotificationFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(),R.layout.layout_noti,null);
    }

    public void onComm(View view){
        Toast.makeText(getActivity(),"click 只有返回值",Toast.LENGTH_SHORT).show();
    }

    public void resultAndPa(View view){
        Toast.makeText(getActivity(),"click 有返回值和参数",Toast.LENGTH_SHORT).show();
    }
}
