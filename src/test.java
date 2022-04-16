/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lehuuhieu
 */
public class test {

    public int fun(int n) {
        if(n == 1|| n == 2) {
            return 1;
        } else {
            return (fun(n - 1) + 3 *fun(n-2));
        }
    }
    public static void main(String[] args) {
        test a = new test();
        System.out.println(a.fun(3));
    }
}
