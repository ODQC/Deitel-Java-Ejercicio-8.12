package com.ssbaez.ejercicio812;

public class PruebaFechaTiempo {
	
	public static void main(String[] args) {
		
		FechaTiempo ft1 = new FechaTiempo();
		FechaTiempo ft2 = new FechaTiempo(5);
		FechaTiempo ft3 = new FechaTiempo(5, 10);
		FechaTiempo ft4 = new FechaTiempo(4, 5, 1990);
		FechaTiempo ft5 = new FechaTiempo(2, 8, 1997, 8);
		FechaTiempo ft6 = new FechaTiempo(21, 5, 2010, 13, 25);
		FechaTiempo ft7 = new FechaTiempo(31, 12, 1995, 23, 59, 59);
		
		System.out.println(ft1);
		System.out.printf("%s%n%n", ft1.aStringUniversal());
		System.out.println(ft2);
		System.out.printf("%s%n%n", ft2.aStringUniversal());
		System.out.println(ft3);
		System.out.printf("%s%n%n", ft3.aStringUniversal());
		System.out.println(ft4);
		System.out.printf("%s%n%n", ft4.aStringUniversal());
		System.out.println(ft5);
		System.out.printf("%s%n%n", ft5.aStringUniversal());
		System.out.println(ft6);
		System.out.printf("%s%n%n", ft6.aStringUniversal());
		System.out.println(ft7);
		System.out.printf("%s%n%n", ft7.aStringUniversal());
		
		ft7.incrementarSegundo();
		System.out.println(ft7);
		System.out.printf("%s%n%n", ft7.aStringUniversal());
	}

}
