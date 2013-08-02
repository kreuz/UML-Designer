/*******************************************************************************
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package org.obeonetwork.dsl.uml2.design.tests.ui.features;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.obeonetwork.dsl.uml2.design.tests.ui.stories.ReconnectARelationshipUiTests;
import org.obeonetwork.dsl.uml2.design.tests.ui.stories.DeleteAFeatureUiTests;
import org.obeonetwork.dsl.uml2.design.tests.ui.stories.CreateARelationshipUiTests;
import org.obeonetwork.dsl.uml2.design.tests.ui.stories.RemoveAnExistingElementUiTests;
import org.obeonetwork.dsl.uml2.design.tests.ui.stories.AddExistingElementUiTests;
import org.obeonetwork.dsl.uml2.design.tests.ui.stories.CreateAFeatureUiTests;
import org.obeonetwork.dsl.uml2.design.tests.ui.stories.CreateATypeUiTests;
import org.obeonetwork.dsl.uml2.design.tests.ui.stories.DeleteARelationshipUiTests;
import org.obeonetwork.dsl.uml2.design.tests.ui.stories.DeleteATypeUiTests;
import org.obeonetwork.dsl.uml2.design.tests.ui.stories.EditARelationshipUiTests;

@RunWith(Suite.class)
@SuiteClasses({RemoveAnExistingElementUiTests.class,CreateATypeUiTests.class,AddExistingElementUiTests.class,DeleteAFeatureUiTests.class,DeleteARelationshipUiTests.class,CreateAFeatureUiTests.class,DeleteATypeUiTests.class,EditARelationshipUiTests.class,CreateARelationshipUiTests.class,ReconnectARelationshipUiTests.class})
/**
 * Testing : Class diagram
 */
public class ClassDiagramUiTests {

}
