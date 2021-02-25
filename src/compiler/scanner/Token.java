/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.scanner;

/**
 *
 * @author Syed Muhammad Hamza
 */
public class Token { 
     public Token(Type kind){
         this.kind=kind;
         id=null;
    }
     public Token(Type kind,String id){
         this.kind=kind;
         this.id=id;
     }
     public Token(Type kind,int val){
         this.kind=kind;
         this.val=val;
         this.id=null;
     }
     public Type getType() {
        return kind;
    }
     public String getVal(){
         return id;
    }
    public  Type kind;
    public int val;
    public String id;
    public int line;
    public int column;
    public enum Type {
        EOF,
        SCOLON,
        LF,
        VAR,
        KEYWORD,
        NUMBER,
        STRING,
        PLUS,
        MINUS,
        MULT,
        DIV,
        LPAREN,
        RPAREN,
        EQ,
        NE,
        GT,
        GTE,
        LT,
        LTE,
        COMMA,
        NEQ,
        NOT,
        FNUMBER,
        INVALIDCHAR
    }
}
