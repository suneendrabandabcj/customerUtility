
package com.bootcampjava.electricityservice.soapservice;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-08-17T13:18:33.358-05:00
 * Generated source version: 3.1.7
 * 
 */
public final class PowerPlanService_PowerPlanServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://serviceplan.soapservice.webservices.services.electricityservice.cmsenergy.com/", "servicePlan");

    private PowerPlanService_PowerPlanServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ServicePlan_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ServicePlan_Service ss = new ServicePlan_Service(wsdlURL, SERVICE_NAME);
        PowerPlanService port = ss.getPowerPlanServiceImplPort();  
        
        {
        System.out.println("Invoking getServicePlans...");
        java.util.List<com.bootcampjava.electricityservice.soapservice.ServicePlan> _getServicePlans__return = port.getServicePlans();
        System.out.println("getServicePlans.result=" + _getServicePlans__return);


        }

        System.exit(0);
    }

}
