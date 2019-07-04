package com.demo.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

    public FunctionManager mFunctionManager;

    public void setFunctionManager(FunctionManager manager){
        this.mFunctionManager = manager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof MainActivity){
            MainActivity mBaseActivity = (MainActivity) context;
            mBaseActivity.setFunctionFragment(getTag());
        }
    }
}
