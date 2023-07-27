import javax.swing.JOptionPane;

public class ConvertidorApp {
	/*double dolar=16.85;
	double euro=18.65;
	double libra=21.60;
	double yen=.12;
	double won=.013;*/
	private Conversor[] monedas ={new Conversor("PESO",1,"MONEDA"),
					new Conversor("DOLAR", 16.85,"MONEDA"),
					new Conversor("EURO", 18.65,"MONEDA"),
					new Conversor("LIBRA", 21.60,"MONEDA"),
					new Conversor("YEN", .12,"MONEDA"),
					new Conversor("WON", .013,"MONEDA")
	};
	private Conversor[] medidas ={new Conversor("CENTIMETROS (cm)",1,"LONGITUD"),
			new Conversor("METROS (m)", 100,"LONGITUD"),
			new Conversor("KILOMETROS (km)", 100000,"LONGITUD"),
			new Conversor("PIES (ft)", 30.48,"LONGITUD"),
			new Conversor("PULGADA (in)", 2.54,"LONGITUD"),
			new Conversor("MILLA (mi)", 160934.4,"LONGITUD"),
			new Conversor("YARDA (yd)", 91.44,"LONGITUD")
};
	private String tipoConversor[]= {"MONEDA","LONGITUD"};
	private String monedasObjects[]= {"DOLAR", "PESO","EURO","LIBRA","YEN","WON"};
	private String medidasObjects[]= {"CENTIMETROS (cm)", "METROS (m)", "KILOMETROS (km)",
										"PIES (ft)", "PULGADA (in)","MILLA (mi)","YARDA (yd)"
										};

	private Object conversor = new Object();
	private Object tipoCambio = new Object();
	private Object segundoTipoCambio = new Object();
	private int terminar = 0;

	private double valorConvertido;

	
	public void convertir() {
	//Vamos a seguir convirtiendo de algún tipo? 
		while(terminar!=1) {
			
			conversor = JOptionPane.showInputDialog(null, 
					"Selecciona el tipo de conversor a utilizar",
					"Conversor", JOptionPane.PLAIN_MESSAGE, null, 
					tipoConversor, tipoConversor[0]);
			
			//Se sellecionó alguna opción?
			if(conversor==null) 
				break;
			else {
				
				String conversorStr = conversor.toString();
				//while(terminar!=1) 
				{
					//Si es conversor de monedas
					if(conversorStr=="MONEDA") {
						tipoCambio = menuTipoConversor("Conversor 'DE'", "Selecciona la moneda para convertir", monedasObjects);
					}
					//si es conversor de longitud
					else if(conversorStr=="LONGITUD"){
						tipoCambio = menuTipoConversor("Conversor 'DE'", "Selecciona la medida para convertir", medidasObjects);
					}
					if(tipoCambio==null)
						break;
					
					//Mientras el tipo de moneda no sea nulo
					else {
						// Se abrevia a string el nombre del tipo de cambio
						String tipoCambioStr = tipoCambio.toString();	
						
						//while(terminar!=1)
						{
							if(conversorStr=="MONEDA") {
								segundoTipoCambio = menuTipoConversor("Conversor 'A'", "Selecciona la moneda para convertir", monedasObjects);
							}
							//si es conversor de longitud
							if(conversorStr=="LONGITUD"){
								segundoTipoCambio = menuTipoConversor("Conversor 'A'", "Selecciona la medida para convertir", medidasObjects);
							}
							
							if(segundoTipoCambio==null) 
								break;
							
							else{
								//while(terminar!=1) 
								{
									Object cantidadACambiarObject = JOptionPane.showInputDialog(null, 
											"Selecciona la cantidad que deseas convertir",
											null, JOptionPane.DEFAULT_OPTION, null, 
											null,
											null);
									if(cantidadACambiarObject==null)
										break;
									if(!isNumber(cantidadACambiarObject)) {
										JOptionPane.showMessageDialog(null, "EL ELEMENTO INGRESADO NO ES UN NÚMERO", null, 0, null);	
									}
									else{
										String segundoTipoCambioStr = segundoTipoCambio.toString();
										Double cantidadACambiarDouble = Double.parseDouble(cantidadACambiarObject.toString());
										Conversor[] arrayElementos= {};
										
										if (conversorStr=="MONEDA") {
											arrayElementos=monedas;
										}
										else if(conversorStr=="LONGITUD") {
											arrayElementos=medidas;
										}
										
										for(Conversor monedaCambio : arrayElementos) {
											if(monedaCambio.getNombre()==tipoCambioStr) {
												
												for(Conversor segundaMonedaCambio : arrayElementos) {
													if(segundaMonedaCambio.getNombre()==segundoTipoCambioStr) {
														
														valorConvertido = monedaCambio.convertir(cantidadACambiarDouble, segundaMonedaCambio);
														break;
														}
													}
												}
											}
										
										JOptionPane.showMessageDialog(null, "Son "+ valorConvertido + " de tipo "+
												segundoTipoCambioStr+" dentro de "+ cantidadACambiarDouble+" "+ tipoCambioStr, null, JOptionPane.WARNING_MESSAGE, null);
										}
									terminar = JOptionPane.showConfirmDialog(null, "¿DESEAS CONTINUAR?", null,0 , JOptionPane.QUESTION_MESSAGE);	
								}
							}
						}
					}
				}
			}
		}
		JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO", null, JOptionPane.INFORMATION_MESSAGE, null);	
	}
	
	Object menuTipoConversor(String titulo, String texto, String[] arregloElementosConversor) {
		return JOptionPane.showInputDialog(null, texto,titulo,
				JOptionPane.PLAIN_MESSAGE, null, 
				arregloElementosConversor,
				arregloElementosConversor[0]);
	}
	boolean isNumber(Object ob) {
		try {
			Double.parseDouble(ob.toString());
			return true;
		}
		catch(NumberFormatException nfe){
			return false;
		}
	}
}
