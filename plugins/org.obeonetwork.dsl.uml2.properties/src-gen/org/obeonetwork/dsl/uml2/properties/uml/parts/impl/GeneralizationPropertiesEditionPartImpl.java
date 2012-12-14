/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.uml2.properties.uml.parts.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart;
import org.obeonetwork.dsl.uml2.properties.uml.parts.UmlViewsRepository;

import org.obeonetwork.dsl.uml2.properties.uml.providers.UmlMessages;


/**
 * @author <a href="mailto:cedric.brun@obeo.fr">Cédric Brun</a>
 * @generated
 */
public class GeneralizationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GeneralizationPropertiesEditionPart {

	protected Button isSubstitutable;
	protected EObjectFlatComboViewer general;
	protected ReferencesTable generalizationSet;
	protected List<ViewerFilter> generalizationSetBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> generalizationSetFilters = new ArrayList<ViewerFilter>();
	protected EObjectFlatComboViewer specific;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * @generated
	 */
	public GeneralizationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * @generated
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * @generated
	 */
	public void createControls(Composite view) { 
		CompositionSequence generalizationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = generalizationStep.addStep(UmlViewsRepository.Generalization.Properties.class);
		propertiesStep.addStep(UmlViewsRepository.Generalization.Properties.isSubstitutable);
		propertiesStep.addStep(UmlViewsRepository.Generalization.Properties.general);
		propertiesStep.addStep(UmlViewsRepository.Generalization.Properties.generalizationSet);
		propertiesStep.addStep(UmlViewsRepository.Generalization.Properties.specific);
		
		
		composer = new PartComposer(generalizationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == UmlViewsRepository.Generalization.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == UmlViewsRepository.Generalization.Properties.isSubstitutable) {
					return createIsSubstitutableCheckbox(parent);
				}
				if (key == UmlViewsRepository.Generalization.Properties.general) {
					return createGeneralFlatComboViewer(parent);
				}
				if (key == UmlViewsRepository.Generalization.Properties.generalizationSet) {
					return createGeneralizationSetAdvancedReferencesTable(parent);
				}
				if (key == UmlViewsRepository.Generalization.Properties.specific) {
					return createSpecificFlatComboViewer(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * @generated
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(UmlMessages.GeneralizationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @generated
	 */
	
	protected Composite createIsSubstitutableCheckbox(Composite parent) {
		isSubstitutable = new Button(parent, SWT.CHECK);
		isSubstitutable.setText(getDescription(UmlViewsRepository.Generalization.Properties.isSubstitutable, UmlMessages.GeneralizationPropertiesEditionPart_IsSubstitutableLabel));
		isSubstitutable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	@generated
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralizationPropertiesEditionPartImpl.this, UmlViewsRepository.Generalization.Properties.isSubstitutable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isSubstitutable.getSelection())));
			}

		});
		GridData isSubstitutableData = new GridData(GridData.FILL_HORIZONTAL);
		isSubstitutableData.horizontalSpan = 2;
		isSubstitutable.setLayoutData(isSubstitutableData);
		EditingUtils.setID(isSubstitutable, UmlViewsRepository.Generalization.Properties.isSubstitutable);
		EditingUtils.setEEFtype(isSubstitutable, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.Generalization.Properties.isSubstitutable, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @generated
	 */
	protected Composite createGeneralFlatComboViewer(Composite parent) {
		createDescription(parent, UmlViewsRepository.Generalization.Properties.general, UmlMessages.GeneralizationPropertiesEditionPart_GeneralLabel);
		general = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(UmlViewsRepository.Generalization.Properties.general, UmlViewsRepository.SWT_KIND));
		general.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		general.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralizationPropertiesEditionPartImpl.this, UmlViewsRepository.Generalization.Properties.general, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getGeneral()));
			}

		});
		GridData generalData = new GridData(GridData.FILL_HORIZONTAL);
		general.setLayoutData(generalData);
		general.setID(UmlViewsRepository.Generalization.Properties.general);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.Generalization.Properties.general, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @generated
	 */
	protected Composite createGeneralizationSetAdvancedReferencesTable(Composite parent) {
		String label = getDescription(UmlViewsRepository.Generalization.Properties.generalizationSet, UmlMessages.GeneralizationPropertiesEditionPart_GeneralizationSetLabel);		 
		this.generalizationSet = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addGeneralizationSet(); }
			public void handleEdit(EObject element) { editGeneralizationSet(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveGeneralizationSet(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromGeneralizationSet(element); }
			public void navigateTo(EObject element) { }
		});
		this.generalizationSet.setHelpText(propertiesEditionComponent.getHelpContent(UmlViewsRepository.Generalization.Properties.generalizationSet, UmlViewsRepository.SWT_KIND));
		this.generalizationSet.createControls(parent);
		this.generalizationSet.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralizationPropertiesEditionPartImpl.this, UmlViewsRepository.Generalization.Properties.generalizationSet, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData generalizationSetData = new GridData(GridData.FILL_HORIZONTAL);
		generalizationSetData.horizontalSpan = 3;
		this.generalizationSet.setLayoutData(generalizationSetData);
		this.generalizationSet.disableMove();
		generalizationSet.setID(UmlViewsRepository.Generalization.Properties.generalizationSet);
		generalizationSet.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @generated
	 */
	protected void addGeneralizationSet() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(generalizationSet.getInput(), generalizationSetFilters, generalizationSetBusinessFilters,
		"generalizationSet", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralizationPropertiesEditionPartImpl.this, UmlViewsRepository.Generalization.Properties.generalizationSet,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				generalizationSet.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * @generated
	 */
	protected void moveGeneralizationSet(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralizationPropertiesEditionPartImpl.this, UmlViewsRepository.Generalization.Properties.generalizationSet, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		generalizationSet.refresh();
	}

	/**
	 * @generated
	 */
	protected void removeFromGeneralizationSet(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralizationPropertiesEditionPartImpl.this, UmlViewsRepository.Generalization.Properties.generalizationSet, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		generalizationSet.refresh();
	}

	/**
	 * @generated
	 */
	protected void editGeneralizationSet(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				generalizationSet.refresh();
			}
		}
	}

	/**
	 * @param parent the parent composite
	 * @generated
	 */
	protected Composite createSpecificFlatComboViewer(Composite parent) {
		createDescription(parent, UmlViewsRepository.Generalization.Properties.specific, UmlMessages.GeneralizationPropertiesEditionPart_SpecificLabel);
		specific = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(UmlViewsRepository.Generalization.Properties.specific, UmlViewsRepository.SWT_KIND));
		specific.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		specific.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GeneralizationPropertiesEditionPartImpl.this, UmlViewsRepository.Generalization.Properties.specific, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getSpecific()));
			}

		});
		GridData specificData = new GridData(GridData.FILL_HORIZONTAL);
		specific.setLayoutData(specificData);
		specific.setID(UmlViewsRepository.Generalization.Properties.specific);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.Generalization.Properties.specific, UmlViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * @generated
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#getIsSubstitutable()
	 * @generated
	 */
	public Boolean getIsSubstitutable() {
		return Boolean.valueOf(isSubstitutable.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#setIsSubstitutable(Boolean newValue)
	 * @generated
	 */
	public void setIsSubstitutable(Boolean newValue) {
		if (newValue != null) {
			isSubstitutable.setSelection(newValue.booleanValue());
		} else {
			isSubstitutable.setSelection(false);
		}
		boolean readOnly = isReadOnly(UmlViewsRepository.Generalization.Properties.isSubstitutable);
		if (readOnly && isSubstitutable.isEnabled()) {
			isSubstitutable.setEnabled(false);
			isSubstitutable.setToolTipText(UmlMessages.Generalization_ReadOnly);
		} else if (!readOnly && !isSubstitutable.isEnabled()) {
			isSubstitutable.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#getGeneral()
	 * @generated
	 */
	public EObject getGeneral() {
		if (general.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) general.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#initGeneral(EObjectFlatComboSettings)
	 */
	public void initGeneral(EObjectFlatComboSettings settings) {
		general.setInput(settings);
		if (current != null) {
			general.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean readOnly = isReadOnly(UmlViewsRepository.Generalization.Properties.general);
		if (readOnly && general.isEnabled()) {
			general.setEnabled(false);
			general.setToolTipText(UmlMessages.Generalization_ReadOnly);
		} else if (!readOnly && !general.isEnabled()) {
			general.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#setGeneral(EObject newValue)
	 * @generated
	 */
	public void setGeneral(EObject newValue) {
		if (newValue != null) {
			general.setSelection(new StructuredSelection(newValue));
		} else {
			general.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(UmlViewsRepository.Generalization.Properties.general);
		if (readOnly && general.isEnabled()) {
			general.setEnabled(false);
			general.setToolTipText(UmlMessages.Generalization_ReadOnly);
		} else if (!readOnly && !general.isEnabled()) {
			general.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#setGeneralButtonMode(ButtonsModeEnum newValue)
	 */
	public void setGeneralButtonMode(ButtonsModeEnum newValue) {
		general.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#addFilterGeneral(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToGeneral(ViewerFilter filter) {
		general.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#addBusinessFilterGeneral(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToGeneral(ViewerFilter filter) {
		general.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#initGeneralizationSet(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initGeneralizationSet(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		generalizationSet.setContentProvider(contentProvider);
		generalizationSet.setInput(settings);
		boolean readOnly = isReadOnly(UmlViewsRepository.Generalization.Properties.generalizationSet);
		if (readOnly && generalizationSet.getTable().isEnabled()) {
			generalizationSet.setEnabled(false);
			generalizationSet.setToolTipText(UmlMessages.Generalization_ReadOnly);
		} else if (!readOnly && !generalizationSet.getTable().isEnabled()) {
			generalizationSet.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#updateGeneralizationSet()
	 * @generated
	 */
	public void updateGeneralizationSet() {
	generalizationSet.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#addFilterGeneralizationSet(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToGeneralizationSet(ViewerFilter filter) {
		generalizationSetFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#addBusinessFilterGeneralizationSet(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToGeneralizationSet(ViewerFilter filter) {
		generalizationSetBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#isContainedInGeneralizationSetTable(EObject element)
	 * @generated
	 */
	public boolean isContainedInGeneralizationSetTable(EObject element) {
		return ((ReferencesTableSettings)generalizationSet.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#getSpecific()
	 * @generated
	 */
	public EObject getSpecific() {
		if (specific.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) specific.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#initSpecific(EObjectFlatComboSettings)
	 */
	public void initSpecific(EObjectFlatComboSettings settings) {
		specific.setInput(settings);
		if (current != null) {
			specific.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean readOnly = isReadOnly(UmlViewsRepository.Generalization.Properties.specific);
		if (readOnly && specific.isEnabled()) {
			specific.setEnabled(false);
			specific.setToolTipText(UmlMessages.Generalization_ReadOnly);
		} else if (!readOnly && !specific.isEnabled()) {
			specific.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#setSpecific(EObject newValue)
	 * @generated
	 */
	public void setSpecific(EObject newValue) {
		if (newValue != null) {
			specific.setSelection(new StructuredSelection(newValue));
		} else {
			specific.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(UmlViewsRepository.Generalization.Properties.specific);
		if (readOnly && specific.isEnabled()) {
			specific.setEnabled(false);
			specific.setToolTipText(UmlMessages.Generalization_ReadOnly);
		} else if (!readOnly && !specific.isEnabled()) {
			specific.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#setSpecificButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSpecificButtonMode(ButtonsModeEnum newValue) {
		specific.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#addFilterSpecific(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToSpecific(ViewerFilter filter) {
		specific.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.GeneralizationPropertiesEditionPart#addBusinessFilterSpecific(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToSpecific(ViewerFilter filter) {
		specific.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * @generated
	 */
	public String getTitle() {
		return UmlMessages.Generalization_Part_Title;
	}



}
