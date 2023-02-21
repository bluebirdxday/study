package com.kimyoji.study.ex12;

public class GenericPrinterTest {

	public static void main(String[] args) {
		
		ThreeDPrinter<Powder> printer = new ThreeDPrinter<Powder>();
		printer.setMaterial(new Powder());
		printer.printing();
		System.out.println(printer.toString());
		
		ThreeDPrinter<Plastic> printer2 = new ThreeDPrinter<Plastic>();
		printer2.setMaterial(new Plastic());
		printer2.printing();

	}
}
