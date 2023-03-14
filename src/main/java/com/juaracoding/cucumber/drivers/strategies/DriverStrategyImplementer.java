package com.juaracoding.cucumber.drivers.strategies;

import com.juaracoding.cucumber.utils.Constans;

public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy(String strategy) {
        switch (strategy) {
            case Constans.CHROME:
                return new Chrome();
            case Constans.FIREFOX:
                return new Firefox();
            default:
                return null;
        }
    }
}
