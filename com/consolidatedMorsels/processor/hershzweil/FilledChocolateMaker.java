package com.consolidatedMorsels.processor.hershzweil;

import com.consolidatedMorsels.processor.BaseTreatMaker;
import java.util.Hashtable;

public class FilledChocolateMaker extends BaseTreatMaker {

	private static String MY_CLASSNAME = FilledChocolateMaker.class.getName();

	public FilledChocolateMaker(Hashtable aHashParameters) {
		super(aHashParameters);

		System.out.println("---CONSTRUCTING " + MY_CLASSNAME);

		// now get the expected parameter type
		Object obj = aHashParameters.get("oneObject");
		System.out.println("Reference of obj:" + obj.toString() );

		System.out.println("---DONE constructing " + MY_CLASSNAME);
	} // end FilledChocolateMaker

	public void setupEquipment() {
		System.out.println("in " + MY_CLASSNAME + " setupEquipment()");
	}

	public void prepareMix() {
		System.out.println("in " + MY_CLASSNAME + " prepareMix()");
	}

	public void mix() {
		System.out.println("in " + MY_CLASSNAME + " mix()");
	}

	public void shape() {
		System.out.println("in " + MY_CLASSNAME + " shape()");
	}

	public void packageTreat() {
		System.out.println("in " + MY_CLASSNAME + " packageTreat()");
	}
} // end class
