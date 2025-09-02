package com.nt.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.sbeans.DieselEngine;
import com.nt.sbeans.ElectricEngine;
import com.nt.sbeans.IEngine;
import com.nt.sbeans.PetrolEngine;
@Component("engineFactory")
public class EngineFactory implements FactoryBean<IEngine>
{
     @Value("${engine.type}")
     private String engineType;
	@Override
	public IEngine getObject() throws Exception {
		System.out.println("EngineFactory.getObject()");
		if(engineType.equalsIgnoreCase("petrol"))
			return new PetrolEngine();
		else if(engineType.equalsIgnoreCase("diesel"))
			return new DieselEngine();
		else if(engineType.equalsIgnoreCase("electric"))
			return new ElectricEngine();
		else
			throw new IllegalArgumentException("Invalid Engine Type");
			
		
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("EngineFactory.getObjectType()");
		return IEngine.class;
	}
	@Override
	public boolean isSingleton() {
		return true;
	}
   
}
