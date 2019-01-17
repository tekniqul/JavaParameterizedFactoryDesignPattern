package com.consolidatedMorsels.processor.swietinuff;

import com.consolidatedMorsels.processor.BaseTreatMaker;
import java.util.Hashtable;

public class HardCandyMaker extends BaseTreatMaker {

	private static String MY_CLASSNAME = HardCandyMaker.class.getName();

	/** enable this constructor, and disable the other to see the
	    runtime NoSuchMethodException thrown from the BaseTreatMakerClient
	public HardCandyMaker() {
		super(new Hashtable() );
	} */

	public HardCandyMaker(Hashtable aHashParameters) {
		super(aHashParameters);

		System.out.println("---CONSTRUCTING " + MY_CLASSNAME);

		// now get the expected parameter type
		Object obj = aHashParameters.get("oneObject");
		System.out.println("Reference of obj:" + obj.toString() );

		System.out.println("---DONE constructing " + MY_CLASSNAME);
	} // end HardCandyMaker


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
