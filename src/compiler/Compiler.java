/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;
import java.util.*;
import compiler.scanner.LexicalAnalyzer;

/**
 *
 * @author Syed Muhammad Hamza
 */
public class Compiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner program =new Scanner(System.in);
        String str =program.next();
        LexicalAnalyzer s=new LexicalAnalyzer();
        s.scanTheString(str);
        // TODO code application logic here
    }
    
}
