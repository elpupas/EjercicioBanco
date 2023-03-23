import java.util.UUID;

public class Cuenta {
	//Atributos
	private int numCuenta;
	private int saldo;
	
	//Constructor
	public Cuenta(int numCuenta, int saldo) {
		this.numCuenta = numCuenta;
		this.saldo = saldo;
	}
//Getter
	public int getNumCuenta() {
		return numCuenta;
	}

	public int getSaldo() {
		return this.saldo;
	}
//Setters
	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
	public int ingresar (int deposito) {
		return this.saldo += deposito;
	}
	public int retirar (int extraccion) {
		return this.saldo -= extraccion;
	}
	//MEthods
	public String toString() {
		return "N.Cuenta:" + this.getNumCuenta() + "Saldo:" + this.saldo;
	}
}