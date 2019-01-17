package com.consolidatedMorsels.processor;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;

public class BaseTreatMakerClient {

	public static void main(String[] args) {

		BaseTreatMaker theBaseTreatMaker = null;

		System.out.println("------BEGIN ALL-----");
		// OPTIONAL ENHANCEMENT: convert from args[n] to arguments to createTreatMaker(....)

		// ---- prep one object to put on the argument Hashtable -----
		Hashtable aHash = new Hashtable();
		Object obj = new Object();
		System.out.println("Reference of obj:" + obj.toString() );

		/* creates a compile warning since
		   the Hashtable type is not parameterized */
		aHash.put("oneObject", obj);


		// ------- MAKE & call methods on each class --------------

		/* Since neither company or Treat is unique,
		   create the NameValuePair object for convenience */
		NameValuePair[] nvsCompanyToTreat =
			{new NameValuePair("hershzweil","FilledChocolate"),
			 new NameValuePair("swietinuff","HardCandy"),
			 new NameValuePair("swietinuff","Cookie"),
			 new NameValuePair("venus","FilledChocolate")};

		int nvsLength = nvsCompanyToTreat.length;
		int i = -1;

		/* Iterate over the set of pairings above,
		   constructing the corresponding class of each */

		NameValuePair nvPair = null;

		String strCompany = null;
		String strTreat = null;

		for (i = 0; i < nvsLength; i++) {
			System.out.println("------BEGIN CREATE A TREATMAKER-----");
			nvPair = nvsCompanyToTreat[i];
			strCompany = nvPair.name;
			strTreat = nvPair.value;

			theBaseTreatMaker =
				BaseTreatMaker.createTreatMaker(strCompany,
						 						strTreat,
					     					 	aHash);

			System.out.println("BaseTreatMaker toString(): " + theBaseTreatMaker.toString() );
			System.out.println("------END CREATE A TREATMAKER-----");
			System.out.println();

			theBaseTreatMaker.setupEquipment();
			theBaseTreatMaker.prepareMix();
			theBaseTreatMaker.mix();
			theBaseTreatMaker.shape();
			theBaseTreatMaker.packageTreat();
			theBaseTreatMaker.cleanup();
		} // end for

		System.out.println("------END ALL-----");

	} /// end main()

}

/** convenience class deliberately with package scope;
    OK to live in same file since tightly bound to the BaseTreatMakerClient */
class NameValuePair {

	// deliberately accessible
	String name;
	String value;

	NameValuePair(String aName, String aValue) {
		name = aName;
		value = aValue;
	} // end NameValuePair constructor
} // end class NameValuePair