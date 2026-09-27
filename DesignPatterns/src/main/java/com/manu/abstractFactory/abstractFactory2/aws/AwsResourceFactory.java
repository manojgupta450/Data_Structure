package com.manu.abstractFactory.abstractFactory2.aws;

import com.manu.abstractFactory.abstractFactory2.Instance;
import com.manu.abstractFactory.abstractFactory2.ResourceFactory;
import com.manu.abstractFactory.abstractFactory2.Storage;

//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Instance.Capacity capacity) {
		return new Ec2Instance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new S3Storage(capMib);
	}


}
