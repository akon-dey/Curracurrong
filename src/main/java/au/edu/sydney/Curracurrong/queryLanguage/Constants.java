package au.edu.sydney.Curracurrong.queryLanguage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * This class keeps the constant variables of the system
 *
 * @author Bernhard Scholz, Akon Dey, Vasvi Kakkad
 * University of Sydney
 *
 */
public interface Constants {
	// Default directory for creating .dot and image files
	public static final String TEMP_DIR = "/tmp/";

	// Default directory for the results
	public static final String RESULTS_DIR = "/tmp/";

	// Default sample rate of a sense operation
	// if sample rate is not explicitly specified.
	public static final double DEFAULT_SAMPLE_RATE = 10;

	// package name for using in class.forname
	public static final String PACKAGE_NAME = "queryLanguage";

	// installed (Graphviz) dot executable
	public static final String DOT = "C:\\Program Files\\Graphviz2.26.3\\bin\\dot.exe";
}
