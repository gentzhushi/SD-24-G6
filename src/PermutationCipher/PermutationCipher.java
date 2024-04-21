package PermutationCipher;

import  org.python.util.PythonInterpreter;

public class PermutationCipher {
    public static void main(String[] args){
        String fajlli = "src/Python/main.py";
        try{
            PythonInterpreter py = new PythonInterpreter();
            py.exec("import warnings");
            py.execfile(fajlli);
            py.cleanup();
            py.close();
        } catch (Exception e){
            System.err.println("Gabim gjate eksekutimit te programit!");
            System.err.println(e.getMessage());
        }
    }
}
