package com.vrsa9208.unit1.solid;

class Document {
	
}

interface Machine {
	//This interface has method which doesn't correspond to a simple printer.
	//Indeed, it could segregate its operations
	void print(Document d);
	void fax(Document d);
	void scan(Document d);
}

class MultiFunctionPrinter implements Machine {

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fax(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}

public class InterfaceSegregationPrinciple {

}
