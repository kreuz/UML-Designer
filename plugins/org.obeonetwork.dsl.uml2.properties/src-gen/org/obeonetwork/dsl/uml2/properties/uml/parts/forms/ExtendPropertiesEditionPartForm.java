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
package org.obeonetwork.dsl.uml2.properties.uml.parts.forms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EcoreAdapterFactory;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart;
import org.obeonetwork.dsl.uml2.properties.uml.parts.UmlViewsRepository;

import org.obeonetwork.dsl.uml2.properties.uml.providers.UmlMessages;


/**
 * @author <a href="mailto:cedric.brun@obeo.fr">Cédric Brun</a>
 * @generated
 */
public class ExtendPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ExtendPropertiesEditionPart {

	protected Text name;
	protected EMFComboViewer visibility;
	protected ReferencesTable clientDependency;
	protected List<ViewerFilter> clientDependencyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> clientDependencyFilters = new ArrayList<ViewerFilter>();
	protected EObjectFlatComboViewer extendedCase;
	protected ReferencesTable extensionLocation;
	protected List<ViewerFilter> extensionLocationBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> extensionLocationFilters = new ArrayList<ViewerFilter>();
	protected EObjectFlatComboViewer extension;



	/**
	 * For {@link ISection} use only.
	 */
	public ExtendPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * @generated
	 */
	public ExtendPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * @generated
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * @generated
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence extendStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = extendStep.addStep(UmlViewsRepository.Extend.Properties.class);
		propertiesStep.addStep(UmlViewsRepository.Extend.Properties.name);
		propertiesStep.addStep(UmlViewsRepository.Extend.Properties.visibility);
		propertiesStep.addStep(UmlViewsRepository.Extend.Properties.clientDependency);
		propertiesStep.addStep(UmlViewsRepository.Extend.Properties.extendedCase);
		propertiesStep.addStep(UmlViewsRepository.Extend.Properties.extensionLocation);
		propertiesStep.addStep(UmlViewsRepository.Extend.Properties.extension);
		
		
		composer = new PartComposer(extendStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == UmlViewsRepository.Extend.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == UmlViewsRepository.Extend.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == UmlViewsRepository.Extend.Properties.visibility) {
					return createVisibilityEMFComboViewer(widgetFactory, parent);
				}
				if (key == UmlViewsRepository.Extend.Properties.clientDependency) {
					return createClientDependencyReferencesTable(widgetFactory, parent);
				}
				if (key == UmlViewsRepository.Extend.Properties.extendedCase) {
					return createExtendedCaseFlatComboViewer(parent, widgetFactory);
				}
				if (key == UmlViewsRepository.Extend.Properties.extensionLocation) {
					return createExtensionLocationReferencesTable(widgetFactory, parent);
				}
				if (key == UmlViewsRepository.Extend.Properties.extension) {
					return createExtensionFlatComboViewer(parent, widgetFactory);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * @generated
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(UmlMessages.ExtendPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	/**
	 * @generated
	 */
	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, UmlViewsRepository.Extend.Properties.name, UmlMessages.ExtendPropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * @generated
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ExtendPropertiesEditionPartForm.this,
							UmlViewsRepository.Extend.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ExtendPropertiesEditionPartForm.this,
									UmlViewsRepository.Extend.Properties.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ExtendPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * @generated
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, UmlViewsRepository.Extend.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.Extend.Properties.name, UmlViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @generated
	 */
	
	protected Composite createVisibilityEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, UmlViewsRepository.Extend.Properties.visibility, UmlMessages.ExtendPropertiesEditionPart_VisibilityLabel);
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		visibility.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	@generated
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.visibility, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getVisibility()));
			}

		});
		visibility.setID(UmlViewsRepository.Extend.Properties.visibility);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.Extend.Properties.visibility, UmlViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @generated
	 */
	protected Composite createClientDependencyReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.clientDependency = new ReferencesTable(getDescription(UmlViewsRepository.Extend.Properties.clientDependency, UmlMessages.ExtendPropertiesEditionPart_ClientDependencyLabel), new ReferencesTableListener	() {
			public void handleAdd() { addClientDependency(); }
			public void handleEdit(EObject element) { editClientDependency(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveClientDependency(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromClientDependency(element); }
			public void navigateTo(EObject element) { }
		});
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UmlViewsRepository.Extend.Properties.clientDependency, UmlViewsRepository.FORM_KIND));
		this.clientDependency.createControls(parent, widgetFactory);
		this.clientDependency.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.clientDependency, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData clientDependencyData = new GridData(GridData.FILL_HORIZONTAL);
		clientDependencyData.horizontalSpan = 3;
		this.clientDependency.setLayoutData(clientDependencyData);
		this.clientDependency.disableMove();
		clientDependency.setID(UmlViewsRepository.Extend.Properties.clientDependency);
		clientDependency.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @generated
	 */
	protected void addClientDependency() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(clientDependency.getInput(), clientDependencyFilters, clientDependencyBusinessFilters,
		"clientDependency", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.clientDependency,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				clientDependency.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * @generated
	 */
	protected void moveClientDependency(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		clientDependency.refresh();
	}

	/**
	 * @generated
	 */
	protected void removeFromClientDependency(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		clientDependency.refresh();
	}

	/**
	 * @generated
	 */
	protected void editClientDependency(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				clientDependency.refresh();
			}
		}
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * @generated
	 */
	protected Composite createExtendedCaseFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, UmlViewsRepository.Extend.Properties.extendedCase, UmlMessages.ExtendPropertiesEditionPart_ExtendedCaseLabel);
		extendedCase = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(UmlViewsRepository.Extend.Properties.extendedCase, UmlViewsRepository.FORM_KIND));
		widgetFactory.adapt(extendedCase);
		extendedCase.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData extendedCaseData = new GridData(GridData.FILL_HORIZONTAL);
		extendedCase.setLayoutData(extendedCaseData);
		extendedCase.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.extendedCase, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getExtendedCase()));
			}

		});
		extendedCase.setID(UmlViewsRepository.Extend.Properties.extendedCase);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.Extend.Properties.extendedCase, UmlViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @generated
	 */
	protected Composite createExtensionLocationReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.extensionLocation = new ReferencesTable(getDescription(UmlViewsRepository.Extend.Properties.extensionLocation, UmlMessages.ExtendPropertiesEditionPart_ExtensionLocationLabel), new ReferencesTableListener	() {
			public void handleAdd() { addExtensionLocation(); }
			public void handleEdit(EObject element) { editExtensionLocation(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveExtensionLocation(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromExtensionLocation(element); }
			public void navigateTo(EObject element) { }
		});
		this.extensionLocation.setHelpText(propertiesEditionComponent.getHelpContent(UmlViewsRepository.Extend.Properties.extensionLocation, UmlViewsRepository.FORM_KIND));
		this.extensionLocation.createControls(parent, widgetFactory);
		this.extensionLocation.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.extensionLocation, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData extensionLocationData = new GridData(GridData.FILL_HORIZONTAL);
		extensionLocationData.horizontalSpan = 3;
		this.extensionLocation.setLayoutData(extensionLocationData);
		this.extensionLocation.disableMove();
		extensionLocation.setID(UmlViewsRepository.Extend.Properties.extensionLocation);
		extensionLocation.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @generated
	 */
	protected void addExtensionLocation() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(extensionLocation.getInput(), extensionLocationFilters, extensionLocationBusinessFilters,
		"extensionLocation", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.extensionLocation,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				extensionLocation.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * @generated
	 */
	protected void moveExtensionLocation(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.extensionLocation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		extensionLocation.refresh();
	}

	/**
	 * @generated
	 */
	protected void removeFromExtensionLocation(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.extensionLocation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		extensionLocation.refresh();
	}

	/**
	 * @generated
	 */
	protected void editExtensionLocation(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				extensionLocation.refresh();
			}
		}
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * @generated
	 */
	protected Composite createExtensionFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, UmlViewsRepository.Extend.Properties.extension, UmlMessages.ExtendPropertiesEditionPart_ExtensionLabel);
		extension = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(UmlViewsRepository.Extend.Properties.extension, UmlViewsRepository.FORM_KIND));
		widgetFactory.adapt(extension);
		extension.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData extensionData = new GridData(GridData.FILL_HORIZONTAL);
		extension.setLayoutData(extensionData);
		extension.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ExtendPropertiesEditionPartForm.this, UmlViewsRepository.Extend.Properties.extension, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getExtension()));
			}

		});
		extension.setID(UmlViewsRepository.Extend.Properties.extension);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(UmlViewsRepository.Extend.Properties.extension, UmlViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#getName()
	 * @generated
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#setName(String newValue)
	 * @generated
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(UmlViewsRepository.Extend.Properties.name);
		if (readOnly && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(UmlMessages.Extend_ReadOnly);
		} else if (!readOnly && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#getVisibility()
	 * @generated
	 */
	public Enumerator getVisibility() {
		Enumerator selection = (Enumerator) ((StructuredSelection) visibility.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#initVisibility(Object input, Enumerator current)
	 */
	public void initVisibility(Object input, Enumerator current) {
		visibility.setInput(input);
		visibility.modelUpdating(new StructuredSelection(current));
		boolean readOnly = isReadOnly(UmlViewsRepository.Extend.Properties.visibility);
		if (readOnly && visibility.isEnabled()) {
			visibility.setEnabled(false);
			visibility.setToolTipText(UmlMessages.Extend_ReadOnly);
		} else if (!readOnly && !visibility.isEnabled()) {
			visibility.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#setVisibility(Enumerator newValue)
	 * @generated
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
		boolean readOnly = isReadOnly(UmlViewsRepository.Extend.Properties.visibility);
		if (readOnly && visibility.isEnabled()) {
			visibility.setEnabled(false);
			visibility.setToolTipText(UmlMessages.Extend_ReadOnly);
		} else if (!readOnly && !visibility.isEnabled()) {
			visibility.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#initClientDependency(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initClientDependency(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		clientDependency.setContentProvider(contentProvider);
		clientDependency.setInput(settings);
		boolean readOnly = isReadOnly(UmlViewsRepository.Extend.Properties.clientDependency);
		if (readOnly && clientDependency.getTable().isEnabled()) {
			clientDependency.setEnabled(false);
			clientDependency.setToolTipText(UmlMessages.Extend_ReadOnly);
		} else if (!readOnly && !clientDependency.getTable().isEnabled()) {
			clientDependency.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#updateClientDependency()
	 * @generated
	 */
	public void updateClientDependency() {
	clientDependency.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#addFilterClientDependency(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToClientDependency(ViewerFilter filter) {
		clientDependencyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#addBusinessFilterClientDependency(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter) {
		clientDependencyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#isContainedInClientDependencyTable(EObject element)
	 * @generated
	 */
	public boolean isContainedInClientDependencyTable(EObject element) {
		return ((ReferencesTableSettings)clientDependency.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#getExtendedCase()
	 * @generated
	 */
	public EObject getExtendedCase() {
		if (extendedCase.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) extendedCase.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#initExtendedCase(EObjectFlatComboSettings)
	 */
	public void initExtendedCase(EObjectFlatComboSettings settings) {
		extendedCase.setInput(settings);
		if (current != null) {
			extendedCase.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean readOnly = isReadOnly(UmlViewsRepository.Extend.Properties.extendedCase);
		if (readOnly && extendedCase.isEnabled()) {
			extendedCase.setEnabled(false);
			extendedCase.setToolTipText(UmlMessages.Extend_ReadOnly);
		} else if (!readOnly && !extendedCase.isEnabled()) {
			extendedCase.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#setExtendedCase(EObject newValue)
	 * @generated
	 */
	public void setExtendedCase(EObject newValue) {
		if (newValue != null) {
			extendedCase.setSelection(new StructuredSelection(newValue));
		} else {
			extendedCase.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(UmlViewsRepository.Extend.Properties.extendedCase);
		if (readOnly && extendedCase.isEnabled()) {
			extendedCase.setEnabled(false);
			extendedCase.setToolTipText(UmlMessages.Extend_ReadOnly);
		} else if (!readOnly && !extendedCase.isEnabled()) {
			extendedCase.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#setExtendedCaseButtonMode(ButtonsModeEnum newValue)
	 */
	public void setExtendedCaseButtonMode(ButtonsModeEnum newValue) {
		extendedCase.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#addFilterExtendedCase(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToExtendedCase(ViewerFilter filter) {
		extendedCase.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#addBusinessFilterExtendedCase(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToExtendedCase(ViewerFilter filter) {
		extendedCase.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#initExtensionLocation(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initExtensionLocation(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		extensionLocation.setContentProvider(contentProvider);
		extensionLocation.setInput(settings);
		boolean readOnly = isReadOnly(UmlViewsRepository.Extend.Properties.extensionLocation);
		if (readOnly && extensionLocation.getTable().isEnabled()) {
			extensionLocation.setEnabled(false);
			extensionLocation.setToolTipText(UmlMessages.Extend_ReadOnly);
		} else if (!readOnly && !extensionLocation.getTable().isEnabled()) {
			extensionLocation.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#updateExtensionLocation()
	 * @generated
	 */
	public void updateExtensionLocation() {
	extensionLocation.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#addFilterExtensionLocation(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToExtensionLocation(ViewerFilter filter) {
		extensionLocationFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#addBusinessFilterExtensionLocation(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToExtensionLocation(ViewerFilter filter) {
		extensionLocationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#isContainedInExtensionLocationTable(EObject element)
	 * @generated
	 */
	public boolean isContainedInExtensionLocationTable(EObject element) {
		return ((ReferencesTableSettings)extensionLocation.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#getExtension()
	 * @generated
	 */
	public EObject getExtension() {
		if (extension.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) extension.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#initExtension(EObjectFlatComboSettings)
	 */
	public void initExtension(EObjectFlatComboSettings settings) {
		extension.setInput(settings);
		if (current != null) {
			extension.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean readOnly = isReadOnly(UmlViewsRepository.Extend.Properties.extension);
		if (readOnly && extension.isEnabled()) {
			extension.setEnabled(false);
			extension.setToolTipText(UmlMessages.Extend_ReadOnly);
		} else if (!readOnly && !extension.isEnabled()) {
			extension.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#setExtension(EObject newValue)
	 * @generated
	 */
	public void setExtension(EObject newValue) {
		if (newValue != null) {
			extension.setSelection(new StructuredSelection(newValue));
		} else {
			extension.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(UmlViewsRepository.Extend.Properties.extension);
		if (readOnly && extension.isEnabled()) {
			extension.setEnabled(false);
			extension.setToolTipText(UmlMessages.Extend_ReadOnly);
		} else if (!readOnly && !extension.isEnabled()) {
			extension.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#setExtensionButtonMode(ButtonsModeEnum newValue)
	 */
	public void setExtensionButtonMode(ButtonsModeEnum newValue) {
		extension.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#addFilterExtension(ViewerFilter filter)
	 * @generated
	 */
	public void addFilterToExtension(ViewerFilter filter) {
		extension.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.uml2.properties.uml.parts.ExtendPropertiesEditionPart#addBusinessFilterExtension(ViewerFilter filter)
	 * @generated
	 */
	public void addBusinessFilterToExtension(ViewerFilter filter) {
		extension.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * @generated
	 */
	public String getTitle() {
		return UmlMessages.Extend_Part_Title;
	}



}
