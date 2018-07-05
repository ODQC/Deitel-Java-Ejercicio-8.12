package com.ssbaez.ejercicio812;

public class FechaTiempo {
	
	private int dia; 
	private int mes; 
	private int anio;
	
	private int hora;
	private int minuto;
	private int segundo;
	
	private static final int[] diasPorMes = 
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public FechaTiempo() {
		this(1, 1, 1000, 0, 0, 0);
	}
	
	public FechaTiempo(int dia) {
		this(dia, 1, 1000, 0, 0, 0);
	}
	
	public FechaTiempo(int dia, int mes) {
		this(dia, mes, 1000, 0, 0, 0);
	}
	
	public FechaTiempo(int dia, int mes, int anio) {
		this(dia, mes, anio, 0, 0, 0);
	}
	
	public FechaTiempo(int dia, int mes, int anio, 
			int hora) {
		this(dia, mes, anio, hora, 0, 0);
	}
	
	public FechaTiempo(int dia, int mes, int anio, 
			int hora, int minuto) {
		this(dia, mes, anio, hora, minuto, 0);
	}
	
	public FechaTiempo(int dia, int mes, int anio, 
			int hora, int minuto, int segundo) {
		
		//Revisa si el mes esta en el rango
		if(mes <= 0 || mes > 12)
			throw new IllegalArgumentException(
					"mes (" + mes + ") debe ser 1 - 12");
				
		//Revisa si el dia esta en rango
		if(dia <= 0 ||
				(dia > diasPorMes[mes] && !(mes == 2 && dia == 29)))
			throw new IllegalArgumentException("dia (" + dia + 
					") fuera de rango para el mes y anio especificados");
				
		//Revisa si es año bisiesto cuando mes es 2 y dia es 29
		if(mes == 2 && dia == 29 && !(anio % 400 == 0 ||
				(anio % 4 == 0 && anio % 100 != 0)))
			throw new IllegalArgumentException("dia (" + dia  + 
					") fuera de rango para el mes y anio especificados");
				
		//Revisa si el año es valido
		if(anio < 1000 || anio > 2020)
			throw new IllegalArgumentException("anio (" + anio + 
					") fuera de rango");
		
		if(hora < 0 || hora >= 24)
			throw new IllegalArgumentException("hora debe estar entre 0 y 23");
		
		if(minuto < 0 || minuto >= 60)
			throw new IllegalArgumentException("minuto debe estar entre 0 y 59");
		
		if(segundo < 0 || segundo >= 60)
			throw new IllegalArgumentException("segundo debe estar entre 0 y 59");
		
		this.dia 		= dia;
		this.mes 		= mes;
		this.anio 		= anio;
		this.hora 		= hora;
		this.minuto 	= minuto;
		this.segundo 	= segundo;
		
	}
	
	public FechaTiempo(FechaTiempo dateTime) {
		this(dateTime.getDia(), dateTime.getMes(), dateTime.getAnio(), 
				dateTime.getHora(), dateTime.getMinuto(), dateTime.getSegundo());
	}
	
	public int getDia() {
		return dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public int getHora() {
		return hora;
	}
	
	public void setHora(int hora) {
		if(hora < 0 || hora >= 24)
			throw new IllegalArgumentException("hora debe estar entre 0 y 23");
		else
			this.hora = hora;		
	}
	
	public int getMinuto() {
		return minuto;
	}
	
	public void setMinuto(int minuto) {
		if(minuto < 0 || minuto >= 60)
			throw new IllegalArgumentException("minuto debe de estar entre 0 y 59");
		else
			this.minuto = minuto;
	}
	
	public int getSegundo() {
		return segundo;
	}
	
	public void setSegundo(int segundo) {
		if(segundo < 0 || segundo >= 60)
			throw new IllegalArgumentException("segundo debe de estar entre 0 y 59");
		else
			this.segundo = segundo;
	}
	
	public void incrementarDia() {
		if((getDia() == diasPorMes[mes])
				|| 
				(getDia() == 29 && getMes() == 2)) {
			setDia(1);
			incrementarMes();
		}
		else
			setDia(getDia() + 1);
	}
	
	public void incrementarMes() {
		if(getMes() == 12) {
			setMes(1);
			incrementarAnio();
		}
		else
			setMes(getMes() + 1);
	}
	
	public void incrementarAnio() {
		setAnio(getAnio() + 1);
	}
	
	public void establecerTiempo(int hora, int minuto, int segundo) {
		if(hora < 0 || hora >= 24)
			throw new IllegalArgumentException("hora debe estar entre 0 y 23");
		
		if(minuto < 0 || minuto >= 60)
			throw new IllegalArgumentException("minuto debe estar entre 0 y 59");
		
		if(segundo < 0 || segundo >= 60)
			throw new IllegalArgumentException("segundo debe estar entre 0 y 59");
	}
	
	public void incrementarSegundo() {
		if(getSegundo() == 59) {
			setSegundo(0);
			incrementarMinuto();
		}
		else
			setSegundo(getSegundo() + 1);
	}
	
	public void incrementarMinuto() {
		if(getMinuto() == 59) {
			setMinuto(0);
			incrementarHora();
		}
		else
			setMinuto(getMinuto() + 1);
	}
	
	public void incrementarHora() {
		if(getHora() == 23) {
			setHora(0);
			incrementarDia();
		}
		else
			setHora(getHora() + 1);
	}
	
	public String aStringUniversal() {
		return String.format("%02d/%02d/%d - %02d:%02d:%02d", 
				getDia(), getMes(), getAnio(), 
				getHora(), getMinuto(), getSegundo());
	}
	
	public String toString() {
		return String.format("%02d/%02d/%d - %02d:%02d:%02d %s", 
				getDia(), getMes(), getAnio(), 
				((getHora() == 0 || getHora() == 12) ? 12 : getHora() % 12), 
				getMinuto(), getSegundo(), (getHora() < 12) ? "AM" : "PM");
	}

}
