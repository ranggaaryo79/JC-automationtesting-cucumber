package com.juaracoding.cucumber.utils;

public enum TestScenarios {

    T1("User valid login into web HRM"),
    T2("User invalid login into web HRM"),
    T3("User No input password into web HRM"),
    T4("User add candidate");

    private String testCastName;

    TestScenarios(String value){
        testCastName = value;
    }

    public String getTestCastName(){
        return testCastName;
    }

}
