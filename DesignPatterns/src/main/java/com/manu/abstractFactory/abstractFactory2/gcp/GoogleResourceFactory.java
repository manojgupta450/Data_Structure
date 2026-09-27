package com.manu.abstractFactory.abstractFactory2.gcp;

import com.manu.abstractFactory.abstractFactory2.Instance;
import com.manu.abstractFactory.abstractFactory2.ResourceFactory;
import com.manu.abstractFactory.abstractFactory2.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Instance.Capacity capacity) {
		return new GoogleComputeEngineInstance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new GoogleCloudStorage(capMib);
	}
	

}
