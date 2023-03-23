import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class BancoDePeter {
	private static ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	//private static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	private static String nombre = "";
	private static String apellido = "";
	private static Scanner input = new Scanner(System.in);
	static int numCuenta = 0,deposito, nc = 0, saldo, iClient = 0;
	public static void main(String[] args) {
		boolean end = false, correcto = false;
		int opcion = 0;
        
		System.out.println("Bienvenido.");
		do {//Do While
			do {
			System.out.println("Que quieres hacer??");
			System.out.println("0.- Salir de la aplicacion.\n" + "1.- Crear client/a.\n" + "2.- Eliminar client/a.\n"
					+ "3.- Crear cuenta a un client/a.\n" + "4.- Ingresar euros en un cuenta de un client/a.\n"
					+ "5.- Retirar euros en un cuenta de un cliente" + "\n6.- Ver todas las cuentas");
			try //Error de formato
			{
			opcion = input.nextInt();
		//	input.nextLine();
			correcto = true;
            } catch (InputMismatchException ex) {
                System.out.println("Error de formato.");
            }
			input.nextLine();
			}while(!correcto);
				
				switch (opcion) {
			case 0:
				System.out.println("ADIOS");
				System.out.println("         *(0 0)* ");
				System.out.println("  ---oOO-- (_) ----oOO---");                  
			    System.out.println("|_________________________|");        
			    System.out.println("|          By             |"); 
			    System.out.println("|          Pupa!          |");
			    System.out.println("|_________________________|");  
			    System.out.println("   -------------------");       
			    System.out.println("        |__|__|");      
			    System.out.println("         || || "); 
			    System.out.println("         ooO Ooo "); 
					end = true;
				break;
			case 1: crearCliente();
							;
				break;
			case 2: eliminarCliente();
													
				break;
			case 3: crearCuenta();
				
				break;
			case 4:
				ingresarSaldo();
				break;
			case 5:
				retirarSaldo();
				break;
			case 6: 
				for(Cliente ver2 : cliente) {
					System.out.println(ver2.getCuentas());
				}
				break;
			default:
				System.out.println("Digite una opcion correcta");
			}

		} while (end == false);

	}
//Metodos
private static void pedirDatos() {
		System.out.println("Cual es el nombre del cliente");
		nombre = input.nextLine();
		System.out.println("Â¿Y el Apellido?");
		apellido = input.nextLine();
	}
	//Crear cliente
private static void crearCliente() {
		pedirDatos();
		Cliente cl = new Cliente(nombre, apellido);
		cliente.add(cl);
		System.out.println("El cliente ha sido agregado" );
	}
	//Eliminar client
public static void eliminarCliente() {
		pedirDatos();
		int i = findIndex(nombre, apellido);
			if (i < 0) 
			{
				System.out.println("El cliente no existe");
			} else
			{
				System.out.println("El cliente ha sido eliminado" 
			+ cliente.get(i).getNombre().toUpperCase());
				Cliente dCuenta = cliente.get(i);
				ArrayList<Cuenta> aux = dCuenta.getCuentas();
				System.out.println(aux);
				cliente.remove(i);
			}
			
	}
	//Crear Cuenta
private static void crearCuenta() {
	pedirDatos();
	 iClient = findIndex(nombre, apellido);
	if(iClient < 0)
	{
		System.out.println("El cliente no existe");
	}else 
	{	Cuenta cuenta1 = new Cuenta(CrearId.nextVal(), 0);
		cliente.get(iClient).getCuentas().add(cuenta1);
		System.out.println("Se creo la cuenta " + cuenta1.getNumCuenta() 
		+ " para el cliente " + nombre + " " + apellido + ".");
	}
} 
//Find index
private static int findIndex(String nombre, String apellido) {
int pos = -1;
int i = 0;
while ( i < cliente.size())
	{
		if (nombre.equalsIgnoreCase(cliente.get(i).getNombre())
		&& (apellido.equalsIgnoreCase(cliente.get(i).getApellido())))
	{
		return i;
	}
		i++;
	}
		return -1;
	}
	//Saldo
public static void ingresarSaldo() {
int  nc;

	pedirDatos();
	 iClient = findIndex(nombre, apellido);
	if (iClient < 0) 
	{
		System.out.println("El cliente no existe");
	}else 
	{
		System.out.println("Ingrese numero de cuenta");
		 nc = input.nextInt();
		input.nextLine();
		Cliente clienteEncontrado = cliente.get(iClient);
		
		int j = clienteEncontrado.findIndexCuenta(nc);
			if (j < 0)
			{
				System.out.println("La cuenta no existe");
			} else
			{	System.out.println(clienteEncontrado.getCuentas());
				System.out.println("Cuanto dinero a ingresar??");
				     deposito = input.nextInt();
				input.nextLine();
			
				//if (!suma) {
				//deposito *= -1;
				if(deposito <= 0)
				{
					System.out.println("Ingrese una cantidad correcta");
					deposito = input.nextInt();
				}
				int saldo = clienteEncontrado.getCuentas().get(j).ingresar(deposito);
				System.out.println("El saldo actual es " + saldo);
			}
		}

}
public static void retirarSaldo() {

//int deposito, nc = 0, saldo, iClient;	
		pedirDatos();
		 iClient = findIndex(nombre, apellido);
		if (iClient < 0)
		{
			System.out.println("El cliente no existe");
		} else
		{
			System.out.println("Ingrese N.cuenta");
				nc = input.nextInt();
			input.nextLine();
			Cliente clienteEncontrado = cliente.get(iClient);
			int j = clienteEncontrado.findIndexCuenta(nc);
			if (j < 0)
			{
				System.out.println("La cuenta no existe");
			} else {
				System.out.println("Cuanto dinero desea retirar??");
				     deposito = input.nextInt();
				input.nextLine();
			/*	if (!suma) {
					deposito *= -1;
				}*/while(deposito > clienteEncontrado.getCuentas().get(j).getSaldo())
			//	if(deposito >clienteEncontrado.getCuentas().get(j).getSaldo()) 
				{
					System.out.println("La cantidad es mayor al saldo de la cuenta. Ingrese otra cantidad");
					 deposito = input.nextInt();
				 }
				 saldo = clienteEncontrado.getCuentas().get(j).retirar(deposito);
				 
				System.out.println("El saldo actual es " + saldo);
			}
		}

  } 


	}
