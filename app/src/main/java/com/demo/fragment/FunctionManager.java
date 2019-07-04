package com.demo.fragment;

import android.text.TextUtils;

import java.util.HashMap;

public class FunctionManager {

    private FunctionManager(){
        mFunctionNoParamNoResult = new HashMap<>();
        mFunctionOnlyParam = new HashMap<>();
        mFunctionOnlyResult = new HashMap<>();
        mFunctionParamAndResult = new HashMap<>();
    }

    private static FunctionManager instance;

    private HashMap<String,FunctionNoParamNoResult> mFunctionNoParamNoResult;
    private HashMap<String,FunctionOnlyParam> mFunctionOnlyParam;
    private HashMap<String,FunctionOnlyResult> mFunctionOnlyResult;
    private HashMap<String,FunctionParamAndResult> mFunctionParamAndResult;

    public static FunctionManager getInstance(){
        if(instance == null){
            instance = new FunctionManager();
        }
        return instance;
    }

    public FunctionManager addFunction(String functionName,FunctionNoParamNoResult function){
        mFunctionNoParamNoResult.put(functionName,function);
        return this;
    }

    public FunctionManager addFunction(String functionName,FunctionOnlyParam function){
        mFunctionOnlyParam.put(functionName,function);
        return this;
    }

    public FunctionManager addFunction(String functionName,FunctionOnlyResult function){
        mFunctionOnlyResult.put(functionName,function);
        return this;
    }

    public FunctionManager addFunction(String functionName,FunctionParamAndResult function){
        mFunctionParamAndResult.put(functionName,function);
        return this;
    }

    public void invokeFunction(String functionName){
        FunctionNoParamNoResult f;
        if(TextUtils.isEmpty(functionName)){
            return;
        }
        if(mFunctionNoParamNoResult != null){
           f = mFunctionNoParamNoResult.get(functionName);
           if(f!= null){
               f.function();
           }else{
               throw new RuntimeException("no method:"+functionName);
           }
        }
    }

    public <Param> void  invokeFunction(String functionName,Param param){
        FunctionOnlyParam f;
        if(TextUtils.isEmpty(functionName)){
            return;
        }
        if(mFunctionOnlyParam != null){
            f = mFunctionOnlyParam.get(functionName);
            if(f!= null){
                f.function(param);
            }else{
                throw new RuntimeException("no method:"+functionName);
            }
        }
    }

    public <Result> Result invokeFunction(String functionName,Class<Result> clazz){
        FunctionOnlyResult f;
        if(TextUtils.isEmpty(functionName)){
            return null;
        }
        if(mFunctionOnlyParam != null){
            f = mFunctionOnlyResult.get(functionName);
            if(f!= null){
                return clazz.cast(f.function());
            }else{
                return (Result) f.function();
            }
        }
        return null;
    }

    public<Result,Param> Result invokeFunction(String functionName,Class<Result> result,Param param){
        FunctionParamAndResult f;
        if(TextUtils.isEmpty(functionName)){
            return null;
        }
        if(mFunctionOnlyParam != null){
            f = mFunctionParamAndResult.get(functionName);
            if(f!= null){
                return result.cast(f.function(param));
            }else{
                return (Result) f.function(param);
            }
        }
        return null;
    }

}
