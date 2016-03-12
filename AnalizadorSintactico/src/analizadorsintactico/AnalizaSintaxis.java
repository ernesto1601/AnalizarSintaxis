/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorsintactico;

import java.util.ArrayList;
import javafx.scene.control.TextArea;

/**
 *
 * @author Ernesto
 */
public class AnalizaSintaxis {
    
    int current_token = 0;
    ArrayList<Token> tokens2;
    
    public String verificaSintx(ArrayList<Token> tokens){
        
        tokens2 = tokens;
        tokens = quitaEspacios(tokens2);//conjunto de tokens sin espacios
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(""+tokens.get(i));
        }
        //////////////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.publico || tokens.get(current_token) == Token.privado){
            current_token++;
        }else{
            System.out.println("Error 1");
            return "Syntax ERROR, expected: public OR private found: "+tokens.get(current_token);
        }
        /////////////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.clase){
            current_token++;
        }else{
            return "Syntax ERROR, expected: class found: "+tokens.get(current_token);
        }
        ////////////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.Identificador){
            current_token++;
        }else{
            return "Syntax ERROR, expected: Identidicador found: "+tokens.get(current_token);
        }
        ///////////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.LLA){
            current_token++;
        }else{
            return "Syntax ERROR, expected: { found: "+tokens.get(current_token);
        }
        if(tokens.get(current_token) == Token.entero_id ||
           tokens.get(current_token) == Token.largo_id ||
           tokens.get(current_token) == Token.doble_id ||
           tokens.get(current_token) == Token.cadena_id ){
            
            //current_token++;
            
            while(tokens.get(current_token) != Token.publico && tokens.get(current_token) != Token.privado){
                System.out.println("Me cicle");
                switch(tokens.get(current_token)){
                    case entero_id:
                        System.out.println("entero");
                            current_token++;
                            if(tokens.get(current_token) == Token.Identificador){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: Identificador found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.igual){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: = found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.Entero){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: Entero found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.punt_coma){
                                current_token++;
                                System.out.println("Token actual: "+tokens.get(current_token));
                            }else{
                                return "Syntax ERROR, expected: ; found: "+tokens.get(current_token);
                            }
                            
                        break;
                        ///////////////////////////////////////////////////
                    case largo_id:
                        System.out.println("Long");
                         current_token++;
                            if(tokens.get(current_token) == Token.Identificador){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: Identificador found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.igual){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: = found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.Entero){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: Entero found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.punt_coma){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: ; found: "+tokens.get(current_token);
                            }
                        break;
                    case doble_id:
                        System.out.println("Double");
                         current_token++;
                            if(tokens.get(current_token) == Token.Identificador){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: Identificador found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.igual){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: = found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.Entero){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: Entero found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.punt_coma){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: ; found: "+tokens.get(current_token);
                            }
                        break;
                    case cadena_id:
                        System.out.println("String");
                         current_token++;
                            if(tokens.get(current_token) == Token.Identificador){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: Identificador found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.igual){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: = found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.cadena){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: Cadena found: "+tokens.get(current_token);
                            }
                            if(tokens.get(current_token) == Token.punt_coma){
                                current_token++;
                            }else{
                                return "Syntax ERROR, expected: ; found: "+tokens.get(current_token);
                            }
                        break;
                    
                }
            }
            
        }else{
            if(tokens.get(current_token) == Token.publico || tokens.get(current_token) == Token.privado){
               // current_token++;
            }else{
                return "Syntax ERROR, expected: Tipo de Dato found: "+tokens.get(current_token);
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.publico || tokens.get(current_token) == Token.privado){
            current_token++;
        }else{
            System.out.println("Error 2");
            return "Syntax ERROR, expected: public OR private found: "+tokens.get(current_token);
        }
        //////////////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.estatico){
            current_token++;
        }else{
            return "Syntax ERROR, expected: static found: "+tokens.get(current_token);
        }
        ///////////////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.ninguno){
            current_token++;
        }else{
            return "Syntax ERROR, expected: void found: "+tokens.get(current_token);
        }
        ////////////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.principal){
            current_token++;
        }else{
            return "Syntax ERROR, expected: main found: "+tokens.get(current_token);
        }
        ////////////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token)== Token.PA){
            current_token++;
        }else{
            return "Syntax ERROR, expected: ( found: "+tokens.get(current_token);
        }
        ///////////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.cadena_id){
            current_token++;
        }else{
            return "Syntax ERROR, expected: String found: "+tokens.get(current_token);
        }
        ///////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.Identificador){
            current_token++;
        }else{
            return "Syntax ERROR, expected: Identificador found: "+tokens.get(current_token);
        }
        //////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.PC){
            current_token++;
        }else{
            return "Syntax ERROR, expected: ) found: "+tokens.get(current_token);
        }
        /////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.LLA){
            current_token++;
        }else{
            return "Syntax ERROR, expected: { found: "+tokens.get(current_token);
        }
        ////////////////////////////////////////////////////////////////////////////
        if(tokens.get(current_token) == Token.funcion || tokens.get(current_token) == Token.LLC){
            if(tokens.get(current_token) == Token.LLC){
                return "La sintaxis es correcta";
            }
            //current_token++;
            while(tokens.get(current_token) == Token.funcion){
                if(tokens.get(current_token)== Token.Identificador){
                    current_token++;
                }else{
                     return "Syntax ERROR, expected: Identificador found: "+tokens.get(current_token);
                }
                ////////////////////////////////////////
                if(tokens.get(current_token) == Token.PA){
                    current_token++;
                }else{
                     return "Syntax ERROR, expected: ( found: "+tokens.get(current_token);
                }
                /////////////////////////////////////////
                if(tokens.get(current_token) == Token.PC ||
                   tokens.get(current_token) == Token.entero_id ||
                   tokens.get(current_token) == Token.largo_id ||
                   tokens.get(current_token) == Token.doble_id ||
                   tokens.get(current_token) == Token.cadena_id ){
                    
                    switch(tokens.get(current_token)){
                        case PC:
                                current_token++;
                            break;
                        case entero_id:
                                current_token++;
                                if(tokens.get(current_token) == Token.Identificador){
                                    current_token++;
                                }else{
                                    return "Syntax ERROR, expected: identificador found: "+tokens.get(current_token);
                                }
                                if(tokens.get(current_token) == Token.PC){
                                    current_token++;
                                }else{
                                    return "Syntax ERROR, expected: ) found: "+tokens.get(current_token);
                                }
                            break;
                        case largo_id:
                                current_token++;
                                if(tokens.get(current_token) == Token.Identificador){
                                    current_token++;
                                }else{
                                    return "Syntax ERROR, expected: identificador found: "+tokens.get(current_token);
                                }
                                if(tokens.get(current_token) == Token.PC){
                                    current_token++;
                                }else{
                                    return "Syntax ERROR, expected: ) found: "+tokens.get(current_token);
                                }
                            break;
                        case doble_id:
                                current_token++;
                                if(tokens.get(current_token) == Token.Identificador){
                                    current_token++;
                                }else{
                                    return "Syntax ERROR, expected: identificador found: "+tokens.get(current_token);
                                }
                                if(tokens.get(current_token) == Token.PC){
                                    current_token++;
                                }else{
                                    return "Syntax ERROR, expected: ) found: "+tokens.get(current_token);
                                }
                            break;
                            
                        case cadena_id:
                                current_token++;
                                if(tokens.get(current_token) == Token.Identificador){
                                    current_token++;
                                }else{
                                    return "Syntax ERROR, expected: identificador found: "+tokens.get(current_token);
                                }
                                if(tokens.get(current_token) == Token.PC){
                                    current_token++;
                                }else{
                                    return "Syntax ERROR, expected: ) found: "+tokens.get(current_token);
                                }
                            break;
                    }
                }
                
                
            }
            
        }
        
        return "La sintaxis es correcta";
    }
    
    private ArrayList<Token> quitaEspacios(ArrayList<Token> tokens){
        
        for(int i=0; i<tokens.size(); i++){
            if(tokens.get(i) == Token.espacio){
                tokens.remove(i);
            }
        }
        return tokens;
    }
    
    
    
}
