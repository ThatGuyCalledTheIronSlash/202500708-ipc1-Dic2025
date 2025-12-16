package modelos;


public abstract class Usuario {
    private String nombre;
    private String CUI;
    private String correo;
    private String contrasena;
    private String usuario;
    private char genero; // 'M' o 'F'
    private int telefono;
    private int edad;
    private char estadoCivil;
//----------------------------------------------------------------------   
    public Usuario(String nombre, String CUI, String correo, String contrasena, String usuario,
            char genero, int telefono, int edad, char estadoCivil) {
        this.nombre = nombre;
        this.CUI = CUI;
        this.correo = correo;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.genero = genero;
        this.telefono = telefono;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
    }
    
    public Usuario(){
        
    }
//----------------------------------------------------------------------   
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
//----------------------------------------------------------------------       
    public String getCUI(){
        return CUI;
    }  
    
    public void setCUI(String CUI){
        this.CUI=CUI;
    }
//----------------------------------------------------------------------       
    public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
//----------------------------------------------------------------------       
    public String getContrasena(){
        return contrasena;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    }
//----------------------------------------------------------------------       
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
 //----------------------------------------------------------------------      
    public char getGenero(){
        return genero;
    }
    
    public void setGenero(char genero){
        this.genero=genero;
    }
//----------------------------------------------------------------------       
    public int getTelefono(){
        return telefono;
    }
    
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
//----------------------------------------------------------------------       
    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
//----------------------------------------------------------------------       
    public char getEstadoCivil(){
        return estadoCivil;
    }
    
    public void setEstadoCivil(char estadoCivil){
        this.estadoCivil=estadoCivil;
    }
//----------------------------------------------------------------------   
    @Override
    public String toString() {
        return "Usuario{" + 
                "nombre=" + nombre + 
                ", CUI=" + CUI + 
                ", correo=" + correo + 
                ", contrasena=" + contrasena + 
                ", usuario=" + usuario + 
                ", genero=" + genero + 
                ", telefono=" + telefono + 
                ", edad=" + edad + 
                ", estadoCivil=" + 
                estadoCivil + '}';
    }
    
    
}
