# AluraChallenge_ConversorMoneda

## Resumen
En el momento de la implementación del programa se ejecutan dos clases: Conversor y ConvertidorApp.
Conversor es la clase encargada de guardar los datos correspondientes para el convertidor, los cuales utiliza los atributos nombreElemento 
(que es el nombre que se le quiera dar al objeto), valor (que es para asignarle su valor numérico) y tipoConversor (que se le asignará el nombre de el tipo de convertidor al que pertenece).
Esta clase se encarga de consultar y convertir los objetos creados a partir de esta clase.
Ya que al momento de intentar implementar una clase para tipos de cambio de moneda y otra para medidores de longitud serían las mismas características, se optó por implementar 
una sola clase con la posibilidad de especificar a qué tipo de conversor sería.

La segunda clase usada es convertidorApp, que es solo la implementación de las ventanas emergentes y validaciones para lograr mostrar el resultado de manera optima.
Se emplean los métodos de convertir, donde se implementan las ventanas, y menuTipoConversor, que abrevia al uso de las mismas líneas de código para reducir el uso repetitivo de esta.

