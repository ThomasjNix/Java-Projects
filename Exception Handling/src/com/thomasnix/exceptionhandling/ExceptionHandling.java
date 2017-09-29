package com.thomasnix.exceptionhandling;

public class ExceptionHandling {

    public static void main(String args[]){

        int sum = 0;

        for (String arg : args){
            try{
                sum += Float.parseFloat(arg);
            }catch(NumberFormatException e){
                System.out.println("WARNING: Numeric Formatting exception,\n\t" + e.getMessage());
                System.out.println("\t" + arg + " is not a valid numeric entry.");
            }catch(Exception e){
                System.out.println("Unspecified exception occurred:\n\t" + e.getMessage());
            }finally{
                System.out.println("Argument: " + arg + "\n\tCurrent Sum: " + sum);

            }

        }

        System.out.println("Sum is " + sum);
    }
}
