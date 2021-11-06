package com.sgic.employee.utills;

public  class Utills {
    public static boolean notNullValidation(String name)
    {
        if(name!=null && !name.trim().isEmpty()){
            return true;
        }
        return false;
    }

}
