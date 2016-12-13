/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorial;

/**
 *
 * @author SALAS
 */
public class CalculoFactorial {
    
    public double factorial(double contador){
        if (contador<=1){
            return 1;
        }else{
            return contador*factorial(contador-1);
        }
    }
     public void imprimir(){
         for (int i = 0; i <= 4; i++) {
            System.out.printf("%d! = %.0f\n", i, factorial(i));
         }
         
     }
    
}
