package com.demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class HomeFragment extends BaseFragment {

    public static final String INTERFACE_NOPARAMANDRESULT = HomeFragment.class.getName();
    public static final String INTERFACE_ONLYPARAM = "ONLYPARAM";
    public static final String INTERFACE_ONLYRESULT = "ONLYRESULT";
    public static final String INTERFACE_RESULTANDPARAM = "RESULTANDPARAM";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getActivity(),R.layout.layout_home,null);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //无参数无结果
//                mFunctionManager.invokeFunction(INTERFACE_NOPARAMANDRESULT);
                //只有参数
                //mFunctionManager.invokeFunction(INTERFACE_ONLYPARAM,"我是参数");
//                String result = mFunctionManager.invokeFunction(INTERFACE_ONLYRESULT,String.class);
//                Toast.makeText(getActivity(), "click 有返回值的方法"+result, Toast.LENGTH_SHORT).show();

                //结果+参数
                String result = mFunctionManager.invokeFunction(INTERFACE_RESULTANDPARAM,String.class,"qianqian");
                Toast.makeText(getActivity(), "click 有返回值的方法"+result, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
