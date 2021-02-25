/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.scanner;
import java.util.*;  

/**
 *
 * @author Syed Muhammad Hamza
 */
public class LexicalAnalyzer {
static int pos=0;
    static int len;
    static StringBuilder fnb = new StringBuilder();
    static char nextch;
    public void skipWhiteSpaces(String s)
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder nb = new StringBuilder();
        sb.append(s);
        nb.append("$");
        int sizesb =sb.length()-1;
        while(sizesb>=0){
            if(sb.charAt(sizesb)== ' '){
                ///skip
            }
            else{
                nb.append(sb.charAt(sizesb));
            }
            sizesb--;
        }
        nb=nb.reverse();
        //System.out.println(nb);
        fnb=nb;
        nextch =fnb.charAt(0);
        len=fnb.length()-1;
    }
    /*Version 1 is preferable because it is shorter and the compiler will in fact turn it into version 2 - no performance difference whatsoever
    Version 1 is preferable because it is shorter and the compiler will in fact turn it into version 2 - no performance difference whatsoever
    */
public void getch(){
       pos++; 
       nextch=fnb.charAt(pos);
    }
    @SuppressWarnings("empty-statement")
   public  Token getToken(){
       int fflag=-1;
         Hashtable<Integer,String> keywords=new Hashtable<>();  
         keywords.put(0,"if");keywords.put(1,"else");keywords.put(2,"for");keywords.put(3,"while");keywords.put(4,"return");keywords.put(5,"do");
         keywords.put(6,"foreach");keywords.put(7,"switch");String put = keywords.put(8,"case");keywords.put(9,"deafult");keywords.put(10,"try");keywords.put(11,"catch");
        //String[] keywords=new String[]{"if","else","while","for","retrun","do","foreach","switch","case","default","try","catch","final"};
        Token result;
        if(nextch=='$'){
                result = new Token(Token.Type.EOF);len--;
                return result;
            }
        switch(nextch){
            case';': result = new Token(Token.Type.SCOLON,";");getch();len--; return result;
            case'=': result = new Token(Token.Type.EQ,"=");getch();len--; return result;
            case'>': result = new Token(Token.Type.GT,">");getch();len--; return result;
            case'<': result = new Token(Token.Type.LT,"<");getch();len--; return result;
            case'(': result = new Token(Token.Type.LPAREN,"(");getch();len--; return result;
            case')': result = new Token(Token.Type.RPAREN,")");getch();len--; return result;
            case'+': result = new Token(Token.Type.PLUS,"+");getch();len--; return result;
            case'-': result = new Token(Token.Type.MINUS,"-");getch();len--; return result;
            case'*': result = new Token(Token.Type.MULT,"*");getch();len--; return result;
            case'/': result = new Token(Token.Type.DIV,"/");getch();len--; return result;
            case',': result = new Token(Token.Type.COMMA,",");getch();len--; return result;
            case'!': 
                len--;
                getch();
                if(nextch=='='){
                   result = new Token(Token.Type.NEQ);len--;getch(); return result;
                }
                else{
                    result = new Token(Token.Type.NOT); return result;
                }
            case'0':case'1':case'2':case'3':case'4':case'5':case'6':case'7':case'8':case'9':
                String num=String.valueOf(nextch);
                len--;getch();
                while(Character.isDigit(nextch) || nextch=='.'){
                   if(nextch=='.'){
                       fflag=fflag++;
                   }
                   num=num+String.valueOf(nextch);len--;getch();
                }
                if(fflag<0){
                    result=new Token(Token.Type.FNUMBER,num);
                    return result;
                }
                else{
                result=new Token(Token.Type.NUMBER,num);
                return result;}
            case'a':case'b':case'c':case'd':case'e':case'f':case'g':case'h':case'i':case'j':case'k':case'l':case'm':case'n':case'o':case'p':case'q':case'r'
            :case's':case't':case'u':case'v':case'w':case'x':case'y':case'z':case'A':case'B':case'C':case'D':case'E':case'F':case'G':case'H':case'I'
            :case'J':case'K':case'L':case'M':case'N':case'O':case'P':case'Q':case'R':case'S':case'T':case'U':case'V':case'W':case'X':case'Y'
            :case'Z':
                    String s =String.valueOf(nextch);len--;getch();
                    while(Character.isDigit(nextch)||Character.isLetter(nextch)){
                        s=s+String.valueOf(nextch);len--;getch();
                    }
                    if(keywords.contains(s)){
                        result=new Token(Token.Type.KEYWORD,s);
                    }
                    else{
                        result=new Token(Token.Type.VAR,s);
                    }
                    //System.out.println(s);
                    return  result;
            default:System.out.println("Invalid char you can take break! Looking forward to the Weekend ");
                len--;getch();
                result=new Token(Token.Type.INVALIDCHAR);
                return result;  
        }
        
    } 
   public void scanTheString(String s){
        skipWhiteSpaces(s);
        while(len>=0){
        Token reto =getToken();
        System.out.println("Lexiacal class="+reto.kind+" value= "+reto.id);
   }
 
    
}
}
