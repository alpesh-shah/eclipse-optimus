/**
 * Optimus, framework for Model Transformation
 *
 * Copyright (C) 2013 Worldline or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */
package net.atos.optimus.m2m.engine.core.masks;

import net.atos.optimus.m2m.engine.core.Activator;

import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Implementation of Transformation mask for the user preferences.
 * 
 * Indeed, the user preferences for transformation execution are handled through
 * a transformation mask
 * 
 * @author mvanbesien
 * @since 1.0
 * 
 */
public class PreferencesTransformationMask implements ITransformationMask {

	/**
	 * Static internal class, in charge of holding the Singleton instance.
	 * 
	 * @generated XA Singleton Generator on 2013-07-10 15:28:48 CEST
	 */
	private static class SingletonHolder {
		static PreferencesTransformationMask instance = new PreferencesTransformationMask();
	}

	/**
	 * Returns the Singleton instance of this class.
	 * 
	 * @generated XA Singleton Generator on 2013-07-10 15:28:48 CEST
	 */
	public static PreferencesTransformationMask getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * Default constructor. Generated because used in singleton instanciation &
	 * needs to be private
	 * 
	 * @generated XA Singleton Generator on 2013-07-10 15:28:48 CEST
	 */
	private PreferencesTransformationMask() {
	}

	/**
	 * Internal instance of preferenceStore
	 */
	private IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.atos.optimus.m2m.engine.core.masks.ITransformationMask#
	 * isTransformationEnabled(java.lang.String)
	 */
	@Override
	public boolean isTransformationEnabled(String id) {
		String enablementKey = Activator.PLUGIN_ID + ".disabled." + id;
		return !this.preferenceStore.getBoolean(enablementKey);
	}

	/**
	 * Updates the value for the enablement of the transformation, which id is passed as
	 * parameter
	 * 
	 * @param id
	 * @param enabled
	 */
	public void setTransformationEnabled(String id, boolean enabled) {
		String enablementKey = Activator.PLUGIN_ID + ".disabled." + id;
		this.preferenceStore.setValue(enablementKey, !enabled);
	}

}
