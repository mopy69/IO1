/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

/**
 *
 * @author leonardo
 */
public class MetodoGranM {
    private int filas;
    private int columnas;
    private double[][] datos;
    
    public MetodoGranM(){
        this.filas=0;
        this.columnas=0;
    }

    // Constructor
    public MetodoGranM(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        datos = new double[filas][columnas];
    }
    
    public void setDim(int fila,int columna){
        this.filas=fila;
        this.columnas=columna;
        datos = new double[fila][columna];
    }

    // Setear un valor
    public void setValor(int fila, int columna, double valor) {
        datos[fila][columna] = valor;
    }

    // Obtener un valor
    public double getValor(int fila, int columna) {
        return datos[fila][columna];
    }

    // Getters por si los necesitás
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
    
    //Desde aqui son los procesos que tienen que ver con el metodo gran m
    
    
    
    public String Mostrar(){

        String cadena = "Funcion Objetivo"+"\n\n";
        int variable;
        String desigualdad;
        //verifica si es minim o maxim, -1 es minim y 1 es maximi
        
        if(datos[0][0] == -1){
            cadena=cadena+"MinimizarZ = ";
            variable=(columnas-2)/3;
            desigualdad=">=";
        } else {
            cadena=cadena+"MaximizarZ = ";
            variable=(columnas-2)/2;
            desigualdad="<=";
        }
        
        //mostrar daatos de la funcion objetivo
        for(int i=1;i<=variable;i++){ // col 0 Datos de la Z || (columnas-2)/3 pa q devuelva la cantidad de variables que meti 
            
            if(datos[0][i]>=0)
                cadena=cadena+"+";
            
            cadena=cadena+ datos[0][i] + "x" + i;
        }
        cadena=cadena+"\n\n"+"Sujeto a:"+"\n\n";
        
        //mostrar datos de las Restricciones
        for (int i = 1; i < filas; i++) {
            for (int j = 1; j <= variable; j++) {
                
                if(datos[i][j]>=0)
                    cadena=cadena+"+";
                
               cadena=cadena+datos[i][j]+"x"+j;
            }
            cadena=cadena+desigualdad;
                
            if(datos[i][columnas-1]>=0)
                cadena=cadena+"+";
            
            cadena=cadena+datos[i][columnas-1]+"\n";
        }
        
        return cadena;
    }
    
    
    public void rellenarTabla(){ //solo ara meter los datos de e y a 
        
        if(datos[0][0]==-1) { //para cuando es minimizacion
            
            //fila de funcion objetvo
            for (int i = (columnas-2)/3+(columnas-2)/3+1; i < columnas-1; i++) {
                datos[0][i]=1; //son las M y rellena tambien rhs
            }
            
            //filas de restricciones las -e o s tan como -1
            for (int i = 1; i < filas; i++) {
                datos[i][i+((columnas-2)/3)]=-1;
            }
            //para rellenar a 
            for (int i = 1; i < filas; i++) {
                datos[i][i+((columnas-2)/3)*2]=1;
            }
            
        } else { //para cuando es maximizacion
            
            //fila de funcion objetivo rellena las s y rhs
            for (int i = (columnas-2)/2+1; i < columnas-1; i++) {
                datos[0][i]=0; 
            }
            //para rellenar a 
            for (int i = 1; i < filas; i++) {
                datos[i][i+((columnas-2)/2)]=1;
            }
            
        }
        
    }
    
    public void Resolver(){
        
        
    }
    
}
