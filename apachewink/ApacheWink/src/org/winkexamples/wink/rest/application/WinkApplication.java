package org.winkexamples.wink.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.winkexamples.wink.rest.services.WinkWebService;

public class WinkApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(WinkWebService.class);
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		
		Set<Object> s = new HashSet<>();
		ObjectMapper objMapper = new ObjectMapper();
		AnnotationIntrospector primary = new JaxbAnnotationIntrospector();
		AnnotationIntrospector secondary = new JaxbAnnotationIntrospector();
		
		AnnotationIntrospector pair = AnnotationIntrospector.pair(primary, secondary);
		objMapper.getDeserializationConfig().withAnnotationIntrospector(pair);
		objMapper.getSerializationConfig().withAnnotationIntrospector(pair);
		
		JacksonJaxbJsonProvider jaxbProvider = new JacksonJaxbJsonProvider();
		jaxbProvider.setMapper(objMapper);
		
		s.add(jaxbProvider);
		
		return s;
	}
}
