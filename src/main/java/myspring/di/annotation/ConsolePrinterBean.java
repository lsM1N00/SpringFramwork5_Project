package myspring.di.annotation;

public class ConsolePrinterBean implements PrinterBean {
	public void print(String message) {
		System.out.println(message);
	}
}
