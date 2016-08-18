package com.xcelenergy.electricityservice.clients.soapclient;

import java.util.List;

import com.xcelenergy.electricityservice.soapservice.PowerPlanService;
import com.xcelenergy.electricityservice.soapservice.ServicePlan_Service;
import com.xcelenergy.electricityservice.soapservice.ServicePlan;
public class ServicePlanConsumer {
	
	public  List<ServicePlan> getServicePlans(){
		ServicePlan_Service service = new ServicePlan_Service();
		PowerPlanService  powerPlans = service.getPowerPlanServiceImplPort();
		return powerPlans.getServicePlans();		
	}
	
	
}
