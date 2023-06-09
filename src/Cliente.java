import java.util.ArrayList;

public class Cliente {
	//Atributos
	private String nombre;
	private String apellido;
	ArrayList <Cuenta> cuentas = new ArrayList <Cuenta>(0);
	
	
	//Constructor
	public Cliente(String nombre, String apellido) {

		this.nombre = nombre;
		this.apellido = apellido;
		
	}
	//Getter

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	//Setter	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	//Metodos
	public int findIndexCuenta(int numCuenta) {
		//El metodo findIndexCuenta con el parametro int numCuenta
		int i = 0, pos = -1;
		//Utilizamos un ciclo while donde: si la var i es menor que cuentas.size, cuando i vale 0
		while ( i < cuentas.size()) {

			if (numCuenta==cuentas.get(i).getNumCuenta()) {
				pos=  i;
			}
			i++;
		}
		return pos;
	}
	public String verCuentasprueba() {
		for(Cuenta ver : cuentas) {
			return ver.toString();
		}return "No hay cuentas";
	}
	
	public String toString() {
		return "CLiente:" + this.getNombre() + "\nCuentas" + verCuentasprueba();
	}
	
	
	

}

