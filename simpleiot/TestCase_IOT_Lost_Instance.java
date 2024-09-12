/**
   * Licensed Materials - Property of IBM
   *
   * Restricted Materials of IBM
   * 
   * This sample program is provided AS IS and may be used, executed, copied
   * and modified without 
   * royalty payment by customer (a) for its own instruction and study, (b)
   * in order to develop 
   * applications designed to run with an IBM WebSphere product, either for
   * customer's own internal use
   * or for redistribution by customer, as part of such an application, in
   * customer's own products.
   * 
   * IBM Security AppScan Source for Analysis
   *
   * (c) Copyright IBM Corp. 2008,2009.  All Rights Reserved.
   *
   * U.S. Government Users Restricted Rights:  Use, duplication or
   * disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
*/
import java.io.*;

/**
 * TestCase_Lost_IOT_Instance_Lost
 * <p/>
 * The results of running this test is an input/output stack trace that is associated with the
 * source and has a root at the main method.
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_Lost_Instance {
    public static void main(String[] args) {
        try {
            TestCase_IOT_Lost_Instance testCase = new TestCase_IOT_Lost_Instance();
            String file = args[0];
            String source = testCase.getVulnerableSource(file);

            String key = args[1];
            testCase.writeToUnknownSink(key, source);
        } catch (Exception e) {
        }
    }

    public String getVulnerableSource(String file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[100];
        fis.read(buf);
        String ret = new String(buf);
        fis.close();
        return ret;
    }

    public void writeToUnknownSink(String key, String str) {
        System.setProperty(key, str);
    }
}
