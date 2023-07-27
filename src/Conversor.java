
//Independientemente de el tipo de objetos que se desean convertir, se ocupan las mismas características
public class Conversor{ 
	public String nombreElemento; //Nombre del objeto
	public double valor;
	public String tipoConversor;//Categoría
	
	public Conversor(String nombre, double valor,String tipoConversor) {
		this.nombreElemento=nombre;
		this.valor=valor;
		this.tipoConversor=tipoConversor;
	}
	
	public String getNombre() {
		return this.nombreElemento;
	}
	public String getTipoConversor() {
		return this.tipoConversor;
	}
//------
	public double convertir(double cantidad, Conversor elementoOrigen, Conversor elementoAConvertir) {
		//Se valida que sea de la misma categoría, ej: MONEDA-MONEDA,   LONGITUD-MONEDA:retorna -1
		if(esMismoTipoConversor(elementoOrigen, elementoAConvertir)) {
			//Si los dos elementos son el mismo no se convierte
			if(esMismoNombreElemento(elementoOrigen, elementoAConvertir)) {
				return cantidad;
			}
			else {
				//Regla de tres
				return (cantidad * elementoOrigen.valor)/elementoAConvertir.valor;
			}
		}
		else {
			return -1;
		}
	}
	public double convertir(double cantidad, Conversor elementoAConvertir) {
		//Se valida que sea de la misma categoría, ej: MONEDA-MONEDA,   LONGITUD-MONEDA:retorna -1
		if(esMismoTipoConversor(this, elementoAConvertir)) {
			//Si los dos elementos son el mismo no se convierte
			if(esMismoNombreElemento(this, elementoAConvertir)) {
				return cantidad;
			}
			else {
				//Regla de tres
				return (cantidad * this.valor)/elementoAConvertir.valor;
			}
		}
		else {
			return -1;
		}
	}
	
//--	Si pertenece a la misma categoría
	public boolean esMismoTipoConversor(Conversor elemento1,Conversor elemento2) {
		if(elemento1.getTipoConversor()==elemento2.getTipoConversor())
			return true;
		else 
			return false;
	}
	public boolean esMismoTipoConversor(String elemento1,String elemento2) {
		if(elemento1==elemento2)
			return true;
		else 
			return false;
	}
	//Si es el mismo elemento
	public boolean esMismoNombreElemento(Conversor elemento1,Conversor elemento2) {
		if(elemento1.getNombre()==elemento2.getNombre())
			return true;
		else 
			return false;
	}


	

}
