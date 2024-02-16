package fecha;

/**
 * Clase que representa a una fecha, conteniendo sus atributos, constructores y
 * funciones
 */
public class Fecha {
	/**
	 * Atributo d: Correspondiente al dia
	 */
	private int d; // d�a
	/**
	 * Atributo m: Correspondiente al mes
	 */
	private int m; // mes
	/**
	 * Atributo m: Correspondiente al anio
	 */
	private int a; // a�o

	/**
	 * Constructor sin parametros
	 */
	public Fecha() {

	}

	/**
	 * Constructor con todos los atributos como parametros
	 * 
	 * @param dia  Correspondiente al dia (atributo d)
	 * @param mes  Correspondiente al mes (atributo m)
	 * @param anio Correspondiente al anio (atributo a)
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	/**
	 * Funcion que indica si una fecha es correcta, atendiendo a que los numeros del
	 * dia, mes y anio sean los correctos y no sobrepasen los posibles valores que
	 * puedan tener
	 * 
	 * @return True o false segun si la fecha es correcta o no
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Funcion que indica si un anio es bisiesto, solo lo usa fechaCorrecta, por eso
	 * es privado
	 * 
	 * @return True o false segun si se cumple la condicion con los calculos correspondientes
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Funcion que modifica los atributos necesarios para indicar convertir la fecha
	 * en al dia siguiente
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Funcion que devuelve, en formato texto, la fecha correspondiente, anniadiendo
	 * ceros a la izquierda si es necesario
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
