package org.example;

import java.util.List;

public class DataService {

    public DataService() {
        throw new IllegalAccessError();
    }

    public List<String> getAllData(){
        return null;
    }

    public List<String> getSomeData(String x){
        return null;
    }

    public int getSquare() {
        return 1;
    }

    public String getTextSum(int a, int b){
        int result = a + b;
        return String.valueOf(result);
    }

    public SomeInnerClass getSomeInnerClass(){
        return new SomeInnerClass();
    }

    public IllegalArgumentException exceptionThrower(){
        return new IllegalArgumentException();
    }


    public static String myName() {
        return "Say my name!";
    }

    static class SomeInnerClass {

    }
}

