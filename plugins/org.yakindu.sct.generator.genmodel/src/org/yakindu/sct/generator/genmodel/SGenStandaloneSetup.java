/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/

package org.yakindu.sct.generator.genmodel;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SGenStandaloneSetup extends SGenStandaloneSetupGenerated{

	public static void doSetup() {
		new SGenStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

