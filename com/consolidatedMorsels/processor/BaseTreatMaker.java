package com.consolidatedMorsels.processor;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;

abstract public class BaseTreatMaker {

	private static String MY_CLASSNAME = BaseTreatMaker.class.getName();

	/** initialize anything in common */
	public BaseTreatMaker(Hashtable aHashtable) {
	}

/**  factory method

	 * catches ClassNotFoundException
	 * 		   IllegalArgumentException
	 * 		   SecurityException
	 * 		   InstantiationException
	 * 		   IllegalAccessException
	 *		   InvocationTargetException
	 * 		   NoSuchMethodException
 */
static public BaseTreatMaker createTreatMaker(String aSubsidiary,
											  String aTreat,
											  Hashtable aHashParameters) {

	/* for easier debugging, I declare my variables OUTSIDE the try {..};
	   then I can check the state of each in any catch (or finally) block
	 */
	BaseTreatMaker aTreatMaker = null;
	Package pkgBaseTreatMaker = null;
	Object objBaseTreatMaker = null;

	Class[] parameterTypes = null;
	Class classDefinition = null;
	Object[] parameters = null;
	Object objTreatMaker = null;

	String strPkg = null;
	String strClassTreatMakerName = null;

	try {
		// Reflection API
		// start from the BaseTreatMaker package
		pkgBaseTreatMaker = BaseTreatMaker.class.getPackage();
		strPkg = pkgBaseTreatMaker.getName();


		StringBuffer sbClassName = new StringBuffer(strPkg);

		sbClassName.append(".");
		sbClassName.append(aSubsidiary);
		sbClassName.append(".");
		sbClassName.append(aTreat);
		sbClassName.append("Maker");

		strClassTreatMakerName = sbClassName.toString();

		// DEBUG
		System.out.println("Classname = " + strClassTreatMakerName);

		// more Reflection API
		parameterTypes = new Class[] { Hashtable.class};
		parameters = new Object[] { aHashParameters };

		classDefinition = Class.forName(strClassTreatMakerName);
		classDefinition.getConstructor(parameterTypes);

		objTreatMaker =
			classDefinition.getConstructor(parameterTypes).newInstance(aHashParameters);

		aTreatMaker = (BaseTreatMaker)objTreatMaker;
	} 	/* Below are all the specific exceptions to be thrown;
	       you might even consolidate to 1 catch block, catch (Exception e),
	       but that's not recommended;
	       */
	  catch (ClassNotFoundException cnfe) {
		cnfe.printStackTrace();
	} 	/* a runtime exception,
	       but throw and possibly handle here yourself IF an invalid argument is passed in */
	  catch (IllegalArgumentException iae) {
		iae.printStackTrace();
	} catch (InvocationTargetException ite) {
		ite.printStackTrace();
	} catch (SecurityException se) {
		se.printStackTrace();
	} catch (InstantiationException ie) {
		ie.printStackTrace();
	} catch (IllegalAccessException iacse) {
		iacse.printStackTrace();
	} catch (NoSuchMethodException nsme) {
		nsme.printStackTrace();
	}

	return aTreatMaker;
} // end createTreatMaker(...)

// TODO: add common-to-all method implementations here, if any

public void cleanup() {
	System.out.println("in " + MY_CLASSNAME + " cleanup()");
}


// abstract keyword forces subclasses to implement
abstract public void setupEquipment();
abstract public void prepareMix();
abstract public void mix();
abstract public void shape();
abstract public void packageTreat();
} // end class