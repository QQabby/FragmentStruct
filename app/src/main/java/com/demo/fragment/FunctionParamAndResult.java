package com.demo.fragment;

/**
 * 参数和返回值
 */
public abstract class FunctionParamAndResult<Param,Result> extends Function {


    public FunctionParamAndResult(String functionName) {
        super(functionName);
    }

    abstract Result function(Param param);
}
