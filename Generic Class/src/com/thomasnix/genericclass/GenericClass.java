package com.thomasnix.genericclass;

/*
    Generic class, follows structure class className<GenericTypeVariable>{
        private GenericTypeVariable varName;
    }
 */
class Login<T>{
    private T name;
    private T pass;

    public Login(T name, T pass){
        this.name = name;
        this.pass = pass;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public void printLogin(){
        System.out.println("Logged in as " + name + " with password " + pass);
    }
}



public class GenericClass {
    public static void main(String args[]){
        Login<String> userLoginStr = new Login<>("username","password");
        userLoginStr.printLogin();

        Login<Integer> userLoginInt = new Login<>(12345, 1337);
        userLoginInt.printLogin();
    }
}
