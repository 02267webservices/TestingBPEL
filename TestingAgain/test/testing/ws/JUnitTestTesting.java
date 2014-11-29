/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.ws;

import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import someother.ws.FlightInfoListType;
import someother.ws.FlightInfoType;
import someother.ws.GetFlightRequestType;

/**
 *
 * @author gravr
 */
public class JUnitTestTesting {
    
    @Test
    public void testingSomething(){
        
        String output = testing("testing fuck ftw",1,1);
        System.out.println("Come on: " +output);
        
        //Testing getFlights
        GetFlightRequestType input = new GetFlightRequestType();
        input.setFlightStartAirport("Copenhagen");
        input.setFlightDestinationAirport("Berlin");

        try {
            DatatypeFactory df = DatatypeFactory.newInstance();
            XMLGregorianCalendar dateFlight = df.newXMLGregorianCalendar("2015-01-01");
            input.setFlightDate(dateFlight);
        }catch (Exception ex) {
        }
        
        FlightInfoListType result = getFlightsOperation(input,1,1);
        
        List<FlightInfoType> flightsInfo = result.getFlightInformation();
        
        System.out.println("Size of result: " +result.getFlightInformation().size());
        
        
        if (!flightsInfo.isEmpty()){
            for (int i = 0; i < flightsInfo.size(); i++) {
		System.out.println(flightsInfo.get(i).getFlightReservationService()+ "\n" +
                           flightsInfo.get(i).getFlightBookingNumber()+ "\n" +
                           Double.toString(flightsInfo.get(i).getFlightPrice()) + "\n" +
                           flightsInfo.get(i).getFlightInfo().getCarrierName() + "\n" +
                           flightsInfo.get(i).getFlightInfo().getDestinationAirport() + "\n" +
                           flightsInfo.get(i).getFlightInfo().getStartAirport());
            }
        }
        
    }

    private static String anotherOperation(java.lang.String input2, int customerId, int itineraryId) {
        someother.ws.TestingWSDLService service = new someother.ws.TestingWSDLService();
        someother.ws.TestingWSDLPortType port = service.getTestingWSDLPort();
        return port.anotherOperation(input2, customerId, itineraryId);
    }

    private static FlightInfoListType getFlightsOperation(someother.ws.GetFlightRequestType input3, int customerId, int itineraryId) {
        someother.ws.TestingWSDLService service = new someother.ws.TestingWSDLService();
        someother.ws.TestingWSDLPortType port = service.getTestingWSDLPort();
        return port.getFlightsOperation(input3, customerId, itineraryId);
    }

    private static String testing(java.lang.String input1, int customerId, int itineraryId) {
        someother.ws.TestingWSDLService service = new someother.ws.TestingWSDLService();
        someother.ws.TestingWSDLPortType port = service.getTestingWSDLPort();
        return port.testing(input1, customerId, itineraryId);
    }

    

    
    
    

    
}