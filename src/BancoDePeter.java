import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;
/*
 * Ejercicio del banco donde se pide crear dos clases. CLiente y Cuenta con sus respesctivos metodos
 * en el main tenenos que crear un menu, donde permita al usuario crear cliente, elimininar cliente
 * crear cuenta, ingresar dinero, retirar dinero
 */

public class BancoDePeter {
	private static ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	
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
			System.out.println("Que quieres hacer??"); //Menu para la aplicacion
			System.out.println("0.- Salir de la aplicacion.\n" + "1.- Crear client/a.\n" + "2.- Eliminar client/a.\n"
					+ "3.- Crear cuenta a un client/a.\n" + "4.- Ingresar euros en un cuenta de un client/a.\n"
					+ "5.- Retirar euros en un cuenta de un cliente" + "\n6.- Ver todas las cuentas");
			try //Error de formato
			{                   
			opcion = input.nextInt();
		//	input.nextLine();
			correcto = true;
            } catch (InputMismatchException ex) {//Try catch con exepction de String
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
			case 1: crearCliente(); //Funcion Crear Cliente
							;
				break;
			case 2: eliminarCliente(); //Funcion eliminarCLiente
													
				break;
			case 3: crearCuenta(); //Funcion crearCuenta
				
				break;
			case 4:
				ingresarSaldo(); //Funcion crear Saldo
				break;
			case 5:
				retirarSaldo(); //Funcion retirarSaldo
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
	//Metodo creado para pedir los datos al cliente
		System.out.println("Cual es el nombre del cliente");
		nombre = input.nextLine();
		System.out.println("Y el Apellido?");
		apellido = input.nextLine();
	}
	//Crear cliente
private static void crearCliente() {
	//Funcion crearCliente, utiliza la funcion pedir datos para almacenarlo en el obejtco cl de la clase Cliente
	
		pedirDatos();
		Cliente cl = new Cliente(nombre, apellido);
		cliente.add(cl); //almaceno el objeto de la clase cliente con nombre Cliente en el ArrayList de client
		System.out.println("El cliente "+ cl.getNombre().toUpperCase() +
				" " + cl.getApellido().toUpperCase() +" ha sido agregado" );
	}
	//Eliminar client
public static void eliminarCliente() {
	//Funcion eliminarCLiente, utiliza la funcion pedir datos y la funcion findIndex almacennand en una var integer 
		pedirDatos();
		int i = findIndex(nombre, apellido);
			if (i < 0) //Si i es menor que 0, el cliente no existe en el arraylist
			{
				System.out.println("El cliente no existe");
			} else
			{  
				System.out.println("El cliente ha sido eliminado " 
			+ cliente.get(i).getNombre().toUpperCase());
				cliente.remove(i);
				 //uso el arraylist con cliente.remove y la var i, que almacena la posicion del cliente para eliminarlo						
			
			}
			
	}
	//Crear Cuenta
private static void crearCuenta() {
	pedirDatos();
	 iClient = findIndex(nombre, apellido); //Pedir datos se almacena en findIndex y luego se almaecena en la variable int iCient
	if(iClient < 0)//if si iClient es menor que 0, el cliente no existe
	{
		System.out.println("El cliente no existe");
	}else //Else: creao un objeto de la clase cuenta con nombre cuenta1, luego con el ArrayList de cliente usando el get
		//con la posicion de iClient usando el getter del ArrayList de cuentas con la extension .add con el objeto cuenta1 dentro
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
	{ //Usando bucle while para buscar en el ArrayList de cliente, mientras i sea menor que clientes.size, i incrementa un ciclo
	  //Si nombre.equalsIgnoreCase & apellido.equalsIgnoreCase con el parametro cliente.get con la posicion de i .getnombre y apellido
	  //Si son iguales, la variable pos equivaldra la pos de i  y retornara esa pos
		if (nombre.equalsIgnoreCase(cliente.get(i).getNombre())
		&& (apellido.equalsIgnoreCase(cliente.get(i).getApellido())))
	{   
		pos = i;
	}
		i++;
	}
		return pos;
	}
	//Saldo
public static void ingresarSaldo() {
int  nc;
//Con la funcion pedirDatos y la funcion findIndex que es un int, para almacenarlo en la var iClient
	pedirDatos();
	 iClient = findIndex(nombre, apellido);
	if (iClient < 0) //Si iClient es menor que 0, el cliente no existe
	{
		System.out.println("El cliente no existe");
	}else 
	{//si se encuentra la posicion, se le pide por pantalla al usuario que teclee el numero de cuenta
		System.out.println("Ingrese numero de cuenta");
		 nc = input.nextInt();
		input.nextLine();
		Cliente clienteEncontrado = cliente.get(iClient); //Creo un objeto de la clase Cliente con el nombre clienteEncontrado
														 
		//en la var j almaceno el objeto clienteEncontrado de la clase cliente con el metodo findIndexCuenta con el parametro nc
		int j = clienteEncontrado.findIndexCuenta(nc);
			if (j < 0) //Si j es menor que 0 la cuenta no existe
			{
				System.out.println("La cuenta no existe");
			} else
			{	System.out.println(clienteEncontrado.getCuentas());
				System.out.println("Cuanto dinero a ingresar??");
				     deposito = input.nextInt();
				input.nextLine();
			
				//if (!suma) {
				//deposito *= -1;
				if(deposito <= 0) //Si deposito es menor o igual que 0, tendra que ingresar una cantidad correta
				{
					System.out.println("Ingrese una cantidad correcta");
					deposito = input.nextInt();
				}//En la var saldo equivale al objeto clienteEncontrado con el getter del ArrayList de cuentas .get con la pos de la var j
				 //.ingresar es el metodo de la clase cuenta
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
