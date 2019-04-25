package com.axicorp.esb.skrill;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import javax.jms.Session;

import org.junit.Test;
import org.mule.munit.runner.functional.FunctionalMunitSuite;
import org.mule.retry.policies.RetryForeverPolicyTemplate;
import org.mule.transport.jms.JmsConnector;

public class TestJMSConfig extends FunctionalMunitSuite {
	
	@Override
	protected boolean haveToMockMuleConnectors() {
		return false;
	}
	
	@Override
	protected boolean haveToDisableInboundEndpoints() {
	  return false;
	}
	
	@Test
	public void testRetrySettings() {
		Collection<JmsConnector> jmsConnectors = muleContext.getRegistry().lookupObjects(org.mule.transport.jms.JmsConnector.class);
		assertFalse(jmsConnectors.isEmpty());
		for (JmsConnector j : jmsConnectors) {
			Map<?,?> so = j.getServiceOverrides();
			assertTrue(j.getName() + " does not retry forever",j.getRetryPolicyTemplate() instanceof RetryForeverPolicyTemplate);
			assertEquals(j.getName() + " does not have a null session handler","org.mule.session.NullSessionHandler",so.get("session.handler"));
			assertEquals(j.getName() + " does not use Client Ack mode",Session.CLIENT_ACKNOWLEDGE,j.getAcknowledgementMode());
			assertTrue(j.getName() + " does not use persistent delivery",j.isPersistentDelivery());
		}
	}


}
